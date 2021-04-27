package exp.exp7;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

public class LoginState implements ILoginState {

	@Override
	public void handle(MessageBoard mb) {
		String str = mb.input();
		if(str.equals("exit")) {
			mb.setState(MessageBoard.LOGOUT);
		}else {
			try {
				mb.addMessage(str + "\t" + InetAddress.getLocalHost().getHostAddress() + "\t" + new Date());
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
		}
	}
}
