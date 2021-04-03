package patterns.adapter.case2;

import java.nio.file.Paths;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MainApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		ScrollPane pane = new ScrollPane();
		HBox fp = new HBox();
		pane.setContent(fp);
		IGIFProcessor gifp = new GIFProcessor();
		
		Image[] images = gifp.extract(Paths.get("bin/images/res/earth.gif").toString());
		for(int i = 0; i < images.length; i++) {
			fp.getChildren().add(new ImageView(images[i]));
		}
		Scene scene = new Scene(pane, 800, 400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("GIFProcessor");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
