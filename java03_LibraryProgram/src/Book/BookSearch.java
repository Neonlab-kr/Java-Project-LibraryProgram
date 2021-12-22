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

import BookCheckoutReturn.*;
import Member.*;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;

public class BookSearch extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
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
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\uC800\uC790:l");
		panel_1.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("\uAC80\uC0C9");
		panel_1.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane.setRightComponent(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new MigLayout("", "[410.00,grow]", "[44.00,grow][grow][grow][grow][grow]"));
		
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
		
		for(int i=1;i<10;i++) {
			JPanel pane = new JPanel();
			panel.add(pane, "cell 0 "+i+",grow");
			pane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			
			JLabel lblNewLabel_3_51 = new JLabel("image");
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
		}
	}
}
