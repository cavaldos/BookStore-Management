package com.raven.form;

import chart.raven.chart.ModelChart;
import com.raven.data.DatabaseConnection;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.raven.data.ModelData;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicReference;
import javax.swing.JComboBox;

/**
 *
 * @author RAVEN
 */
public class Revenue_statistics extends javax.swing.JFrame {
private String previousBookSelection;
private String previousCategorySelection;
private String previousCustomerSelection;
private String previousEmployeeSelection;

    /**
     * Creates new form Test
     */
      public Revenue_statistics() {
        initComponents();
        // Clear existing items
        clearComboBoxes();
        // Load new items into each ComboBox
       
     
        DateBox.addItem("Month");
         DateBox.addItem("Week");
          DateBox.addItem("Day");
        // Setup chart
        setupChart();
     

        // Any additional setup
        test();
    }

    private void clearComboBoxes() {
        BookBox.removeAllItems();
        CategoryBox.removeAllItems();
        CustomerBox.removeAllItems();
        EmployeesBox.removeAllItems();
        DateBox.removeAllItems();
    }

   private void loadAndInitializeComboBox(String query, JComboBox<String> comboBox, String columnName, Color color1, Color color2) {
    try {
        PreparedStatement pst = DatabaseConnection.getInstance().getConnection().prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        boolean isFirst = true;
        String firstItem = null;

        while (rs.next()) {
            String name = rs.getString(columnName);
            comboBox.addItem(name);
            if (isFirst) {
                firstItem = name;
                isFirst = false;
            }
        }
        
        if (firstItem != null) {
            comboBox.setSelectedItem(firstItem);
            chart.addLegend(firstItem, firstItem, color1, color2); // Gửi giá trị ban đầu lên biểu đồ
        }

        rs.close();
        pst.close();

        // Gắn ActionListener sau khi thiết lập lựa chọn đầu tiên
        addComboBoxListener(comboBox, color1, color2);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

private void addComboBoxListener(JComboBox<String> comboBox, Color color1, Color color2) {
    comboBox.addActionListener(new ActionListener() {
        private String previousSelection = (String) comboBox.getSelectedItem();

        @Override
        public void actionPerformed(ActionEvent e) {
            String currentSelection = (String) comboBox.getSelectedItem();
            if (!currentSelection.equals(previousSelection)) {
                chart.addLegend(currentSelection, previousSelection, color1, color2);
                previousSelection = currentSelection;
            }
        }
    });
}






public void initializeComboBoxes() {
    loadAndInitializeComboBox("SELECT title FROM book", BookBox, "title", Color.decode("#7b4397"), Color.decode("#dc2430"));
    loadAndInitializeComboBox("SELECT name FROM category", CategoryBox, "name", Color.decode("#7b4397"), Color.decode("#dc2430"));
    loadAndInitializeComboBox("SELECT username FROM customer", CustomerBox, "username", Color.decode("#7b4397"), Color.decode("#dc2430"));
    loadAndInitializeComboBox("SELECT username FROM account WHERE role = 'employee'", EmployeesBox, "username", Color.decode("#7b4397"), Color.decode("#dc2430"));
}




    private void setupChart() {
        
        chart.setTitle("Chart Data");
      
        initializeComboBoxes();
    }

    // Other methods...


    private void setData() {
        try {
            List<ModelData> lists = new ArrayList<>();
         
            String sql = "select DATE_FORMAT(Date,'%M') as `Month`, SUM(TotalAmount) as Amount, SUM(TotalCost) as Cost, SUM(TotalProfit) as Profit from orders group by DATE_FORMAT(Date,'%m%Y') order by Date DESC limit 7";
            PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                String month = r.getString("Month");
                double amount = r.getDouble("Amount");
                double cost = r.getDouble("Cost");
                double profit = r.getDouble("Profit");
                lists.add(new ModelData(month, amount, cost, profit));
            }
            r.close();
            p.close();
            //  Add Data to chart
            for (int i = lists.size() - 1; i >= 0; i--) {
                ModelData d = lists.get(i);
                chart.addData(new ModelChart(d.getMonth(), new double[]{d.getAmount(), d.getCost(), d.getProfit()}));
            }
            //  Start to show data with animation
            chart.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void test() {
        chart.clear();
        chart.addData(new ModelChart("January", new double[]{500, 50, 100}));
        chart.addData(new ModelChart("February", new double[]{600, 300, 150}));
        chart.addData(new ModelChart("March", new double[]{200, 50, 900}));
        chart.addData(new ModelChart("April", new double[]{480, 700, 100}));
        chart.addData(new ModelChart("May", new double[]{350, 540, 500}));
        chart.addData(new ModelChart("June", new double[]{450, 800, 100}));
        chart.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelShadow1 = new chart.raven.panel.PanelShadow();
        chart = new chart.raven.chart.CurveLineChart();
        BookBox = new javax.swing.JComboBox<>();
        CustomerBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        CategoryBox = new javax.swing.JComboBox<>();
        EmployeesBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        DateBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelShadow1.setBackground(new java.awt.Color(34, 59, 69));
        panelShadow1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelShadow1.setForeground(new java.awt.Color(255, 255, 255));
        panelShadow1.setColorGradient(new java.awt.Color(0, 51, 51));

        chart.setForeground(new java.awt.Color(237, 237, 237));
        chart.setFillColor(true);

        BookBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        CustomerBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Customer List");

        CategoryBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        EmployeesBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Book List");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Caterogy List");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Employees List");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Date");

        DateBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BookBox, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CustomerBox, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CategoryBox, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EmployeesBox, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(DateBox, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(BookBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(CategoryBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(12, 12, 12)
                        .addComponent(CustomerBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(EmployeesBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(DateBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    private javax.swing.JComboBox<String> BookBox;
    private javax.swing.JComboBox<String> CategoryBox;
    private javax.swing.JComboBox<String> CustomerBox;
    private javax.swing.JComboBox<String> DateBox;
    private javax.swing.JComboBox<String> EmployeesBox;
    private chart.raven.chart.CurveLineChart chart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private chart.raven.panel.PanelShadow panelShadow1;
    // End of variables declaration//GEN-END:variables
}
