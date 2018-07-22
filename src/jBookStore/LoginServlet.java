package jBookStore;

import java.io.*;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");

		// ѕолучаем параметры авторизации
		String username = request.getParameter("user");
		String password = request.getParameter("password");

		// ѕровер€ем им€ пользовател€ и пароль
		if (username.equals("user") && password.equals("1234")) {
			// если логин и пароль верны,
			// получаем ссылку на текущую сессию
			HttpSession session = request.getSession(true);
			// и устанавливаем атрибут user
			session.setAttribute("user", username);
			// также создаем новую корзину товаров
			session.setAttribute("booksBasket", new HashMap());
		}
		// перенаправл€ем запрос на страницу выбора товаров
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/bookStore.jsp");
		dispatcher.forward(request, response);
		
		
		
	}
}