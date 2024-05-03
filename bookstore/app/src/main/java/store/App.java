
package store;

import java.sql.SQLException;

import com.toedter.calendar.JCalendar;

import store.view.MainUI;

import store.view.admin.MainAdmin;
import store.view.employee.Main_Employee;
import store.view.component.CalendarComponent;

public class App {
    public static void main(String args[]) throws SQLException, ClassNotFoundException {
        Run run = Run.getInstance();
        run.run();
    }

}
