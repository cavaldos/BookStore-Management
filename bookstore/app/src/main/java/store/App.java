
package store;

import java.sql.SQLException;


public class App {
    public static void main(String args[]) throws SQLException, ClassNotFoundException {
        Run run = Run.getInstance();
        run.run();
    }

}
