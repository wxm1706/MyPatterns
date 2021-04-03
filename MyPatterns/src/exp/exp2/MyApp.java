package exp.exp2;

import game.GameLoopTimer;
import game.ImageTool;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MyApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Group group = new Group();
		Scene scene = new Scene(group, 1200, 512);
		
		Canvas gameCanvas = new Canvas();
		GraphicsContext gc = gameCanvas.getGraphicsContext2D();
		gameCanvas.widthProperty().bind(scene.widthProperty());
		gameCanvas.heightProperty().bind(scene.heightProperty());
		
        group.getChildren().add(gameCanvas);
		primaryStage.setScene(scene);

		Image mapImage = new Image("file:" + System.getProperty("user.dir") + "/bin/images/maps/map03.jpg");

		
		//Create buildings and riders
		Image resource1 = new Image("file:" + System.getProperty("user.dir") + "/bin/images/res/res01.png");
		Image resource2 = new Image("file:" + System.getProperty("user.dir") + "/bin/images/res/res02.png");
		Image house1 = ImageTool.clipImage(resource1, 600, 0, 240, 256);
		Image house2 = ImageTool.clipImage(resource2, 0, 0, 240, 256);
		Building b1 = new PlayerBuilding(house1, new Point2D(0, 0));
		Building b2 = new PlayerBuilding(house2, new Point2D(944, 256));
		Image[] images1 = new Image[3];
		for(int i = 0; i < 3; i++) {
			images1[i] = ImageTool.clipImage(resource1, 540 + i * 110, 370, 110, 80);
		}
		PlayerRider ps = new PlayerRider(images1, new Point2D(200, 200));
		
		Image[] images2 = new Image[3];
		for(int i = 0; i < 3; i++) {
			images2[i] = ImageTool.rotate(ImageTool.clipImage(resource2, 10 + i * 100, 860, 100, 70), 180, new Point3D(0,1,0));
		}
		EnemyRider es = new EnemyRider(images2, new Point2D(800, 300));
		
		GameLoopTimer timer = new GameLoopTimer() {
			@Override
			public void inputProcess() {}
			
			@Override
			public void logicUpdate() {
				ps.move();
				es.move();
			}
			
			@Override
			public void displayUpdate() {
				gc.clearRect(0, 0, 1200, 512);
				gc.drawImage(mapImage, 0, 0);
				gc.drawImage(b1.getImage(), b1.getPosition().getX(), b1.getPosition().getY());
				gc.drawImage(b2.getImage(), b2.getPosition().getX(), b2.getPosition().getY());
				gc.drawImage(ps.getCurrentImage(), ps.getPosition().getX(), ps.getPosition().getY());
				gc.drawImage(es.getCurrentImage(), es.getPosition().getX(), es.getPosition().getY());
			}
			
        };
        
        timer.start();
        primaryStage.setResizable(false);
        primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
