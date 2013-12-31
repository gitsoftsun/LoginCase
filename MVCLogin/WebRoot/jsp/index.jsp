<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<html>
<head>
<title>登录页面</title>
<script language="javaScript">
	function validate(f) {
		if (!(/^\w{5,15}$/.test(f.userid.value))) {
			alert("用户ID必须是5~15位！");
			f.userid.focus();
			return false;
		}
		if (!(/^\w{5,15}$/.test(f.userpass.value))) {
			alert("密码必须是5~15位！");
			f.userid.focus();
			return false;
		}
		return true
	}
</script>
</head>
<body>
	<h2>用户登录程序</h2>
	<%
		request.setCharacterEncoding("utf-8");
	%>
	<%
		List<String> info = (List<String>) request.getAttribute("info");//取得属性 
		if (info != null) { //判断是否有内容 
			Iterator<String> iter = info.iterator();//  实例化Iterator 
			while (iter.hasNext()) {
	%>
	<h4><%=iter.next()%></h4>
	<%
		}
		}
	%>
	<form action="LoginServlet" method="post"   onSubmit="return validate(this)">
		用户ID：<input type="text" name="userid"><br>
		密&nbsp;&nbsp;码： <input type="password" name="userpass"><br>
		<input type="submit" value="登录"> <input type="reset"
			value="重置">
	</form>
</body>
</html>