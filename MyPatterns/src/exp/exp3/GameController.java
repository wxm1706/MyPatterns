package exp.exp3;

import java.util.ArrayList;
import java.util.List;

public class GameController {
	private static final GameController instance = new GameController();
	private List<String> keyInputs;
	
	private GameController() {
		setKeyInputs(new ArrayList<String>());
	}

	public void process() {
		GameManager gm = GameManager.getManager();
		String lastKey = "";
		if(keyInputs.size() > 0) {
			lastKey = keyInputs.get(keyInputs.size() - 1);
		}		
		switch(lastKey) {
			case "LEFT":{
				if(gm.getPlayer().getPosition().getX() > 0) {
					gm.getPlayer().left();
				}else{
					gm.getPlayer().stop();
				}}break;
			case "RIGHT":{
				if(gm.getPlayer().getPosition().getX() < (gm.getMap().getWidth() - gm.getPlayer().getWidth())) {
					gm.getPlayer().right();
				}else{
					gm.getPlayer().stop();
				}}break;
			case "STOP":{
				gm.getPlayer().stop();
				}break;
			default:break;
		}
		keyInputs.clear();
	}
	
	public static GameController getController() {
		return instance;
	}

	public void add(String keyInput) {
		getKeyInputs().add(keyInput);
	}

	public List<String> getKeyInputs() {
		return keyInputs;
	}


	public void setKeyInputs(List<String> keyInputs) {
		this.keyInputs = keyInputs;
	}
}
