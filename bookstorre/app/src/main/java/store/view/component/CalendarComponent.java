
package store.view.component;

import com.toedter.calendar.JDateChooser;
import javax.swing.JFrame;
import java.util.Date;

public class CalendarComponent extends JFrame {
    private JDateChooser dateChooser; // Lưu trữ tham chiếu của JDateChooser
    public CalendarComponent() {
        super("JCalendar Operations"); // Gọi constructor của lớp cha để thiết lập tiêu đề
        initializeUI();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    private void initializeUI() {
        setSize(300, 300); // Thiết lập kích thước cho JFrame
        setLayout(null); // Sử dụng layout manager là null để có thể đặt vị trí các thành phần tự do

        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setBounds(50, 50, 200, 30); // Thiết lập vị trí và kích thước của JDateChooser
        add(dateChooser); // Thêm JDateChooser vào JFrame

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Thiết lập hành động khi đóng cửa sổ
        setVisible(true); // Làm cho JFrame hiển thị
    }

    public Date getSelectedDate() {
        return dateChooser.getDate();
    }
    // public static void main(String[] args) {
    // new CalendarComponent(); // Tạo và hiển thị JFrame bằng cách tạo thể hiện của
    // CalendarComponent
    // }
}
