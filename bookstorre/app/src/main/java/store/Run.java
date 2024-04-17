package store;

import store.view.admin.MainAdmin;
import store.view.employee.Main_Employee;
import store.view.MainUI;
import store.utils.UserSession;

public class Run {
    private static Run instance = null;

    private MainUI mainUI;
    private MainAdmin mainAdmin;
    private Main_Employee mainEmployee;
    private UserSession userSession;

    private Run() {
        this.userSession = UserSession.getInstance();
    }

    public static Run getInstance() {
        if (instance == null) {
            instance = new Run();
        }
        return instance;
    }

    public void initializeUI() {
        disposeWindows(); // Giải phóng tài nguyên của các cửa sổ hiện tại
        this.mainUI = new MainUI(); // Luôn tạo mới MainUI khi khởi tạo lại giao diện người dùng
        this.mainUI.setVisible(true);
    }

    public void initializeAdmin() {
        disposeWindows(); // Giải phóng tài nguyên của các cửa sổ hiện tại
        this.mainAdmin = new MainAdmin(); // Luôn tạo mới MainAdmin khi người dùng là admin
        this.mainAdmin.setVisible(true);
    }

    public void initializeEmployee() {
        disposeWindows(); // Giải phóng tài nguyên của các cửa sổ hiện tại
        this.mainEmployee = new Main_Employee(); // Luôn tạo mới MainEmployee khi người dùng là nhân viên
        this.mainEmployee.setVisible(true);
    }

    private void disposeWindows() {
        if (mainUI != null) {
            mainUI.dispose();
            mainUI = null;
        }
        if (mainAdmin != null) {
            mainAdmin.dispose();
            mainAdmin = null;
        }
        if (mainEmployee != null) {
            mainEmployee.dispose();
            mainEmployee = null;
        }
    }

    public void logout() {
        this.userSession.logout();
        initializeUI(); // Khởi tạo lại giao diện đăng nhập
    }

    public void run() {
        if (this.userSession.checkLogin()) {
            if (this.userSession.getRole().equals("admin")) {
                initializeAdmin();
            } else {
                initializeEmployee();
            }
        } else {
            initializeUI();
        }
    }
}
