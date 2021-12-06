package MemberGUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;

public class MemberSearchGUI extends JPanel {
	private JTextField textField_Booktitle;
	private JTextField textField_Author;

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
	
	public MemberSearchGUI() {
		setBounds(100, 100, 561, 389);
		setLayout(null);
		
		JLabel lbTitle = new JLabel("\uD68C\uC6D0\uAC80\uC0C9");
		lbTitle.setFont(new Font("굴림", Font.BOLD, 15));
		lbTitle.setBounds(12, 10, 75, 27);
		add(lbTitle);
		
		JLabel lbBookTitle = new JLabel("\uC81C\uBAA9 :");
		lbBookTitle.setFont(new Font("굴림", Font.PLAIN, 15));
		lbBookTitle.setBounds(43, 47, 48, 18);
		add(lbBookTitle);
		
		textField_Booktitle = new JTextField();
		textField_Booktitle.setBounds(87, 46, 75, 21);
		add(textField_Booktitle);
		textField_Booktitle.setColumns(10);
		
		JLabel lbAuthor = new JLabel("\uC800\uC790 :");
		lbAuthor.setFont(new Font("굴림", Font.PLAIN, 15));
		lbAuthor.setBounds(174, 47, 48, 18);
		add(lbAuthor);
		
		textField_Author = new JTextField();
		textField_Author.setColumns(10);
		textField_Author.setBounds(222, 46, 75, 21);
		add(textField_Author);
		
		JButton btnSearch = new JButton("\uAC80\uC0C9");
		btnSearch.setFont(new Font("굴림", Font.PLAIN, 14));
		btnSearch.setBounds(338, 47, 69, 21);
		add(btnSearch);
		

		jp_label = new JPanel();

	   // 라벨이 들어갈 panel 은 레이아웃을 GridBag을 사용한다.
	   jp_label.setLayout(Gbag);  

//	   jp_label.setBackground(Color.white);

	   label = new JLabel();
	   create_form(label, 0,0,30,10);  // GridBagLayout 을 위한 함수호출
		
		JScrollPane scrollPane = new JScrollPane(jp_label);
		scrollPane.setBounds(12, 77, 395, 203);
		add(scrollPane); 
		

		for(int i=0;i<10;i++) {
			JLabel imgLabel = new JLabel();
			ImageIcon c = new ImageIcon("image/icon1.png");
			imgLabel.setIcon(c);
			JLabel a = new JLabel("제목 : 자바어려워 ");
			a.setFont(new Font("굴림", Font.PLAIN, 15));
			JLabel b = new JLabel("저자 : 성철 ");
			b.setFont(new Font("굴림", Font.PLAIN, 15));
			JPanel label2 = new JPanel();
			JButton btnNewButton = new JButton("클릭");
			label2.add(imgLabel);
			label2.add(a);
			label2.add(b);
			label2.add(btnNewButton);
	        create_form(label2,0,count++*30,30,10);
		}
	}
}
