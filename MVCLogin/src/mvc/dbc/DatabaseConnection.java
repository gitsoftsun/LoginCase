package mvc.dbc;

import java.sql.*;

public class DatabaseConnection {
	private static final String DBdriver = "org.gjt.mm.mysql.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/51ctomvctest";
	private static final String DBUSER = "root";
	private static final String DBPASS = "";
	private Connection conn = null;

	public DatabaseConnection() throws Exception { // 在构造方法中进行数据库连接
		try {
			Class.forName(DBdriver);// 加载驱动程序
			this.conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);// 连接数据库
		} catch (Exception e) {
			throw e;
		}
	}

	public Connection getConnection() {// 取得数据库连接
		return this.conn;// 取得数据连接
	}

	public void close() throws Exception {// 关闭数据库操作
		if (this.conn != null) {// 避免NullPointerException
			try {
				this.conn.close();// 关闭数据库
			} catch (Exception e) {
				throw e;
			}
		}
	}
}
