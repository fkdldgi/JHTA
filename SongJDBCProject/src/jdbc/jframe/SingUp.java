package jdbc.jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jdbc.dao.MemberDao;
import jdbc.dto.MemberDto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.Point;
import java.awt.Cursor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class SingUp extends JFrame {

	private JPanel contentPane;
	private JTextField txtemail;
	private JTextField txtpw;
	private JTextField txtname;
	private JTextField txtresnum;
	private JTextField txtphone;
	private JTextField txtaddr;
	MemberDao dao=new MemberDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SingUp frame = new SingUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SingUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("\uCE74\uCE74\uC624\uACC4\uC815 \uC815\uBCF4\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel.setBounds(32, 77, 320, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("kakao");
		lblNewLabel_1.setFont(new Font("Aparajita", Font.BOLD, 35));
		lblNewLabel_1.setBounds(187, 29, 75, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\uCE74\uCE74\uC624\uACC4\uC815 \uC774\uBA54\uC77C");
		lblNewLabel_2.setBounds(32, 145, 122, 15);
		contentPane.add(lblNewLabel_2);
		
		txtemail = new JTextField();
		txtemail.setOpaque(false);
		txtemail.setAutoscrolls(false);
		txtemail.setBounds(32, 170, 370, 30);
		contentPane.add(txtemail);
		txtemail.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblNewLabel_3.setBounds(32, 215, 55, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\uC774\uB984");
		lblNewLabel_4.setBounds(32, 285, 57, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\uC8FC\uBBFC\uB4F1\uB85D\uBC88\uD638");
		lblNewLabel_5.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblNewLabel_5.setBounds(32, 361, 93, 15);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\uC804\uD654\uBC88\uD638");
		lblNewLabel_6.setBounds(30, 441, 57, 15);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("\uC8FC\uC18C");
		lblNewLabel_7.setBounds(32, 519, 57, 15);
		contentPane.add(lblNewLabel_7);
		
		txtpw = new JTextField();
		txtpw.setOpaque(false);
		txtpw.setColumns(10);
		txtpw.setAutoscrolls(false);
		txtpw.setBounds(32, 240, 370, 30);
		contentPane.add(txtpw);
		
		txtname = new JTextField();
		txtname.setOpaque(false);
		txtname.setColumns(10);
		txtname.setAutoscrolls(false);
		txtname.setBounds(32, 310, 370, 30);
		contentPane.add(txtname);
		
		txtresnum = new JTextField();
		txtresnum.setOpaque(false);
		txtresnum.setColumns(10);
		txtresnum.setAutoscrolls(false);
		txtresnum.setBounds(32, 386, 370, 30);
		contentPane.add(txtresnum);
		
		txtphone = new JTextField();
		txtphone.setOpaque(false);
		txtphone.setColumns(10);
		txtphone.setAutoscrolls(false);
		txtphone.setBounds(32, 466, 370, 30);
		contentPane.add(txtphone);
		
		txtaddr = new JTextField();
		txtaddr.setOpaque(false);
		txtaddr.setColumns(10);
		txtaddr.setAutoscrolls(false);
		txtaddr.setBounds(32, 544, 370, 30);
		contentPane.add(txtaddr);
		
		JButton btnNewButton = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberDto dto=new MemberDto(txtemail.getText(),txtpw.getText(),txtname.getText(),
						Long.parseLong(txtresnum.getText()),Long.parseLong(txtphone.getText()),txtaddr.getText(),null);
				int n=0;
				if(txtresnum.getText().length()==13) {
					n=dao.signUp(dto);
				}
				if(n>0) {
					JOptionPane.showMessageDialog(SingUp.this, "회원가입 완료!");
					dispose();
					Login frame = new Login();
					frame.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(SingUp.this, "회원가입 실패!");
				}
			}
		});
		btnNewButton.setBounds(32, 600, 155, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uCDE8\uC18C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login frame = new Login();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(247, 600, 155, 40);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(SingUp.class.getResource("/MainImg/\uD558\uB2E8\uBC14.png")));
		lblNewLabel_8.setBounds(0, 647, 450, 55);
		contentPane.add(lblNewLabel_8);
		
		JButton btnNewButton_1_1 = new JButton("New button");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Home frame = new Home();
				frame.setVisible(true);
			}
		});
		btnNewButton_1_1.setContentAreaFilled(false);
		btnNewButton_1_1.setBorderPainted(false);
		btnNewButton_1_1.setBounds(157, 647, 140, 55);
		contentPane.add(btnNewButton_1_1);
	}

}
