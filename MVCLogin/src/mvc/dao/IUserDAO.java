package mvc.dao;

import mvc.vo.User;

public interface IUserDAO {
	/**
	 * 用户登录验证
	 * 
	 * @param user
	 *            传入VO对象
	 * @param 验证的操作结果
	 * @throw Exception
	 */
	public boolean findLogin(User user) throws Exception;
}
