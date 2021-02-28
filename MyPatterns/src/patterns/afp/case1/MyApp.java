package patterns.afp.case1;

import java.io.File;

import game.GameLoopTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
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
		
		IFactory factory1 = new CartoonFactory();
		Role r1 = factory1.createRole(new File(System.getProperty("user.dir") + "/bin/images/saber/"));
		Effect e1 = factory1.createEffect(new File(System.getProperty("user.dir") + "/bin/images/effects/e01/"));
		e1.setLocation(new Point2D(450, 50));
		IFactory factory2 = new PixelFactory();
		Role r2 = factory2.createRole(new File(System.getProperty("user.dir") + "/bin/images/roles/role001.png"));
		Effect e2 = factory2.createEffect(new File(System.getProperty("user.dir") + "/bin/images/effects/e02/boom.png"));
		e2.setLocation(new Point2D(150, 350));
		
		Image mapImage = new Image("file:" + System.getProperty("user.dir") + "/bin/images/maps/map01.png");
		
		
		GameLoopTimer timer = new GameLoopTimer() {
			@Override
			public void inputProcess() {
			}

			@Override
			public void logicUpdate() {
				r1.move();
				r2.move();
				e1.change();
				e2.change();
			}

			@Override
			public void displayUpdate() {
				gc.clearRect(0, 0, 600, 800);
				gc.drawImage(mapImage, 0, 0, 800, 600);
				gc.drawImage(r1.getImage(), r1.getLocation().getX(), r1.getLocation().getY());
				gc.drawImage(r2.getImage(), r2.getLocation().getX(), r2.getLocation().getY());
				gc.drawImage(e1.getImage(), e1.getLocation().getX(), e1.getLocation().getY());
				gc.drawImage(e2.getImage(), e2.getLocation().getX(), e2.getLocation().getY());
			}
			
        };
        
        timer.start();
        primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
