package jdbc.jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jdbc.dto.MemberDto;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;
	private String name;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Main frame = new Main(new MemberDto());
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
	public Main(MemberDto dto) {
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		if(dto.getMem_name().length()>2) {
			name=dto.getMem_name().substring(1,3);
		}else if(dto.getMem_name().length()<3) {
			name=dto.getMem_name();
		}
		
		JLabel lblNewLabel_1 = new JLabel("\uC548\uB155\uD558\uC138\uC694.");
		lblNewLabel_1.setFont(new Font("±¼¸²", Font.BOLD, 16));
		lblNewLabel_1.setBounds(40, 116, 98, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblName = new JLabel(name+"´Ô,"); //·Î±×ÀÎ ÇÑ È¸¿øÀÇ ÀÌ¸§À¸·Î ¼³Á¤
		lblName.setFont(new Font("±¼¸²", Font.BOLD, 16));
		lblName.setBounds(40, 79, 98, 37);
		contentPane.add(lblName);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(0, 191, 450, 238);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vertication frame = new Vertication(dto);
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("±¼¸²", Font.BOLD, 17));
		btnNewButton.setBounds(0, 0, 450, 238);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("|");
		lblNewLabel_4.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_4.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(190, 414, 17, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(Main.class.getResource("/MainImg/\uD558\uB2E8\uBC14.png")));
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
		btnNewButton_1.setBounds(155, 647, 140, 55);
		contentPane.add(btnNewButton_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Main.class.getResource("/MainImg/img2.png")));
		label.setBounds(0, 0, 450, 700);
		contentPane.add(label);
		setLocationRelativeTo(null);
	}
}
