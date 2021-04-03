package exp.exp4;

import java.io.File;
import java.nio.file.Path;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GIFApp extends Application {
	Frame[] frames = null;
	String[] texts = null;
	VBox textParent = null;
	int time = 100;
	boolean playing = false;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// 读写器
		IGIFReader reader = new GIFReader();
		IGIFWriter writer = new GIFWriter();
		
		// 总布局
		SplitPane layout = new SplitPane();
		
		// 展示区与文本添加区域布局
		VBox viewLayout = new VBox();
		VBox textLayout = new VBox();
		
		// 文件选择区域
		HBox fileLayout = new HBox();
		fileLayout.setPadding(new Insets(10));
		Label label = new Label("文件：");
		label.setFont(new Font(16));
		TextField filePath = new TextField();
		filePath.setEditable(false);
		filePath.setPrefWidth(560);
		Button browse = new Button("浏览..");
		fileLayout.getChildren().addAll(label, filePath, browse);
		HBox.setMargin(filePath, new Insets(0, 10, 0, 10));
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("选择动态图片");
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("动图", "*.gif"));
		
		// 画布区域
		Canvas canvas = new Canvas(680, 400);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		HBox playLayout = new HBox();
		Slider slider = new Slider();
		slider.setShowTickMarks(true);
		slider.setShowTickLabels(true);
		slider.setBlockIncrement(1);
		slider.setMajorTickUnit(1);
		slider.setPrefWidth(650);
		Button playBtn = new Button("播放");
		playLayout.getChildren().addAll(slider, playBtn);
		VBox.setMargin(canvas, new Insets(10, 10, 10, 10));

		// 字幕添加区域
		Button addTextBtn = new Button("添加字幕");
		addTextBtn.setFont(new Font(16));
		addTextBtn.setPrefWidth(130);
		VBox.setMargin(addTextBtn, new Insets(10, 10, 10, 10));
		ScrollPane scrp = new ScrollPane();
		textParent = new VBox();
		scrp.setContent(textParent);
		Button saveBtn = new Button("导出动态图片");
		saveBtn.setPrefWidth(130);
		saveBtn.setFont(new Font(16));
		VBox.setMargin(saveBtn, new Insets(10, 10, 10, 10));
		

		// 布局组合
		viewLayout.getChildren().addAll(fileLayout, canvas, playLayout);
		textLayout.getChildren().addAll(addTextBtn, scrp, saveBtn);
		layout.getItems().addAll(viewLayout, textLayout);
		
		// 单击按钮选择文件路径
		browse.setOnAction(e -> {
			File selectedFile = fileChooser.showOpenDialog(primaryStage);
			if (selectedFile != null) {
				filePath.setText(selectedFile.getAbsolutePath());
				frames = reader.read(selectedFile.getAbsolutePath());
				texts = new String[frames.length];
				gc.drawImage(frames[0].getImage(), 0, 0, 680, 400);
				slider.setMax(frames.length - 1);
				slider.setValue(0);
			}
		});
		
		// 添加字幕编辑模块
		addTextBtn.setOnAction(e -> {
			TextPane tp = new TextPane(textParent);
			tp.setOnInputMethodTextChanged(te -> {
				updateText();
			});
			textParent.getChildren().add(tp);
		});
		
		// 滑动查看每帧图片
		slider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number oldValue, Number newValue) {
				if(frames != null) {
					int i = newValue.intValue();
					Render.rendering(canvas, frames[i], texts[i]);
				}	
			}
		});
		
		// 播放动态图片
		playBtn.setOnAction(e -> {
			if(frames != null && playing == false) {
				updateText();
				Timeline tl = new Timeline();
				tl.setCycleCount(frames.length);
				tl.getKeyFrames().add(new KeyFrame(Duration.millis(time), new EventHandler<ActionEvent>() {
					int i = 0;
					@Override
					public void handle(ActionEvent arg0) {
						slider.setValue(i);
						Render.rendering(canvas, frames[i], texts[i]);
						i++;
						if(i < frames.length) {
							time = frames[i].getDelay();
						}
					}
				}));
				tl.play();
				playing = true;
				tl.setOnFinished(fe -> {
					slider.setValue(0);
					Render.rendering(canvas, frames[0], texts[0]);
					playing = false;
				});
			}
		});
		
		// 导出动态图片
		saveBtn.setOnAction(e -> {
			if(frames != null) {
				String fileName = filePath.getText().replaceAll(".gif", "_new.gif");
				Frame[] output = new Frame[frames.length];
				for(int i = 0; i < frames.length; i++) {
					Image img = Render.rendering(canvas, frames[i], texts[i]);
					output[i] = new Frame(img, frames[i].getDelay());
				}
				writer.write(output, fileName);
			}
		});
		
		Scene scene = new Scene(layout, 860, 500);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.getIcons().add(new Image(Path.of("bin/images/res/gif.png").toUri().toString()));
		primaryStage.setTitle("添加动图字幕");
		primaryStage.show();
	}
	
	public void updateText() {
		if(frames != null) {
			texts = new String[frames.length];
			for(Node tp:textParent.getChildren()) {
				TextPane temp = (TextPane) tp;
				int start = Integer.parseInt(temp.getStart().getText());
				int end = Integer.parseInt(temp.getEnd().getText());
				for(int i = start; i <= end; i++) {
					texts[i] = temp.getContent().getText();
				}
			}
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
