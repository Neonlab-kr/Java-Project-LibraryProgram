package Member;


import javax.swing.JLabel;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import BookCheckoutReturn.BookCheckout;

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
		setLayout(null);
		
		JLabel lbTitle = new JLabel("\uD68C\uC6D0\uB4F1\uB85D");
		lbTitle.setFont(new Font("����", Font.BOLD, 15));
		lbTitle.setBounds(12, 10, 75, 27);
		add(lbTitle);
		
		JLabel lbImage = new JLabel("        Image");
		lbImage.setBounds(49, 67, 97, 92);
		add(lbImage);
		
		JButton btn_ImageFind = new JButton("\uCC3E\uC544\uBCF4\uAE30");
		btn_ImageFind.setBounds(49, 161, 97, 23);
		add(btn_ImageFind);
		
		JLabel lbName = new JLabel("\uC774\uB984");
		lbName.setBounds(204, 67, 42, 15);
		add(lbName);
		
		textField_Name = new JTextField();
		textField_Name.setBounds(258, 64, 144, 21);
		add(textField_Name);
		textField_Name.setColumns(10);
		
		JLabel lbBirth = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		lbBirth.setBounds(189, 106, 57, 15);
		add(lbBirth);
		
		textField_Birth = new JTextField();
		textField_Birth.setBounds(258, 103, 144, 21);
		add(textField_Birth);
		textField_Birth.setColumns(10);
		
		JLabel lbSex = new JLabel("\uC131\uBCC4");
		lbSex.setBounds(204, 141, 32, 15);
		add(lbSex);
		
		JRadioButton rdMan = new JRadioButton("\uB0A8\uC131");
		rdMan.setBounds(258, 137, 57, 23);
		add(rdMan);
		
		JRadioButton rdWom = new JRadioButton("\uC5EC\uC131");
		rdWom.setBounds(345, 136, 57, 23);
		add(rdWom);
		
		JLabel lbEmail = new JLabel("\uC774\uBA54\uC77C");
		lbEmail.setBounds(194, 176, 42, 15);
		add(lbEmail);
		
		textField_Email = new JTextField();
		textField_Email.setColumns(10);
		textField_Email.setBounds(258, 173, 144, 21);
		add(textField_Email);
		
		JLabel lbPhoneN = new JLabel("\uC804\uD654\uBC88\uD638");
		lbPhoneN.setBounds(189, 210, 57, 15);
		add(lbPhoneN);
		
		textField_PhoneN = new JTextField();
		textField_PhoneN.setBounds(258, 207, 144, 21);
		add(textField_PhoneN);
		textField_PhoneN.setColumns(10);
		
		JButton btnUp = new JButton("\uB4F1\uB85D");
		btnUp.setBounds(82, 246, 97, 23);
		add(btnUp);
		
		JButton btnCancel = new JButton("\uCDE8\uC18C");
		btnCancel.setBounds(268, 246, 97, 23);
		add(btnCancel);
	}
}
