package Book;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BookCheckoutReturn.BCR_BookSearch;
import BookCheckoutReturn.BookCheckout;
import BookCheckoutReturn.BookReturn;
import Member.MemberRegister;
import Member.MemberSearch;
import SQL.dbConnector;
import net.miginfocom.swing.MigLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;


public class BookSearch extends JFrame {

	private JPanel contentPane;
	private JTextField txtn;
	private JTextField txtm;
	private JPanel panel;
	private int index=0;
	
	dbConnector dbConn = new dbConnector();
	
	/**
	 * @wbp.nonvisual location=169,284
	 */
	private final JPanel panel_2_5 = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookSearch frame = new BookSearch();
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
	public BookSearch() {
		setTitle("LibraryManager");
		panel_2_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_3_5 = new JLabel("image");
		panel_2_5.add(lblNewLabel_3_5);
		
		JLabel lblNewLabel_4_5 = new JLabel("\uC81C\uBAA9:");
		panel_2_5.add(lblNewLabel_4_5);
		
		JLabel lblNewLabel_5_5 = new JLabel("\uC81C\uBAA9\uD544\uB4DC");
		panel_2_5.add(lblNewLabel_5_5);
		
		JLabel lblNewLabel_6_5 = new JLabel("\uC800\uC790:");
		panel_2_5.add(lblNewLabel_6_5);
		
		JLabel lblNewLabel_7_5 = new JLabel("\uC800\uC790\uD544\uB4DC");
		panel_2_5.add(lblNewLabel_7_5);
		
		JButton btnNewButton_1_5 = new JButton("\uC0C1\uC138\uC815\uBCF4");
		panel_2_5.add(btnNewButton_1_5);
		setTitle("LibaryManager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 428);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("\u3163");
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
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setLeftComponent(splitPane_1);
		
		JLabel lblNewLabel = new JLabel("\uB3C4\uC11C\uAC80\uC0C9");
		splitPane_1.setLeftComponent(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		splitPane_1.setRightComponent(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("\uC81C\uBAA9:");
		panel_1.add(lblNewLabel_1);
		
		txtn = new JTextField();
		txtn.setScrollOffset(2);
		panel_1.add(txtn);
		txtn.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\uC800\uC790:");
		panel_1.add(lblNewLabel_2);
		
		txtm = new JTextField();
		panel_1.add(txtm);
		txtm.setColumns(10);
		
		JButton btnNewButton = new JButton("\uAC80\uC0C9");	//검색버튼
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index=0;	//인덱스 초기화
				panel.removeAll();	//패널 비우기
				
				try {
					if (txtn.getText().equals("") && txtm.getText().equals("")) {	//제목필드와 저자필드 둘 다 비웠을때
						JOptionPane.showMessageDialog(null, "검색을 위한 정보가 기입되지 않았습니다.\n모든 도서를 표시합니다.\n로딩에 시간이 소요될 수 있습니다.", "모두 표시",	JOptionPane.WARNING_MESSAGE);
					}
					
					ResultSet src = dbConn.executeQurey("select * from BOOK where BOOK_TITLE like \"%" + txtn.getText() + "%\" and BOOK_AUTHOR like \"%" + txtm.getText() + "%\";");
					if (!src.isBeforeFirst()) {
						JOptionPane.showMessageDialog(null, "검색 결과가 없습니다.", "결과 없음", JOptionPane.WARNING_MESSAGE);
					} else {
						while(src.next()) {
							AddResult(src);		
						}	
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			
			}
		});
		panel_1.add(btnNewButton);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane.setRightComponent(scrollPane);
		
		panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new MigLayout("", "[410.00,grow]", "[grow][grow][grow][grow][grow]"));
		

		/*
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, "cell 0 0,growx,aligny center");
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_3 = new JLabel("image");
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\uC81C\uBAA9:");
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\uC81C\uBAA9\uD544\uB4DC");
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\uC800\uC790:");
		panel_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("\uC800\uC790\uD544\uB4DC");
		panel_2.add(lblNewLabel_7);
		
		JButton btnNewButton_1 = new JButton("\uC0C1\uC138\uC815\uBCF4");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_2.add(btnNewButton_1);
		*/
		
		
		

		//검색결과
		/*
			JPanel pane = new JPanel();
			pane.setSize(new Dimension(201, 0));
			panel.add(pane, "growx,aligny center");
			pane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
			JLabel lblNewLabel_3_51 = new JLabel("image");
			lblNewLabel_3_51.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			pane.add(lblNewLabel_3_51);
			
			JLabel lblNewLabel_4_51 = new JLabel("\uC81C\uBAA9:");
			pane.add(lblNewLabel_4_51);
			
			JLabel lblNewLabel_5_51 = new JLabel("\uC81C\uBAA9\uD544\uB4DC");
			pane.add(lblNewLabel_5_51);
			
			JLabel lblNewLabel_6_51 = new JLabel("\uC800\uC790:");
			pane.add(lblNewLabel_6_51);
			
			JLabel lblNewLabel_7_51 = new JLabel("\uC800\uC790\uD544\uB4DC");
			pane.add(lblNewLabel_7_51);
			
			JButton btnNewButton_1_51 = new JButton("\uC0C1\uC138\uC815\uBCF4");
			pane.add(btnNewButton_1_51);

		*/
		
		
		/*
		JPanel panel_2_1 = new JPanel();
		panel.add(panel_2_1, "cell 0 1,grow");
		panel_2_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_3_1 = new JLabel("image");
		panel_2_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("\uC81C\uBAA9:");
		panel_2_1.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("\uC81C\uBAA9\uD544\uB4DC");
		panel_2_1.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("\uC800\uC790:");
		panel_2_1.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("\uC800\uC790\uD544\uB4DC");
		panel_2_1.add(lblNewLabel_7_1);
		
		JButton btnNewButton_1_1 = new JButton("\uC0C1\uC138\uC815\uBCF4");
		panel_2_1.add(btnNewButton_1_1);
		
		JPanel panel_2_2 = new JPanel();
		panel.add(panel_2_2, "cell 0 2,grow");
		panel_2_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_3_2 = new JLabel("image");
		panel_2_2.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_4_2 = new JLabel("\uC81C\uBAA9:");
		panel_2_2.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_5_2 = new JLabel("\uC81C\uBAA9\uD544\uB4DC");
		panel_2_2.add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_6_2 = new JLabel("\uC800\uC790:");
		panel_2_2.add(lblNewLabel_6_2);
		
		JLabel lblNewLabel_7_2 = new JLabel("\uC800\uC790\uD544\uB4DC");
		panel_2_2.add(lblNewLabel_7_2);
		
		JButton btnNewButton_1_2 = new JButton("\uC0C1\uC138\uC815\uBCF4");
		panel_2_2.add(btnNewButton_1_2);
		
		JPanel panel_2_3 = new JPanel();
		panel.add(panel_2_3, "cell 0 3,grow");
		panel_2_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_3_3 = new JLabel("image");
		panel_2_3.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_4_3 = new JLabel("\uC81C\uBAA9:");
		panel_2_3.add(lblNewLabel_4_3);
		
		JLabel lblNewLabel_5_3 = new JLabel("\uC81C\uBAA9\uD544\uB4DC");
		panel_2_3.add(lblNewLabel_5_3);
		
		JLabel lblNewLabel_6_3 = new JLabel("\uC800\uC790:");
		panel_2_3.add(lblNewLabel_6_3);
		
		JLabel lblNewLabel_7_3 = new JLabel("\uC800\uC790\uD544\uB4DC");
		panel_2_3.add(lblNewLabel_7_3);
		
		JButton btnNewButton_1_3 = new JButton("\uC0C1\uC138\uC815\uBCF4");
		panel_2_3.add(btnNewButton_1_3);
		
		*/
		

		
		
	}

	void AddResult(ResultSet src) {
		int isbn = 0;
		try {
			isbn=src.getInt(0);
			System.out.println(isbn);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		BookAmend info = new BookAmend(isbn);

		JPanel pane = new JPanel();
		panel.add(pane, "cell 0 "+index+",grow");
		pane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel_3_51 = new JLabel();	//이미지
		InputStream inputStream = null;

		try {
			inputStream = src.getBinaryStream(7);
			lblNewLabel_3_51.setIcon(new ImageIcon(new ImageIcon(ImageIO.read(inputStream)).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
			pane.add(lblNewLabel_3_51);
			
			JTextPane titlePane = new JTextPane();
			titlePane.setText("-제목-\n\n"+src.getString(2));
			pane.add(titlePane);

			
			JTextPane authPane = new JTextPane();
			authPane.setText("-저자-\n\n"+src.getString(3));
			pane.add(authPane);
			
			JTextPane pubPane = new JTextPane();
			pubPane.setText("-출판사-\n\n"+src.getString(4));
			pane.add(pubPane);
			
			JButton btnNewButton_1_51 = new JButton("세부정보");
			btnNewButton_1_51.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					info.setVisible(true);
					//info.isbn=isbn;
					System.out.println(info.isbn);
				}
			});
			pane.add(btnNewButton_1_51);
		}catch(NullPointerException e) {
			e.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		index++;
		panel.revalidate();	//패널 다시 그리기
		panel.repaint();
	}
}
