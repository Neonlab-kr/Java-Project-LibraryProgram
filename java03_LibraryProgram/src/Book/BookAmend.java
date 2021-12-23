package Book;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BookCheckoutReturn.BookCheckout;
import BookCheckoutReturn.BookReturn;
import Member.MemberRegister;
import Member.MemberSearch;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class BookAmend extends JFrame implements ActionListener

{

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
					BookAmend frame = new BookAmend();
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
	public BookAmend() {
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
		
		JLabel lblNewLabel = new JLabel("\uB3C4\uC11C\uC815\uBCF4");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton_3 = new JButton("\uC218\uC815");
		panel.add(btnNewButton_3);
		
		JButton btnNewButton = new JButton("\uC0AD\uC81C");
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uCDE8\uC18C");
		panel.add(btnNewButton_1);
		
		JSplitPane splitPane = new JSplitPane();
		contentPane.add(splitPane, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		splitPane.setLeftComponent(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("image");
		panel_1.add(lblNewLabel_1);
		
		JButton btnNewButton_2 = new JButton("\uCC3E\uC544\uBCF4\uAE30");	//이미지 찾아보기
		panel_1.add(btnNewButton_2, BorderLayout.SOUTH);
		ActionListener find=new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame jFrame=new JFrame();
				FileDialog fileDialogOpen = new FileDialog(jFrame, "이미지 열기", FileDialog.LOAD);
                fileDialogOpen.setVisible(true);
                String filePath = fileDialogOpen.getDirectory() + fileDialogOpen.getFile();
                System.out.println(filePath);
                //사진파일 입력
			}
		};
		btnNewButton_2.addActionListener(find);

		
		
		
		JPanel panel_2 = new JPanel();
		splitPane.setRightComponent(panel_2);
		panel_2.setLayout(new MigLayout("", "[72.00px][265.00px,grow]", "[21.00px][23.00][][][][47.00][][]"));
		
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
		
		JLabel lblNewLabel_6 = new JLabel("\uAC00\uACA9");
		panel_2.add(lblNewLabel_6, "cell 0 2,alignx center,aligny center");
		
		textField_2 = new JTextField();
		panel_2.add(textField_2, "cell 1 2,grow");
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\uB9C1\uD06C");
		panel_2.add(lblNewLabel_3, "cell 0 3,alignx center,aligny center");
		
		textField_3 = new JTextField();
		panel_2.add(textField_3, "cell 1 3,grow");
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("ISBN");
		panel_2.add(lblNewLabel_5, "cell 0 4,alignx center,aligny center");
		
		textField_4 = new JTextField();
		panel_2.add(textField_4, "cell 1 4,grow");
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("\uC124\uBA85");
		panel_2.add(lblNewLabel_7, "cell 0 5,alignx center,aligny center");
		
		textField_5 = new JTextField();
		panel_2.add(textField_5, "cell 1 5,grow");
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("\uB300\uCD9C\uC790");
		panel_2.add(lblNewLabel_8, "cell 0 6,alignx center,aligny center");
		
		textField_6 = new JTextField();
		panel_2.add(textField_6, "cell 1 6,growx,aligny center");
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("\uBC18\uB0A9\uC608\uC815\uC77C");
		panel_2.add(lblNewLabel_9, "cell 0 7,alignx trailing");
		
		textField_7 = new JTextField();
		panel_2.add(textField_7, "cell 1 7,growx,aligny center");
		textField_7.setColumns(10);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
