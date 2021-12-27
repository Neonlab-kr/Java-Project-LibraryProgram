package Member;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JTextField;

import Book.BookRegister;
import Book.BookSearch;
import BookCheckoutReturn.BCR_MemberSearch;
import BookCheckoutReturn.BookCheckout;
import BookCheckoutReturn.BookReturn;
import SQL.dbConnector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.sql.*;

public class MemberSearch extends JFrame {
	private JTextField textField_Booktitle;
	private JTextField textField_Author;

	dbConnector dbConn = new dbConnector();

	MemberSearch getSelf() {
		return this;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberSearch frame = new MemberSearch();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the panel.
	 */
	JPanel jp_label, jp_btn;
	JScrollPane scroll;
	JLabel label;
	JButton btn;
	int count = 1;
	GridBagLayout Gbag = new GridBagLayout();
	GridBagConstraints gbc1;
	JScrollPane scrollPane;

	public void create_form(Component cmpt, int x, int y, int w, int h) {

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		this.Gbag.setConstraints(cmpt, gbc);
		jp_label.add(cmpt);
		jp_label.updateUI();

	}

	public MemberSearch() {
		setBounds(100, 100, 680, 428);
		setLayout(null);

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

		JLabel lbTitle = new JLabel("�쉶�썝寃��깋");
		lbTitle.setFont(new Font("援대┝", Font.BOLD, 15));
		lbTitle.setBounds(12, 10, 75, 27);
		add(lbTitle);

		JLabel lbBookTitle = new JLabel("�씠由� :");
		lbBookTitle.setFont(new Font("援대┝", Font.PLAIN, 15));
		lbBookTitle.setBounds(82, 46, 48, 18);
		add(lbBookTitle);

		textField_Booktitle = new JTextField();
		textField_Booktitle.setBounds(131, 46, 111, 21);
		add(textField_Booktitle);
		textField_Booktitle.setColumns(10);

		JLabel lbAuthor = new JLabel("�쟾�솕踰덊샇 :");
		lbAuthor.setFont(new Font("援대┝", Font.PLAIN, 15));
		lbAuthor.setBounds(254, 46, 75, 18);
		add(lbAuthor);

		textField_Author = new JTextField();
		textField_Author.setColumns(10);
		textField_Author.setBounds(330, 45, 111, 21);
		add(textField_Author);

		JButton btnSearch = new JButton("寃��깋");
		btnSearch.setFont(new Font("援대┝", Font.PLAIN, 14));
		btnSearch.setBounds(460, 45, 111, 21);
		add(btnSearch);

		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet src = dbConn
						.executeQurey("select * from USER where USER_OUT_DATE is null and USER_NAME like \"%"
								+ textField_Booktitle.getText() + "%\" and USER_PHONE like \"%"
								+ textField_Author.getText() + "%\";");
//					ResultSet src = dbConn.executeQurey("select * from j20183087.USER where USER_NAME=\"�븳援��씤\";");

				remove(jp_label);
				remove(scrollPane);

				jp_label = new JPanel();

				jp_label.setLayout(Gbag);
				scrollPane = new JScrollPane(jp_label);
				scrollPane.setBounds(12, 77, 642, 281);
				add(scrollPane);

				try {
					while (src.next()) {
						System.out.print(src.getString(2));
						JLabel imgLabel = new JLabel();
						ImageIcon c = new ImageIcon("image/icon1.png");
						imgLabel.setIcon(c);
						JLabel a = new JLabel("�씠由� : " + src.getString(2));
						a.setFont(new Font("援대┝", Font.PLAIN, 15));
						JLabel b = new JLabel("�쟾�솕踰덊샇 : " + src.getString(1));
						b.setFont(new Font("援대┝", Font.PLAIN, 15));
						JPanel label2 = new JPanel();
						JButton btnNewButton = new JButton("�긽�꽭�젙蹂�");

						String name = src.getString(2);
						Date from = new Date();
						SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
						String birth = transFormat.format(src.getDate(3));
						int sex = src.getInt(4);
						String mail = src.getString(5);
						String phone = src.getString(1);
//							byte[] image = src.getBytes(6);
						InputStream image = src.getBinaryStream(6);

						btnNewButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								MemberAmend temp = new MemberAmend(image, name, birth, sex, mail, phone);
								temp.setVisible(true);

							}
						});
						label2.add(imgLabel);
						label2.add(a);
						label2.add(b);
						label2.add(btnNewButton);
						create_form(label2, 0, count++ * 30, 30, 10);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "寃��깋�씠 �셿猷뚮릺�뿀�뒿�땲�떎.", "寃��깋�셿猷�", JOptionPane.PLAIN_MESSAGE);
			}
		});

		jp_label = new JPanel();

		// �씪踰⑥씠 �뱾�뼱媛� panel �� �젅�씠�븘�썐�쓣 GridBag�쓣 �궗�슜�븳�떎.
		jp_label.setLayout(Gbag);

