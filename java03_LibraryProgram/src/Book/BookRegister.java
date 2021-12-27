package Book;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

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
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import BookCheckoutReturn.BookCheckout;
import BookCheckoutReturn.BookReturn;
import Member.MemberRegister;
import Member.MemberSearch;
import SQL.dbConnector;
import Util.ImageCheck;
import net.miginfocom.swing.MigLayout;
import java.awt.Rectangle;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class BookRegister extends JFrame {
	
	LocalDateTime now = LocalDateTime.now();
	dbConnector dbConn = new dbConnector();
	FileInputStream iis;	//이미지파일
	File file;

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookRegister frame = new BookRegister();
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
	public BookRegister() {
		setTitle("LibrayManager");
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
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\uB3C4\uC11C\uB4F1\uB85D");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("\uC800\uC7A5");	//저장버튼
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(iis==null||textField.getText()==""||textField_1.getText()==""||textField_2.getText()==""||textField_3.getText()==""||textField_4.getText()==""||textArea.getText()=="") {
					JOptionPane.showMessageDialog(null, "모든 필드가 채워지지 않았습니다.", "입력 오류", JOptionPane.WARNING_MESSAGE);
				}
				else {
					try {
						Connection tmpConn = dbConn.getConnection();
						Statement st = tmpConn.createStatement();
			            //File imgfile = new File("d:\\images.jpg");
			            //FileInputStream fin = new FileInputStream(imgfile);
			            PreparedStatement pre = tmpConn.prepareStatement("insert into BOOK(BOOK_IMAGE,BOOK_TITLE,BOOK_AUTHOR,BOOK_PUB,BOOK_PRICE,BOOK_LINK,BOOK_ISBN,BOOK_DESCRIPTION)VALUES(?,?,?,?,?,?,?,?);");
			            pre.setBinaryStream(1,iis,(int)file.length());	//이미지
			            pre.setString(2,textField.getText());	//제목
			            pre.setString(3,textField_1.getText());	//저자
			            pre.setString(4,textField_6.getText());	//출판사
			            pre.setInt(5,Integer.parseInt(textField_2.getText()));	//가격
			            pre.setString(6,textField_3.getText());	//링크
			            pre.setInt(7,Integer.parseInt(textField_4.getText()));	//ISBN
			            pre.setString(8,textArea.getText());	//설명
			            pre.executeUpdate();

						
						
						//String sql=("insert into DB_BOOK(BOOK_IMAGE,BOOK_TITLE,BOOK_AUTHOR,BOOK_PRICE,BOOK_LINK,BOOK_ISBN,BOOK_DESCRIPTION)VALUES(?"+",\'"+textField.getText(/*제목*/)+"\',\'"+textField_1.getText(/*저자*/)+"\',"+textField_2.getText(/*가격*/)+",\'"+textField_3.getText(/*링크*/)+"\',"+textField_4.getText(/*ISBN*/)+",\'"+textField_5.getText(/*설명*/)+"\');");
						//PreparedStatement ps;
						//ps.setString(1, textField_4.getText());
						//ps = tmpConn.prepareStatement(sql);
						//ps.executeUpdate();
						
						
						JOptionPane.showMessageDialog(null, "저장이 완료되었습니다", "저장 완료", JOptionPane.INFORMATION_MESSAGE);
						setVisible(false);
						BookRegister temp = new BookRegister();
						temp.setVisible(true);
					} catch (NullPointerException |SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "저장에 실패하였습니다.\n중복틍록인지  확인하세요.", "저장 실패", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}
				}
	
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uCDE8\uC18C");	//취소버튼
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				BookSearch temp = new BookSearch();
				temp.setVisible(true);
			}
		});
		panel.add(btnNewButton_1);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(2);
		splitPane.setFocusCycleRoot(true);
		contentPane.add(splitPane, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		splitPane.setLeftComponent(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("");
		panel_1.add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("\uCC3E\uC544\uBCF4\uAE30");	//찾아보기 버튼
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					JFrame jFrame=new JFrame();
					FileDialog fileDialogOpen = new FileDialog(jFrame, "이미지 열기", FileDialog.LOAD);
	                fileDialogOpen.setVisible(true);
	                
	                String filePath = fileDialogOpen.getDirectory() + fileDialogOpen.getFile();
	                System.out.println(filePath);
	                //사진파일 입력
	            	file = new File(filePath);
	                
	                //이미지 불러오기
	            	try {           		           	
						if(ImageCheck.isImage(file)==false){
							JOptionPane.showMessageDialog(null, "이미지가 아닙니다.", "이미지 오류", JOptionPane.ERROR_MESSAGE);
						}
						else {
							iis = new FileInputStream(file);
							Image image = ImageIO.read(file);           	
			            	Image resize=image.getScaledInstance(175,230,Image.SCALE_SMOOTH);
			            	ImageIcon icon=new ImageIcon(resize);
			            	lblNewLabel_1.setIcon(icon);
						}  						
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "이미지를 불러오는데 실패했습니다.", "이미지 오류", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "이미지를 불러오는데 실패했습니다.", "이미지 오류", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}
			}
		});
		panel_1.add(btnNewButton_2, BorderLayout.SOUTH);
		
		JPanel panel_2 = new JPanel();
		splitPane.setRightComponent(panel_2);
		panel_2.setLayout(new MigLayout("", "[50.00px][357.00px,grow]", "[23.00px][23.00][][][][][172.00,grow]"));
		
		JLabel lblNewLabel_2 = new JLabel("\uC81C\uBAA9");
		panel_2.add(lblNewLabel_2, "cell 0 0,alignx center,aligny center");
		
		textField = new JTextField();
		panel_2.add(textField, "cell 1 0,grow");
		textField.setColumns(10);
		 
		JLabel lblNewLabel_4 = new JLabel("\uC800\uC790");
		panel_2.add(lblNewLabel_4, "cell 0 1,alignx center,aligny center");
		
		textField_1 = new JTextField();
		panel_2.add(textField_1, "cell 1 1,growx");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("\uCD9C\uD310\uC0AC");
		panel_2.add(lblNewLabel_8, "cell 0 2,alignx center");
		
		textField_6 = new JTextField();
		panel_2.add(textField_6, "cell 1 2,growx");
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("\uAC00\uACA9");
		panel_2.add(lblNewLabel_6, "cell 0 3,alignx center,aligny center");
		
		textField_2 = new JTextField();
		panel_2.add(textField_2, "cell 1 3,grow");
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\uB9C1\uD06C");
		panel_2.add(lblNewLabel_3, "cell 0 4,alignx center,aligny center");
		
		textField_3 = new JTextField();
		panel_2.add(textField_3, "cell 1 4,grow");
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("ISBN");
		panel_2.add(lblNewLabel_5, "cell 0 5,alignx center,aligny center");
		
		textField_4 = new JTextField();
		panel_2.add(textField_4, "cell 1 5,grow");
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("\uC124\uBA85");
		panel_2.add(lblNewLabel_7, "cell 0 6,alignx center,aligny center");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_2.add(scrollPane, "cell 1 6,grow");
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		splitPane.setDividerLocation(170);
	}

}
