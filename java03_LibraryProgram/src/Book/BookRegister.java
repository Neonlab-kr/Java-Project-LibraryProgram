package Book;

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

import BookCheckoutReturn.BookCheckout;
import BookCheckoutReturn.BookReturn;
import Member.MemberRegister;
import Member.MemberSearch;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Font;
import javax.swing.SpringLayout;
import javax.swing.JTextField;

public class BookRegister extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

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
		
		JButton btnNewButton = new JButton("\uC800\uC7A5");
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
		
		JButton btnNewButton_2 = new JButton("\uCC3E\uC544\uBCF4\uAE30");
		panel_1.add(btnNewButton_2, BorderLayout.SOUTH);
		
		JPanel panel_2 = new JPanel();
		splitPane.setRightComponent(panel_2);
		panel_2.setLayout(new MigLayout("", "[47.00px][265.00px,grow]", "[23.00px][23.00][][][][65.00]"));
		
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
	}

}
