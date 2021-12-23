package BookCheckoutReturn;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Book.*;
import Member.*;
import SQL.dbConnector;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import java.awt.Color;

public class BookCheckout extends JFrame {
	
	dbConnector dbConn = new dbConnector();

	private JPanel contentPane;
	JTextField textField;
	JTextField textField_1;
	JTextField textField_2;
	JTextField textField_3;
	JTextField textField_4;
	JTextField textField_5;
	JTextField textField_6;
	JTextField textField_7;
	JTextField textField_9;
	JTextField textField_8;
	JRadioButton rdbtnNewRadioButton;
	JRadioButton rdbtnNewRadioButton_1;
	JLabel lblNewLabel_1_1;
	BookCheckout getSelf() {
		return this;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookCheckout frame = new BookCheckout();
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
	public BookCheckout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 428);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\uB3C4\uC11C\uAD00\uB9AC");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\uB3C4\uC11C\uAC80\uC0C9");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				BookSearch temp = new BookSearch();
				temp.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\uB3C4\uC11C\uB4F1\uB85D");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				BookRegister temp = new BookRegister();
				temp.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("\uD68C\uC6D0\uAD00\uB9AC");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\uD68C\uC6D0\uAC80\uC0C9");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MemberSearch temp = new MemberSearch();
				temp.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\uD68C\uC6D0\uB4F1\uB85D");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				MemberRegister temp = new MemberRegister();
				temp.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_2 = new JMenu("\uB300\uCD9C\uAD00\uB9AC");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\uB3C4\uC11C\uB300\uCD9C");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				BookCheckout temp = new BookCheckout();
				temp.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\uB3C4\uC11C\uBC18\uB0A9");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				BookReturn temp = new BookReturn();
				temp.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("book image");
		lblNewLabel_1.setBounds(306, 35, 67, 89);
		lblNewLabel_1.setBorder(new LineBorder(Color.BLACK));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("\uC81C\uBAA9");
		lblNewLabel.setBounds(385, 35, 57, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("\uC800\uC790");
		lblNewLabel_2.setBounds(385, 69, 57, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uAC00\uACA9");
		lblNewLabel_3.setBounds(385, 97, 57, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2_1 = new JLabel("\uB9C1\uD06C");
		lblNewLabel_2_1.setBounds(385, 131, 57, 15);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setBounds(385, 159, 57, 15);
		contentPane.add(lblIsbn);
		
		JLabel lblNewLabel_2_2 = new JLabel("\uC124\uBA85");
		lblNewLabel_2_2.setBounds(385, 193, 57, 15);
		contentPane.add(lblNewLabel_2_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(426, 33, 226, 21);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(426, 64, 226, 21);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(426, 95, 226, 21);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(426, 126, 226, 21);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(426, 157, 226, 21);
		contentPane.add(textField_4);
		
		JButton btnNewButton = new JButton("\uB300\uCD9C");
		btnNewButton.setBounds(446, 281, 97, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uB3C4\uC11C\uAC80\uC0C9");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BCR_BookSearch temp = new BCR_BookSearch();
				temp.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(555, 281, 97, 37);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(426, 191, 226, 63);
		contentPane.add(scrollPane);
		
		textField_5 = new JTextField();
		textField_5.setBounds(428, 191, 224, 61);
		contentPane.add(textField_5);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		
		lblNewLabel_1_1 = new JLabel("user image");
		lblNewLabel_1_1.setBounds(12, 35, 67, 89);
		lblNewLabel_1_1.setBorder(new LineBorder(Color.BLACK));
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_4 = new JLabel("\uC774\uB984");
		lblNewLabel_4.setBounds(91, 35, 57, 15);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_2_3 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		lblNewLabel_2_3.setBounds(91, 69, 57, 15);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("\uC131\uBCC4");
		lblNewLabel_3_1.setBounds(91, 101, 57, 15);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("\uC774\uBA54\uC77C");
		lblNewLabel_2_1_1.setBounds(91, 144, 57, 15);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblIsbn_1 = new JLabel("\uC804\uD654\uBC88\uD638");
		lblIsbn_1.setBounds(91, 205, 57, 15);
		contentPane.add(lblIsbn_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(146, 35, 150, 21);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(146, 69, 150, 21);
		contentPane.add(textField_7);
		
		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		textField_9.setBounds(146, 144, 150, 45);
		contentPane.add(textField_9);
		
		JButton btnNewButton_2 = new JButton("\uD68C\uC6D0\uAC80\uC0C9");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField_8.getText().equals(""))
				{
					ResultSet src = dbConn.executeQurey("select * from USER where USER_PHONE like \"" + textField_8.getText() +"\";");
					if(src==null)
					{
						JOptionPane.showMessageDialog(null, "검색 결과가 없습니다.", "결과 없음",JOptionPane.ERROR_MESSAGE);
					}
					else {
						BCR_MemberSearch temp = new BCR_MemberSearch(getSelf(),src);
						temp.setVisible(true);
					}
				}
				else if(!textField_6.getText().equals("") && !textField_7.getText().equals(""))
				{
					ResultSet src = dbConn.executeQurey("select * from USER where USER_NAME like \"%" + textField_6.getText() + "\"% and USER_BIRTH like\"%"+textField_7.getText()+"%\";");
					if(src==null)
					{
						JOptionPane.showMessageDialog(null, "검색 결과가 없습니다.", "결과 없음",JOptionPane.ERROR_MESSAGE);
					}
					else {
						BCR_MemberSearch temp = new BCR_MemberSearch(getSelf(),src);
						temp.setVisible(true);
					}
				}
				else if(!textField_6.getText().equals("")) {
					ResultSet src = dbConn.executeQurey("select * from USER where USER_NAME like \"%" + textField_6.getText() + "%\";");
					if(src==null)
					{
						JOptionPane.showMessageDialog(null, "검색 결과가 없습니다.", "결과 없음",JOptionPane.ERROR_MESSAGE);
					}
					else {
						BCR_MemberSearch temp = new BCR_MemberSearch(getSelf(),src);
						temp.setVisible(true);
					}
				}
				else if(!textField_7.getText().equals("")) {
					ResultSet src = dbConn.executeQurey("select * from USER where USER_BIRTH like\"%"+textField_7.getText()+"%\";");
					if(src==null)
					{
						JOptionPane.showMessageDialog(null, "검색 결과가 없습니다.", "결과 없음",JOptionPane.ERROR_MESSAGE);
					}
					else {
						BCR_MemberSearch temp = new BCR_MemberSearch(getSelf(),src);
						temp.setVisible(true);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "검색을 위한 정보가 기입되지 않았습니다.", "입력 오류",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_2.setBounds(199, 281, 97, 37);
		contentPane.add(btnNewButton_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(146, 101, 150, 33);
		contentPane.add(panel);
		
		rdbtnNewRadioButton = new JRadioButton("\uB0A8\uC131");
		rdbtnNewRadioButton.setEnabled(false);
		panel.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("\uC5EC\uC131");
		rdbtnNewRadioButton_1.setEnabled(false);
		panel.add(rdbtnNewRadioButton_1);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(146, 199, 150, 21);
		contentPane.add(textField_8);
	}
}
