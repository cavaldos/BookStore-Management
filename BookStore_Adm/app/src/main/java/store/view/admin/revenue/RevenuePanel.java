/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package store.view.admin.revenue;

import chart.chartComponent.ModelChart;
import store.view.admin.chart.dataCateModel.ModelCategoryData;
import store.utils.DatabaseUtils;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RevenuePanel extends javax.swing.JPanel {

    List<ModelCategoryData> ListCateDate = new ArrayList<>();
    List<ModelCategoryData> ListCateWeek = new ArrayList<>();
    List<ModelCategoryData> ListCateMonth = new ArrayList<>();
    List<String> dateTimeList = new ArrayList<>();
    List<Double> dateBookList = new ArrayList<>();
    List<Double> dateCustomerList = new ArrayList<>();
    List<Double> dateEmployeeList = new ArrayList<>();
    List<String> weekTimeList = new ArrayList<>();
    List<Double> weekBookList = new ArrayList<>();
    List<Double> weekCustomerList = new ArrayList<>();
    List<Double> weekEmployeeList = new ArrayList<>();
    List<String> monthTimeList = new ArrayList<>();
    List<Double> monthBookList = new ArrayList<>();
    List<Double> monthCustomerList = new ArrayList<>();
    List<Double> monthEmployeeList = new ArrayList<>();
    public RevenuePanel() {
     initComponents();
        DateBox.removeAllItems();
        DateBox.addItem("Month");
        DateBox.addItem("Week");
        DateBox.addItem("Day");
        DateBox.setSelectedItem("Day");
        fetchComboBoxCateData();
        setupChart();
        setData();
        DateBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                setData();
            }
        });
        CateBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setData();
            }
        });

    }
  private void setupChart() {

        chart.setTitle("Chart Data");
        chart.addLegend("Books", Color.decode("#7b4397"), Color.decode("#dc2430"));
        chart.addLegend("Category", Color.decode("#e65c00"), Color.decode("#F9D423"));
        chart.addLegend("Customer", Color.decode("#0099F7"), Color.decode("#F11712"));
        chart.addLegend("Employee", Color.decode("#0099F7"), Color.decode("#F11712"));

    }

    private void setData() {
        try {
            String time = (String) DateBox.getSelectedItem();
            String sql = "";
            switch (time) {
                case "Day":
                    fetchDateBookData();
                    fetchDateCategoryData();
                    fetchDateCustomerData();
                    fetchDateEmployeeData();
                    for (int i = dateTimeList.size() - 1; i >= 0; i--) {
                        String NameCate = (String) CateBox.getSelectedItem();
                        ModelCategoryData categoryData = ListCateDate.get(i);
                        if (categoryData.getNameCate().equals(NameCate)) {
                            chart.clear();
                   chart.addData(new ModelChart("test",new double[]{200,100,50,234}));
                            chart.addData(new ModelChart(dateTimeList.get(i), new double[]{dateBookList.get(i), categoryData.getRevenueCate(), dateCustomerList.get(i), dateEmployeeList.get(i)}));
                            chart.start();
                        }
                    }
                    break;
                case "Week":
                    fetchWeekBookData();
                    fetchWeekCategoryData();
                    fetchWeekCustomerData();
                    fetchWeekEmployeeData();
                    for (int i = dateTimeList.size() - 1; i >= 0; i--) {
                        String NameCate = (String) CateBox.getSelectedItem();
                        ModelCategoryData categoryData = ListCateWeek.get(i);
                        if (categoryData.getNameCate().equals(NameCate)) {
                            chart.clear();
                              chart.addData(new ModelChart("test",new double[]{200,100,50,234}));
                            chart.addData(new ModelChart(weekTimeList.get(i), new double[]{weekBookList.get(i), categoryData.getRevenueCate(), weekCustomerList.get(i), weekEmployeeList.get(i)}));
                            chart.start();
                        }
                    }
                    break;
                case "Month":
                    fetchMonthBookData();
                    fetchMonthCategoryData();
                    fetchMonthCustomerData();
                    fetchMonthEmployeeData();
                    for (int i = dateTimeList.size() - 1; i >= 0; i--) {
                        String NameCate = (String) CateBox.getSelectedItem();
                        ModelCategoryData categoryData = ListCateMonth.get(i);
                        if (categoryData.getNameCate().equals(NameCate)) {
                            chart.clear();
                             chart.addData(new ModelChart("test",new double[]{200,100,50,234}));
                            chart.addData(new ModelChart(monthTimeList.get(i), new double[]{monthBookList.get(i), categoryData.getRevenueCate(), monthCustomerList.get(i), monthEmployeeList.get(i)}));
                            chart.start();
                        }
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Invalid time period specified");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fetchComboBoxCateData() {
        String query = "SELECT name AS NameCate FROM category";
        try (PreparedStatement pst = DatabaseUtils.connect().prepareStatement(query); ResultSet rs = pst.executeQuery()) {
            CateBox.removeAllItems();
            boolean isFirst = true; // More descriptive variable name
            while (rs.next()) {
                String categoryName = rs.getString("NameCate"); // Store in a variable to avoid multiple calls
                CateBox.addItem(categoryName);
                if (isFirst) {
                    CateBox.setSelectedItem(categoryName); // Use the stored variable
                    isFirst = false;
                }
            }
        } catch (Exception e) { // Catch more specific exception
            e.printStackTrace(); // Consider logging this error or handling it differently
        }
    }

    private void fetchDateBookData() {
        String query = "SELECT date AS OrderDate, SUM(totalCost) AS Revenue FROM orders GROUP BY date ORDER BY date";

        try (PreparedStatement pst = DatabaseUtils.connect().prepareStatement(query); ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                String date = rs.getString("OrderDate");
                double revenue = rs.getDouble("Revenue");
                dateTimeList.add(date);
                dateBookList.add(revenue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fetchWeekBookData() {
        String query = "SELECT YEAR(o.date) AS Year, WEEK(o.date) AS OrderDate, SUM(o.totalCost) AS Revenue FROM orders o GROUP BY YEAR(o.date), WEEK(o.date)";

        try (PreparedStatement pst = DatabaseUtils.connect().prepareStatement(query); ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                String date = rs.getString("OrderDate");
                double revenue = rs.getDouble("Revenue");
                weekTimeList.add(date);
                weekBookList.add(revenue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fetchMonthBookData() {
        String query = "SELECT YEAR(o.date) AS Year, MONTH(o.date) AS OrderDate, SUM(o.totalCost) AS Revenue FROM orders o GROUP BY YEAR(o.date), MONTH(o.date)";

        try (PreparedStatement pst = DatabaseUtils.connect().prepareStatement(query); ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                String date = rs.getString("OrderDate");
                double revenue = rs.getDouble("Revenue");
                monthTimeList.add(date);
                monthBookList.add(revenue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fetchDateCategoryData() {
        String query = "SELECT c.name AS CategoryName, DATE(o.date) AS OrderDate, SUM(d.quantity * b.price) AS TotalRevenue FROM orders o JOIN order_detail d ON o.orderID = d.orderID JOIN book b ON d.bookID = b.bookID JOIN category c ON b.categoryID = c.categoryID GROUP BY c.name, DATE(o.date) ORDER BY OrderDate";
        try (PreparedStatement pst = DatabaseUtils.connect().prepareStatement(query); ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                ListCateDate.add(new ModelCategoryData(rs.getString("CategoryName"), rs.getDouble("TotalRevenue")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fetchWeekCategoryData() {
        String query = "SELECT c.name AS CategoryName, YEAR(o.date) AS Year, WEEK(o.date) AS Week, SUM(d.quantity * b.price) AS TotalRevenue FROM orders o JOIN order_detail d ON o.orderID = d.orderID JOIN book b ON d.bookID = b.bookID JOIN category c ON b.categoryID = c.categoryID GROUP BY c.name, YEAR(o.date), WEEK(o.date) ORDER BY Year, Week";
        try (PreparedStatement pst = DatabaseUtils.connect().prepareStatement(query); ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                ListCateWeek.add(new ModelCategoryData(rs.getString("CategoryName"), rs.getDouble("TotalRevenue")));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fetchMonthCategoryData() {
        String query = "SELECT c.name AS CategoryName, YEAR(o.date) AS Year, MONTH(o.date) AS Month, SUM(d.quantity * b.price) AS TotalRevenue FROM orders o JOIN order_detail d ON o.orderID = d.orderID JOIN book b ON d.bookID = b.bookID JOIN category c ON b.categoryID = c.categoryID GROUP BY c.name, YEAR(o.date), MONTH(o.date) ORDER BY Year, Month";
        try (PreparedStatement pst = DatabaseUtils.connect().prepareStatement(query); ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                ListCateMonth.add(new ModelCategoryData(rs.getString("CategoryName"), rs.getDouble("TotalRevenue")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fetchDateCustomerData() {
        String query = "SELECT DATE(orders.date) AS order_date, SUM(order_detail.quantity * book.price) AS Revenue FROM orders INNER JOIN order_detail ON orders.orderID = order_detail.orderID INNER JOIN book ON order_detail.bookID = book.bookID INNER JOIN customer ON orders.customerID = customer.customerID GROUP BY order_date";
        try (PreparedStatement pst = DatabaseUtils.connect().prepareStatement(query); ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                double revenue = rs.getDouble("Revenue");
                dateCustomerList.add(revenue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fetchWeekCustomerData() {
        String query = "SELECT YEARWEEK(orders.date) AS year_week, SUM(order_detail.quantity * book.price) AS Revenue FROM orders INNER JOIN order_detail ON orders.orderID = order_detail.orderID INNER JOIN book ON order_detail.bookID = book.bookID INNER JOIN customer ON orders.customerID = customer.customerID GROUP BY year_week";
        try (PreparedStatement pst = DatabaseUtils.connect().prepareStatement(query); ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                double revenue = rs.getDouble("Revenue");
                weekCustomerList.add(revenue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fetchMonthCustomerData() {
        String query = "SELECT DATE_FORMAT(orders.date, '%Y-%m') AS month, SUM(order_detail.quantity * book.price) AS Revenue FROM orders INNER JOIN order_detail ON orders.orderID = order_detail.orderID INNER JOIN book ON order_detail.bookID = book.bookID INNER JOIN customer ON orders.customerID = customer.customerID GROUP BY month";
        try (PreparedStatement pst = DatabaseUtils.connect().prepareStatement(query); ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                double revenue = rs.getDouble("Revenue");
                monthCustomerList.add(revenue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fetchDateEmployeeData() {
        String query = "SELECT DATE(orders.date) AS order_date, a.firstname AS employee_firstname, a.lastname AS employee_lastname, SUM(order_detail.quantity * book.price) AS Revenue FROM orders INNER JOIN order_detail ON orders.orderID = order_detail.orderID INNER JOIN book ON order_detail.bookID = book.bookID INNER JOIN account a ON orders.employeeID = a.userID GROUP BY order_date, a.firstname, a.lastname";
        try (PreparedStatement pst = DatabaseUtils.connect().prepareStatement(query); ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                double revenue = rs.getDouble("Revenue");
                dateEmployeeList.add(revenue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fetchWeekEmployeeData() {
        String query = "SELECT YEARWEEK(orders.date) AS year_week, a.firstname AS employee_firstname, a.lastname AS employee_lastname, SUM(order_detail.quantity * book.price) AS Revenue FROM orders INNER JOIN order_detail ON orders.orderID = order_detail.orderID INNER JOIN book ON order_detail.bookID = book.bookID INNER JOIN account a ON orders.employeeID = a.userID GROUP BY year_week, a.firstname, a.lastname";
        try (PreparedStatement pst = DatabaseUtils.connect().prepareStatement(query); ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                double revenue = rs.getDouble("Revenue");
                weekEmployeeList.add(revenue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fetchMonthEmployeeData() {
        String query = "SELECT DATE_FORMAT(orders.date, '%Y-%m') AS month, a.firstname AS employee_firstname, a.lastname AS employee_lastname, SUM(order_detail.quantity * book.price) AS Revenue FROM orders INNER JOIN order_detail ON orders.orderID = order_detail.orderID INNER JOIN book ON order_detail.bookID = book.bookID INNER JOIN account a ON orders.employeeID = a.userID GROUP BY month, a.firstname, a.lastname";
        try (PreparedStatement pst = DatabaseUtils.connect().prepareStatement(query); ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                double revenue = rs.getDouble("Revenue");
                monthEmployeeList.add(revenue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelShadow2 = new chart.panel.PanelShadow();
        chart = new chart.chartComponent.CurveLineChart();
        jLabel5 = new javax.swing.JLabel();
        DateBox = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        CateBox = new javax.swing.JComboBox<>();

        setPreferredSize(new java.awt.Dimension(1248, 650));

        panelShadow2.setBackground(new java.awt.Color(26, 45, 58));
        panelShadow2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelShadow2.setColorGradient(new java.awt.Color(26, 45, 58));

        chart.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Date");

        DateBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Category");

        CateBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout panelShadow2Layout = new javax.swing.GroupLayout(panelShadow2);
        panelShadow2.setLayout(panelShadow2Layout);
        panelShadow2Layout.setHorizontalGroup(
            panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow2Layout.createSequentialGroup()
                .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow2Layout.createSequentialGroup()
                        .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(78, 78, 78))
                    .addComponent(DateBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CateBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(chart, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        panelShadow2Layout.setVerticalGroup(
            panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(DateBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(CateBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelShadow2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 241, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(panelShadow2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CateBox;
    private javax.swing.JComboBox<String> DateBox;
    private chart.chartComponent.CurveLineChart chart;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private chart.panel.PanelShadow panelShadow2;
    // End of variables declaration//GEN-END:variables
}
