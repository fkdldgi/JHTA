package jdbc.jframe;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import java.awt.event.ActionEvent;
import javax.swing.JTable;


public class Home extends JFrame {
	private JPanel contentPane;
	JLabel lbl_time = new JLabel("\uB0A0\uC9DC,\uC2DC\uAC04 \uC694\uC77C");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 740);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		
		lbl_time.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_time.setBounds(36, 20, 364, 81);
		contentPane.add(lbl_time);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setIcon(new ImageIcon(Home.class.getResource("/jdbc/jframe/kakaotalk_icon.png")));
		lblNewLabel_2.setBounds(36, 410, 64, 64);
		contentPane.add(lblNewLabel_2);
		
		JButton bankicon = new JButton("");
		bankicon.setIcon(new ImageIcon(Home.class.getResource("/jdbc/jframe/\uCE74\uCE74\uC624\uBC45\uD06C \uC5B4\uD50C\uC544\uC774\uCF581.png")));
		bankicon.setBorderPainted(false);
		bankicon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Login login = new Login();
				login.setVisible(true);
			}
		});
		bankicon.setForeground(Color.WHITE);
		bankicon.setBackground(Color.WHITE);
		bankicon.setBounds(136, 410, 64, 64);
		bankicon.setContentAreaFilled(false);
		contentPane.add(bankicon);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(Home.class.getResource("/jdbc/jframe/call-icon-android-62-64x64.png")));
		lblNewLabel_2_1.setBackground(Color.WHITE);
		lblNewLabel_2_1.setBounds(36, 532, 64, 64);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("");
		lblNewLabel_2_1_1.setIcon(new ImageIcon(Home.class.getResource("/jdbc/jframe/\uADF8\uB9BC2.png")));
		lblNewLabel_2_1_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1.setBounds(236, 532, 64, 64);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("");
		lblNewLabel_2_1_2.setIcon(new ImageIcon(Home.class.getResource("/jdbc/jframe/\uADF8\uB9BC4.png")));
		lblNewLabel_2_1_2.setBackground(Color.WHITE);
		lblNewLabel_2_1_2.setBounds(136, 532, 64, 64);
		contentPane.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_2_1_3 = new JLabel("");
		lblNewLabel_2_1_3.setIcon(new ImageIcon(Home.class.getResource("/jdbc/jframe/1200px-Samsung_Internet_logo.svg.png")));
		lblNewLabel_2_1_3.setBackground(Color.WHITE);
		lblNewLabel_2_1_3.setBounds(336, 532, 64, 64);
		contentPane.add(lblNewLabel_2_1_3);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(Home.class.getResource("/MainImg/\uD558\uB2E8\uBC14.png")));
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
		btnNewButton_1.setBounds(160, 647, 140, 55);
		contentPane.add(btnNewButton_1);
	}
}
