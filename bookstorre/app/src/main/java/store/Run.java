
package store;

import java.sql.SQLException;


import store.view.admin.MainAdmin;
import store.view.employee.MainEmployee;
import store.view.MainUI;

public class Run {

    public static void main(String args[]) throws SQLException, ClassNotFoundException {
        // MainAdmin mainUI = new MainAdmin();
        // mainUI.setVisible(true);
        // MainEmployee mainUIss = new MainEmployee();
        // mainUIss.setVisible(true);

        MainUI mainUI = new MainUI();
        mainUI.setVisible(true);
    }

}

