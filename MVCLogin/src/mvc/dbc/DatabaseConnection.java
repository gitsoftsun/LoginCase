package mvc.dbc;

import java.sql.*;

public class DatabaseConnection {
	private static final String DBdriver = "org.gjt.mm.mysql.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/51ctomvctest";
	private static final String DBUSER = "root";
	private static final String DBPASS = "";
	private Connection conn = null;

	public DatabaseConnection() throws Exception { // �ڹ��췽���н������ݿ�����
		try {
			Class.forName(DBdriver);// ������������
			this.conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);// �������ݿ�
		} catch (Exception e) {
			throw e;
		}
	}

	public Connection getConnection() {// ȡ�����ݿ�����
		return this.conn;// ȡ����������
	}

	public void close() throws Exception {// �ر����ݿ����
		if (this.conn != null) {// ����NullPointerException
			try {
				this.conn.close();// �ر����ݿ�
			} catch (Exception e) {
				throw e;
			}
		}
	}
}
