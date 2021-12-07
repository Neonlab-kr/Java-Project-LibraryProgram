package BookCheckoutReturn;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JScrollPane;

public class BCR_BookSearch extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPanel jp_label;
	private JScrollPane scroll;
	private GridBagLayout Gbag = new GridBagLayout();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BCR_BookSearch frame = new BCR_BookSearch();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void create_form(Component cmpt, int x, int y, int w, int h) {

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

	/**
	 * Create the frame.
	 */
	public BCR_BookSearch() {
		setBounds(100, 100, 680, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 191, 664, 198);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(55, 38, 91, 106);
		panel.add(lblNewLabel);

		JButton btnNewButton = new JButton("\uB3C4\uC11C\uC120\uD0DD");
		btnNewButton.setBounds(533, 38, 97, 23);
		panel.add(btnNewButton);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(269, 25, 208, 21);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(269, 56, 208, 21);
		panel.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(269, 87, 208, 21);
		panel.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(269, 118, 208, 21);
		panel.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(269, 149, 208, 21);
		panel.add(textField_4);

		JLabel lblNewLabel_1 = new JLabel("\uC81C\uBAA9");
		lblNewLabel_1.setBounds(184, 28, 57, 15);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("\uC800\uC790");
		lblNewLabel_1_1.setBounds(184, 57, 57, 15);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("\uAC00\uACA9");
		lblNewLabel_1_2.setBounds(184, 90, 57, 15);
		panel.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("\uB9C1\uD06C");
		lblNewLabel_1_3.setBounds(184, 121, 57, 15);
		panel.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("ISBN");
		lblNewLabel_1_4.setBounds(184, 152, 57, 15);
		panel.add(lblNewLabel_1_4);

		jp_label = new JPanel();

		jp_label.setLayout(Gbag);

		scroll = new JScrollPane(jp_label);
		scroll.setBounds(0, 0, 664, 192);

		contentPane.add(scroll);

		for (int count = 0; count < 5; count++) {
			JLabel imgLabel = new JLabel();
			JLabel Title = new JLabel("제목 :  ");
			Title.setFont(new Font("굴림", Font.PLAIN, 15));
			JLabel Author = new JLabel("저자 :  ");
			Author.setFont(new Font("굴림", Font.PLAIN, 15));
			JPanel label2 = new JPanel();
			JButton tempButton = new JButton("상세정보");
			label2.add(imgLabel);
			label2.add(Title);
			label2.add(Author);
			label2.add(tempButton);

			create_form(label2, 0, 30 * count, 30, 10);
		}
	}
}
