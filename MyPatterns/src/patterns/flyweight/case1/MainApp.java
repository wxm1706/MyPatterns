package patterns.flyweight.case1;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import game.ImageTool;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Font f = new Font(16);
		long start = System.currentTimeMillis();		
		
		// GUI布局
		HBox layout = new HBox();
		Canvas canvas = new Canvas(800, 600);
		GraphicsContext gc =  canvas.getGraphicsContext2D();
		VBox statisticView = new VBox();
		Label l1 = new Label("运行时间：");
		l1.setFont(f);
		Label l2 = new Label("总对象数：");
		l2.setFont(f);
		statisticView.getChildren().addAll(l1, l2);
		layout.getChildren().addAll(canvas, statisticView);
		
		// 产生数字并显示
		List<Number> list = new ArrayList<Number>();
		Timeline timer = new Timeline(new KeyFrame(Duration.millis(10), e -> {
			l1.setText("运行时间（秒）：" + (System.currentTimeMillis() - start) / 1000);
			l2.setText("对象数量（个）：" + list.size());
			Number in = new Number((int)(Math.random() * 10));
			
			in.setX(800 * Math.random());
			in.setY(600 * Math.random());
			list.add(in);
			gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
			for(Number n:list) {
				gc.drawImage(n.getImage(), n.getX(), n.getY());
			}
		}));
		timer.setCycleCount(Timeline.INDEFINITE);
		timer.play();
		primaryStage.setScene(new Scene(layout, 1000, 650));
		primaryStage.show();
	}


	public static void main(String[] args) {
		launch(args);
	}

}
