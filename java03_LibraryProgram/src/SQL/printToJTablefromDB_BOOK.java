package SQL;

import java.awt.*;
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
		String[] columnNames = {"ISBN","도서명","저자","출판사","가격","설명","이미지","상세링크","존재여부"};

		tableModel = new DefaultTableModel(data, columnNames);
		table = new JTable(tableModel);
		
		ArrayList<Image> tmpImg = new ArrayList<>();
		
		try {
			ResultSet src = dbConn.executeQurey("Select * from BOOK;");
			while(src.next()) {
				String liveState;
				
				if(src.getInt(9) == 1) {
					liveState = "보유";
				}else {
					liveState = "미보유";
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
	}
}
