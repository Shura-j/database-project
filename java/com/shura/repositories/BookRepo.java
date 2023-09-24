package com.shura.repositories;

import java.sql.*;
import com.shura.domain.*;
import java.util.*;

public class BookRepo {
	
	private Connection Database;
	
	public BookRepo() throws ClassNotFoundException, SQLException {
		this.Database = new Database().getConnection();
	}
	
	public Boolean addBook(Book new_book) throws SQLException {
		
		String query = "insert into booklist (Author, Bname, Btype, Bprice, a_quantity, user_id, description) values (?,?,?,?,?,?,?)";
		PreparedStatement pst = this.Database.prepareStatement(query);
		pst.setString(1, new_book.Author);
		pst.setString(2, new_book.Name);
		pst.setString(3, new_book.BookType);
		pst.setDouble(4, new_book.Price);
		pst.setInt(5, new_book.Quantity);
		pst.setInt(6, new_book.UserId);
		pst.setString(7, new_book.Description);
		
		return pst.executeUpdate() > 0;

	}

	public ArrayList<Book> getBooks(String name, String Author, String type) throws SQLException {
		
		String query = "select * from booklist ";
		ArrayList<Book> books = new ArrayList<Book>();
		
		if(!name.equals("")) {
			query += "where Bname = '" + name +"'";
		}
		
		if(!Author.equals("")) {
			query += ((name.equals("") ? "where " : " or ") + "Author = '" + Author +"'");
		}
		
		if(!type.equals("")) {
			query += (((name.equals("") && Author.equals("")) ? "where " : ", ") + "Btype = '" + type +"'");
		}
		
		PreparedStatement pst = this.Database.prepareStatement(query);

		ResultSet rs = pst.executeQuery();

		while(rs.next()) {

			Book found_book = new Book();
			found_book.Id = rs.getInt("id");
			found_book.Name = rs.getString("Bname");
			found_book.Author= rs.getString("Author");
			found_book.Price = rs.getDouble("Bprice");
			found_book.BookType = rs.getString("Btype");
			found_book.Quantity = rs.getInt("a_quantity");
			found_book.UserId = rs.getInt("user_id");
			found_book.Description = rs.getString("description");
			books.add(found_book);

		}

		return books;

	}
	
	public ArrayList<Book> getByUser(int user_id) throws SQLException {
		
		String query = "select * from booklist where user_id = ?";
		ArrayList<Book> books = new ArrayList<Book>();
		
		PreparedStatement pst = this.Database.prepareStatement(query);
		pst.setInt(1, user_id);
		
		ResultSet rs = pst.executeQuery();

		while(rs.next()) {
			
			Book found_book = new Book();
			found_book.Id = rs.getInt("id");
			found_book.Name = rs.getString("Bname");
			found_book.Author= rs.getString("Author");
			found_book.Price = rs.getDouble("Bprice");
			found_book.BookType = rs.getString("Btype");
			found_book.Quantity = rs.getInt("a_quantity");
			found_book.UserId = rs.getInt("user_id");
			found_book.Description = rs.getString("description");
			books.add(found_book);
			
		}

		return books;

	}
	
	public Book getBook(int id) throws SQLException, Exception {
		
		String query = "select * from booklist where id = ?";
		PreparedStatement pst = this.Database.prepareStatement(query);
		pst.setInt(1, id);

		ResultSet rs = pst.executeQuery();

		if(!rs.next()) {
			throw new Exception("Book not found!");
		}
		
		Book found_book = new Book();
		found_book.Id = rs.getInt("id");
		found_book.Name = rs.getString("Bname");
		found_book.Author= rs.getString("Author");
		found_book.Price = rs.getDouble("Bprice");
		found_book.BookType = rs.getString("Btype");
		found_book.Quantity = rs.getInt("a_quantity");
		found_book.UserId = rs.getInt("user_id");
		found_book.Description = rs.getString("description");

		return found_book;
		
	}
	
}
