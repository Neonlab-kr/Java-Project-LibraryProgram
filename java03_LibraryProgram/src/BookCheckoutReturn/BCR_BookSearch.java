package BookCheckoutReturn;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Program.MainMenu;
import SQL.dbConnector;

import javax.swing.JScrollBar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JScrollPane;
import java.awt.Color;

public class BCR_BookSearch extends JFrame {

	dbConnector dbConn = new dbConnector();
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPanel jp_label;
	private JScrollPane scroll;
	private GridBagLayout Gbag = new GridBagLayout();
	BookCheckout BCO;
	BookReturn BR;

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
	public BCR_BookSearch(int num, ResultSet src) {
		setBounds(100, 100, 680, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 191, 664, 198);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(55, 38, 91, 106);
		panel.add(lblNewLabel);

		JButton btnNewButton = new JButton("\uB3C4\uC11C\uC120\uD0DD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(num==1) {
					if(textField_4.equals("")) {
						JOptionPane.showMessageDialog(null, "도서가 선택되지 않았습니다.", "선택 없음", JOptionPane.ERROR_MESSAGE);
					}
					else {
						BCO.textField.setText(textField.getText());
						BCO.textField.setEditable(false);
						BCO.textField_1.setText(textField_1.getText());
						BCO.textField_1.setEditable(false);
						BCO.textField_2.setText(textField_2.getText());
						BCO.textField_3.setText(textField_3.getText());
						BCO.textField_4.setText(textField_4.getText());
						BCO.textField_4.setEditable(false);
						ResultSet tempsrc = dbConn.executeQurey("select * from BOOK where BOOK_ISBN like \""
								+ textField_4.getText().replaceAll("[^0-9]", "") + "\";");
						try {
							tempsrc.next();
							BCO.textArea.setText(tempsrc.getString(6));
							InputStream inputStream = tempsrc.getBinaryStream(7);
							BCO.lblNewLabel_1.setIcon(new ImageIcon(new ImageIcon(ImageIO.read(inputStream)).getImage().getScaledInstance(67, 89, Image.SCALE_SMOOTH)));
							setVisible(false);
						} catch (SQLException | IOException e1) {
							e1.printStackTrace();
						}
					}
				}
				else {
					if(textField_4.equals("")) {
						JOptionPane.showMessageDialog(null, "도서가 선택되지 않았습니다.", "선택 없음", JOptionPane.ERROR_MESSAGE);
					}
					else {
						BR.textField.setText(textField.getText());
						BR.textField.setEditable(false);
						BR.textField_1.setText(textField_1.getText());
						BR.textField_1.setEditable(false);
						BR.textField_2.setText(textField_2.getText());
						BR.textField_3.setText(textField_3.getText());
						BR.textField_4.setText(textField_4.getText());
						BR.textField_4.setEditable(false);
						ResultSet tempsrc = dbConn.executeQurey("select * from BOOK where BOOK_ISBN like \""
								+ textField_4.getText().replaceAll("[^0-9]", "") + "\";");
						try {
							tempsrc.next();
							BR.textArea.setText(tempsrc.getString(6));
							InputStream inputStream = tempsrc.getBinaryStream(7);
							BR.lblNewLabel_1.setIcon(new ImageIcon(new ImageIcon(ImageIO.read(inputStream)).getImage().getScaledInstance(67, 89, Image.SCALE_SMOOTH)));
							setVisible(false);
						} catch (SQLException | IOException e1) {
							e1.printStackTrace();
						}
						ResultSet tempsrc1 = dbConn.executeQurey("select * from RENT where BOOK_ISBN like \""
								+ textField_4.getText().replaceAll("[^0-9]", "") + "\";");
						try {
							tempsrc1.next();
							BR.textField_7.setText(tempsrc1.getString(3));
							ResultSet tempsrc2 = dbConn.executeQurey("select * from USER where USER_PHONE like \""
									+ tempsrc1.getString(5) + "\";");
							tempsrc2.next();
							BR.textField_6.setText(tempsrc2.getString(2));
						} catch(SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
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
		
		try {
			int count = 0;
			while (src.next()) {
				InputStream inputStream = src.getBinaryStream(7);
				JLabel imgLabel = new JLabel(new ImageIcon(new ImageIcon(ImageIO.read(inputStream)).getImage()
						.getScaledInstance(100, 80, Image.SCALE_SMOOTH)));
				JLabel Title = new JLabel("제목 : " + src.getString(2));
				Title.setFont(new Font("굴림", Font.PLAIN, 15));
				JLabel Author = new JLabel("저자 : " + src.getString(3));
				Author.setFont(new Font("굴림", Font.PLAIN, 15));
				JLabel ISBN = new JLabel("ISBN : " + src.getString(1));
				ISBN.setFont(new Font("굴림", Font.PLAIN, 15));
				JPanel label2 = new JPanel();
				JButton tempButton = new JButton("상세정보");
				tempButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							ResultSet tempsrc = dbConn.executeQurey("select * from BOOK where BOOK_ISBN like \""
									+ ISBN.getText().replaceAll("[^0-9]", "") + "\";");
							tempsrc.next();
							InputStream inputStream = tempsrc.getBinaryStream(7);
							textField.setText(tempsrc.getString(2));
							textField_1.setText(tempsrc.getString(3));
							textField_2.setText(tempsrc.getString(5));
							textField_3.setText(tempsrc.getString(8));
							textField_4.setText(tempsrc.getString(1));
							lblNewLabel.setIcon(new ImageIcon(new ImageIcon(ImageIO.read(inputStream)).getImage()
									.getScaledInstance(91, 106, Image.SCALE_SMOOTH)));
						} catch (SQLException e1) {
							e1.printStackTrace();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				});
				label2.add(imgLabel);
				label2.add(Title);
				label2.add(Author);
				label2.add(tempButton);
				label2.setBorder(new LineBorder(Color.BLACK));
				create_form(label2, 0, 30 * count++, 30, 10);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
