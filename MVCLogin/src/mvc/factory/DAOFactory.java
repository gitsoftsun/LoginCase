package mvc.factory;

import mvc.dao.*;

public class DAOFactory {
	public static IUserDAO getIUserDAOInstance() {// 取得DAO实例
		return new UserDAOProxy();// 返回代理实例
	}
}