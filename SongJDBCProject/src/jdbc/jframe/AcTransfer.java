package jdbc.jframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jdbc.dto.AccountDto;
import jdbc.dto.MemberDto;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.List;
import javax.swing.ImageIcon;

public class AcTransfer extends JFrame {

	private JPanel contentPane;
	private JTextField txt1;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JButton txtInput;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JLabel lblNewLabel_8;
	private JButton btnNewButton_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AcTransfer frame = new AcTransfer(new MemberDto(),0);
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
	public AcTransfer(MemberDto dto,long ac_num) { //dto와 계좌번호를 파라미터로 받음
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("\uC774\uCCB4");
		lblNewLabel.setFont(new Font("HY헤드라인M", Font.BOLD, 20));
		lblNewLabel.setBounds(49, 44, 57, 47);
		contentPane.add(lblNewLabel);
		
		txt1 = new JTextField();
		txt1.setForeground(Color.LIGHT_GRAY);
		txt1.setText("\uBC1B\uB294\uC0AC\uB78C \uC774\uB984 \uB610\uB294 \uACC4\uC88C\uBC88\uD638");
		txt1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(txt1.getText().equals("받는사람 이름 또는 계좌번호")) {
					txt1.setText("");
					txt1.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txt1.getText().equals("")) {
					txt1.setText("받는사람 이름 또는 계좌번호");
					txt1.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		txt1.setOpaque(false);
		txt1.setBounds(49, 101, 348, 35);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(49, 170, 348, 300);
		contentPane.add(tabbedPane);
		
		panel = new JPanel();
		tabbedPane.addTab("               계좌번호               ", null, panel, null);
		panel.setLayout(null);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBounds(50, 0, 288, 50);
		panel.add(btnNewButton_1);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(0, 0, 50, 50);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(0, 50, 50, 50);
		panel.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(0, 100, 50, 50);
		panel.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(0, 150, 50, 50);
		panel.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(1, 200, 50, 50);
		panel.add(lblNewLabel_7);
		
		btnNewButton_2 = new JButton("");
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setBounds(50, 50, 288, 50);
		panel.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("");
		btnNewButton_3.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_3.setContentAreaFilled(false);
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setBounds(50, 100, 288, 50);
		panel.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("");
		btnNewButton_4.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_4.setContentAreaFilled(false);
		btnNewButton_4.setBorderPainted(false);
		btnNewButton_4.setBounds(50, 150, 288, 50);
		panel.add(btnNewButton_4);
		
		btnNewButton_5 = new JButton("");
		btnNewButton_5.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_5.setContentAreaFilled(false);
		btnNewButton_5.setBorderPainted(false);
		btnNewButton_5.setBounds(50, 200, 288, 50);
		panel.add(btnNewButton_5);
		
		panel_1 = new JPanel();
		tabbedPane.addTab("            카카오톡 친구            ", null, panel_1, null);
		panel_1.setLayout(null);
		
		lblNewLabel_1 = new JLabel("\uCE5C\uAD6C\uC758 \uACC4\uC88C\uBC88\uD638\uB97C \uBAB0\uB77C\uB3C4 OK!");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_1.setBounds(73, 43, 187, 37);
		panel_1.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("<html><center>\uBA54\uC2DC\uC9C0 \uBCF4\uB0B4\uB4EF \uCE74\uCE74\uC624\uD1A1 \uCE5C\uAD6C\uC5D0\uAC8C<br>\uAC04\uD3B8\uD558\uAC8C \uC774\uCCB4\uD560 \uC218 \uC788\uC2B5\uB2C8\uB2E4.</center></html>");
		lblNewLabel_2.setBounds(73, 74, 199, 51);
		panel_1.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("\uCE74\uCE74\uC624\uACC4\uC815 \uC5F0\uACB0");
		btnNewButton.setBorderPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBackground(Color.YELLOW);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(73, 135, 187, 48);
		panel_1.add(btnNewButton);
		
		txtInput = new JButton("+ \uACC4\uC88C\uBC88\uD638 \uC9C1\uC811\uC785\uB825");
		txtInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SendInput frame = new SendInput(dto,ac_num);
				frame.setVisible(true);
			}
		});
		txtInput.setBackground(Color.WHITE);
		txtInput.setFont(new Font("굴림", Font.BOLD, 12));
		txtInput.setBounds(49, 527, 348, 47);
		contentPane.add(txtInput);
		
		lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(AcTransfer.class.getResource("/MainImg/\uD558\uB2E8\uBC14.png")));
		lblNewLabel_8.setBounds(0, 647, 450, 55);
		contentPane.add(lblNewLabel_8);
		
		btnNewButton_6 = new JButton("New button");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Home frame = new Home();
				frame.setVisible(true);
			}
		});
		btnNewButton_6.setContentAreaFilled(false);
		btnNewButton_6.setBorderPainted(false);
		btnNewButton_6.setBounds(154, 647, 140, 55);
		contentPane.add(btnNewButton_6);
		
	}
}
