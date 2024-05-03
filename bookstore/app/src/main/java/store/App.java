
package store;

import java.sql.SQLException;

import com.toedter.calendar.JCalendar;

import store.view.MainUI;
import store.view.NewJFrame;
import store.view.admin.MainAdmin;
import store.view.employee.Main_Employee;
import store.view.component.CalendarComponent;

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