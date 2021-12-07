package Member;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import Book.BookRegister;
import Book.BookSearch;
import BookCheckoutReturn.BookCheckout;
import BookCheckoutReturn.BookReturn;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;

public class MemberSearch extends JFrame {
	private JTextField textField_Booktitle;
	private JTextField textField_Author;

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
	 JButton btn ;
	 int count =1;
	 GridBagLayout Gbag = new GridBagLayout();
	 GridBagConstraints gbc1;
	public void create_form(Component cmpt, int x, int y, int w, int h){

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
		
		JLabel lbTitle = new JLabel("\uD68C\uC6D0\uAC80\uC0C9");
		lbTitle.setFont(new Font("±¼¸²", Font.BOLD, 15));
		lbTitle.setBounds(12, 10, 75, 27);
		add(lbTitle);
		
		JLabel lbBookTitle = new JLabel("\uC81C\uBAA9 :");
		lbBookTitle.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		lbBookTitle.setBounds(43, 47, 48, 18);
		add(lbBookTitle);
		
		textField_Booktitle = new JTextField();
		textField_Booktitle.setBounds(87, 46, 75, 21);
		add(textField_Booktitle);
		textField_Booktitle.setColumns(10);
		
		JLabel lbAuthor = new JLabel("\uC800\uC790 :");
		lbAuthor.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		lbAuthor.setBounds(174, 47, 48, 18);
		add(lbAuthor);
		
		textField_Author = new JTextField();
		textField_Author.setColumns(10);
		textField_Author.setBounds(222, 46, 75, 21);
		add(textField_Author);
		
		JButton btnSearch = new JButton("\uAC80\uC0C9");
		btnSearch.setFont(new Font("±¼¸²", Font.PLAIN, 14));
		btnSearch.setBounds(338, 47, 69, 21);
		add(btnSearch);
		

		jp_label = new JPanel();

	   // ¶óº§ÀÌ µé¾î°¥ panel Àº ·¹ÀÌ¾Æ¿ôÀ» GridBagÀ» »ç¿ëÇÑ´Ù.
	   jp_label.setLayout(Gbag);  

//	   jp_label.setBackground(Color.white);

	   label = new JLabel();
	   create_form(label, 0,0,30,10);  // GridBagLayout À» À§ÇÑ ÇÔ¼öÈ£Ãâ
		
		JScrollPane scrollPane = new JScrollPane(jp_label);
		scrollPane.setBounds(12, 77, 395, 203);
		add(scrollPane); 
		

		for(int i=0;i<10;i++) {
			JLabel imgLabel = new JLabel();
			ImageIcon c = new ImageIcon("image/icon1.png");
			imgLabel.setIcon(c);
			JLabel a = new JLabel("ÀÌ¸§ :À±¼ºÃ¶");
			a.setFont(new Font("±¼¸²", Font.PLAIN, 15));
			JLabel b = new JLabel("ÀüÈ­¹øÈ£ :0192222222");
			b.setFont(new Font("±¼¸²", Font.PLAIN, 15));
			JPanel label2 = new JPanel();
			JButton btnNewButton = new JButton("Å¬¸¯");
			label2.add(imgLabel);
			label2.add(a);
			label2.add(b);
			label2.add(btnNewButton);
	        create_form(label2,0,count++*30,30,10);
		}
	}
}
