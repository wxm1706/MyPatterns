package patterns.prototype.case1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import game.GameLoopTimer;
import game.ImageTool;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.geometry.Point3D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import patterns.fmp.case2.IFactory;
import patterns.fmp.case2.MonsterFactory;
import patterns.fmp.case2.PlayerFactory;
import patterns.fmp.case2.Role;

public class MainApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		double height = 750;
		double width = 1350;
		AnchorPane gameAnchor = new AnchorPane();
		gameAnchor.setMaxSize(width, height);
		gameAnchor.setMinSize(width, height);
		Canvas gameCanvas = new Canvas();
		GraphicsContext gc = gameCanvas.getGraphicsContext2D();
		gameCanvas.widthProperty().bind(gameAnchor.widthProperty());
        gameCanvas.heightProperty().bind(gameAnchor.heightProperty());
        gameAnchor.getChildren().add(gameCanvas);
		Scene s = new Scene(gameAnchor);
		primaryStage.setScene(s);
		primaryStage.setTitle("MyPatterns");
		primaryStage.getIcons().add(new Image("file:" + System.getProperty("user.dir") + "/bin/images/icon.png"));
		
		
		Image mapImage = new Image("file:" + System.getProperty("user.dir") + "/bin/images/maps/map02.jpg");
		
		List<Image> swords = new ArrayList<Image>();
		for(int i = 1; i < 10; i++) {
			Image sword = new Image("file:" + System.getProperty("user.dir") + "/bin/images/sword/0" + i + ".png");
			Image newSword = ImageTool.clipImage(sword, 40, 0, 60, 198);
			swords.add(newSword);
		}
		
		List<Image> rotateSwords = new ArrayList<Image>();
		for(int i = 0; i < 30; i++) {
			rotateSwords.add(ImageTool.rotate(swords.get(0), 12 * i, new Point3D(0, 1, 0)));
		}

		GameLoopTimer timer = new GameLoopTimer() {
			int i = 0;
			int k = 0;
			@Override
			public void inputProcess() {}

			@Override
			public void logicUpdate() {
				k = (k + 1) % 30;
			}

			@Override
			public void displayUpdate() {
				gc.clearRect(0, 0, 1350, 750);
				gc.drawImage(mapImage, 0, 0);
				//gc.save();
				//gc.translate(300 + swords.get(1).getWidth()/2, 300 + swords.get(1).getHeight()/4);
				//gc.rotate(20 * i++);
				//gc.translate(-300 - swords.get(1).getWidth()/2, -300 - swords.get(1).getHeight()/4);
				//gc.drawImage(swords.get(1), 300, 300);
				//gc.restore();
				System.out.println(rotateSwords.get(k).getHeight() + "," + rotateSwords.get(k).getWidth());
				gc.drawImage(rotateSwords.get(k), 200 + (rotateSwords.get(0).getWidth() - rotateSwords.get(k).getWidth()) / 2, 200);
				
			}
			
        };
        
        timer.start();
        primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
