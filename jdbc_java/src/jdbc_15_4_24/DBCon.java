package jdbc_15_4_24;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCon {
	static Connection con;
	static Statement sql;
	static ResultSet res;

	public static Connection getCon() {// �������ݿ�ĺ�����
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL���ݿ�����
		String connectDB = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Blog";// ����Դ
		 String user="sa";  
		    String password="888018";

		try {
			Class.forName(JDriver);// �������ݿ����棬���ظ����ַ���������
			con=DriverManager.getConnection(connectDB,user,password);//��½
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("�������ݿ�����ʧ��");
			System.exit(0);
		}
		System.out.println("���ݿ������ɹ�");
		return con;
	}

	public static void closeAllMethod(Connection con, Statement stmt,
			ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			// TODO �Զ����� catch ��
			e.printStackTrace();
		}
	}
}
