package jdbc.jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jdbc.dao.TransactionDao;
import jdbc.dto.AccountDto;
import jdbc.dto.MemberDto;
import jdbc.dto.TransactionDto;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Component;

public class Main1 extends JFrame {

	private JPanel contentPane;
	private String name;
	TransactionDao tdao=new TransactionDao();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Main1 frame = new Main1(new MemberDto(),new AccountDto());
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
	public Main1(MemberDto dto,AccountDto adto) {
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		if(dto.getMem_name().length()>2) {
			name=dto.getMem_name().substring(1,3);
		}else if(dto.getMem_name().length()<3) {
			name=dto.getMem_name();
		}
		String name2=dto.getMem_name();
		
		JLabel lblNewLabel_1 = new JLabel("\uC548\uB155\uD558\uC138\uC694.");
		lblNewLabel_1.setFont(new Font("±¼¸²", Font.BOLD, 16));
		lblNewLabel_1.setBounds(37, 117, 98, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblName1 = new JLabel(name+"´Ô,");
		lblName1.setFont(new Font("±¼¸²", Font.BOLD, 16));
		lblName1.setBounds(37, 80, 98, 37);
		contentPane.add(lblName1);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBorder(null);
		panel.setBounds(6, 178, 438, 233);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("\uC774\uCCB4");
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.addActionListener(new ActionListener() { //°èÁÂÀÌÃ¼·Î ÀÌµ¿
			public void actionPerformed(ActionEvent e) {
				AcTransfer frame = new AcTransfer(dto,adto.getAc_num()); //dto:³»È¸¿øÁ¤º¸, °èÁÂ¹øÈ£¸¦ ÆÄ¶ó¹ÌÅÍ·Î º¸³¿
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(0, 178, 219, 55);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("\uCE74\uB4DC\uC774\uC6A9\uB0B4\uC5ED");
		btnNewButton_1_1.setBorderPainted(false);
		btnNewButton_1_1.setContentAreaFilled(false);
		btnNewButton_1_1.setBounds(219, 178, 219, 54);
		panel.add(btnNewButton_1_1);
		
		String acNum=String.valueOf(adto.getAc_num());
		String s=acNum.substring(0, 4)+"-"+acNum.substring(4, 6)+"-"+acNum.substring(6, 11);
		JLabel lblNewLabel_2 = new JLabel(s);
		lblNewLabel_2.setForeground(Color.DARK_GRAY);
		lblNewLabel_2.setBounds(175, 58, 100, 15);
		panel.add(lblNewLabel_2);
		
		JLabel lblName2 = new JLabel(name2+"ÀÇ ÅëÀå¡Ú");
		lblName2.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lblName2.setBounds(12, 20, 106, 22);
		panel.add(lblName2);
		
		
		String acMoney=String.format("%,d",adto.getAc_money()); 
		JButton btnNewButton = new JButton(acMoney+"¿ø");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setOpaque(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<TransactionDto> dtlist1=tdao.selectDeposit(adto.getAc_num());
				ArrayList<TransactionDto> wtlist1=tdao.selectWithdraw(adto.getAc_num());
				dispose();
				TransactionState frame = new TransactionState(dto,adto,dtlist1,wtlist1);
				frame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("±¼¸²", Font.BOLD, 15));
		btnNewButton.setBounds(0, 0, 438, 178);
		panel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Vertication frame = new Vertication(dto);
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("±¼¸²", Font.BOLD, 17));
		btnNewButton_2.setBounds(6, 418, 438, 230);
		contentPane.add(btnNewButton_2);
		
		JLabel lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(Main1.class.getResource("/MainImg/img1.png")));
		lblImg.setBounds(0, 0, 450, 700);
		contentPane.add(lblImg);
		
		JButton btnNewButton_1_2 = new JButton("New button");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Home frame = new Home();
				frame.setVisible(true);
			}
		});
		btnNewButton_1_2.setContentAreaFilled(false);
		btnNewButton_1_2.setBorderPainted(false);
		btnNewButton_1_2.setBounds(153, 658, 140, 55);
		contentPane.add(btnNewButton_1_2);
		setLocationRelativeTo(null);
	}
}
