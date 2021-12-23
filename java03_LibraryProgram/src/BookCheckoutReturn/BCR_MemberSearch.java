package BookCheckoutReturn;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;

import Program.MainMenu;
import SQL.dbConnector;

public class BCR_MemberSearch extends JFrame {

	dbConnector dbConn = new dbConnector();
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JRadioButton rdbtnNewRadioButton;
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
	public BCR_MemberSearch(BookCheckout BCO, ResultSet src) {
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
		lblNewLabel.setBounds(38, 38, 91, 106);
		panel.add(lblNewLabel);

		JButton btnNewButton = new JButton("\uD68C\uC6D0\uC120\uD0DD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_4.equals("")) {
					JOptionPane.showMessageDialog(null, "회원이 선택되지 않았습니다.", "선택 없음", JOptionPane.ERROR_MESSAGE);
				} else {
					BCO.textField_6.setText(textField.getText());
					BCO.textField_6.setEditable(false);
					BCO.textField_7.setText(textField_1.getText());
					BCO.textField_7.setEditable(false);
					BCO.textField_9.setText(textField_3.getText());
					BCO.textField_8.setText(textField_4.getText());
					BCO.textField_8.setEditable(false);
					if (rdbtnNewRadioButton.isSelected()) {
						BCO.rdbtnNewRadioButton.setSelected(true);
					} else {
						BCO.rdbtnNewRadioButton_1.setSelected(true);
					}
					ResultSet tempsrc = dbConn.executeQurey("select * from USER where USER_PHONE like \""+ textField_4.getText().replaceAll("[^0-9]", "") + "\";");
					try {
						tempsrc.next();
						InputStream inputStream = tempsrc.getBinaryStream(6);
						BCO.lblNewLabel_1_1.setIcon(new ImageIcon(new ImageIcon(ImageIO.read(inputStream)).getImage().getScaledInstance(67, 89, Image.SCALE_SMOOTH)));
						setVisible(false);
					} catch (SQLException | IOException e1) {
						e1.printStackTrace();
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

		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(269, 136, 208, 21);
		panel.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(269, 167, 208, 21);
		panel.add(textField_4);

		JLabel lblNewLabel_1 = new JLabel("\uC774\uB984");
		lblNewLabel_1.setBounds(184, 28, 57, 15);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		lblNewLabel_1_1.setBounds(184, 57, 57, 15);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("\uC131\uBCC4");
		lblNewLabel_1_2.setBounds(184, 90, 57, 15);
		panel.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("\uC774\uBA54\uC77C");
		lblNewLabel_1_3.setBounds(184, 139, 57, 15);
		panel.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("\uC804\uD654\uBC88\uD638");
		lblNewLabel_1_4.setBounds(184, 170, 57, 15);
		panel.add(lblNewLabel_1_4);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(269, 87, 208, 33);
		panel.add(panel_2);

		rdbtnNewRadioButton = new JRadioButton("\uB0A8\uC131");
		rdbtnNewRadioButton.setEnabled(false);
		panel_2.add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\uC5EC\uC131");
		rdbtnNewRadioButton_1.setEnabled(false);
		panel_2.add(rdbtnNewRadioButton_1);

		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);

		jp_label = new JPanel();

		jp_label.setLayout(Gbag);

		scroll = new JScrollPane(jp_label);
		scroll.setBounds(0, 0, 664, 192);

		contentPane.add(scroll);

		try {
			int count = 0;
			while (src.next()) {
				InputStream inputStream = src.getBinaryStream(6);
				JLabel imgLabel = new JLabel(new ImageIcon(new ImageIcon(ImageIO.read(inputStream)).getImage()
						.getScaledInstance(100, 80, Image.SCALE_SMOOTH)));
				JLabel Name = new JLabel("이름 : " + src.getString(2));
				Name.setFont(new Font("굴림", Font.PLAIN, 15));
				JLabel Phone = new JLabel("전화번호 : " + src.getString(1));
				Phone.setFont(new Font("굴림", Font.PLAIN, 15));
				JPanel label2 = new JPanel();
				JButton tempButton = new JButton("상세정보");
				tempButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							ResultSet tempsrc = dbConn.executeQurey("select * from USER where USER_PHONE like \""
									+ Phone.getText().replaceAll("[^0-9]", "") + "\";");
							tempsrc.next();
							InputStream inputStream = tempsrc.getBinaryStream(6);
							textField.setText(tempsrc.getString(2));
							textField_1.setText(tempsrc.getString(3));
							textField_3.setText(tempsrc.getString(5));
							textField_4.setText(tempsrc.getString(1));
							if (tempsrc.getInt(4) == 1) {
								rdbtnNewRadioButton.setSelected(true);
							} else {
								rdbtnNewRadioButton_1.setSelected(true);
							}
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
				label2.add(Name);
				label2.add(Phone);
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
