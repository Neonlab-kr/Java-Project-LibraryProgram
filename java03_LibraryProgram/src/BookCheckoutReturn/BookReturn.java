package BookCheckoutReturn;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.net.*;

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

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.SystemColor;

public class BookReturn extends JFrame {

	dbConnector dbConn = new dbConnector();
	private JPanel contentPane;
	JTextField textField;
	JTextField textField_1;
	JTextField textField_2;
	JTextField textField_3;
	JTextField textField_4;
	JTextField textField_6;
	JTextField textField_7;
	JLabel lblNewLabel_1;
	JTextArea textArea;

	BookReturn getSelf() {
		return this;
	}

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
		setTitle("LibraryManager");
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

		lblNewLabel_1 = new JLabel("book image");
		lblNewLabel_1.setBounds(78, 37, 99, 112);
		lblNewLabel_1.setBorder(new LineBorder(Color.BLACK));
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
		lblNewLabel_3_1.setBounds(12, 195, 57, 15);
		contentPane.add(lblNewLabel_3_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("\uBC18\uB0A9\uC608\uC815\uC77C");
		lblNewLabel_2_1_1.setBounds(12, 226, 70, 15);
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
		textField_3.setToolTipText("\uD558\uC774\uD37C\uB9C1\uD06C\uB85C \uC5F0\uACB0");
		textField_3.setForeground(Color.BLUE);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(360, 130, 226, 21);
		textField_3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {                                           
			    if (Desktop.isDesktopSupported()) {
			            Desktop desktop = Desktop.getDesktop();
			            try {
			                URI uri = new URI(textField_3.getText());
			                desktop.browse(uri);
			            } catch (IOException ex) {
			                ex.printStackTrace();
			            } catch (URISyntaxException ex) {
			                ex.printStackTrace();
			            }
			    }
			}
		});
		Font font = textField_3.getFont();
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		textField_3.setFont(font.deriveFont(attributes));
		contentPane.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(360, 161, 226, 21);
		contentPane.add(textField_4);

		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(78, 192, 190, 21);
		contentPane.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(78, 223, 191, 21);
		contentPane.add(textField_7);

		JButton btnNewButton = new JButton("\uB3C4\uC11C\uAC80\uC0C9");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!textField_4.getText().equals("")) {
						ResultSet src = dbConn.executeQurey(
								"select * from BOOK where BOOK_ISBN like \"" + textField_4.getText() + "\";");
						if (!src.isBeforeFirst()) {
							JOptionPane.showMessageDialog(null, "도서 검색 결과가 없습니다.", "결과 없음", JOptionPane.ERROR_MESSAGE);
						} else {
							src.next();
							ResultSet tempsrc = dbConn.executeQurey(
									"select * from RENT where BOOK_ISBN like \"" + src.getString(1) + "\";");
							if (!tempsrc.isBeforeFirst()) {
								JOptionPane.showMessageDialog(null, "대출중인 도서 검색 결과가 없습니다.", "결과 없음",
										JOptionPane.ERROR_MESSAGE);
							} else {
								src = dbConn.executeQurey(
										"select * from BOOK where BOOK_ISBN like \"" + textField_4.getText() + "\";");
								BCR_BookSearch temp = new BCR_BookSearch(2, src);
								temp.BR = getSelf();
								temp.setVisible(true);
							}
						}
					} else if (!textField.getText().equals("") && !textField_1.getText().equals("")) {
						ResultSet src = dbConn.executeQurey("select * from BOOK where BOOK_TITLE like \"%"
								+ textField.getText() + "%\" and BOOK_AUTHOR like\"%" + textField_1.getText() + "%\";");
						if (!src.isBeforeFirst()) {
							JOptionPane.showMessageDialog(null, "검색 결과가 없습니다.", "결과 없음", JOptionPane.ERROR_MESSAGE);
						} else {
							src.next();
							ResultSet tempsrc = dbConn.executeQurey(
									"select * from RENT where BOOK_ISBN like \"" + src.getString(1) + "\";");
							if (!tempsrc.isBeforeFirst()) {
								JOptionPane.showMessageDialog(null, "대출중인 도서 검색 결과가 없습니다.", "결과 없음",
										JOptionPane.ERROR_MESSAGE);
							} else {
								src = dbConn.executeQurey("select * from BOOK where BOOK_TITLE like \"%"
										+ textField.getText() + "%\" and BOOK_AUTHOR like\"%" + textField_1.getText() + "%\";");
								BCR_BookSearch temp = new BCR_BookSearch(2, src);
								temp.BR = getSelf();
								temp.setVisible(true);
							}
						}
					} else if (!textField.getText().equals("")) {
						ResultSet src = dbConn.executeQurey(
								"select * from BOOK where BOOK_TITLE like \"%" + textField.getText() + "%\";");
						if (!src.isBeforeFirst()) {
							JOptionPane.showMessageDialog(null, "검색 결과가 없습니다.", "결과 없음", JOptionPane.ERROR_MESSAGE);
						} else {
							src.next();
							ResultSet tempsrc = dbConn.executeQurey(
									"select * from RENT where BOOK_ISBN like \"" + src.getString(1) + "\";");
							if (!tempsrc.isBeforeFirst()) {
								JOptionPane.showMessageDialog(null, "대출중인 도서 검색 결과가 없습니다.", "결과 없음",
										JOptionPane.ERROR_MESSAGE);
							} else {
								src = dbConn.executeQurey(
										"select * from BOOK where BOOK_TITLE like \"%" + textField.getText() + "%\";");
								BCR_BookSearch temp = new BCR_BookSearch(2, src);
								temp.BR = getSelf();
								temp.setVisible(true);
							}
						}
					} else if (!textField_1.getText().equals("")) {
						ResultSet src = dbConn.executeQurey(
								"select * from BOOK where BOOK_AUTHOR like\"%" + textField_1.getText() + "%\";");
						if (!src.isBeforeFirst()) {
							JOptionPane.showMessageDialog(null, "검색 결과가 없습니다.", "결과 없음", JOptionPane.ERROR_MESSAGE);
						} else {
							src.next();
							ResultSet tempsrc = dbConn.executeQurey(
									"select * from RENT where BOOK_ISBN like \"" + src.getString(1) + "\";");
							if (!tempsrc.isBeforeFirst()) {
								JOptionPane.showMessageDialog(null, "대출중인 도서 검색 결과가 없습니다.", "결과 없음",
										JOptionPane.ERROR_MESSAGE);
							} else {
								src = dbConn.executeQurey(
										"select * from BOOK where BOOK_AUTHOR like\"%" + textField_1.getText() + "%\";");
								BCR_BookSearch temp = new BCR_BookSearch(2, src);
								temp.BR = getSelf();
								temp.setVisible(true);
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "검색을 위한 정보가 기입되지 않았습니다.", "입력 오류",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(360, 285, 97, 37);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("\uBC18\uB0A9");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_4.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "도서가 선택되지 않았습니다.", "반납 오류", JOptionPane.ERROR_MESSAGE);
				} else {
					ResultSet src = dbConn
							.executeQurey("select * from RENT where BOOK_ISBN like \"" + textField_4.getText() + "\";");
					try {
						if (src.isBeforeFirst()) {
							src.next();
							String sql = "DELETE FROM RENT where BOOK_ISBN=" + textField_4.getText() + ";";
							Connection tmpConn = dbConn.getConnection();
							PreparedStatement ps = tmpConn.prepareStatement(sql);
							ps.executeUpdate();
							sql = "UPDATE USER set USER_RENT_CNT = USER_RENT_CNT - 1 where USER_PHONE = \""+ src.getString(5) +"\";";
							tmpConn = dbConn.getConnection();
							ps = tmpConn.prepareStatement(sql);
							ps.executeUpdate();
							src = dbConn.executeQurey("select * from USER where USER_PHONE like \"" + src.getString(5) + "\";");
							src.next();
							JOptionPane.showMessageDialog(null, "반납이 완료되었습니다\n"+src.getString(2)+"님의 남은 대여 도서는 "+src.getString(9)+"권 입니다.", "반납 완료",JOptionPane.INFORMATION_MESSAGE);
							BookReturn temp = new BookReturn();
							temp.setVisible(true);
							setVisible(false);
						} else {
							JOptionPane.showMessageDialog(null, "대여중이지 않은 도서입니다.", "반납 불가", JOptionPane.ERROR_MESSAGE);
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton_1.setBounds(489, 285, 97, 37);
		contentPane.add(btnNewButton_1);

		JScrollPane scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(360, 195, 226, 60);
		contentPane.add(scrollPane);

		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setBackground(SystemColor.control);
		scrollPane.setViewportView(textArea);
	}

}
