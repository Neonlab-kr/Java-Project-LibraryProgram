package Member;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import Program.MainMenu;
import SQL.dbConnector;
import Util.ImageCheck;

public class MemberAmend extends JFrame {
	dbConnector dbConn = new dbConnector();
	
	private JTextField textField_Name;
	private JTextField textField_Birth;
	private JTextField textField_Email;
	private JTextField textField_PhoneN;
	private JLabel lbImage;
	private FileInputStream iis=null;
	private File file;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					MemberAmend frame = new MemberAmend();
					MainMenu frame = new MainMenu();
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
	public MemberAmend(InputStream image, String name,String birth,int sex,String mail,String phone) {
		setBounds(100, 100, 680, 428);
		getContentPane().setLayout(null);
			
		JLabel lbTitle = new JLabel("\uD68C\uC6D0\uC815\uBCF4");
		lbTitle.setFont(new Font("援대┝", Font.BOLD, 15));
		lbTitle.setBounds(12, 10, 75, 27);
		getContentPane().add(lbTitle);


		try {
			lbImage = new JLabel();
			BufferedImage bimg = ImageIO.read(image);	
			lbImage.setIcon(new ImageIcon(new ImageIcon(bimg).getImage()
					.getScaledInstance(199, 199, Image.SCALE_SMOOTH)));
			lbImage.setBounds(70, 78, 199, 199);
			lbImage.setBorder(new TitledBorder(new LineBorder(Color.black,5)));
			getContentPane().add(lbImage);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		
		

		JButton btn_ImageFind = new JButton("\uCC3E\uC544\uBCF4\uAE30");
		btn_ImageFind.setBounds(36, 315, 138, 43);
		getContentPane().add(btn_ImageFind);
		
		btn_ImageFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					JFrame jFrame=new JFrame();
					FileDialog fileDialogOpen = new FileDialog(jFrame, "이미지 찾기", FileDialog.LOAD);
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
			            	Image resize=image.getScaledInstance(190,190,Image.SCALE_SMOOTH);
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
		lbName.setBounds(326, 93, 42, 15);
		getContentPane().add(lbName);
		
		textField_Name = new JTextField(name);
		textField_Name.setBounds(433, 90, 144, 21);
		getContentPane().add(textField_Name);
		textField_Name.setColumns(10);
		
		JLabel lbBirth = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		lbBirth.setBounds(326, 133, 57, 15);
		getContentPane().add(lbBirth);
		
		textField_Birth = new JTextField(birth);
		textField_Birth.setBounds(433, 130, 144, 21);
		getContentPane().add(textField_Birth);
		textField_Birth.setColumns(10);
		
		JLabel lbSex = new JLabel("\uC131\uBCC4");
		lbSex.setBounds(326, 173, 32, 15);
		getContentPane().add(lbSex);
		
		ButtonGroup group = new ButtonGroup();
		
		
		JRadioButton rdMan = new JRadioButton("\uB0A8\uC131");
		rdMan.setBounds(433, 165, 57, 23);
		getContentPane().add(rdMan);
		
		JRadioButton rdWom = new JRadioButton("\uC5EC\uC131");
		rdWom.setBounds(520, 164, 57, 23);
		getContentPane().add(rdWom);
		
		if(sex==0) {
			rdWom.setSelected(true);
		}else {
			rdMan.setSelected(true);
		}
			
		
		group.add(rdMan);
		group.add(rdWom);
		
		JLabel lbEmail = new JLabel("\uC774\uBA54\uC77C");
		lbEmail.setBounds(326, 213, 42, 15);
		getContentPane().add(lbEmail);
		
		textField_Email = new JTextField(mail);
		textField_Email.setColumns(10);
		textField_Email.setBounds(433, 210, 144, 21);
		getContentPane().add(textField_Email);
		
		JLabel lbPhoneN = new JLabel("\uC804\uD654\uBC88\uD638");
		lbPhoneN.setBounds(326, 253, 57, 15);
		getContentPane().add(lbPhoneN);
		
		textField_PhoneN = new JTextField(phone);
		textField_PhoneN.setBounds(433, 256, 144, 21);
		getContentPane().add(textField_PhoneN);
		textField_PhoneN.setColumns(10);
		
		JButton btnAmend = new JButton("\uC218\uC815");
		btnAmend.setBounds(186, 315, 138, 43);
		getContentPane().add(btnAmend);
		
		btnAmend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_Name.getText()==""||textField_Birth.getText()==""||textField_Email.getText()==""||textField_PhoneN.getText()=="") {
					JOptionPane.showMessageDialog(null, "모든 필드가 채워지지 않았습니다.", "입력 오류", JOptionPane.WARNING_MESSAGE);
				}
				else {
					if(iis==null) {
						try {
							Connection tmpConn = dbConn.getConnection();
	
	//						String sql = "UPDATE USER SET USER_PHONE = ?, USER_NAME = ?, USER_BIRTH = ?, USER_SEX = ?, USER_MAIL = ? WHERE USER_PHONE = ?;";
	//						System.out.println(lbPhoneN.getText());
	//						System.out.println(textField_Name.getText());
							String sql = "UPDATE USER set USER_PHONE = ?,USER_NAME = ? ,USER_BIRTH = ?, USER_SEX = ?, USER_MAIL = ? WHERE USER_PHONE = \""+ textField_PhoneN.getText() +"\";";
	
				            PreparedStatement pre = tmpConn.prepareStatement(sql);
	
				            pre.setString(1,textField_PhoneN.getText());	
				            pre.setString(2,textField_Name.getText());	
				            
				            SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
				            
				            Date to = null;
							try {
								to = transFormat.parse(textField_Birth.getText());
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
				            
				            long timeInMilliSeconds = to.getTime();
				            
				            pre.setDate(3,new java.sql.Date(timeInMilliSeconds));	
				            if(rdWom.isSelected())
				            	pre.setInt(4,0);	
				            else
				            	pre.setInt(4,1);	
				            
				            
				            pre.setString(5,textField_Email.getText());	

				            pre.executeUpdate();
		
							JOptionPane.showMessageDialog(null, "수정이 완료되었습니다.", "수정 완료", JOptionPane.INFORMATION_MESSAGE);
							setVisible(false);
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "수정에 실패하였습니다.", "수정 실패\n", JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
					}
					}else {
						try {
							Connection tmpConn = dbConn.getConnection();
	
	//						String sql = "UPDATE USER SET USER_PHONE = ?, USER_NAME = ?, USER_BIRTH = ?, USER_SEX = ?, USER_MAIL = ? WHERE USER_PHONE = ?;";
	//						System.out.println(lbPhoneN.getText());
	//						System.out.println(textField_Name.getText());
							String sql = "UPDATE USER set USER_PHONE = ?,USER_NAME = ? ,USER_BIRTH = ?, USER_SEX = ?, USER_MAIL = ? , USER_IMAGE = ? WHERE USER_PHONE = \""+ textField_PhoneN.getText() +"\";";
	
				            PreparedStatement pre = tmpConn.prepareStatement(sql);
	
				            pre.setString(1,textField_PhoneN.getText());	
				            pre.setString(2,textField_Name.getText());	
				            
				            SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
				            
				            Date to = null;
							try {
								to = transFormat.parse(textField_Birth.getText());
							} catch (ParseException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
				            
				            long timeInMilliSeconds = to.getTime();
				            
				            pre.setDate(3,new java.sql.Date(timeInMilliSeconds));	
				            if(rdWom.isSelected())
				            	pre.setInt(4,0);	
				            else
				            	pre.setInt(4,1);	
				            
				            
				            pre.setString(5,textField_Email.getText());	
				            
				            pre.setBinaryStream(6,iis,(int)file.length());	
				       
				            
				            pre.executeUpdate();
		
							JOptionPane.showMessageDialog(null, "수정이 완료되었습니다.", "저장 완료", JOptionPane.INFORMATION_MESSAGE);
							MemberSearch temp = new MemberSearch();
							temp.setVisible(true);
							setVisible(false);
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "수정에 실패하였습니다.", "저장 실패\n", JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
						
						}
					}
				}
			}
		});
		
