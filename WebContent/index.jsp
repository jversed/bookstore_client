<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="errorPage.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;
charset=UTF-8">
<title>Книжный магазин</title>
</head>
<body>
	<form action="LoginServlet" method="post">
		Имя пользователя: <input type="text" name="user"> <br>
		Пароль: <input type="password" name="password"> <br> <input
			type="submit" value="ОК">
	</form>
</body>
</html>