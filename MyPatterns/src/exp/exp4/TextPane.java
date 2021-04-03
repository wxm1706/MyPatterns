package exp.exp4;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class TextPane extends VBox{
	private Pane father;
	private TextField content;
	private TextField start;
	private TextField end;
	
	public TextPane(Pane father) {
		
		this.setPadding(new Insets(5, 5, 5, 5));
		this.father = father;
		start = new TextField();
		start.setText("0");
		start.setPrefWidth(30);
		end = new TextField();
		end.setPrefWidth(30);
		end.setText("0");
		content = new TextField();
		content.setPrefWidth(130);
		VBox.setMargin(content, new Insets(5, 0, 5, 0));
		Button btn = new Button("ɾ������Ļ");
		btn.setPrefWidth(130);
		HBox hbox = new HBox();
		Label l1 = new Label("��");
		Label l2 = new Label("��");
		l1.setFont(new Font(16));
		l2.setFont(new Font(16));
		hbox.getChildren().addAll(l1, start, l2, end);
		
		this.getChildren().addAll(hbox, content, btn);
		
		
		btn.setOnAction(e -> {
			remove();
		});
	}
	
	
	public void remove() {
		father.getChildren().remove(this);
	}


	public Pane getFather() {
		return father;
	}


	public void setFather(Pane father) {
		this.father = father;
	}


	public TextField getContent() {
		return content;
	}


	public void setContent(TextField content) {
		this.content = content;
	}


	public TextField getStart() {
		return start;
	}


	public void setStart(TextField start) {
		this.start = start;
	}


	public TextField getEnd() {
		return end;
	}


	public void setEnd(TextField end) {
		this.end = end;
	}
	
}
