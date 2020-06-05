package test01_batch;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class test02_Timer {
	public static void main(String[] args) {
		TimerTask task=new TimerTask() {//�����ð����� �����ؾ��� job(�������̽��� �͸��� ����Ŭ������ ����)
			@Override
			public void run() {
				System.out.println(new Date());
			}
		};
		Timer timer=new Timer(true);//true:���θ޼ҵ尡 ������ ���� ����
		Calendar cal=Calendar.getInstance();//������ �ð��� ���� ������ ���³�¥��ü
		cal.set(2020,4,26,15,10,0);//������ �ð� ����(���� -1�ؼ��־��� ex:5��=4)
		timer.scheduleAtFixedRate(task,new Date(cal.getTimeInMillis()),2000);
		try {
			Thread.sleep(120000);
		}catch (InterruptedException ie) {
			System.out.println(ie.getMessage());
		}
		System.out.println("���α׷�����...");
		timer.cancel();//Ÿ�̸�����
	}
}





