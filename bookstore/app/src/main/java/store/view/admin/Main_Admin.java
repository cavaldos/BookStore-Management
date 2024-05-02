package store.view.admin;

import java.awt.Color;
import javax.swing.JComponent;
import store.view.admin.ui.event.EventMenuSelected;
import store.utils.UserSession;
import store.view.admin.ui.form.*;
import store.view.admin.revenue.*;
import store.view.admin.user.*;

// import store.utils.UserSession;

public class Main_Admin extends javax.swing.JFrame {

        // private UserSession userSession;

        public Main_Admin() {
                initComponents();
                setBackground(new Color(0, 0, 0, 0));
                this.setLocationRelativeTo(null);
                // this.userSession = UserSession.getInstance();
                menu.initMoving(Main_Admin.this);
                menu.addEventMenuSelected(new EventMenuSelected() {
                        @Override
                        public void selected(int index) {
                                if (index <= 0) {
                                        setForm(new ManagerUser());
                                } else if (index == 1) {
                                        setForm(new RevenuePanel());
                                }
                        }
                });
        }

        private void setForm(JComponent component) {
                mainPanel.removeAll();
                mainPanel.add(component);
                mainPanel.repaint();
                mainPanel.revalidate();
        }

        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                panelBorder1 = new store.view.admin.ui.swing.PanelBorder();
                menu = new store.view.admin.ui.component.Menu();
                header1 = new store.view.admin.ui.component.Header();
                mainPanel = new javax.swing.JPanel();
                formHome1 = new store.view.admin.ui.form.FormHome();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setUndecorated(true);

                mainPanel.setLayout(new javax.swing.BoxLayout(mainPanel, javax.swing.BoxLayout.LINE_AXIS));
                mainPanel.add(formHome1);

                javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
                panelBorder1.setLayout(panelBorder1Layout);
                panelBorder1Layout.setHorizontalGroup(
                                panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(panelBorder1Layout.createSequentialGroup()
                                                                .addComponent(menu,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(panelBorder1Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(header1,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                956,
                                                                                                Short.MAX_VALUE)
                                                                                .addGroup(panelBorder1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(6, 6, 6)
                                                                                                .addComponent(mainPanel,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                0,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addContainerGap()))));
                panelBorder1Layout.setVerticalGroup(
                                panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                .addGroup(panelBorder1Layout.createSequentialGroup()
                                                                .addComponent(header1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(mainPanel,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                496, Short.MAX_VALUE)
                                                                .addContainerGap()));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

                pack();
                setLocationRelativeTo(null);
        }// </editor-fold>//GEN-END:initComponents

        /**
         * @param args the command line arguments
         */
        // public static void main(String args[]) {
        // /* Set the Nimbus look and feel */
        // // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // // (optional) ">
        // /*
        // * If Nimbus (introduced in Java SE 6) is not available, stay with the default
        // * look and feel.
        // * For details see
        // * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
        // */
        // try {
        // for (javax.swing.UIManager.LookAndFeelInfo info :
        // javax.swing.UIManager.getInstalledLookAndFeels()) {
        // if ("Nimbus".equals(info.getName())) {
        // javax.swing.UIManager.setLookAndFeel(info.getClassName());
        // break;
        // }
        // }
        // } catch (ClassNotFoundException ex) {
        // java.util.logging.Logger.getLogger(Main_Admin.class.getName()).log(java.util.logging.Level.SEVERE,
        // null,
        // ex);
        // } catch (InstantiationException ex) {
        // java.util.logging.Logger.getLogger(Main_Admin.class.getName()).log(java.util.logging.Level.SEVERE,
        // null,
        // ex);
        // } catch (IllegalAccessException ex) {
        // java.util.logging.Logger.getLogger(Main_Admin.class.getName()).log(java.util.logging.Level.SEVERE,
        // null,
        // ex);
        // } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        // java.util.logging.Logger.getLogger(Main_Admin.class.getName()).log(java.util.logging.Level.SEVERE,
        // null,
        // ex);
        // }
        // // </editor-fold>

        // /* Create and display the form */
        // // java.awt.EventQueue.invokeLater(new Runnable() {
        // // public void run() {
        // // new Main_Admin().setVisible(true);
        // // }
        // // });
        // }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private store.view.admin.ui.form.FormHome formHome1;
        private store.view.admin.ui.component.Header header1;
        private javax.swing.JPanel mainPanel;
        private store.view.admin.ui.component.Menu menu;
        private store.view.admin.ui.swing.PanelBorder panelBorder1;
        // End of variables declaration//GEN-END:variables
}
