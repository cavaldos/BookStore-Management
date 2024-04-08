
package store;

import javax.swing.*;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

import java.awt.*;
import java.awt.print.Book;

import store.view.*;
import store.Service.BookService;
import store.view.component.*;

import java.sql.SQLException;
import java.util.List;
import store.view.*;


// import order DAO

public class App {

    public static void main(String args[]) throws SQLException, ClassNotFoundException {
        MainUI mainUI = new MainUI();
        mainUI.setVisible(true);



    }

}

// MainUI mainUI = new MainUI();

// mainUI.setVisible(true);

// try
// {
// // Initialize BookService
// BookService bookService = new BookService();

// // Retrieve all books using BookService
// List<store.Model.Book> allBooks = bookService.getAllBooks();

// // Display the books (Example: Print to console)
// for (store.Model.Book book : allBooks) {
// System.err.println("afasdf");
// System.out.println(book);
// }
// }catch(
// SQLException e)
// {
// e.printStackTrace();
// System.out.println("Error retrieving books from database.");
// }

// System.out.println("Hello World");
// for (javax.swing.UIManager.LookAndFeelInfo info :
// javax.swing.UIManager.getInstalledLookAndFeels()) {
// if ("Nimbus".equals(info.getName())) {
// javax.swing.UIManager.setLookAndFeel(info.getClassName());
// break;
// }
// }