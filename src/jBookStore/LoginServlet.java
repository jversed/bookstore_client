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

		// �������� ��������� �����������
		String username = request.getParameter("user");
		String password = request.getParameter("password");

		// ��������� ��� ������������ � ������
		if (username.equals("user") && password.equals("1234")) {
			// ���� ����� � ������ �����,
			// �������� ������ �� ������� ������
			HttpSession session = request.getSession(true);
			// � ������������� ������� user
			session.setAttribute("user", username);
			// ����� ������� ����� ������� �������
			session.setAttribute("booksBasket", new HashMap());
		}
		// �������������� ������ �� �������� ������ �������
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/bookStore.jsp");
		dispatcher.forward(request, response);
		
		
		
	}
}