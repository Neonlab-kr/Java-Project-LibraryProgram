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

import java.awt.Color;
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
	
	
	BookSearch getSelf() {
		return this;
	}
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
		splitPane.setEnabled(false);
		splitPane.setDividerSize(2);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		contentPane.add(splitPane);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setDividerSize(4);
		splitPane_1.setEnabled(false);
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
		
		JButton btnNewButton = new JButton("\uAC80\uC0C9");	//�˻���ư
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index=0;	//�ε��� �ʱ�ȭ
				panel.removeAll();	//�г� ����
				
				try {
					if (txtn.getText().equals("") && txtm.getText().equals("")) {	//�����ʵ�� �����ʵ� �� �� �������
						JOptionPane.showMessageDialog(null, "�˻��� ���� ������ ���Ե��� �ʾҽ��ϴ�.\n��� ������ ǥ���մϴ�.\n�ε��� �ð��� �ҿ�� �� �ֽ��ϴ�.", "��� ǥ��",	JOptionPane.WARNING_MESSAGE);
					}
					
					ResultSet src = dbConn.executeQurey("select * from BOOK where BOOK_TITLE like \"%" + txtn.getText() + "%\" and BOOK_AUTHOR like \"%" + txtm.getText() + "%\";");
					if (!src.isBeforeFirst()) {
						JOptionPane.showMessageDialog(null, "�˻� ����� �����ϴ�.", "��� ����", JOptionPane.WARNING_MESSAGE);
					} else {
						while(src.next()) {
							AddResult(src);		
						}	
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}catch(NullPointerException e2) {
					e2.printStackTrace();
				}
			
			}
		});
		panel_1.add(btnNewButton);
	
		JScrollPane scrollPane = new JScrollPane();
		splitPane.setRightComponent(scrollPane);
		
		panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new MigLayout("", "[410.00,grow]", "[grow][grow][grow][grow][grow]"));
		
	}

	void AddResult(ResultSet src) {
		JPanel pane = new JPanel();
		pane.setBackground(Color.WHITE);
		panel.add(pane, "cell 0 "+index+",grow");
		pane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblNewLabel_3_51 = new JLabel();	//�̹���
		InputStream inputStream = null;

		try {
			inputStream = src.getBinaryStream(7);
			try {
				lblNewLabel_3_51.setIcon(new ImageIcon(new ImageIcon(ImageIO.read(inputStream)).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
			}catch(NullPointerException e) {
				lblNewLabel_3_51.setText("�̹��� ����");
			}
			pane.add(lblNewLabel_3_51);
			
			JTextPane titlePane = new JTextPane();
			titlePane.setText("-����-\n\n"+src.getString(2));
			pane.add(titlePane);

			
			JTextPane authPane = new JTextPane();
			authPane.setText("-����-\n\n"+src.getString(3));
			pane.add(authPane);
			
			JTextPane pubPane = new JTextPane();
			pubPane.setText("-���ǻ�-\n\n"+src.getString(4));
			pane.add(pubPane);
			
			JLabel isbnLabel = new JLabel(src.getString(1));
			
			JButton btnNewButton_1_51 = new JButton("��������");
			btnNewButton_1_51.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					BookAmend info = new BookAmend(getSelf(),isbnLabel.getText());
					info.setVisible(true);
					System.out.println(isbnLabel.getText());
				}
			});
			pane.add(btnNewButton_1_51);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		index++;
		panel.revalidate();	//�г� �ٽ� �׸���
		panel.repaint();
	}
}