//	   jp_label.setBackground(Color.white);

		label = new JLabel();
		create_form(label, 0, 0, 30, 10); // GridBagLayout �쓣 �쐞�븳 �븿�닔�샇異�

		scrollPane = new JScrollPane(jp_label);
		scrollPane.setBounds(12, 77, 642, 281);
		add(scrollPane);

//		for(int i=0;i<10;i++) {
		/*
		 * ResultSet src =
		 * dbConn.executeQurey("select * from USER where USER_OUT_DATE is null;"); try {
		 * while (src.next()) { JLabel imgLabel = new JLabel(); ImageIcon c = new
		 * ImageIcon("image/icon1.png"); imgLabel.setIcon(c); JLabel a = new
		 * JLabel("�씠由� : " + src.getString(2)); a.setFont(new Font("援대┝", Font.PLAIN,
		 * 15)); JLabel b = new JLabel("�쟾�솕踰덊샇 : " + src.getString(1)); b.setFont(new
		 * Font("援대┝", Font.PLAIN, 15));
		 * 
		 * dbConnector dbConn2 = new dbConnector(); Connection tmpConn =
		 * dbConn2.getConnection(); Statement stmt =
		 * tmpConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
		 * ResultSet.CONCUR_UPDATABLE);
		 * 
		 * // ResultSet src2 =
		 * dbConn2.executeQurey("select * from RENT where USER_PHONE=\"0171234567\";");
		 * ResultSet src2 = stmt.executeQuery("select * from RENT where USER_PHONE=\"" +
		 * src.getString(1) + "\";"); src2.last(); int columnCount = src2.getRow();
		 * 
		 * System.out.println(src.getString(1)); System.out.println(columnCount);
		 * 
		 * JLabel c2 = new JLabel("��異쒖쨷 : " + Integer.toString(columnCount));
		 * b.setFont(new Font("援대┝", Font.PLAIN, 15)); JPanel label2 = new JPanel();
		 * JButton btnNewButton = new JButton("�긽�꽭�젙蹂�");
		 * 
		 * String name = src.getString(2); Date from = new Date(); SimpleDateFormat
		 * transFormat = new SimpleDateFormat("yyyy-MM-dd"); String birth =
		 * transFormat.format(src.getDate(3)); int sex = src.getInt(4); String mail =
		 * src.getString(5); String phone = src.getString(1); // byte[] image =
		 * src.getBytes(6); InputStream image = src.getBinaryStream(6);
		 * 
		 * btnNewButton.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { ResultSet src =
		 * dbConn.executeQurey("select * from USER where USER_PHONE like \"" + phone +
		 * "\" and USER_OUT_DATE is null;"); try { src.next(); MemberAmend temp1 = new
		 * MemberAmend(src.getBinaryStream(6), name, birth, sex, mail, phone);
		 * temp1.setVisible(true); } catch (SQLException e1) { // TODO Auto-generated
		 * catch block e1.printStackTrace(); } } }); label2.add(imgLabel);
		 * label2.add(a); label2.add(b); label2.add(c2); label2.add(btnNewButton);
		 * create_form(label2, 0, count++ * 30, 50, 10); } } catch (SQLException e1) {
		 * // TODO Auto-generated catch block e1.printStackTrace(); }
		 */
	}
}
