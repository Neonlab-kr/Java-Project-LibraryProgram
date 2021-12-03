package BookCheckoutReturn;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Book.BookRegister;
import Book.BookSearch;
import Member.MemberRegister;
import Member.MemberSearch;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class BookReturn extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookReturn frame = new BookReturn();
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
	public BookReturn() {
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(78, 37, 99, 112);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("\uC81C\uBAA9");
		lblNewLabel.setBounds(291, 37, 57, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("\uC800\uC790");
		lblNewLabel_2.setBounds(291, 71, 57, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\uAC00\uACA9");
		lblNewLabel_3.setBounds(291, 99, 57, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2_1 = new JLabel("\uB9C1\uD06C");
		lblNewLabel_2_1.setBounds(291, 133, 57, 15);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setBounds(291, 161, 57, 15);
		contentPane.add(lblIsbn);
		
		JLabel lblNewLabel_2_2 = new JLabel("\uC124\uBA85");
		lblNewLabel_2_2.setBounds(291, 195, 57, 15);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_3_1 = new JLabel("\uB300\uCD9C\uC790");
		lblNewLabel_3_1.setBounds(291, 223, 57, 15);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("\uBC18\uB0A9\uC608\uC815\uC77C");
		lblNewLabel_2_1_1.setBounds(291, 257, 70, 15);
		contentPane.add(lblNewLabel_2_1_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(360, 37, 226, 21);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(360, 68, 226, 21);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(360, 99, 226, 21);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(360, 130, 226, 21);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(360, 161, 226, 21);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(360, 192, 226, 21);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(360, 223, 226, 21);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(360, 254, 226, 21);
		contentPane.add(textField_7);
		
		JButton btnNewButton = new JButton("\uB3C4\uC11C\uAC80\uC0C9");
		btnNewButton.setBounds(303, 285, 97, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uBC18\uB0A9");
		btnNewButton_1.setBounds(489, 285, 97, 37);
		contentPane.add(btnNewButton_1);
	}

}