		JButton btnCancel = new JButton("\uCDE8\uC18C");
		btnCancel.setBounds(336, 315, 138, 43);
		getContentPane().add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
			}
		);
		
		JButton btnTOut = new JButton("\uD0C8\uD1F4");
		btnTOut.setBounds(486, 315, 138, 43);
		getContentPane().add(btnTOut);
		btnTOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_Name.getText()==""||textField_Birth.getText()==""||textField_Email.getText()==""||textField_PhoneN.getText()=="") {
					JOptionPane.showMessageDialog(null, "모든 필드가 채워지지 않았습니다.", "입력 오류", JOptionPane.WARNING_MESSAGE);
				}
				else {
					try {
						
						Connection tmpConn = dbConn.getConnection();
						ResultSet src = dbConn.executeQurey("select * from USER where USER_PHONE = \""+textField_PhoneN.getText()+"\";");//폰 번호를 프라이머리로 받아서 검색
						int ys=-1;
						while(src.next())
							ys = src.getInt(9);
						
						System.out.println(ys);
						
						if(ys != 0) {
							JOptionPane.showMessageDialog(null, "도서 대출 상태입니다","탈퇴 오류" ,JOptionPane.WARNING_MESSAGE);
						}else {
							String sql = "UPDATE USER set USER_OUT_DATE = ? WHERE USER_PHONE = \""+ textField_PhoneN.getText() +"\";";
				            PreparedStatement pre = tmpConn.prepareStatement(sql);
				            SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
				            
				            Date time = new Date();
				            
				            long timeInMilliSeconds = time.getTime();
				            java.sql.Date date1 = new java.sql.Date(timeInMilliSeconds);
	
				            pre.setDate(1,date1);	
				            
				            pre.executeUpdate();
		
							JOptionPane.showMessageDialog(null, "탈퇴 완료되었습니다.", "탈퇴 완료", JOptionPane.INFORMATION_MESSAGE);
							setVisible(false);
						}
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "탈퇴 실패하였습니다.", "탈퇴 실패\n", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					
					}
				}
			}
		});
	}
}
