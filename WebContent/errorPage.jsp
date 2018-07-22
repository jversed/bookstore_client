<%-- Параметр isErrorPage обозначает, что это страница ошибок --%>
<%@ page isErrorPage="true" pageEncoding="UTF-8" session="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ошибка</title>
</head>
<body>
	<h2>
		<%-- exception содержит ссылку на возникшее исключение --%>

		<%-- Выводим тип исключительной ситуации --%>
		<%=exception.getClass().getName()%>
		:
		<%-- Выводим текст сообщения исключительной ситуации --%>
		<%=exception.getMessage()%>
	</h2>
	<%
		exception.printStackTrace();
	%>
</body>
</html>