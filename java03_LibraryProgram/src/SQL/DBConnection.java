package SQL;

import java.sql.*;

 
public class DBConnection {
	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; //����̹�
	private final String DB_URL = "jdbc:mysql://jdb.deu.monster:60001"; //������ DB ����
	private final String USER_NAME = "20203025"; //DB�� ������ ����� �̸��� ����� ����
	private final String PASSWORD = "!!!!20203025"; //������� ��й�ȣ�� ����� ����

    
    
	//������
	public DBConnection(){ 
	    Connection conn = null; 
		Statement state = null; 
	    try{
				Class.forName(JDBC_DRIVER);
				conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
				state = conn.createStatement();
				//String sql; //SQL���� ������ String
				//sql = "SELECT * FROM student";
				
		           StringBuilder sb = new StringBuilder();
		            String sql = sb.append("create table DB_BOOK2(")    //if not exists = �������� ���� ���� ����
		                    .append("BOOK_IMAGE LONGBLOB DEFAULT NULL,")
		                    .append("BOOK_TITLE VARCHAR(100) NOT NULL,")
		                    .append("BOOK_AUTHOR VARCHAR(30) NOT NULL,")
		                    .append("BOOK_PRICE INT DEFAULT NULL,")
		                    .append("BOOK_LINK VARCHAR(255) DEFAULT NULL,/*��ũ*/BOOK_ISBN CHAR(13) primary KEY,")
		                    .append("BOOK_DESCRIPTION TEXT DEFAULT NULL,")
		                    .append("RENT_MEMBER int null,")
		                    .append("RENT_RETURNDATE date null")
		                    .append(");").toString(); 



				
				ResultSet rs = state.executeQuery(sql); //SQL���� �����Ͽ� ����
				state.execute(sql);

					
					rs.close();
					state.close();
					conn.close();
				}
	    catch(Exception e){
						//���� �߻� �� ó���κ�
				}
	    finally { //���ܰ� �ֵ� ���� ������ ����
					try{
						if(state!=null)
							state.close();
					}catch(SQLException ex1){
						//
					}
							
					try{
						if(conn!=null)
							conn.close();
					}catch(SQLException ex1){
						//
					}
				}
	    
    }
}

