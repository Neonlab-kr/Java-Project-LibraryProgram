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
import java.io.InputStream;
import java.nio.file.Files;
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

import BookCheckoutReturn.BCR_BookSearch;
import BookCheckoutReturn.BookCheckout;
import BookCheckoutReturn.BookReturn;
import Member.MemberRegister;
import Member.MemberSearch;
import Program.MainMenu;
import SQL.dbConnector;
import Util.ImageCheck;
import net.miginfocom.swing.MigLayout;
import java.awt.ComponentOrientation;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class BookAmend extends JFrame implements ActionListener

{
	LocalDateTime now = LocalDateTime.now();
	dbConnector dbConn = new dbConnector();
	FileInputStream iis;	//�̹�������


	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JLabel lblNewLabel_1; //�̹��� ��
	private File file;	//�̹��� ����
	JTextArea textArea;
	JButton btnNewButton;	//������ư


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
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
	public BookAmend(BookSearch BS, String isbn) {
		setTitle("LibrayManager");
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
		
		JLabel lblNewLabel = new JLabel("\uB3C4\uC11C\uC815\uBCF4");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton_3 = new JButton("\uC218\uC815");	//������ư
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText()==""||textField_1.getText()==""||textField_2.getText()==""||textField_3.getText()==""||textField_4.getText()==""||textArea.getText()=="") {
					JOptionPane.showMessageDialog(null, "��� �ʵ尡 ä������ �ʾҽ��ϴ�.", "�Է� ����", JOptionPane.WARNING_MESSAGE);
				}else {
					try {
						Connection tmpConn = dbConn.getConnection();
						Statement st = tmpConn.createStatement();
			            //File imgfile = new File("d:\\images.jpg");
			            //FileInputStream fin = new FileInputStream(imgfile);
			            PreparedStatement pre = tmpConn.prepareStatement("update BOOK set BOOK_TITLE=?,BOOK_AUTHOR=?,BOOK_PUB=?,BOOK_PRICE=?,BOOK_LINK=?,BOOK_ISBN=?,BOOK_DESCRIPTION=? where BOOK_ISBN like \""+isbn+"\";");    
			            pre.setString(1,textField.getText());	//����
			            pre.setString(2,textField_1.getText());	//����
			            pre.setString(3,textField_5.getText());	//���ǻ�
			            pre.setInt(4,Integer.parseInt(textField_2.getText()));	//����
			            pre.setString(5,textField_3.getText());	//��ũ
			            pre.setString(6,textField_4.getText());	//ISBN
			            pre.setString(7,textArea.getText());	//����
			            pre.executeUpdate();
			            
			            if(!(iis==null)) {//�̹��� ����
							System.out.println("�̹��� ����");
						
				            //File imgfile = new File("d:\\images.jpg");
				            //FileInputStream fin = new FileInputStream(imgfile);
				            PreparedStatement pref = tmpConn.prepareStatement("update BOOK set BOOK_IMAGE=? where BOOK_ISBN like \""+isbn+"\";");
				            pref.setBinaryStream(1,iis,(int)file.length());	//�̹���
				            pref.executeUpdate();
						}
			            JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�.", "���� �Ϸ�", JOptionPane.INFORMATION_MESSAGE);
			            setVisible(false);
			            BS.setVisible(false);
			            BookSearch temp = new BookSearch();
			            temp.setVisible(true);
			            
					}catch (NullPointerException |SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "������ �����Ͽ����ϴ�.\n�ߺ��v������  Ȯ���ϼ���.", "���� ����", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
					}

				}
			}
		});
			


		panel.add(btnNewButton_3);
		
		btnNewButton = new JButton("\uC0AD\uC81C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ResultSet src = dbConn.executeQurey("delete from BOOK where BOOK_ISBN like \""+isbn+"\";");
				System.out.println("������ư");
				Connection tmpConn = dbConn.getConnection();
				try {
					PreparedStatement pre = tmpConn.prepareStatement("delete from BOOK where BOOK_ISBN like \""+isbn+"\";");
					pre.executeUpdate();
					JOptionPane.showMessageDialog(null, "������ �Ϸ�Ǿ����ϴ�.", "����", JOptionPane.INFORMATION_MESSAGE);
		            setVisible(false);
		            BS.setVisible(false);
		            BookSearch temp = new BookSearch();
		            temp.setVisible(true);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uCDE8\uC18C");
		btnNewButton_1.addActionListener(new ActionListener() {	//��ҹ�ư
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		panel.add(btnNewButton_1);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(2);
		contentPane.add(splitPane, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		splitPane.setLeftComponent(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		
		
		JButton btnNewButton_2 = new JButton("\uCC3E\uC544\uBCF4\uAE30");	//�̹��� ã�ƺ���
		panel_1.add(btnNewButton_2, BorderLayout.SOUTH);
		
		lblNewLabel_1 = new JLabel("Image");
		panel_1.add(lblNewLabel_1, BorderLayout.CENTER);
		
		
		ActionListener find=new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame jFrame=new JFrame();
				FileDialog fileDialogOpen = new FileDialog(jFrame, "�̹��� ����", FileDialog.LOAD);
				//���� ������ �־����
                fileDialogOpen.setVisible(true);
                
                
                //�̹��� �ҷ�����
            	try {
            		String filePath = fileDialogOpen.getDirectory() + fileDialogOpen.getFile();
	                System.out.println(filePath);
	                //�������� �Է�
	            	file = new File(filePath);
					
					if(ImageCheck.isImage(file)==false&&!filePath.equals("nullnull")){
						JOptionPane.showMessageDialog(null, "�̹����� �ƴմϴ�.", "�̹��� ����", JOptionPane.ERROR_MESSAGE);
					}
					else if(!filePath.equals("nullnull")) {						
						iis = new FileInputStream(file);
						Image image = ImageIO.read(file);           	
		            	Image resize=image.getScaledInstance(175,230,Image.SCALE_SMOOTH);
		            	ImageIcon icon=new ImageIcon(resize);
		            	lblNewLabel_1.setIcon(icon);
					}  						
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "�̹����� �ҷ����µ� �����߽��ϴ�.", "FileNotFoundException", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "�̹����� �ҷ����µ� �����߽��ϴ�.", "IOException", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		};
		btnNewButton_2.addActionListener(find);

		


			
			
			JPanel panel_2 = new JPanel();
			splitPane.setRightComponent(panel_2);
			panel_2.setLayout(new MigLayout("", "[74.00px][265.00px,grow]", "[21.00px][23.00][][][][][47.00,grow][][]"));
			
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
			
			JLabel lblNewLabel_10 = new JLabel("\uCD9C\uD310\uC0AC");
			panel_2.add(lblNewLabel_10, "cell 0 2,alignx center,aligny center");
			
			textField_5 = new JTextField();
			panel_2.add(textField_5, "cell 1 2,grow");
			textField_5.setColumns(10);
			
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
			textArea.setLineWrap(true);
			scrollPane.setViewportView(textArea);
			
			JLabel lblNewLabel_8 = new JLabel("\uB300\uCD9C\uC790");
			panel_2.add(lblNewLabel_8, "cell 0 7,alignx center,aligny center");
			
			textField_6 = new JTextField();
			textField_6.setEditable(false);
			panel_2.add(textField_6, "cell 1 7,growx,aligny center");
			textField_6.setColumns(10);
			
			JLabel lblNewLabel_9 = new JLabel("\uBC18\uB0A9\uC608\uC815\uC77C");
			panel_2.add(lblNewLabel_9, "cell 0 8,alignx center");
			
			textField_7 = new JTextField();
			textField_7.setEditable(false);
			panel_2.add(textField_7, "cell 1 8,growx,aligny center");
			textField_7.setColumns(10);
			splitPane.setDividerLocation(160);
			
			
			//�������� ǥ��
			InputStream inputStream = null;
		try {
			ResultSet src = dbConn.executeQurey("select * from BOOK where BOOK_ISBN like \"" + isbn + "\";");
			System.out.println("select * from BOOK where BOOK_ISBN like \"" + isbn + "\";");
			src.next();
			
			System.out.println(src.getString(2));
			textField.setText(src.getString(2));
			textField_1.setText(src.getString(3));
			textField_2.setText(src.getString(5));
			textField_3.setText(src.getString(8));
			textField_4.setText(src.getString(1));
			textField_5.setText(src.getString(4));
			textArea.setText(src.getString(6));
			inputStream = src.getBinaryStream(7);
			lblNewLabel_1.setIcon(new ImageIcon(new ImageIcon(ImageIO.read(inputStream)).getImage().getScaledInstance(160, 180, Image.SCALE_SMOOTH)));

			contentPane.revalidate();	//�г� �ٽ� �׸���
			contentPane.repaint();
			
		}catch(NullPointerException e) {
			e.printStackTrace();		
		}catch(SQLException e){
			e.printStackTrace();
		}catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//�������� ǥ��
		try {
			ResultSet src= dbConn.executeQurey("select * from RENT where BOOK_ISBN like \""+isbn+"\";");
			System.out.println("������ȸisbn:"+isbn);
			System.out.println("select * from RENT where BOOK_ISBN like \'"+isbn+"\';");
			if (!src.isBeforeFirst()) {
				textField_6.setText("������� ����");
				textField_7.setText("������� ����");
			} else {
				src.close();
				ResultSet src_rent= dbConn.executeQurey("select * from RENT where BOOK_ISBN like \""+isbn+"\";");
				src_rent.next();
				String phonenum=src_rent.getString(5);
				String rdate=src_rent.getString(3);
				System.out.println("select * from USER where USER_PHONE like \"" + phonenum + "\";");
				ResultSet src_name= dbConn.executeQurey("select * from USER where USER_PHONE like \"" + phonenum + "\";");
				src_name.next();
				//System.out.println("select * from USER where USER_PHONE like \"" +  + "\";");
				textField_6.setText(src_name.getString(2)+" ("+phonenum+")");
				textField_7.setText(rdate);
				btnNewButton.setEnabled(false);
				btnNewButton.setText("������ �����Ұ�");
				
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}catch(NullPointerException e) {
			e.printStackTrace();		
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


}

		