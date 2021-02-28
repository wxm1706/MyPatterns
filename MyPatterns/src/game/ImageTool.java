package game;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.geometry.Point3D;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class ImageTool {
	public static void main(String[] args) throws IOException {
		ImageTool i = new ImageTool();
		i.displayPath();
	}
	
	public void displayPath() {
		System.out.println(this.getClass().getResource("").getPath());
	}
	
	public static void clipImage(Image sourceImage, int row, int col) {
		PixelReader pr = sourceImage.getPixelReader();
		WritableImage wi = new WritableImage(pr,0,0,64,64);
		
		try {
			ImageIO.write((RenderedImage) wi, "png",new File("C:\\out.png"));
		}
		catch (Exception s) {
		}
	}
	
	public static Image scale(Image source, int targetWidth, int targetHeight, boolean preserveRatio) {
	    ImageView imageView = new ImageView(source);
	    imageView.setPreserveRatio(preserveRatio);
	    imageView.setFitWidth(targetWidth);
	    imageView.setFitHeight(targetHeight);
	    SnapshotParameters parameters = new SnapshotParameters();
	    parameters.setFill(Color.TRANSPARENT);
	    return imageView.snapshot(parameters, null);
	}
	
	public static Image rotate(Image source, double angle, Point3D axis) {
		ImageView imageView = new ImageView(source);
	    imageView.setFitWidth(source.getWidth());
	    imageView.setFitHeight(source.getHeight());
	    imageView.setRotate(angle);
	    imageView.setRotationAxis(axis);
		SnapshotParameters parameters = new SnapshotParameters();
		parameters.setFill(Color.TRANSPARENT);
		return imageView.snapshot(parameters, null); 
	}
}
