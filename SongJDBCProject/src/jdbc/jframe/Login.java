package jdbc.jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jdbc.dao.AccountDao;
import jdbc.dao.MemberDao;
import jdbc.dto.AccountDto;
import jdbc.dto.MemberDto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtPw;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	MemberDao dao=new MemberDao();
	AccountDao adao=new AccountDao();
	private JLabel lblNewLabel_1;
	private JButton btnNewButton_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 740);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/jdbc/jframe/kakaotalk_icon.png")));
		lblNewLabel.setBounds(193, 33, 64, 64);
		contentPane.add(lblNewLabel);
		
		txtId = new JTextField();
		txtId.setText("\uCE74\uCE74\uC624\uACC4\uC815 (\uC774\uBA54\uC77C)");
		txtId.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtId.getText().equals("카카오계정 (이메일)")) {
					txtId.setText("");
					txtId.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtId.getText().equals("")) {
					txtId.setText("카카오계정 (이메일)");
					txtId.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		txtId.setForeground(Color.LIGHT_GRAY);
		txtId.setBounds(75, 161, 300, 35);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtPw = new JTextField();
		txtPw.setText("\uBE44\uBC00\uBC88\uD638");
		txtPw.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPw.getText().equals("비밀번호")) {
					txtPw.setText("");
					txtPw.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPw.getText().equals("")) {
					txtPw.setText("비밀번호");
					txtPw.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		txtPw.setForeground(Color.LIGHT_GRAY);
		txtPw.setBounds(75, 196, 300, 35);
		contentPane.add(txtPw);
		txtPw.setColumns(10);
		
		JButton btnNewButton = new JButton("\uB85C\uADF8\uC778");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email=txtId.getText();
				String pw=txtPw.getText();
				MemberDto dto=dao.login(email, pw);
				if(dto!=null) {
					int count=adao.selectCount(email);
					if(count==0) {
						Main frame = new Main(dto);
						frame.setVisible(true);
						dispose();
					}else if(count==1) {
						ArrayList<AccountDto> list=adao.selectAll(dto.getMem_email());
						AccountDto adto=list.get(0);
						Main1 frame = new Main1(dto,adto);
						frame.setVisible(true);
						dispose();
					}else if(count==2) {
						ArrayList<AccountDto> list=adao.selectAll(dto.getMem_email());
						Main2 frame=new Main2(dto,list);
						frame.setVisible(true);
						dispose();
					}
				}else {
					JOptionPane.showMessageDialog(Login.this, "존재하지 않는 회원입니다.");
				}
			}
		});
		btnNewButton.setBounds(75, 241, 300, 40);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SingUp frame = new SingUp();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setFont(new Font("굴림", Font.PLAIN, 11));
		btnNewButton_1.setBounds(62, 300, 79, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("\uCE74\uCE74\uC624\uACC4\uC815");
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setFont(new Font("굴림", Font.PLAIN, 10));
		btnNewButton_2.setBounds(203, 300, 85, 23);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setContentAreaFilled(false);
		btnNewButton_3.setFont(new Font("굴림", Font.PLAIN, 10));
		btnNewButton_3.setBounds(288, 300, 100, 23);
		contentPane.add(btnNewButton_3);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/MainImg/\uD558\uB2E8\uBC14.png")));
		lblNewLabel_1.setBounds(0, 647, 450, 55);
		contentPane.add(lblNewLabel_1);
		
		btnNewButton_4 = new JButton("New button");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Home frame = new Home();
				frame.setVisible(true);
			}
		});
		btnNewButton_4.setContentAreaFilled(false);
		btnNewButton_4.setBorderPainted(false);
		btnNewButton_4.setBounds(160, 647, 140, 55);
		contentPane.add(btnNewButton_4);
	}
}
