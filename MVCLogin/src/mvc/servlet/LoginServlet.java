//定义Servlet，在Servlet中要接受客户端发来的输入数据 
//同时要调用DAO，并且要根据DAO的结果返回响应的信息 
//在Servlet中，首先定义对接受的userid和userpass两个参数进行验证，如果没有输入参数//或者是输入的参数为空，则会在info对象中增加相应的错误信息。 
//当验证通过后，程序将调用DAO进行数据层的验证，并根据DAO的返回结果来决定返回//给客户端的信息 
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
		String userid = req.getParameter("userid");// 接受userid内容
		String userpass = req.getParameter("userpass");// 接受password内容
		List<String> info = new ArrayList<String>();// 保存所有返回信息
		if (userid == null || "".equals(userid)) {
			info.add("用么id不能为空！");
		}
		if (userpass == null || "".equals(userpass)) {
			info.add("密码不能为空！");
		}
		if (info.size() == 0) {// 用户名和密码验证通过
			User user = new User();// 实例化VO
			user.setUserid(userid);// 设置userid
			user.setPassword(userpass);// 设置password
			try {
				if (DAOFactory.getIUserDAOInstance().findLogin(user)) {// 验证通过
					info.add("用户登录成功，欢迎" + user.getName() + "光临！");
				} else {
					info.add("用户登录失败，错误的用户名和密码！");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		req.setAttribute("info", info);// 保存错误信息
		req.getRequestDispatcher(path).forward(req, resp);// 跳转
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);// 调用doGet()操作
	}
}