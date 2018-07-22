package jBookStore;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;

public class BookTagHandler extends TagSupport {
	// ����-�������� ����
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
			// �������� ����� ������ �������
			JspWriter out = pageContext.getOut();

			// ��������� �����
			out.print("<form action = \"" + pageURL + "\" method=post>");

			// ������ �������
			out.print("<tr>");

			// ���������� ��� �����
			out.print("<td>" + bookId + "</td>");

			// ������� ������� ���� ����� ���
			// �������� ���� ����� ��� ������������� �����
			out.print("<input type = hidden name=\"bookId\" " + "value=\"" + bookId + "\">");

			// ���������� ��������
			out.print("<td>" + name + "</td>");

			// ���������� ������
			out.print("<td>" + author + "</td>");

			// ���������� ����
			out.print("<td>" + price + "</td>");

			// ������� ������� ���� ����� ���
			// �������� ���� ����� ��� ������������� �����
			out.print("<input type = hidden name=\"bookPrice\" " + "value=\"" + price + "\">");

			// ������ submit
			out.print("<td><input type=submit " + "value=\"�������� � �������\"></td>");

			// ��������� ����
			out.print("</tr>");
			out.print("</form>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
}
