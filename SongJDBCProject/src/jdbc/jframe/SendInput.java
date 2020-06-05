package jdbc.jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jdbc.dto.MemberDto;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class SendInput extends JFrame {

	private JPanel contentPane;
	private JTextField txtAcNum;
	private JLabel lblNewLabel_1 = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SendInput frame = new SendInput(new MemberDto(),0);
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
	public SendInput(MemberDto dto,long ac_num) {
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JComboBox cb1 = new JComboBox();
		cb1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				lblNewLabel_1.setIcon(new ImageIcon(SendInput.class.getResource("/BankImg/"+cb1.getSelectedItem()+".png")));
			}
		});
		
		cb1.setModel(new DefaultComboBoxModel(new String[] {"\uCE74\uCE74\uC624\uBC45\uD06C", "\uAE30\uC5C5\uC740\uD589", "\uC2E0\uD55C\uC740\uD589", "\uAD6D\uBBFC\uC740\uD589", "\uC6B0\uB9AC\uC740\uD589"}));
		cb1.setBounds(99, 33, 99, 21);
		contentPane.add(cb1);
		
		JLabel lblNewLabel = new JLabel("\uC785\uAE08\uC740\uD589");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setBounds(99, 68, 57, 15);
		contentPane.add(lblNewLabel);
		
		JButton btnSubit = new JButton("\uD655\uC778");
		btnSubit.setFont(new Font("굴림", Font.BOLD, 17));
		btnSubit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtAcNum.getText().length()==13) {
					String bname=(String)cb1.getSelectedItem();
					long deac_num=Long.parseLong(txtAcNum.getText());
					dispose();
					Transaction frame = new Transaction(dto,ac_num,deac_num,bname);
					frame.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(SendInput.this, "입금할 계좌번호(13자리)를 입력하세요.");
				}
			}
		});
		btnSubit.setBounds(0, 554, 449, 70);
		contentPane.add(btnSubit);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBounds(12, 174, 422, 330);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton btn1 = new JButton("");
		btn1.setIcon(new ImageIcon(SendInput.class.getResource("/jdbc/jframe/numButtonimg/numpad_1.png")));
		btn1.setContentAreaFilled(false);
		btn1.setBorderPainted(false);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
			}
		});
		panel.add(btn1);
		
		JButton btn2 = new JButton("");
		btn2.setIcon(new ImageIcon(SendInput.class.getResource("/jdbc/jframe/numButtonimg/numpad_2.png")));
		btn2.setContentAreaFilled(false);
		btn2.setBorderPainted(false);
		panel.add(btn2);
		
		JButton btn3 = new JButton("");
		btn3.setIcon(new ImageIcon(SendInput.class.getResource("/jdbc/jframe/numButtonimg/numpad_3.png")));
		btn3.setContentAreaFilled(false);
		btn3.setBorderPainted(false);
		panel.add(btn3);
		
		JButton btn4 = new JButton("");
		btn4.setIcon(new ImageIcon(SendInput.class.getResource("/jdbc/jframe/numButtonimg/numpad_4.png")));
		btn4.setContentAreaFilled(false);
		btn4.setBorderPainted(false);
		panel.add(btn4);
		
		JButton btn5 = new JButton("");
		btn5.setIcon(new ImageIcon(SendInput.class.getResource("/jdbc/jframe/numButtonimg/numpad_5.png")));
		btn5.setContentAreaFilled(false);
		btn5.setBorderPainted(false);
		panel.add(btn5);
		
		JButton btn6 = new JButton("");
		btn6.setIcon(new ImageIcon(SendInput.class.getResource("/jdbc/jframe/numButtonimg/numpad_6.png")));
		btn6.setContentAreaFilled(false);
		btn6.setBorderPainted(false);
		panel.add(btn6);
		
		JButton btn7 = new JButton("");
		btn7.setIcon(new ImageIcon(SendInput.class.getResource("/jdbc/jframe/numButtonimg/numpad_7.png")));
		btn7.setContentAreaFilled(false);
		btn7.setBorderPainted(false);
		panel.add(btn7);
		
		JButton btn8 = new JButton("");
		btn8.setIcon(new ImageIcon(SendInput.class.getResource("/jdbc/jframe/numButtonimg/numpad_8.png")));
		btn8.setContentAreaFilled(false);
		btn8.setBorderPainted(false);
		panel.add(btn8);
		
		JButton btn9 = new JButton("");
		btn9.setIcon(new ImageIcon(SendInput.class.getResource("/jdbc/jframe/numButtonimg/numpad_9.png")));
		btn9.setContentAreaFilled(false);
		btn9.setBorderPainted(false);
		panel.add(btn9);
		
		JButton btnNewButton_5_4 = new JButton("");
		btnNewButton_5_4.setEnabled(false);
		btnNewButton_5_4.setContentAreaFilled(false);
		btnNewButton_5_4.setBorderPainted(false);
		panel.add(btnNewButton_5_4);
		
		JButton btn0 = new JButton("");
		btn0.setIcon(new ImageIcon(SendInput.class.getResource("/jdbc/jframe/numButtonimg/numpad_0.png")));
		btn0.setContentAreaFilled(false);
		btn0.setBorderPainted(false);
		panel.add(btn0);
		
		JButton btnDel = new JButton("");
		btnDel.setIcon(new ImageIcon(SendInput.class.getResource("/jdbc/jframe/numButtonimg/numpad_del.png")));
		btnDel.setContentAreaFilled(false);
		btnDel.setBorderPainted(false);
		panel.add(btnDel);
		
		txtAcNum = new JTextField();
		txtAcNum.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtAcNum.getText().equals("입금할 계좌번호 입력")) {
					txtAcNum.setText("");
					txtAcNum.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtAcNum.getText().equals("")) {
					txtAcNum.setText("입금할 계좌번호 입력");
					txtAcNum.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		txtAcNum.setText("\uC785\uAE08\uD560 \uACC4\uC88C\uBC88\uD638 \uC785\uB825");
		txtAcNum.setForeground(Color.LIGHT_GRAY);
		txtAcNum.setFont(new Font("굴림", Font.BOLD, 16));
		txtAcNum.setColumns(10);
		txtAcNum.setBounds(38, 122, 377, 42);
		contentPane.add(txtAcNum);
		
		
		lblNewLabel_1.setIcon(new ImageIcon(SendInput.class.getResource("/BankImg/\uCE74\uCE74\uC624\uBC45\uD06C.png")));
		lblNewLabel_1.setBounds(38, 33, 50, 50);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(SendInput.class.getResource("/MainImg/\uD558\uB2E8\uBC14.png")));
		lblNewLabel_8.setBounds(0, 647, 450, 55);
		contentPane.add(lblNewLabel_8);
		
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
		btnNewButton_1.setBounds(153, 647, 140, 55);
		contentPane.add(btnNewButton_1);
	}
}
