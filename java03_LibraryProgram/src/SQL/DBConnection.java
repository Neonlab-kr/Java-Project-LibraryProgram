import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class DBConnection {
    private Connection conn; //DB Ŀ�ؼ� ���� ��ü
    private static final String USERNAME = "20203025";//DBMS���� �� ���̵�
    private static final String PASSWORD = "!!!!20203025";//DBMS���� �� ��й�ȣ
    private static final String URL = "jdbc:mysql://jdb.deu.monster:60001/j20203025";//DBMS������ db��
    
    public DBConnection() {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            System.out.println("������");
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("����̹� �ε� ����");
        } catch (Exception e) {
            System.out.println("����̹� �ε� ���� ");
            try {
                conn.close();
            } catch (SQLException e1) {    }
        }
        
        
    }
}