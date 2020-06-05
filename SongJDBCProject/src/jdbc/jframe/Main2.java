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
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main2 extends JFrame {

	private JPanel contentPane;
	long ac_num1;
	long ac_num2;
	private String name;
	AccountDto adto1=new AccountDto();
	AccountDto adto2=new AccountDto();
	TransactionDao tdao=new TransactionDao();

	/**
	 * Create the frame.
	 */
	public Main2(MemberDto dto,ArrayList<AccountDto> list) {
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
		String name2=dto.getMem_name(); //«Æ≥◊¿”
		
		JLabel lblNewLabel_1 = new JLabel("\uC548\uB155\uD558\uC138\uC694.");
		lblNewLabel_1.setFont(new Font("±º∏≤", Font.BOLD, 16));
		lblNewLabel_1.setBounds(34, 113, 98, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblName1 = new JLabel(name+"¥‘,");
		lblName1.setFont(new Font("±º∏≤", Font.BOLD, 16));
		lblName1.setBounds(34, 76, 98, 37);
		contentPane.add(lblName1);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(0, 178, 450, 232);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("\uC774\uCCB4");
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcTransfer frame = new AcTransfer(dto,ac_num1);
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(0, 176, 225, 56);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("\uCE74\uB4DC\uC774\uC6A9\uB0B4\uC5ED");
		btnNewButton_1_1.setContentAreaFilled(false);
		btnNewButton_1_1.setBorderPainted(false);
		btnNewButton_1_1.setBounds(225, 176, 225, 56);
		panel.add(btnNewButton_1_1);
		
		JLabel lblac_num1 = new JLabel("\uACC4\uC88C\uBC88\uD638 \uACF5\uAC04");
		lblac_num1.setBounds(180, 45, 100, 15);
		panel.add(lblac_num1);
		
		JLabel lblName2 = new JLabel(name2+"¿« ≈Î¿Â°⁄");
		lblName2.setFont(new Font("±º∏≤", Font.BOLD, 12));
		lblName2.setBounds(12, 10, 106, 22);
		panel.add(lblName2);
		
		JButton btn1 = new JButton("");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<TransactionDto> dtlist1=tdao.selectDeposit(ac_num1);
				ArrayList<TransactionDto> wtlist1=tdao.selectWithdraw(ac_num1);
				dispose();
				TransactionState frame = new TransactionState(dto,adto1,dtlist1,wtlist1);
				frame.setVisible(true);
			}
		});
		btn1.setContentAreaFilled(false);
		btn1.setFont(new Font("±º∏≤", Font.BOLD, 15));
		btn1.setBounds(0, 0, 450, 175);
		panel.add(btn1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setLayout(null);
		panel_1.setBounds(0, 415, 450, 232);
		contentPane.add(panel_1);
		
		JButton btnNewButton_1_2 = new JButton("\uC774\uCCB4");
		btnNewButton_1_2.setContentAreaFilled(false);
		btnNewButton_1_2.setBorderPainted(false);
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcTransfer frame = new AcTransfer(dto,ac_num2);
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_2.setBounds(0, 176, 225, 56);
		panel_1.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_1_1 = new JButton("\uCE74\uB4DC\uC774\uC6A9\uB0B4\uC5ED");
		btnNewButton_1_1_1.setContentAreaFilled(false);
		btnNewButton_1_1_1.setBorderPainted(false);
		btnNewButton_1_1_1.setBounds(225, 176, 225, 56);
		panel_1.add(btnNewButton_1_1_1);
		
		JLabel lblac_num2 = new JLabel("\uACC4\uC88C\uBC88\uD638 \uACF5\uAC04");
		lblac_num2.setBounds(180, 44, 100, 15);
		panel_1.add(lblac_num2);
		
		JLabel lblName2_1 = new JLabel(name2+"¿« ≈Î¿Â°⁄");
		lblName2_1.setFont(new Font("±º∏≤", Font.BOLD, 12));
		lblName2_1.setBounds(12, 10, 106, 22);
		panel_1.add(lblName2_1);
		
		JButton btn2 = new JButton("");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<TransactionDto> dtlist2=tdao.selectDeposit(ac_num2);
				ArrayList<TransactionDto> wtlist2=tdao.selectWithdraw(ac_num2);
				dispose();
				TransactionState frame = new TransactionState(dto,adto1,dtlist2,wtlist2);
				frame.setVisible(true);
			}
		});
		btn2.setContentAreaFilled(false);
		btn2.setFont(new Font("±º∏≤", Font.BOLD, 15));
		btn2.setBounds(0, 0, 450, 175);
		panel_1.add(btn2);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(Main2.class.getResource("/MainImg/\uD558\uB2E8\uBC14.png")));
		lblNewLabel_8.setBounds(0, 647, 450, 55);
		contentPane.add(lblNewLabel_8);
		
		JButton btnNewButton_1_3 = new JButton("New button");
		btnNewButton_1_3.setContentAreaFilled(false);
		btnNewButton_1_3.setBorderPainted(false);
		btnNewButton_1_3.setBounds(152, 647, 140, 55);
		contentPane.add(btnNewButton_1_3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Main2.class.getResource("/MainImg/img3.png")));
		lblNewLabel_2.setBounds(0, 0, 450, 700);
		contentPane.add(lblNewLabel_2);
		setLocationRelativeTo(null);
		
		for(int i=0; i<list.size(); i++) {
			if(i==0) { //√ππ¯¬∞∞Ë¡¬
				adto1=list.get(i);
				ac_num1=adto1.getAc_num(); //∞Ë¡¬π¯»£
				long ac_money=adto1.getAc_money(); //¿‹æ◊
				String acNum=String.valueOf(ac_num1);
				String s=acNum.substring(0, 4)+"-"+acNum.substring(4, 6)+"-"+acNum.substring(6, 11);
				lblac_num1.setText(s);
				String acMoney=String.format("%,dø¯",ac_money);
				btn1.setText(acMoney);
			}else { //µŒπ¯¬∞∞Ë¡¬
				adto2=list.get(i);
				ac_num2=adto2.getAc_num(); //∞Ë¡¬π¯»£
				long ac_money=adto2.getAc_money(); //¿‹æ◊
				String acNum=String.valueOf(ac_num2);
				String s=acNum.substring(0, 4)+"-"+acNum.substring(4, 6)+"-"+acNum.substring(6, 11);
				lblac_num2.setText(s);
				String acMoney=String.format("%,dø¯",ac_money);
				btn2.setText(acMoney);
			}
		}
	}
}
