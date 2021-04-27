package exp.exp7;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LogoutState implements ILoginState {
	

	@Override
	public void handle(MessageBoard mb) {
		login(mb);
	}
	
	private void login(MessageBoard mb) {
		System.out.print("游客登陆（Y/N）：");
		if(mb.input().equals("Y")) {
			try {
				InetAddress addr = InetAddress.getLocalHost();
				System.out.println("游客[" + addr.getHostAddress() + "]登陆成功");
				mb.setState(MessageBoard.LOGIN);
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
		}
	}
}
