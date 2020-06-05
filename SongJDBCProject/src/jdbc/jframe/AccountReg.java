package jdbc.jframe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jdbc.dao.AccountDao;
import jdbc.dto.AccountDto;
import jdbc.dto.MemberDto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class AccountReg extends JFrame {

	private JPanel contentPane;
	private JTextField txtAccount;
	private JTextField txtPw;
	AccountDao adao=new AccountDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountReg frame = new AccountReg(new MemberDto());
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
	public AccountReg(MemberDto dto) {
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("\uACC4\uC88C\uC0DD\uC131");
		lblNewLabel.setRequestFocusEnabled(true);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setEnabled(true);
		lblNewLabel.setBounds(154, 10, 140, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("<html><center>\uC0AC\uC6A9\uD560 \uACC4\uC88C\uBC88\uD638\uC640</center>\uACC4\uC88C\uBE44\uBC00\uBC88\uD638\uB97C \uC785\uB825\uD558\uC138\uC694..</html>");
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 14));
		lblNewLabel_1.setBounds(62, 72, 322, 67);
		contentPane.add(lblNewLabel_1);
		
		txtAccount = new JTextField();
		txtAccount.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtAccount.getText().equals("계좌번호(13자리)")) {
					txtAccount.setText("");
					txtAccount.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtAccount.getText().equals("")) {
					txtAccount.setText("계좌번호(13자리)");
					txtAccount.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		txtAccount.setText("\uACC4\uC88C\uBC88\uD638(13\uC790\uB9AC)");
		txtAccount.setForeground(Color.LIGHT_GRAY);
		txtAccount.setColumns(10);
		txtAccount.setBounds(62, 214, 322, 40);
		contentPane.add(txtAccount);
		
		txtPw = new JTextField();
		txtPw.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPw.getText().equals("계좌비밀번호(6자리)")) {
					txtPw.setText("");
					txtPw.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPw.getText().equals("")) {
					txtPw.setText("계좌비밀번호(6자리)");
					txtPw.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		txtPw.setText("\uACC4\uC88C\uBE44\uBC00\uBC88\uD638(6\uC790\uB9AC)");
		txtPw.setForeground(Color.LIGHT_GRAY);
		txtPw.setColumns(10);
		txtPw.setBounds(62, 255, 322, 40);
		contentPane.add(txtPw);
		
		JComboBox cbBank = new JComboBox();
		cbBank.setFont(new Font("굴림", Font.BOLD, 12));
		cbBank.setModel(new DefaultComboBoxModel(new String[] {"\uCE74\uCE74\uC624\uBC45\uD06C", "\uAE30\uC5C5\uC740\uD589", "\uC2E0\uD55C\uC740\uD589", "\uAD6D\uBBFC\uC740\uD589", "\uC6B0\uB9AC\uC740\uD589"}));
		cbBank.setBounds(62, 173, 322, 40);
		contentPane.add(cbBank);
		
		JButton btnNewButton = new JButton("\uD655\uC778");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long ac_num=Long.parseLong(txtAccount.getText());
				String mem_email=dto.getMem_email();
				int ac_pw=Integer.parseInt(txtPw.getText());
				String ac_bname=(String)cbBank.getSelectedItem();
				AccountDto adto=new AccountDto(ac_num,mem_email,ac_pw,100000,ac_bname);		
				if(txtAccount.getText().length()==13 && txtPw.getText().length()==6 ) {
					int n=adao.insertNew(adto);
					if(n>0) { //계좌생성 성공
						JOptionPane.showMessageDialog(AccountReg.this, "계좌개설이 완료되었습니다.");
						//계좌 개수에 따라 Main,Main1,Main2를 호출
						int count=adao.selectCount(dto.getMem_email());
						if(count==1) {
							Main1 frame = new Main1(dto,adto);
							frame.setVisible(true);
							dispose();
						}else if(count==2) {
							ArrayList<AccountDto> list=adao.selectAll(dto.getMem_email());
							Main2 frame=new Main2(dto,list);
							frame.setVisible(true);
							dispose();
						}
					}else { //계좌생성실패
						JOptionPane.showMessageDialog(AccountReg.this, "존재하는 계좌입니다.");
					}
				}else {
					JOptionPane.showMessageDialog(AccountReg.this, "계좌번호(13자리) 혹은 비밀번호(6자리)를 입력하세요.");
				}
			}
		});
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 14));
		btnNewButton.setBounds(62, 295, 322, 40);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(AccountReg.class.getResource("/MainImg/\uD558\uB2E8\uBC14.png")));
		lblNewLabel_2.setBounds(0, 647, 450, 55);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Home frame = new Home();
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(154, 647, 140, 55);
		contentPane.add(btnNewButton_1);
	}
}


