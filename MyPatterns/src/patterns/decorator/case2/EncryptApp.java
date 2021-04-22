package patterns.decorator.case2;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class EncryptApp extends Application {
	private List<Encryptor> encryptorlist;

	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox global = new VBox();
		encryptorlist = new ArrayList<Encryptor>();
		
		Font font = new Font(16);
		Border border = new Border(new BorderStroke[] {new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, null)});
		
		HBox encryptLayout = new  HBox();
		Button encryptBtnA = new Button("加密器A");
		Button encryptBtnB = new Button("加密器B");
		Button encryptBtnC = new Button("加密器C");
		encryptBtnA.setFont(font);
		encryptBtnB.setFont(font);
		encryptBtnC.setFont(font);
		encryptLayout.setPadding(new Insets(5, 5, 5, 5));
		HBox.setMargin(encryptBtnB, new Insets(0, 5, 0, 5));
		encryptLayout.getChildren().addAll(encryptBtnA, encryptBtnB, encryptBtnC);
		//encryptLayout.setBorder(border);
		
		HBox contentLayout = new HBox();
		contentLayout.setPadding(new Insets(5, 5, 5, 5));
		TextArea plaintext = new TextArea();
		plaintext.setPrefWidth(250);
		plaintext.setPrefHeight(350);
		VBox controlLayout = new VBox();
		controlLayout.setPadding(new Insets(0, 5, 0, 5));
		Button encodeBtn = new Button("加密->");
		encodeBtn.setFont(font);
		VBox cipherList = new VBox();
		Button decodeBtn = new Button("<-解密");
		VBox.setMargin(encodeBtn, new Insets(0, 0, 5, 0));
		VBox.setMargin(decodeBtn, new Insets(5, 0, 0, 0));
		decodeBtn.setFont(font);
		controlLayout.getChildren().addAll(encodeBtn, cipherList, decodeBtn);
		TextArea ciphertext = new TextArea();
		ciphertext.setPrefWidth(250);
		ciphertext.setPrefHeight(350);
		contentLayout.getChildren().addAll(plaintext, controlLayout, ciphertext);
		
		
		encryptBtnA.setOnAction(e -> {
			Button tempBtn = new Button("加密A");
			tempBtn.setFont(font);
			tempBtn.setPrefWidth(decodeBtn.getWidth());
			VBox.setMargin(tempBtn, new Insets(5, 0, 0, 0));
			cipherList.getChildren().add(tempBtn);
			Encryptor a = new EncryptorA(); 
			encryptorlist.add(a);
			tempBtn.setOnAction(ine -> {
				cipherList.getChildren().remove(tempBtn);
				encryptorlist.remove(a);
			});
		});
		
		encryptBtnB.setOnAction(e -> {
			Button tempBtn = new Button("加密B");
			tempBtn.setFont(font);
			tempBtn.setPrefWidth(decodeBtn.getWidth());
			VBox.setMargin(tempBtn, new Insets(5, 0, 0, 0));
			cipherList.getChildren().add(tempBtn);
			Encryptor b = new EncryptorB(); 
			encryptorlist.add(b);
			tempBtn.setOnAction(ine -> {
				cipherList.getChildren().remove(tempBtn);
				encryptorlist.remove(b);
			});
		});
		
		encryptBtnC.setOnAction(e -> {
			Button tempBtn = new Button("加密C");
			tempBtn.setFont(font);
			tempBtn.setPrefWidth(decodeBtn.getWidth());
			VBox.setMargin(tempBtn, new Insets(5, 0, 0, 0));
			cipherList.getChildren().add(tempBtn);
			Encryptor c = new EncryptorC(); 
			encryptorlist.add(c);
			tempBtn.setOnAction(ine -> {
				cipherList.getChildren().remove(tempBtn);
				encryptorlist.remove(c);
			});
		});
		
		encodeBtn.setOnAction(e -> {
			System.out.println(encryptorlist.size());
			if(encryptorlist.size() > 0) {
				for(Encryptor encryptor:encryptorlist) {
					encryptor.setCipher(null);
				}
				Encryptor encryptor = encryptorlist.get(0);
				for(int i = 0; i < encryptorlist.size() - 1; i++) {
					encryptorlist.get(i).setCipher(encryptorlist.get(i + 1));
				}
				ciphertext.setText(encryptor.encipher(plaintext.getText()));
			}
		});
		
		decodeBtn.setOnAction(e -> {
			System.out.println(encryptorlist.size());
			if(encryptorlist.size() > 0) {
				for(Encryptor encryptor:encryptorlist) {
					encryptor.setCipher(null);
				}
				Encryptor encryptor = encryptorlist.get(0);
				for(int i = 0; i < encryptorlist.size() - 1; i++) {
					encryptorlist.get(i).setCipher(encryptorlist.get(i + 1));
				}
				plaintext.setText(encryptor.decipher(ciphertext.getText()));
			}
		});
		
		
		global.getChildren().addAll(encryptLayout, contentLayout);
		Scene scene = new Scene(global, 600, 400);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.setTitle("加密器");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
