package patterns.fmp.case2;

import java.io.File;

import game.GameLoopTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MyApp extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		double height = 600;
		double width = 800;
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
		
		IFactory roleFactory = new PlayerFactory();
		Role player = roleFactory.create(new File(System.getProperty("user.dir") + "/bin/images/saber/"));
		roleFactory = new MonsterFactory();
		Role monster = roleFactory.create(new File(System.getProperty("user.dir") + "/bin/images/monster/wolfman.png"));
		
		Image mapImage = new Image("file:" + System.getProperty("user.dir") + "/bin/images/maps/map01.png");
		
		GameLoopTimer timer = new GameLoopTimer() {
			@Override
			public void inputProcess() {
			}

			@Override
			public void logicUpdate() {
				player.move();
				monster.move();
			}

			@Override
			public void displayUpdate() {
				gc.clearRect(0, 0, 600, 800);
				gc.drawImage(mapImage, 0, 0);
				gc.drawImage(player.getImage(), player.getLocation().getX(), player.getLocation().getY());
				gc.drawImage(monster.getImage(), monster.getLocation().getX(), monster.getLocation().getY());
			}
			
        };
        
        timer.start();
        primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
