package table.form;

import chart.chartComponent.ModelChart;
import database.data.DatabaseConnection;
import database.data.ModelCategoryData;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Revenue_statistics extends javax.swing.JFrame {
    List<ModelCategoryData> ListCateDate = new ArrayList<>();
      List<ModelCategoryData> ListCateWeek = new ArrayList<>();
        List<ModelCategoryData> ListCateMonth = new ArrayList<>();
      List<String> dateTimeList = new ArrayList<>();
        List<Double> dateBookList = new ArrayList<>();
    List<Double> dateCategoryList = new ArrayList<>();
        List<Double> dateCustomerList = new ArrayList<>();
            List<Double> dateEmployeeList = new ArrayList<>();
              List<String> weekTimeList = new ArrayList<>();
        List<Double> weekBookList = new ArrayList<>();
    List<Double> weekCategoryList = new ArrayList<>();
        List<Double> weekCustomerList = new ArrayList<>();
            List<Double> weekEmployeeList = new ArrayList<>();
              List<String> monthTimeList = new ArrayList<>();
        List<Double> monthBookList = new ArrayList<>();
    List<Double> monthCategoryList = new ArrayList<>();
        List<Double> monthCustomerList = new ArrayList<>();
            List<Double> monthEmployeeList = new ArrayList<>();
 
      public Revenue_statistics() {
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
        String sql ="";
        switch (time) {
            case "Day":
     fetchDateBookData();
     fetchDateCategoryData();
      fetchDateCustomerData();
     fetchDateEmployeeData();
       for (int i = dateTimeList.size() - 1; i >= 0; i--) {
           String NameCate = (String) CateBox.getSelectedItem();
         ModelCategoryData categoryData = ListCateDate.get(i);
          if (categoryData.getNameCate().equals(NameCate)){ 
           chart.clear();
          chart.addData(new ModelChart(dateTimeList.get(i), new double[]{dateBookList.get(i),categoryData.getRevenueCate(),dateCustomerList.get(i),dateEmployeeList.get(i)})); 
           chart.addData(new ModelChart("test",new double[]{200,100,50,234}));
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
          if (categoryData.getNameCate().equals(NameCate)){ 
           chart.clear();
          chart.addData(new ModelChart(weekTimeList.get(i), new double[]{weekBookList.get(i),categoryData.getRevenueCate(),weekCustomerList.get(i),weekEmployeeList.get(i)})); 
           chart.addData(new ModelChart("test",new double[]{200,100,100,20}));
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
          if (categoryData.getNameCate().equals(NameCate)){ 
           chart.clear();
          chart.addData(new ModelChart(monthTimeList.get(i), new double[]{monthBookList.get(i),categoryData.getRevenueCate(),monthCustomerList.get(i),monthEmployeeList.get(i)})); 
           chart.addData(new ModelChart("test",new double[]{200,100,23,54}));
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
    try (PreparedStatement pst = DatabaseConnection.getInstance().getConnection().prepareStatement(query);
         ResultSet rs = pst.executeQuery()) {
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
    
    try (PreparedStatement pst = DatabaseConnection.getInstance().getConnection().prepareStatement(query);
         ResultSet rs = pst.executeQuery()) {
        
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
    
    try (PreparedStatement pst = DatabaseConnection.getInstance().getConnection().prepareStatement(query);
         ResultSet rs = pst.executeQuery()) {
        
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
    
    try (PreparedStatement pst = DatabaseConnection.getInstance().getConnection().prepareStatement(query);
         ResultSet rs = pst.executeQuery()) {
        
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
    try (PreparedStatement pst = DatabaseConnection.getInstance().getConnection().prepareStatement(query);
         ResultSet rs = pst.executeQuery()) {
        while (rs.next()) {
           ListCateDate.add(new ModelCategoryData(rs.getString("CategoryName"),rs.getDouble("TotalRevenue")));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
private void fetchWeekCategoryData() {
    String query = "SELECT c.name AS CategoryName, YEAR(o.date) AS Year, WEEK(o.date) AS Week, SUM(d.quantity * b.price) AS TotalRevenue FROM orders o JOIN order_detail d ON o.orderID = d.orderID JOIN book b ON d.bookID = b.bookID JOIN category c ON b.categoryID = c.categoryID GROUP BY c.name, YEAR(o.date), WEEK(o.date) ORDER BY Year, Week";
    try (PreparedStatement pst = DatabaseConnection.getInstance().getConnection().prepareStatement(query);
         ResultSet rs = pst.executeQuery()) {
        while (rs.next()) {
           ListCateWeek.add(new ModelCategoryData(rs.getString("CategoryName"),rs.getDouble("TotalRevenue")));
       
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
private void fetchMonthCategoryData() {
    String query = "SELECT c.name AS CategoryName, YEAR(o.date) AS Year, MONTH(o.date) AS Month, SUM(d.quantity * b.price) AS TotalRevenue FROM orders o JOIN order_detail d ON o.orderID = d.orderID JOIN book b ON d.bookID = b.bookID JOIN category c ON b.categoryID = c.categoryID GROUP BY c.name, YEAR(o.date), MONTH(o.date) ORDER BY Year, Month";
    try (PreparedStatement pst = DatabaseConnection.getInstance().getConnection().prepareStatement(query);
         ResultSet rs = pst.executeQuery()) {
        while (rs.next()) {
           ListCateMonth.add(new ModelCategoryData(rs.getString("CategoryName"),rs.getDouble("TotalRevenue")));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
private void fetchDateCustomerData() {
    String query = "SELECT DATE(orders.date) AS order_date, SUM(order_detail.quantity * book.price) AS Revenue FROM orders INNER JOIN order_detail ON orders.orderID = order_detail.orderID INNER JOIN book ON order_detail.bookID = book.bookID INNER JOIN customer ON orders.customerID = customer.customerID GROUP BY order_date";
    try (PreparedStatement pst = DatabaseConnection.getInstance().getConnection().prepareStatement(query);
         ResultSet rs = pst.executeQuery()) {
        
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
    try (PreparedStatement pst = DatabaseConnection.getInstance().getConnection().prepareStatement(query);
         ResultSet rs = pst.executeQuery()) {
        
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
    try (PreparedStatement pst = DatabaseConnection.getInstance().getConnection().prepareStatement(query);
         ResultSet rs = pst.executeQuery()) {
        
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
    try (PreparedStatement pst = DatabaseConnection.getInstance().getConnection().prepareStatement(query);
         ResultSet rs = pst.executeQuery()) {
        
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
    try (PreparedStatement pst = DatabaseConnection.getInstance().getConnection().prepareStatement(query);
         ResultSet rs = pst.executeQuery()) {
        
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
    try (PreparedStatement pst = DatabaseConnection.getInstance().getConnection().prepareStatement(query);
         ResultSet rs = pst.executeQuery()) {
        
        while (rs.next()) {
            double revenue = rs.getDouble("Revenue");
            monthEmployeeList.add(revenue);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelShadow1 = new chart.panel.PanelShadow();
        chart = new chart.chartComponent.CurveLineChart();
        jLabel5 = new javax.swing.JLabel();
        CateBox = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        DateBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelShadow1.setBackground(new java.awt.Color(34, 59, 69));
        panelShadow1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelShadow1.setForeground(new java.awt.Color(255, 255, 255));
        panelShadow1.setColorGradient(new java.awt.Color(0, 51, 51));

        chart.setForeground(new java.awt.Color(237, 237, 237));
        chart.setFillColor(true);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Date");

        CateBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Category");

        DateBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(84, 84, 84))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createSequentialGroup()
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(DateBox, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CateBox, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(DateBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(CateBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CateBox;
    private javax.swing.JComboBox<String> DateBox;
    private chart.chartComponent.CurveLineChart chart;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private chart.panel.PanelShadow panelShadow1;
    // End of variables declaration//GEN-END:variables
}
