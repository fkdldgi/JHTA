package jdbc.jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jdbc.dto.AccountDto;
import jdbc.dto.MemberDto;
import jdbc.dto.TransactionDto;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JTabbedPane;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TransactionState extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Date[] tr_date1=new Date[5]; //입금된 쪽 날짜배열
	private long[] wdac_num=new long[5]; //상대방계좌번호
	private long[] tr_money1=new long[5]; //입금된 쪽 거래금액
	private long[] tr_afmoney1=new long[5]; //입금된 쪽 잔액
	
	private Date[] tr_date2=new Date[5]; //출금된 쪽 날짜배열
	private long[] deac_num=new long[5]; //상대방계좌번호
	private long[] tr_money2=new long[5]; //출금된 쪽 거래금액
	private long[] tr_afmoney2=new long[5]; //출금된 쪽 잔액
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AccountState frame = new AccountState();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public TransactionState(MemberDto dto,AccountDto adto,ArrayList<TransactionDto> tlist,ArrayList<TransactionDto> tlist2) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		if(tlist!=null) {
			for(int i=0; i<tlist.size(); i++) {
				TransactionDto tdto=tlist.get(i);
				tr_date1[i]=tdto.getTr_date();
				wdac_num[i]=tdto.getWdac_num();
				tr_money1[i]=tdto.getTr_money();
				tr_afmoney1[i]=tdto.getTr_afmoney();
				if(i==4) {
					break;
				}
			}
		}
		if(tlist2!=null) {
			for(int i=0; i<tlist2.size(); i++) {
				TransactionDto tdto=tlist2.get(i);
				tr_date2[i]=tdto.getTr_date();
				deac_num[i]=tdto.getWdac_num();
				tr_money2[i]=tdto.getTr_money();
				tr_afmoney2[i]=tdto.getTr_afmoney();
				if(i==4) {
					break;
				}
			}
		}
		
		JLabel lbl1 = new JLabel(dto.getMem_name()+"의 통장");
		lbl1.setBounds(0, 0, 449, 40);
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setBackground(Color.YELLOW);
		contentPane.add(lbl1);
		
		textField = new JTextField();
		textField.setBounds(0, 212, 449, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 40, 449, 172);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		
		String acNum=String.valueOf(adto.getAc_num());
		String s=acNum.substring(0, 4)+"-"+acNum.substring(4, 6)+"-"+acNum.substring(6, 11);
		JLabel lblNewLabel_8 = new JLabel(s);
		lblNewLabel_8.setForeground(Color.DARK_GRAY);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(116, 35, 210, 15);
		panel_5.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel(adto.getAc_money()+"원");
		lblNewLabel_9.setFont(new Font("굴림", Font.BOLD, 17));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBounds(58, 70, 337, 48);
		panel_5.add(lblNewLabel_9);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 251, 449, 393);
		contentPane.add(tabbedPane);
		
		JPanel panel_6 = new JPanel();
		tabbedPane.addTab("              출금내역              ", null, panel_6, null);
		tabbedPane.setFont(new Font("굴림", Font.BOLD, 12));
		panel_6.setLayout(null);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setLayout(null);
		panel_4_1.setBounds(0, 292, 444, 73);
		panel_6.add(panel_4_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("");
		if(tr_date2[4]!=null) {
			lblNewLabel_7_1.setText(tr_date2[4]+"");
		}
		lblNewLabel_7_1.setBounds(2, 20, 78, 15);
		panel_4_1.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("");
		if(deac_num[4]!=0) {
			String temp=String.valueOf(deac_num[4]);
			String s0=temp.substring(0, 4)+"-"+temp.substring(4, 6)+"-"+temp.substring(6, 11);
			lblNewLabel_1_4_1.setText(s0);
		}
		lblNewLabel_1_4_1.setBounds(79, 20, 140, 15);
		panel_4_1.add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_2_4_1 = new JLabel("");
		if(tr_money2[4]!=0) {
			String trMoney=String.format("%,d원",tr_money2[4]);
			lblNewLabel_2_4_1.setText("-"+trMoney);
		}
		lblNewLabel_2_4_1.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_2_4_1.setBounds(341, 15, 96, 25);
		panel_4_1.add(lblNewLabel_2_4_1);
		
		JLabel lblNewLabel_3_4_1 = new JLabel("");
		if(tr_afmoney2[4]!=0) {
			String trMoney=String.format("%,d원",tr_afmoney2[4]);
			lblNewLabel_3_4_1.setText(trMoney);
		}
		lblNewLabel_3_4_1.setForeground(Color.GRAY);
		lblNewLabel_3_4_1.setBounds(341, 50, 96, 15);
		panel_4_1.add(lblNewLabel_3_4_1);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBounds(0, 219, 444, 73);
		panel_6.add(panel_3_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("");
		if(tr_date2[3]!=null) {
			lblNewLabel_6_1.setText(tr_date2[3]+"");
		}
		lblNewLabel_6_1.setBounds(2, 20, 78, 15);
		panel_3_1.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("");
		if(deac_num[3]!=0) {
			String temp=String.valueOf(deac_num[3]);
			String s0=temp.substring(0, 4)+"-"+temp.substring(4, 6)+"-"+temp.substring(6, 11);
			lblNewLabel_1_3_1.setText(s0);
		}
		lblNewLabel_1_3_1.setBounds(79, 20, 140, 15);
		panel_3_1.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("");
		if(tr_money2[3]!=0) {
			String trMoney=String.format("%,d원",tr_money2[3]);
			lblNewLabel_2_3_1.setText("-"+trMoney);
		}
		lblNewLabel_2_3_1.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_2_3_1.setBounds(341, 15, 96, 25);
		panel_3_1.add(lblNewLabel_2_3_1);
		
		JLabel lblNewLabel_3_3_1 = new JLabel("");
		if(tr_afmoney2[3]!=0) {
			String trMoney=String.format("%,d원",tr_afmoney2[3]);
			lblNewLabel_3_3_1.setText(trMoney);
		}
		lblNewLabel_3_3_1.setForeground(Color.GRAY);
		lblNewLabel_3_3_1.setBounds(341, 50, 96, 15);
		panel_3_1.add(lblNewLabel_3_3_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBounds(0, 146, 444, 73);
		panel_6.add(panel_2_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("");
		if(tr_date2[2]!=null) {
			lblNewLabel_5_1.setText(tr_date2[2]+"");
		}
		lblNewLabel_5_1.setBounds(2, 20, 78, 15);
		panel_2_1.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("");
		if(deac_num[2]!=0) {
			String temp=String.valueOf(deac_num[2]);
			String s0=temp.substring(0, 4)+"-"+temp.substring(4, 6)+"-"+temp.substring(6, 11);
			lblNewLabel_1_2_1.setText(s0);
		}
		lblNewLabel_1_2_1.setBounds(79, 20, 140, 15);
		panel_2_1.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("");
		if(tr_money2[2]!=0) {
			String trMoney=String.format("%,d원",tr_money2[2]);
			lblNewLabel_2_2_1.setText("-"+trMoney);
		}
		lblNewLabel_2_2_1.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_2_2_1.setBounds(341, 15, 96, 25);
		panel_2_1.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("");
		if(tr_afmoney2[2]!=0) {
			String trMoney=String.format("%,d원",tr_afmoney2[2]);
			lblNewLabel_3_2_1.setText(trMoney);
		}
		lblNewLabel_3_2_1.setForeground(Color.GRAY);
		lblNewLabel_3_2_1.setBounds(341, 50, 96, 15);
		panel_2_1.add(lblNewLabel_3_2_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(0, 73, 444, 73);
		panel_6.add(panel_1_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		if(tr_date2[1]!=null) {
			lblNewLabel_4_1.setText(tr_date2[1]+"");
		}
		lblNewLabel_4_1.setBounds(2, 20, 78, 15);
		panel_1_1.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		if(deac_num[1]!=0) {
			String temp=String.valueOf(deac_num[1]);
			String s0=temp.substring(0, 4)+"-"+temp.substring(4, 6)+"-"+temp.substring(6, 11);
			lblNewLabel_1_1_1.setText(s0);
		}
		lblNewLabel_1_1_1.setBounds(79, 20, 140, 15);
		panel_1_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("");
		if(tr_money2[1]!=0) {
			String trMoney=String.format("%,d원",tr_money2[1]);
			lblNewLabel_2_1_1.setText("-"+trMoney);
		}
		lblNewLabel_2_1_1.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_2_1_1.setBounds(341, 15, 96, 25);
		panel_1_1.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("");
		if(tr_afmoney2[1]!=0) {
			String trMoney=String.format("%,d원",tr_afmoney2[1]);
			lblNewLabel_3_1_1.setText(trMoney);
		}
		lblNewLabel_3_1_1.setForeground(Color.GRAY);
		lblNewLabel_3_1_1.setBounds(341, 50, 96, 15);
		panel_1_1.add(lblNewLabel_3_1_1);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBounds(0, 0, 444, 73);
		panel_6.add(panel_7);
		
		JLabel lblNewLabel_10 = new JLabel("");
		if(tr_date2[0]!=null) {
			lblNewLabel_10.setText(tr_date2[0]+"");
		}
		lblNewLabel_10.setBounds(2, 20, 78, 15);
		panel_7.add(lblNewLabel_10);
		
		JLabel lblNewLabel_1_5 = new JLabel("");
		if(deac_num[0]!=0) {
			String temp=String.valueOf(deac_num[0]);
			String s0=temp.substring(0, 4)+"-"+temp.substring(4, 6)+"-"+temp.substring(6, 11);
			lblNewLabel_1_5.setText(s0);
		}
		lblNewLabel_1_5.setBounds(79, 20, 140, 15);
		panel_7.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_2_5 = new JLabel("");
		if(tr_money2[0]!=0) {
			String trMoney=String.format("%,d원",tr_money2[0]);
			lblNewLabel_2_5.setText("-"+trMoney);
		}
		lblNewLabel_2_5.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_2_5.setBounds(341, 15, 96, 25);
		panel_7.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_3_5 = new JLabel("");
		if(tr_afmoney2[0]!=0) {
			String trMoney=String.format("%,d원",tr_afmoney2[0]);
			lblNewLabel_3_5.setText(trMoney);
		}
		lblNewLabel_3_5.setForeground(Color.GRAY);
		lblNewLabel_3_5.setBounds(341, 50, 96, 15);
		panel_7.add(lblNewLabel_3_5);
		
		JPanel panel_6_1 = new JPanel();
		panel_6_1.setLayout(null);
		tabbedPane.addTab("              입금내역              ", null, panel_6_1, null);
		
		JPanel panel_4_1_1 = new JPanel();
		panel_4_1_1.setLayout(null);
		panel_4_1_1.setBounds(0, 292, 444, 73);
		panel_6_1.add(panel_4_1_1);
		
		JLabel date5 = new JLabel("");
		if(tr_date1[4]!=null) {
			date5.setText(tr_date1[4]+"");
		}
		date5.setBounds(2, 20, 78, 15);
		panel_4_1_1.add(date5);
		
		JLabel num5 = new JLabel("");
		if(wdac_num[4]!=0) {
			String temp=String.valueOf(wdac_num[4]);
			String s0=temp.substring(0, 4)+"-"+temp.substring(4, 6)+"-"+temp.substring(6, 11);
			num5.setText(s0);
		}
		num5.setBounds(88, 20, 140, 15);
		panel_4_1_1.add(num5);
		
		JLabel tran5 = new JLabel("");
		tran5.setForeground(SystemColor.textHighlight);
		if(tr_money1[4]!=0) {
			String trMoney=String.format("%,d원",tr_money1[4]);
			tran5.setText(trMoney);
		}
		tran5.setBounds(341, 15, 96, 25);
		panel_4_1_1.add(tran5);
		
		JLabel money5 = new JLabel("");
		if(tr_afmoney1[4]!=0) {
			String trMoney=String.format("%,d원",tr_afmoney1[4]);
			money5.setText(trMoney);
		}
		money5.setForeground(Color.GRAY);
		money5.setBounds(341, 50, 96, 15);
		panel_4_1_1.add(money5);
		
		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setLayout(null);
		panel_3_1_1.setBounds(0, 219, 444, 73);
		panel_6_1.add(panel_3_1_1);
		
		JLabel date4 = new JLabel("");
		if(tr_date1[3]!=null) {
			date4.setText(tr_date1[3]+"");
		}
		date4.setBounds(2, 20, 78, 15);
		panel_3_1_1.add(date4);
		
		JLabel num4 = new JLabel("");
		if(wdac_num[3]!=0) {
			String temp=String.valueOf(wdac_num[3]);
			String s0=temp.substring(0, 4)+"-"+temp.substring(4, 6)+"-"+temp.substring(6, 11);
			num4.setText(s0);
		}
		num4.setBounds(88, 20, 140, 15);
		panel_3_1_1.add(num4);
		
		JLabel tran4 = new JLabel("");
		tran4.setForeground(SystemColor.textHighlight);
		if(tr_money1[3]!=0) {
			String trMoney=String.format("%,d원",tr_money1[3]);
			tran4.setText(trMoney);
		}
		tran4.setBounds(341, 15, 96, 25);
		panel_3_1_1.add(tran4);
		
		JLabel money4 = new JLabel("");
		if(tr_afmoney1[3]!=0) {
			String trMoney=String.format("%,d원",tr_afmoney1[3]);
			money4.setText(trMoney);
		}
		money4.setForeground(Color.GRAY);
		money4.setBounds(341, 50, 96, 15);
		panel_3_1_1.add(money4);
		
		JPanel panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBounds(0, 146, 444, 73);
		panel_6_1.add(panel_2_1_1);
		
		JLabel date3 = new JLabel("");
		if(tr_date1[2]!=null) {
			date3.setText(tr_date1[2]+"");
		}
		date3.setBounds(2, 20, 78, 15);
		panel_2_1_1.add(date3);
		
		JLabel num3 = new JLabel("");
		if(wdac_num[2]!=0) {
			String temp=String.valueOf(wdac_num[2]);
			String s0=temp.substring(0, 4)+"-"+temp.substring(4, 6)+"-"+temp.substring(6, 11);
			num3.setText(s0);
		}
		num3.setBounds(88, 20, 140, 15);
		panel_2_1_1.add(num3);
		
		JLabel tran3 = new JLabel("");
		tran3.setForeground(SystemColor.textHighlight);
		if(tr_money1[2]!=0) {
			String trMoney=String.format("%,d원",tr_money1[2]);
			tran3.setText(trMoney);
		}
		tran3.setBounds(341, 15, 96, 25);
		panel_2_1_1.add(tran3);
		
		JLabel money3 = new JLabel("");
		if(tr_afmoney1[2]!=0) {
			String trMoney=String.format("%,d원",tr_afmoney1[2]);
			money3.setText(trMoney);
		}
		money3.setForeground(Color.GRAY);
		money3.setBounds(341, 50, 96, 15);
		panel_2_1_1.add(money3);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBounds(0, 73, 444, 73);
		panel_6_1.add(panel_1_1_1);
		
		JLabel date2 = new JLabel("");
		if(tr_date1[1]!=null) {
			date2.setText(tr_date1[1]+"");
		}
		date2.setBounds(2, 20, 78, 15);
		panel_1_1_1.add(date2);
		
		JLabel num2 = new JLabel("");
		if(wdac_num[1]!=0) {
			String temp=String.valueOf(wdac_num[1]);
			String s0=temp.substring(0, 4)+"-"+temp.substring(4, 6)+"-"+temp.substring(6, 11);
			num2.setText(s0);
		}
		num2.setBounds(88, 20, 140, 15);
		panel_1_1_1.add(num2);
		
		JLabel tran2 = new JLabel("");
		tran2.setForeground(SystemColor.textHighlight);
		if(tr_money1[1]!=0) {
			String trMoney=String.format("%,d원",tr_money1[1]);
			tran2.setText(trMoney);
		}
		tran2.setBounds(341, 15, 96, 25);
		panel_1_1_1.add(tran2);
		
		JLabel money2 = new JLabel("");
		if(tr_afmoney1[1]!=0) {
			String trMoney=String.format("%,d원",tr_afmoney1[1]);
			money2.setText(trMoney);
		}
		money2.setForeground(Color.GRAY);
		money2.setBounds(341, 50, 96, 15);
		panel_1_1_1.add(money2);
		
		JPanel panel_7_1 = new JPanel();
		panel_7_1.setLayout(null);
		panel_7_1.setBounds(0, 0, 444, 73);
		panel_6_1.add(panel_7_1);
		
		JLabel date1 = new JLabel("");
		if(tr_date1[0]!=null) {
			date1.setText(tr_date1[0]+"");
		}
		date1.setBounds(2, 20, 78, 15);
		panel_7_1.add(date1);
		
		JLabel num1 = new JLabel("");
		if(wdac_num[0]!=0) {
			String temp=String.valueOf(wdac_num[0]);
			String s0=temp.substring(0, 4)+"-"+temp.substring(4, 6)+"-"+temp.substring(6, 11);
			num1.setText(s0);
		}
		num1.setBounds(88, 20, 140, 15);
		panel_7_1.add(num1);
		
		JLabel tran1 = new JLabel("");
		tran1.setForeground(SystemColor.textHighlight);
		if(tr_money1[0]!=0) {
			String trMoney=String.format("%,d원",tr_money1[0]);
			tran1.setText(trMoney);
		}
		tran1.setBounds(341, 15, 96, 25);
		panel_7_1.add(tran1);
		
		JLabel money1 = new JLabel("");
		money1.setForeground(Color.GRAY);
		if(tr_afmoney1[0]!=0) {
			String trMoney=String.format("%,d원",tr_afmoney1[0]);
			money1.setText(trMoney);
		}
		money1.setBounds(341, 50, 96, 15);
		panel_7_1.add(money1);
		
		JLabel lblNewLabel_8_1 = new JLabel("");
		lblNewLabel_8_1.setIcon(new ImageIcon(TransactionState.class.getResource("/MainImg/\uD558\uB2E8\uBC14.png")));
		lblNewLabel_8_1.setBounds(0, 647, 450, 55);
		contentPane.add(lblNewLabel_8_1);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Home frame = new Home();
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBounds(149, 647, 140, 55);
		contentPane.add(btnNewButton_1);
	}
}
