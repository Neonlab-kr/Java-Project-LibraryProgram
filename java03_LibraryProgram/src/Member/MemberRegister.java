package Member;
import Program.MainMenu;
import SQL.dbConnector;
import Util.ImageCheck;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FileDialog;
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
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import Book.BookRegister;
import Book.BookSearch;
import BookCheckoutReturn.BookCheckout;
import BookCheckoutReturn.BookReturn;
import SQL.dbConnector;
import Util.ImageCheck;

import javax.swing.JRadioButton;

//<<<<<<< HEAD:java03_LibraryProgram/src/Member/MemberResigster.java
//public class MemberResigster extends JPanel {
//=======
public class MemberRegister extends JFrame {
//>>>>>>> fc80ecfc8da66def7f819e3e19d8febccccbcf2a:java03_LibraryProgram/src/Member/MemberRegister.java
	private JTextField textField_Name;
	private JTextField textField_Birth;
	private JTextField textField_Email;
	private JTextField textField_PhoneN;
	private FileInputStream iis=null;
	private File file;
	dbConnector dbConn = new dbConnector();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberRegister frame = new MemberRegister();
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
//<<<<<<< HEAD:java03_LibraryProgram/src/Member/MemberResigster.java
//	public MemberRegister() {
//=======
	public MemberRegister() {
//>>>>>>> fc80ecfc8da66def7f819e3e19d8febccccbcf2a:java03_LibraryProgram/src/Member/MemberRegister.java
		setBounds(100, 100, 680, 428);
		getContentPane().setLayout(null);
		ButtonGroup group = new ButtonGroup();
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
		
		JLabel lbTitle = new JLabel("\uD68C\uC6D0\uB4F1\uB85D");
		lbTitle.setFont(new Font("굴림", Font.BOLD, 15));
		lbTitle.setBounds(12, 10, 75, 27);
		getContentPane().add(lbTitle);
		
		JLabel lbImage = new JLabel("     User Image");
		lbImage.setBorder(new LineBorder(Color.BLACK));
		lbImage.setBounds(120, 84, 97, 92);
		getContentPane().add(lbImage);
		
		JButton btn_ImageFind = new JButton("\uCC3E\uC544\uBCF4\uAE30");
		btn_ImageFind.setBounds(120, 186, 97, 23);
		getContentPane().add(btn_ImageFind);
		btn_ImageFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame jFrame = new JFrame();
					FileDialog fileDialogOpen = new FileDialog(jFrame, "이미지 열기", FileDialog.LOAD);
	                fileDialogOpen.setVisible(true);
	                
	                //이미지 불러오기
	            	try {
	            		String filePath = fileDialogOpen.getDirectory() + fileDialogOpen.getFile();
		                System.out.println(filePath);
		                //사진파일 입력
		            	file = new File(filePath);
		            	
		            	iis = new FileInputStream(file);
		
						if(ImageCheck.isImage(file)==false){
							JOptionPane.showMessageDialog(null, "이미지가 아닙니다.", "이미지 오류", JOptionPane.ERROR_MESSAGE);
						}

						else {
							
							Image image = ImageIO.read(file);
			            	
			            	
			            	Image resize=image.getScaledInstance(90,90,Image.SCALE_SMOOTH);
			            	ImageIcon icon=new ImageIcon(resize);
			            	lbImage.setIcon(icon);

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
		
		JLabel lbName = new JLabel("\uC774\uB984");
		lbName.setBounds(323, 87, 42, 15);
		getContentPane().add(lbName);
		
		textField_Name = new JTextField();
		textField_Name.setBounds(377, 84, 144, 21);
		getContentPane().add(textField_Name);
		textField_Name.setColumns(10);
		
		JLabel lbBirth = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		lbBirth.setBounds(308, 126, 57, 15);
		getContentPane().add(lbBirth);
		
		textField_Birth = new JTextField();
		textField_Birth.setBounds(377, 123, 144, 21);
		getContentPane().add(textField_Birth);
		textField_Birth.setColumns(10);
		
		JLabel lbSex = new JLabel("\uC131\uBCC4");
		lbSex.setBounds(323, 161, 32, 15);
		getContentPane().add(lbSex);
		
		JRadioButton rdMan = new JRadioButton("\uB0A8\uC131");
		rdMan.setBounds(377, 157, 57, 23);
		getContentPane().add(rdMan);
		
		JRadioButton rdWom = new JRadioButton("\uC5EC\uC131");
		rdWom.setBounds(464, 156, 57, 23);
		getContentPane().add(rdWom);
		
		group.add(rdWom);
		group.add(rdMan);
		
		JLabel lbEmail = new JLabel("\uC774\uBA54\uC77C");
		lbEmail.setBounds(313, 196, 42, 15);
		getContentPane().add(lbEmail);
		
		textField_Email = new JTextField();
		textField_Email.setColumns(10);
		textField_Email.setBounds(377, 193, 144, 21);
		getContentPane().add(textField_Email);
		
		JLabel lbPhoneN = new JLabel("\uC804\uD654\uBC88\uD638");
		lbPhoneN.setBounds(308, 230, 57, 15);
		getContentPane().add(lbPhoneN);
		
		textField_PhoneN = new JTextField();
		textField_PhoneN.setBounds(377, 227, 144, 21);
		getContentPane().add(textField_PhoneN);
		textField_PhoneN.setColumns(10);
		
		JButton btnUp = new JButton("\uB4F1\uB85D");
		btnUp.setBounds(187, 306, 97, 23);
		getContentPane().add(btnUp);
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_Name.getText().equals("")||textField_Birth.getText().equals("")||textField_Email.getText().equals("")||textField_PhoneN.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "모든 필드가 채워지지 않았습니다.", "입력 오류", JOptionPane.WARNING_MESSAGE);
				}
				else {
					
						Connection tmpConn = dbConn.getConnection();
						Calendar cal = Calendar.getInstance();
						cal.setTime(new Date());
						DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String nowDT = df.format(cal.getTime());
						cal.add(Calendar.DATE, 14);
						String RetrunDT = df.format(cal.getTime());
						String sql = "insert into USER (USER_PHONE,USER_NAME,USER_BIRTH,USER_SEX,USER_MAIL,USER_IMAGE,USER_REG_DATE) values (?,?,?,?,?,?,?);";
						PreparedStatement ps;
						try {
							ps = tmpConn.prepareStatement(sql);
							ps.setString(1, textField_PhoneN.getText());
							ps.setString(2, textField_Name.getText());
							ps.setString(3, textField_Birth.getText());
							 if(rdWom.isSelected())
					            	ps.setInt(4,0);	//성별
					            else
					            	ps.setInt(4,1);	//성별
							ps.setString(5, textField_Email.getText());
							ps.setBinaryStream(6,iis,(int)file.length());
							ps.setString(7, nowDT);
							
							ps.executeUpdate();
							JOptionPane.showMessageDialog(null, "저장이 완료되었습니다", "저장 완료", JOptionPane.INFORMATION_MESSAGE);
							setVisible(false);
							MainMenu temp = new MainMenu();
							temp.setVisible(true);
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "저장에 실패하였습니다.", "저장 실패\n", JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();	
						}catch (NullPointerException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "저장에 실패하였습니다.", "NullPointerException", JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();	
						}
						
						
						
						
			
			}
		}
		});
		
		
		
		JButton btnCancel = new JButton("\uCDE8\uC18C");
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
				MemberRegister temp = new MemberRegister();
				temp.setVisible(true);
				
			}
		});
		
		btnCancel.setBounds(371, 306, 97, 23);
		getContentPane().add(btnCancel);
		btnCancel.addActionListener(null);
	}
}
