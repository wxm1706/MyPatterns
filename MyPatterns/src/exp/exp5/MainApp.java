package exp.exp5;

import java.io.File;
import java.nio.file.Paths;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainApp extends Application {
	LookDecorator foucsDecorator = null;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		LookDecorator[] decorators = new LookDecorator[3]; //0-Ƥ��װ����,1-������װ����,2-�ȼ�װ����
		
		VBox layout = new VBox();
		Font font = new Font(16);
		Border border1 = new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, null, new BorderWidths(3)));
		
		// װ��ѡ������
		HBox selectArea = new HBox();
		selectArea.setPadding(new Insets(5, 5, 5, 5));
		Button skinBtn1 = new Button("Ƥ����������");
		skinBtn1.setFont(font);
		Button skinBtn2 = new Button("Ƥ����ͩ�ˡ�");
		skinBtn2.setFont(font);
		Button protectionBtn = new Button("������");
		protectionBtn.setFont(font);
		Button levelBtn = new Button("�ȼ�װ��");
		levelBtn.setFont(font);
		HBox.setMargin(skinBtn2, new Insets(0, 5, 0, 5));
		HBox.setMargin(protectionBtn, new Insets(0, 5, 0, 0));
		selectArea.getChildren().addAll(skinBtn1, skinBtn2, protectionBtn, levelBtn);
		
		// ��ʾ��������ʾ����ʾ����
		HBox viewLayout = new HBox();
		viewLayout.setPadding(new Insets(5, 5, 5, 5));
		Canvas canvas = new Canvas(330, 330);
		StackPane sp = new StackPane(canvas);
		sp.setBorder(border1);
		VBox tuningView = new VBox();
		tuningView.setPadding(new Insets(5, 5, 5, 5));
		tuningView.setBorder(border1);
		Label selected = new Label("");
		selected.setBorder(border1);
		selected.setFont(font);
		selected.setAlignment(Pos.CENTER);
		selected.setPrefWidth(200);
		Slider xtunning = new Slider();
		xtunning.setPrefWidth(200);
		Slider ytunning = new Slider();
		ytunning.setPrefWidth(200);
		tuningView.getChildren().addAll(selected, xtunning, ytunning);
		VBox.setMargin(xtunning, new Insets(5, 0, 5, 0));
		HBox.setMargin(sp, new Insets(0, 5, 0, 0));
		viewLayout.getChildren().addAll(sp, tuningView);

		
		// ������ɫ����
		Player player = new Player(new Rectangle2D(0, 0, 200, 200));
		xtunning.setMax(200);
		ytunning.setMax(200);
		
		// ����Ƥ����������
		DynamicImage saberImg = new DynamicImage();
		File file = Paths.get("bin/images/saber").toFile();
		for(File f:file.listFiles()) {
			Image img = new Image(f.toURI().toString());
			saberImg.add(img);
		}
		LookDecorator saber = new Skin(saberImg);
		saber.setWidth(130);
		saber.setHeight(100);
		
		// ����Ƥ����ͩ�ˡ�
		DynamicImage tongrenImg = new DynamicImage();
		file = Paths.get("bin/images/tongren").toFile();
		for(File f:file.listFiles()) {
			Image img = new Image(f.toURI().toString());
			tongrenImg.add(img);
		}
		LookDecorator tongren = new Skin(tongrenImg);
		tongren.setWidth(100);
		tongren.setHeight(100);

		// ����������
		DynamicImage proImg = new DynamicImage();
		file = Paths.get("bin/images/protection").toFile();
		for(File f:file.listFiles()) {
			Image img = new Image(f.toURI().toString());
			proImg.add(img);
		}
		LookDecorator prot1 = new Protection(proImg);
		prot1.setWidth(130);
		prot1.setHeight(130);
		
		// �ȼ�װ��
		Image img = new Image(Paths.get("bin/images/res/res06.png").toUri().toString());
		LookDecorator level1 = new Level(img);
		level1.setWidth(20);
		level1.setHeight(20);

		layout.getChildren().addAll(selectArea, viewLayout);
		Scene scene = new Scene(layout, 600, 400);
		
		
		// �л�����Ƥ��
		skinBtn1.setOnAction(e -> {
			if(decorators[0] != saber) {
				decorators[0] = saber;
				foucsDecorator = saber;
				selected.setText("Ƥ����������");
			}else {
				decorators[0] = null;
			}
		});
		
		// �л�ͩ��Ƥ��
		skinBtn2.setOnAction(e -> {
			if(decorators[0] != tongren) {
				decorators[0] = tongren;
				foucsDecorator = tongren;
				selected.setText("Ƥ����ͩ�ˡ�");
			}else {
				decorators[0] = null;
			}
		});
		
		// ���ñ�����
		protectionBtn.setOnAction(e -> {
			if(decorators[1] != prot1) {
				decorators[1] = prot1;
				foucsDecorator = prot1;
				selected.setText("������");
			}else {
				decorators[1] = null;
			}
		});
		
		// ���õȼ�װ��
		levelBtn.setOnAction(e -> {
			if(decorators[2] != level1) {
				decorators[2] = level1;
				foucsDecorator = level1;
				selected.setText("�ȼ�װ��");
			}else {
				decorators[2] = null;
			}
		});
		
		// �޸�װ��λ��
		xtunning.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number oldValue, Number newValue) {
				if(foucsDecorator != null) {
					int i = newValue.intValue();
					foucsDecorator.setOffx(i);
				}	
			}
		});
		ytunning.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number oldValue, Number newValue) {
				if(foucsDecorator != null) {
					int i = newValue.intValue();
					foucsDecorator.setOffy(i);
				}	
			}
		});

		// ͼ����Ⱦ
		GraphicsContext gc = canvas.getGraphicsContext2D();
		Timeline timer = new Timeline(new KeyFrame(Duration.millis(100), te -> {
			gc.setFill(Color.WHITE);
			gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
			ILook temp = player;
			for(LookDecorator ld:decorators) {
				if(ld != null) {
					ld.setLook(temp);
					temp = ld;
				}
			}
			Entity entity = temp.entityToDraw();
			Rectangle2D r = entity.getFrame();
			gc.drawImage(entity.getLook(), (canvas.getWidth() - r.getWidth()) / 2, (canvas.getHeight() - r.getHeight()) / 2, r.getWidth(), r.getHeight());
		}));
		timer.setCycleCount(Timeline.INDEFINITE);
		timer.play();
		
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("װ��ϵͳ");
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
