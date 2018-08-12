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

	public static Connection getCon() {// 加载数据库的函数；
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL数据库引擎
		String connectDB = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Blog";// 数据源
		 String user="sa";  
		    String password="888018";

		try {
			Class.forName(JDriver);// 加载数据库引擎，返回给定字符串名的类
			con=DriverManager.getConnection(connectDB,user,password);//登陆
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("加载数据库引擎失败");
			System.exit(0);
		}
		System.out.println("数据库驱动成功");
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
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
	}
}
