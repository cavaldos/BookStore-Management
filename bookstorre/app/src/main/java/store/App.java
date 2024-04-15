
package store;

import java.sql.SQLException;

import com.toedter.calendar.JCalendar;

import store.view.MainUI;
import store.view.NewJFrame;
import store.view.admin.MainAdmin;
import store.view.employee.MainEmployee;
import store.view.component.CalendarComponent;
public class App {

    public static void main(String args[]) throws SQLException, ClassNotFoundException {
        Run run = Run.getInstance();
        run.run();
        startAutoLogout(3660000); // 60000ms = 1 phút
        
        // MainEmployee MainEmployee = new MainEmployee();
        // MainEmployee.setVisible(true);


        // NewJFrame newJFrame = new NewJFrame();
        // newJFrame.setVisible(true);


    }

    private static void startAutoLogout(int timeoutMs) {
        Run run2 = Run.getInstance();
        Thread autoLogoutThread = new Thread(() -> {
            try {
                Thread.sleep(timeoutMs);
                run2.getInstance().logout();
                System.out.println("Tự động đăng xuất sau 1 phút");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        autoLogoutThread.start();
    }

}
