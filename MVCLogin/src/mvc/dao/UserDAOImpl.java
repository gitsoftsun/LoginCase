package mvc.dao;

import java.sql.*;
import mvc.vo.User;

public class UserDAOImpl implements IUserDAO {
	private Connection conn = null;// 定义数据库连接对象
	private PreparedStatement pstmt = null;// 定义数据库连接对象

	public UserDAOImpl(Connection conn) {// 设置数据库连接
		this.conn = conn;
	}

	public boolean findLogin(User user) throws Exception {
		boolean flag = false;
		try {
			String sql = "select name from user where userid=? and password=?";
			this.pstmt = this.conn.prepareStatement(sql);// 实例化操作
			this.pstmt.setString(1, user.getUserid());// 设置id
			this.pstmt.setString(2, user.getPassword());// 设置密码
			ResultSet rs = this.pstmt.executeQuery();// 取得查询结果
			if (rs.next()) {
				user.setName(rs.getString(1));// 取得姓名
				flag = true;// 登录成功
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (this.pstmt != null) {
				try {
					this.pstmt.close();// 关闭操作
				} catch (Exception e) {
					throw e;
				}
			}
		}
		return flag;
	}
}