package mvc.dao;

import mvc.vo.User;

public interface IUserDAO {
	/**
	 * �û���¼��֤
	 * 
	 * @param user
	 *            ����VO����
	 * @param ��֤�Ĳ������
	 * @throw Exception
	 */
	public boolean findLogin(User user) throws Exception;
}
