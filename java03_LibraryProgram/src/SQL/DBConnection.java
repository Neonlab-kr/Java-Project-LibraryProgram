package SQL;

import java.sql.*;

 
public class DBConnection {
	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; //드라이버
	private final String DB_URL = "jdbc:mysql://jdb.deu.monster:60001"; //접속할 DB 서버
	private final String USER_NAME = "20203025"; //DB에 접속할 사용자 이름을 상수로 정의
	private final String PASSWORD = "!!!!20203025"; //사용자의 비밀번호를 상수로 정의

    
    
	//생성자
	public DBConnection(){ 
	    Connection conn = null; 
		Statement state = null; 
	    try{
				Class.forName(JDBC_DRIVER);
				conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
				state = conn.createStatement();
				//String sql; //SQL문을 저장할 String
				//sql = "SELECT * FROM student";
				
		           StringBuilder sb = new StringBuilder();
		            String sql = sb.append("create table DB_BOOK2(")    //if not exists = 존재하지 않을 때만 생성
		                    .append("BOOK_IMAGE LONGBLOB DEFAULT NULL,")
		                    .append("BOOK_TITLE VARCHAR(100) NOT NULL,")
		                    .append("BOOK_AUTHOR VARCHAR(30) NOT NULL,")
		                    .append("BOOK_PRICE INT DEFAULT NULL,")
		                    .append("BOOK_LINK VARCHAR(255) DEFAULT NULL,/*링크*/BOOK_ISBN CHAR(13) primary KEY,")
		                    .append("BOOK_DESCRIPTION TEXT DEFAULT NULL,")
		                    .append("RENT_MEMBER int null,")
		                    .append("RENT_RETURNDATE date null")
		                    .append(");").toString(); 



				
				ResultSet rs = state.executeQuery(sql); //SQL문을 전달하여 실행
				state.execute(sql);

					
					rs.close();
					state.close();
					conn.close();
				}
	    catch(Exception e){
						//예외 발생 시 처리부분
				}
	    finally { //예외가 있든 없든 무조건 실행
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

