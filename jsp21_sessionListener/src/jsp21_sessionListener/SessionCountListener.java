package jsp21_sessionListener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
/*
 * HttpSessionListener -> 세션이 생성되거나 종료될 때에 대한 이벤트를
 * 처리하는 리스너클래스
 */
public class SessionCountListener implements HttpSessionListener{
	private static int userCount=0;
	public static int getUserCount() {
		return userCount;
	}
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("세션이 생성되었어요!");
		userCount++;
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("세션이 종료되었어요!");
		userCount--;
	}
}
