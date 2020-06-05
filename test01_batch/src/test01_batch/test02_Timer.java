package test01_batch;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class test02_Timer {
	public static void main(String[] args) {
		TimerTask task=new TimerTask() {//일정시간마다 수행해야할 job(인터페이스라서 익명의 내부클래스로 구현)
			@Override
			public void run() {
				System.out.println(new Date());
			}
		};
		Timer timer=new Timer(true);//true:메인메소드가 끝나면 같이 죽음
		Calendar cal=Calendar.getInstance();//실행할 시간에 대한 정보를 갖는날짜객체
		cal.set(2020,4,26,15,10,0);//실행할 시간 설정(월은 -1해서넣어줌 ex:5월=4)
		timer.scheduleAtFixedRate(task,new Date(cal.getTimeInMillis()),2000);
		try {
			Thread.sleep(120000);
		}catch (InterruptedException ie) {
			System.out.println(ie.getMessage());
		}
		System.out.println("프로그램종료...");
		timer.cancel();//타이머해제
	}
}





