
package store;

import java.sql.SQLException;

import store.view.MainUI;

public class App {

    public static void main(String args[]) throws SQLException, ClassNotFoundException {
        Run run = Run.getInstance();
        run.run();
        startAutoLogout(120000); // 60000ms = 1 phút

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
