/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package store.view.admin.ui.form;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import store.utils.DatabaseUtils;
import store.Model.Book;
import store.helper.BookHelper;

/**
 *
 * @author TCCom
 */
public class FormHome extends javax.swing.JPanel {

        BookHelper helper = new BookHelper();
        Book newBook1 = helper.newBook1();
        Book newBook2 = helper.newBook2();
        Book newBook3 = helper.newBook3();

        // public FormHome() {
        // initComponents();
        // card1.setData(newBook1);
        // card2.setData(newBook2);
        // card3.setData(newBook3);
        // // try {
        // // Connection connection = DatabaseUtils.connect();
        // // Book hotBook1 = helper.hotBook1(connection);
        // // Book hotBook2 = helper.hotBook2(connection);
        // // Book hotBook3 = helper.hotBook3(connection);

        // // card4.setData(hotBook1);
        // // card5.setData(hotBook2);
        // // card6.setData(hotBook3);
        // // } catch (ClassNotFoundException | SQLException e) {
        // // e.printStackTrace();
        // // }
        // card4.setData(new Book("Data Structures and Algorithms", "Cormen,
        // Leiserson,Rivest, Stein", 400000.00));
        // card5.setData(new Book("Introduction to Java Programming", "Y. Daniel Liang",
        // 300000.00));
        // card6.setData(new Book("Deep Learning", "Ian Goodfellow, Yoshua Bengio,
        // AaronCourville", 450000.00));
        // }

        public FormHome() {
                initComponents();
                card1.setData(newBook1);
                card2.setData(newBook2);
                card3.setData(newBook3);
                String query1 = "SELECT b.title AS title, a.name AS author, b.price AS price " +
                                "FROM book b " +
                                "JOIN author a ON b.authorID = a.authorID " +
                                "JOIN ( " +
                                "    SELECT bookID, SUM(quantity) AS total_sold " +
                                "    FROM order_detail " +
                                "    GROUP BY bookID " +
                                "    ORDER BY total_sold DESC " +
                                "    LIMIT 1 " +
                                ") AS top_book ON b.bookID = top_book.bookID;";
                card4.setData(fetchTopBookRevenue(query1));
                String query2 = "SELECT b.title AS title, a.name AS author, b.price AS price " +
                                "FROM book b " +
                                "JOIN author a ON b.authorID = a.authorID " +
                                "JOIN ( " +
                                "    SELECT bookID, SUM(quantity) AS total_sold " +
                                "    FROM order_detail " +
                                "    GROUP BY bookID " +
                                "    ORDER BY total_sold DESC " +
                                "    LIMIT 1 OFFSET 1 " +
                                ") AS second_book ON b.bookID = second_book.bookID;";

                card5.setData(fetchTopBookRevenue(query2));
                String query3 = "SELECT b.title AS title, a.name AS author, b.price AS price " +
                                "FROM book b " +
                                "JOIN author a ON b.authorID = a.authorID " +
                                "JOIN ( " +
                                "    SELECT bookID, SUM(quantity) AS total_sold " +
                                "    FROM order_detail " +
                                "    GROUP BY bookID " +
                                "    ORDER BY total_sold DESC " +
                                "    LIMIT 1 OFFSET 2 " +
                                ") AS third_book ON b.bookID = third_book.bookID;";

                card6.setData(fetchTopBookRevenue(query3));
        }

        private Book fetchTopBookRevenue(String query) {
                Book book = null;
                try (Connection connection = DatabaseUtils.connect();
                                PreparedStatement pst = connection.prepareStatement(query);
                                ResultSet rs = pst.executeQuery()) {

                        if (rs.next()) {
                                book = new Book(rs.getString("title"),
                                                rs.getString("author"),
                                                rs.getDouble("price"));
                        }
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return book;
        }

        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jLabel1 = new javax.swing.JLabel();
                jLayeredPane1 = new javax.swing.JLayeredPane();
                card1 = new store.view.employee.ui.component.Card();
                card2 = new store.view.employee.ui.component.Card();
                card3 = new store.view.employee.ui.component.Card();
                jLabel2 = new javax.swing.JLabel();
                jLayeredPane2 = new javax.swing.JLayeredPane();
                card4 = new store.view.employee.ui.component.Card();
                card5 = new store.view.employee.ui.component.Card();
                card6 = new store.view.employee.ui.component.Card();

                setBackground(new java.awt.Color(255, 255, 255));
                setPreferredSize(new java.awt.Dimension(883, 457));

                jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
                jLabel1.setText("New Books");

                jLayeredPane1.setLayout(new java.awt.GridLayout(1, 0, 10, 0));
                jLayeredPane1.add(card1);
                jLayeredPane1.add(card2);
                jLayeredPane1.add(card3);

                jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
                jLabel2.setText("Hot Books");

                jLayeredPane2.setLayout(new java.awt.GridLayout(1, 0, 10, 0));
                jLayeredPane2.add(card4);
                jLayeredPane2.add(card5);
                jLayeredPane2.add(card6);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(26, 26, 26)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                false)
                                                                                .addComponent(jLabel2)
                                                                                .addComponent(jLabel1)
                                                                                .addComponent(jLayeredPane1,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                875,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(jLayeredPane2))
                                                                .addContainerGap(25, Short.MAX_VALUE)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(17, 17, 17)
                                                                .addComponent(jLabel1)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLayeredPane1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                184,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(35, 35, 35)
                                                                .addComponent(jLabel2)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLayeredPane2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                184,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(21, Short.MAX_VALUE)));
        }// </editor-fold>//GEN-END:initComponents

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private store.view.employee.ui.component.Card card1;
        private store.view.employee.ui.component.Card card2;
        private store.view.employee.ui.component.Card card3;
        private store.view.employee.ui.component.Card card4;
        private store.view.employee.ui.component.Card card5;
        private store.view.employee.ui.component.Card card6;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLayeredPane jLayeredPane1;
        private javax.swing.JLayeredPane jLayeredPane2;
        // End of variables declaration//GEN-END:variables
}
