package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BookDAO;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		java.io.PrintWriter pw = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		BookDAO dao = new BookDAO();
		int value = dao.deleteBook(id);
		pw.println("<h1 style=color:green>book id " + value + "deleted successfully</h1>");
	}

}