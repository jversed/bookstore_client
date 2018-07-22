<%-- Связывание со страницей ошибок --%>
<%@page errorPage="errorPage.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Iterator"%>
<%@page import= "java.rmi.Naming"%>
<%@page import= "java.rmi.NotBoundException"%>
<%@page import= "jBookStore.BookStore" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%
	// Проверка наличия атрибута user в текущей сессии
	if (session.getAttribute("user") == null) {
		// если атрибут отсутствует, выброс исключения,
		// которое перенаправляется странице ошибок
		throw new Exception("Ошибка аутентификации: неверное имя пользователя/пароль");
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Книжный магазин</title>
</head>
<body>
	<p>
		<b> 
			<%
			/*String url = "//localhost:123/store";
			try {
				BookStore bs1 = (BookStore) Naming.lookup(url);
			} catch (NotBoundException e) {
				e.printStackTrace();
			}*/
			
 			HashMap booksBasket = (HashMap) session.getAttribute("booksBasket");
 			// Получаем параметры запроса
 			String bookId = request.getParameter("bookId");
 			String bookPriceStr = request.getParameter("bookPrice");
 			Integer bookPrice = bookPriceStr == null ? null : new Integer(bookPriceStr);
 			// Если параметры не пустые
 			// (т.е. произошло добавление товара в корзину)
 			if (bookId != null && bookPrice != null) {
 			/* помещаем значения в корзину, ключом элемента HashMap является код книги,
 			значением - цена книги таким образом предполагается, что
 			каждая книга может быть добавлена только один раз*/
 			booksBasket.put(bookId, bookPrice);
 		}
 	if (booksBasket.size() == 0) {
 		out.print("Ваша корзина пуста");
 	} 
 		else 
 		{
 		int sum = 0;
 		// если корзина не пуста, перечисляем значения HashMap
 		// которые содержат цену книг и вычислем сумму
 		Iterator iterator = booksBasket.values().iterator();
 		while (iterator.hasNext()) {
 			Integer price = (Integer) iterator.next();
 			sum += price.intValue();
 		}
 		// отображаем количество и суммарную
 		// стоимость товаров в корзине
 		out.print("Количество товаров в корзине: " + booksBasket.size());
 		out.print("<br>");
 		out.print("На сумму: " + sum);
 	}
 	%>
		</b>
	</p>
	
	<!-- Подключение библиотеки тегов -->
	<%@ taglib uri="/WEB-INF/BookTagLib.tld" prefix="x"%>

	<!-- Отображение списка книг -->
	<!-- создаем таблицу -->
	<table border=1>
		<tr>
			<td>Код товара</td>
			<td>Название</td>
			<td>Автор</td>
			<td>Цена</td>
		</tr>
		<!--
Используем клиентский тег для создания строки таблицы. При создании экземпляра тега
указываем значения параметров тега. Параметр pageURL указывает на эту же страницу
		-->
		<x:BookTagHandler pageURL="bookStore.jsp" bookId="001"
			name="Thinking in Java" author="Bruce Eckel" price="400" />
		<x:BookTagHandler pageURL="bookStore.jsp" bookId="002"
			name="Bitter Java" author="Bruce Tate" price="300" />
		<x:BookTagHandler pageURL="bookStore.jsp" bookId="003"
			name="Object-Oriented Design Patterns" author="Erich Gamma et al."
			price="500" />
	</table>
</body>
</html>
