package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import POJO.Book;

public class BookDAO {

	public Connection getConnection() {
		Connection c = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "SYSTEM", "root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	public int addBook(Book b) {
		Connection c = getConnection();
		PreparedStatement pstmt = null;
		int inserted = 0;
		try {
			pstmt = c.prepareStatement("insert into books(id,name,price,author) values(?,?,?,?)");
			pstmt.setInt(1, b.getId());
			pstmt.setString(2, b.getName());
			pstmt.setDouble(3, b.getPrice());
			pstmt.setString(4, b.getAuthor());
			inserted = pstmt.executeUpdate();
		} catch (SQLException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				c.close();
			} catch (SQLException e) {
// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return inserted;
	}

	public int deleteBook(int id) {
		Connection c = getConnection();
		PreparedStatement pstmt = null;
		int deleted = 0;
		try {
			pstmt = c.prepareStatement("delete from books where id=?");
			pstmt.setInt(1, id);

			deleted = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return deleted;
	}

	public int updateBook(int id, double price) throws SQLException {
		Connection c = getConnection();
		PreparedStatement ps = null;
		int update = 0;
		ps = c.prepareStatement("update books set price=? where id=?");
		ps.setInt(2, id);
		ps.setDouble(1, price);
		update = ps.executeUpdate();
		ps.close();
		return update;
	}

}