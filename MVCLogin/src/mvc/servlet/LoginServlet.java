//����Servlet����Servlet��Ҫ���ܿͻ��˷������������� 
//ͬʱҪ����DAO������Ҫ����DAO�Ľ��������Ӧ����Ϣ 
//��Servlet�У����ȶ���Խ��ܵ�userid��userpass��������������֤�����û���������//����������Ĳ���Ϊ�գ������info������������Ӧ�Ĵ�����Ϣ�� 
//����֤ͨ���󣬳��򽫵���DAO�������ݲ����֤��������DAO�ķ��ؽ������������//���ͻ��˵���Ϣ 
package mvc.servlet;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import mvc.factory.*;
import mvc.vo.*;

public class LoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String path = "index.jsp";
		String userid = req.getParameter("userid");// ����userid����
		String userpass = req.getParameter("userpass");// ����password����
		List<String> info = new ArrayList<String>();// �������з�����Ϣ
		if (userid == null || "".equals(userid)) {
			info.add("��ôid����Ϊ�գ�");
		}
		if (userpass == null || "".equals(userpass)) {
			info.add("���벻��Ϊ�գ�");
		}
		if (info.size() == 0) {// �û�����������֤ͨ��
			User user = new User();// ʵ����VO
			user.setUserid(userid);// ����userid
			user.setPassword(userpass);// ����password
			try {
				if (DAOFactory.getIUserDAOInstance().findLogin(user)) {// ��֤ͨ��
					info.add("�û���¼�ɹ�����ӭ" + user.getName() + "���٣�");
				} else {
					info.add("�û���¼ʧ�ܣ�������û��������룡");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		req.setAttribute("info", info);// ���������Ϣ
		req.getRequestDispatcher(path).forward(req, resp);// ��ת
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);// ����doGet()����
	}
}