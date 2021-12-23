package SQL;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.*;

public class printToJTablefromDB_BOOK extends JFrame {
	
	dbConnector dbConn = new dbConnector();
	
	public printToJTablefromDB_BOOK() {
		setTitle("Jtable Book");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		JTable table;
		DefaultTableModel tableModel;
		
		Object[][] data = new Object[0][9];
		String[] columnNames = {"ISBN","������","����","���ǻ�","����","����","�̹���","�󼼸�ũ","���翩��"};

		tableModel = new DefaultTableModel(data, columnNames);
		table = new JTable(tableModel);
		
		ArrayList<Image> tmpImg = new ArrayList<>();
		
		try {
			ResultSet src = dbConn.executeQurey("Select * from BOOK;");
			while(src.next()) {
				String liveState;
				
				if(src.getInt(9) == 1) {
					liveState = "����";
				}else {
					liveState = "�̺���";
				}
				
				Object[] tmp = {src.getString(1),src.getString(2),src.getString(3),src.getString(4),src.getString(5),src.getString(6),"Click",src.getString(8),liveState};
				tableModel.addRow(tmp);
				
				InputStream inputStream = src.getBinaryStream(7);
				try {
					tmpImg.add(ImageIO.read(inputStream));
				} catch(IOException e1) {
					e1.printStackTrace();
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JTable sourceTable = (JTable) e.getSource();
				DefaultTableModel sourceModel = (DefaultTableModel) sourceTable.getModel();
				
				int clickedTableRow = sourceTable.getSelectedRow();
				int clickedTableColumn = sourceTable.getSelectedColumn();
				
				if(clickedTableColumn == 6) {
					JFrame showBookImgWindows = new JFrame();
					JLabel bookImg = new JLabel((new ImageIcon(tmpImg.get(clickedTableRow))));
					showBookImgWindows.add(bookImg);
					
					showBookImgWindows.addWindowListener(new WindowAdapter() {
						
						public void windowClosing(WindowEvent e) {
							System.out.println("Closed sub windows");
							e.getWindow().dispose();
						}
					});
					showBookImgWindows.pack();
					showBookImgWindows.setLocationRelativeTo(null);
					showBookImgWindows.setVisible(true);
				}
			}
		});
	}
}
