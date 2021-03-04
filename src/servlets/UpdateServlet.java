package servlets;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.BookDAO;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		java.io.PrintWriter pw = response.getWriter();

		int id = Integer.parseInt(request.getParameter("id"));
		double price = Double.parseDouble(request.getParameter("price"));
		BookDAO dao = new BookDAO();
		int value = 0;
		try {
			value = dao.updateBook(id, price);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.println("<h1 style=color:green>book id " + value + " Updated successfully</h1>");

	}
}
