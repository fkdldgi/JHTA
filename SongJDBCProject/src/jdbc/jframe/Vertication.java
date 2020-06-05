package jdbc.jframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jdbc.dao.MemberDao;
import jdbc.dto.MemberDto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Vertication extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtRes;
	MemberDao dao=new MemberDao();
	private JLabel lblNewLabel_2;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vertication frame = new Vertication(new MemberDto());
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
	public Vertication(MemberDto dto) {
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC2E4\uBA85\uC815\uBCF4 \uD655\uC778");
		lblNewLabel.setEnabled(true);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setRequestFocusEnabled(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setBounds(153, 10, 140, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("<html><center>\uC2E4\uBA85\uC815\uBCF4 \uD655\uC778\uC744 \uC704\uD574</center>\uC774\uB984\uACFC \uC8FC\uBBFC\uB4F1\uB85D\uBC88\uD638\uB97C \uC785\uB825\uD558\uC138\uC694.</html>");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("����", Font.BOLD, 14));
		lblNewLabel_1.setBounds(56, 72, 322, 67);
		contentPane.add(lblNewLabel_1);
		
		txtName = new JTextField();
		txtName.setForeground(Color.LIGHT_GRAY);
		txtName.setText("\uC774\uB984");
		txtName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtName.getText().equals("�̸�")) {
					txtName.setText("");
					txtName.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent arg0) {
				if(txtName.getText().equals("")) {
					txtName.setText("�̸�");
					txtName.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		txtName.setBounds(56, 171, 322, 40);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtRes = new JTextField();
		txtRes.setForeground(Color.LIGHT_GRAY);
		txtRes.setText("\uC8FC\uBBFC\uB4F1\uB85D\uBC88\uD638");
		txtRes.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtRes.getText().equals("�ֹε�Ϲ�ȣ")) {
					txtRes.setText("");
					txtRes.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtRes.getText().equals("")) {
					txtRes.setText("�ֹε�Ϲ�ȣ");
					txtRes.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		txtRes.setColumns(10);
		txtRes.setBounds(56, 212, 322, 40);
		contentPane.add(txtRes);
		
		//�Ǹ����� Ȯ�ι�ư�� �������
		JButton btnNewButton = new JButton("\uD655\uC778");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name="";
				name=dao.selectVerti(txtName.getText(),Long.parseLong(txtRes.getText()));
				if(name.equals(dto.getMem_name())) {
					JOptionPane.showMessageDialog(Vertication.this, "�Ǹ������� �Ϸ�Ǿ����ϴ�.");
					AccountReg frame = new AccountReg(dto);
					frame.setVisible(true);
					dispose();
				}else {
					JOptionPane.showMessageDialog(Vertication.this, "�̸��� �ֹε�Ϲ�ȣ�� Ȯ�����ּ���.");
				}
			}
		});
		btnNewButton.setFont(new Font("����", Font.BOLD, 14));
		btnNewButton.setBounds(56, 251, 322, 40);
		contentPane.add(btnNewButton);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Vertication.class.getResource("/MainImg/\uD558\uB2E8\uBC14.png")));
		lblNewLabel_2.setBounds(0, 647, 450, 55);
		contentPane.add(lblNewLabel_2);
		
		btnNewButton_1 = new JButton("New button");
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
		setLocationRelativeTo(null);
	}
}
