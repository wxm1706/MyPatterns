package exp.exp7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MessageBoard {
	private List<String> messageList;
	private ILoginState state;
	private Scanner input;
	public static ILoginState LOGIN = new LoginState();
	public static ILoginState LOGOUT = new LogoutState();
	
	
	public MessageBoard(ILoginState state) {
		super();
		this.state = state;
		this.messageList = new ArrayList<String>();
		input = new Scanner(System.in);
	}

	public void request() {
		state.handle(this);
		display();
	}
	
	public String input() {
		return input.next();
	}
	
	public void display() {
		System.out.println("*******************************ÁôÑÔ°å*******************************");
		for(String str:messageList) {
			System.out.println("-->" + str);
		}
		System.out.println("******************************************************************");
	}
	
	public void addMessage(String m) {
		messageList.add(m);
	}

	public ILoginState getState() {
		return state;
	}

	public void setState(ILoginState state) {
		this.state = state;
	}
}                                                                      