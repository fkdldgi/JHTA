package jdbc.jframe;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import jdbc.dao.AccountDao;
import jdbc.dao.TransactionDao;
import jdbc.dto.AccountDto;
import jdbc.dto.MemberDto;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Transaction extends JFrame {

	private JPanel contentPane;
	private JTextField txtmoney;
	private JComboBox cbAcData = new JComboBox();
	private JLabel lblPayCheck = new JLabel("");
	
	String[] s=new String[2];
	AccountDao adao=new AccountDao();
	AccountDto adto1=new AccountDto(); //첫번째 계좌
	AccountDto adto2=new AccountDto(); //두번째 계좌

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transaction frame = new Transaction(new MemberDto(),0,0,"");
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
	public Transaction(MemberDto dto,long wdac_num,long deac_num,String bname) { //회원정보,출금될계좌번호,이체할 계좌번호,은행명
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);	
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBounds(12, 210, 425, 330);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton btn1 = new JButton("");
		btn1.setIcon(new ImageIcon(Transaction.class.getResource("/jdbc/jframe/numButtonimg/numpad_1.png")));
		btn1.setContentAreaFilled(false);
		btn1.setBorderPainted(false);
		panel.add(btn1);
		
		JButton btn2 = new JButton("");
		btn2.setIcon(new ImageIcon(Transaction.class.getResource("/jdbc/jframe/numButtonimg/numpad_2.png")));
		btn2.setContentAreaFilled(false);
		btn2.setBorderPainted(false);
		panel.add(btn2);
		
		JButton btn3 = new JButton("");
		btn3.setIcon(new ImageIcon(Transaction.class.getResource("/jdbc/jframe/numButtonimg/numpad_3.png")));
		btn3.setContentAreaFilled(false);
		btn3.setBorderPainted(false);
		panel.add(btn3);
		
		JButton btn4 = new JButton("");
		btn4.setIcon(new ImageIcon(Transaction.class.getResource("/jdbc/jframe/numButtonimg/numpad_4.png")));
		btn4.setContentAreaFilled(false);
		btn4.setBorderPainted(false);
		panel.add(btn4);
		
		JButton btn5 = new JButton("");
		btn5.setIcon(new ImageIcon(Transaction.class.getResource("/jdbc/jframe/numButtonimg/numpad_5.png")));
		btn5.setContentAreaFilled(false);
		btn5.setBorderPainted(false);
		panel.add(btn5);
		
		JButton btn6 = new JButton("");
		btn6.setIcon(new ImageIcon(Transaction.class.getResource("/jdbc/jframe/numButtonimg/numpad_6.png")));
		btn6.setContentAreaFilled(false);
		btn6.setBorderPainted(false);
		panel.add(btn6);
		
		JButton btn7 = new JButton("");
		btn7.setIcon(new ImageIcon(Transaction.class.getResource("/jdbc/jframe/numButtonimg/numpad_7.png")));
		btn7.setContentAreaFilled(false);
		btn7.setBorderPainted(false);
		panel.add(btn7);
		
		JButton btn8 = new JButton("");
		btn8.setIcon(new ImageIcon(Transaction.class.getResource("/jdbc/jframe/numButtonimg/numpad_8.png")));
		btn8.setContentAreaFilled(false);
		btn8.setBorderPainted(false);
		panel.add(btn8);
		
		JButton btn9 = new JButton("");
		btn9.setIcon(new ImageIcon(Transaction.class.getResource("/jdbc/jframe/numButtonimg/numpad_9.png")));
		btn9.setContentAreaFilled(false);
		btn9.setBorderPainted(false);
		panel.add(btn9);
		
		JButton btnNewButton_5_4 = new JButton("");
		btnNewButton_5_4.setEnabled(false);
		btnNewButton_5_4.setContentAreaFilled(false);
		btnNewButton_5_4.setBorderPainted(false);
		panel.add(btnNewButton_5_4);
		
		JButton btn0 = new JButton("");
		btn0.setIcon(new ImageIcon(Transaction.class.getResource("/jdbc/jframe/numButtonimg/numpad_0.png")));
		btn0.setContentAreaFilled(false);
		btn0.setBorderPainted(false);
		panel.add(btn0);
		
		JButton btnDel = new JButton("");
		btnDel.setIcon(new ImageIcon(Transaction.class.getResource("/jdbc/jframe/numButtonimg/numpad_del.png")));
		btnDel.setContentAreaFilled(false);
		btnDel.setBorderPainted(false);
		panel.add(btnDel);
		
		JButton btnNewButton = new JButton("\uACC4\uC88C\uC774\uCCB4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { //이체버튼
				String item=(String)cbAcData.getSelectedItem();
				String[] arr=item.split("\\(|\\)");
				long wdac_num=Long.parseLong(arr[1]);
				int count=adao.selectCount(dto.getMem_email()); //로그인 되어있는 아이디의 계좌수
				if(cbAcData.getSelectedIndex()==0) { //첫번째 계좌를 선택했을 경우 
					if(Long.parseLong(txtmoney.getText())>adto1.getAc_money()) { //이체할 잔액이 부족할 경우
						JOptionPane.showMessageDialog(Transaction.this, "계좌잔액이 부족합니다.");
					}else if(Long.parseLong(txtmoney.getText())==adto1.getAc_money()) { //잔액이 0원일경우
						JOptionPane.showMessageDialog(Transaction.this, "0원은 이체할 수 없습니다.");
					}else if(wdac_num==deac_num) {
						JOptionPane.showMessageDialog(Transaction.this, "내 계좌에 입금할 수 없습니다.");
					}else {	//이체성공
						TransactionDao tdao=new TransactionDao();
						//입출금기능 및 거래테이블 insert 트랜잭션
						tdao.transaction(wdac_num, deac_num, Long.parseLong(txtmoney.getText()));
						//이체 성공 후 계좌수에 맞게 Main화면으로 돌아가기
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
					}
				}else {	//두번째 계좌를 선택했을 경우
					if(Long.parseLong(txtmoney.getText())>adto2.getAc_money()) {
						JOptionPane.showMessageDialog(Transaction.this, "계좌잔액이 부족합니다.");
					}else if(Long.parseLong(txtmoney.getText())==adto2.getAc_money()) {
						JOptionPane.showMessageDialog(Transaction.this, "0원은 이체할 수 없습니다.");
					}else {
						TransactionDao tdao=new TransactionDao();
						//입출금기능 및 거래테이블 insert 트랜잭션
						tdao.transaction(wdac_num, deac_num, Long.parseLong(txtmoney.getText())); 
						//이체 성공 후 계좌수에 맞게 Main화면으로 돌아가기
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
					}
				}
			}
		});
		btnNewButton.setFont(new Font("굴림", Font.BOLD, 17));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(0, 561, 449, 70);
		contentPane.add(btnNewButton);
		
		txtmoney = new JTextField();
		txtmoney.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {

				if(txtmoney.getText().equals("보낼금액")) {
					txtmoney.setText("");
					txtmoney.setForeground(Color.BLACK);
				}		
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtmoney.getText().equals("")) {
					txtmoney.setText("보낼금액");
					txtmoney.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		txtmoney.setBorder(null);
		txtmoney.setOpaque(false);
		txtmoney.setHorizontalAlignment(SwingConstants.CENTER);
		txtmoney.setFont(new Font("굴림", Font.BOLD, 30));
		txtmoney.setForeground(Color.LIGHT_GRAY);
		txtmoney.setText("\uBCF4\uB0BC\uAE08\uC561");
		txtmoney.setBounds(88, 79, 297, 41);
		contentPane.add(txtmoney);
		txtmoney.setColumns(10);
		
		
		JLabel lblDsac = new JLabel(bname+" "+deac_num);
		lblDsac.setHorizontalAlignment(SwingConstants.CENTER);
		lblDsac.setBounds(88, 10, 297, 15);
		contentPane.add(lblDsac);
		
		
		ArrayList<AccountDto> list=adao.selectAll(dto.getMem_email());
		if(list.size()>1) {
			adto1=list.get(0);
			long getAc_num1=adto1.getAc_num(); //내계좌번호
			long ac_money1=adto1.getAc_money(); //계좌잔액
			s[0]=dto.getMem_name()+"의 통장("+getAc_num1+"): "+ac_money1+"원";
			
			adto2=list.get(1);
			long getAc_num2=adto2.getAc_num(); //내계좌번호
			long ac_money2=adto2.getAc_money(); //계좌잔액
			s[1]=dto.getMem_name()+"의 통장("+getAc_num2+"): "+ac_money2+"원";
		}else{
			adto1=list.get(0);
			long getAc_num1=adto1.getAc_num(); //내계좌번호
			long ac_money1=adto1.getAc_money(); //계좌잔액
			s[0]=dto.getMem_name()+"의 통장("+getAc_num1+"): "+ac_money1+"원";
		}

		
		
		cbAcData.setModel(new DefaultComboBoxModel(s));
		cbAcData.setBounds(28, 153, 388, 35);
		contentPane.add(cbAcData);
		
		
		lblPayCheck.setBounds(120, 128, 244, 15);
		contentPane.add(lblPayCheck);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(Transaction.class.getResource("/MainImg/\uD558\uB2E8\uBC14.png")));
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
		btnNewButton_1.setBounds(150, 647, 140, 55);
		contentPane.add(btnNewButton_1);
	}
}
