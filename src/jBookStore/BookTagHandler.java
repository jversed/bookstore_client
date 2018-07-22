package jBookStore;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;

public class BookTagHandler extends TagSupport {
	// Поля-свойства тега
	private String pageURL;
	private String bookId;
	private String name;
	private String author;
	private int price;

	public String getPageURL() {
		return pageURL;
	}

	public void setPageURL(String pageURL) {
		this.pageURL = pageURL;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int doStartTag() throws JspException {
		try {
			// получаем поток ответа клиенту
			JspWriter out = pageContext.getOut();

			// заголовок формы
			out.print("<form action = \"" + pageURL + "\" method=post>");

			// строка таблицы
			out.print("<tr>");

			// отображаем код книги
			out.print("<td>" + bookId + "</td>");

			// создаем скрытое поле формы для
			// передачи кода книги при подтверждении формы
			out.print("<input type = hidden name=\"bookId\" " + "value=\"" + bookId + "\">");

			// отображаем название
			out.print("<td>" + name + "</td>");

			// отображаем автора
			out.print("<td>" + author + "</td>");

			// отображаем цену
			out.print("<td>" + price + "</td>");

			// создаем скрытое поле формы для
			// передачи цены книги при подтверждении формы
			out.print("<input type = hidden name=\"bookPrice\" " + "value=\"" + price + "\">");

			// кнопка submit
			out.print("<td><input type=submit " + "value=\"Добавить в корзину\"></td>");

			// закрываем теги
			out.print("</tr>");
			out.print("</form>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
}
