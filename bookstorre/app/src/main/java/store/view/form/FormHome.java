/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package store.view.form;

/**
 *
 * @author TCCom
 */
public class FormHome extends javax.swing.JPanel {

    /**
     * Creates new form FormHome
     */
    public FormHome() {
        initComponents();
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
        jLabel2 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        card6 = new store.view.component.Card();
        card2 = new store.view.component.Card();
        card5 = new store.view.component.Card();
        card4 = new store.view.component.Card();
        card3 = new store.view.component.Card();
        card1 = new store.view.component.Card();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        card10 = new store.view.component.Card();
        card12 = new store.view.component.Card();
        card11 = new store.view.component.Card();
        card9 = new store.view.component.Card();
        card8 = new store.view.component.Card();
        card7 = new store.view.component.Card();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Sách Bán Chạy");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Sách Mới Ra Mắt");

        jLayeredPane1.setLayout(new java.awt.GridLayout(1, 0, 10, 0));
        jLayeredPane1.add(card6);
        jLayeredPane1.add(card2);
        jLayeredPane1.add(card5);
        jLayeredPane1.add(card4);
        jLayeredPane1.add(card3);
        jLayeredPane1.add(card1);

        jLayeredPane2.setLayout(new java.awt.GridLayout(1, 0, 10, 0));
        jLayeredPane2.add(card10);
        jLayeredPane2.add(card12);
        jLayeredPane2.add(card11);
        jLayeredPane2.add(card9);
        jLayeredPane2.add(card8);
        jLayeredPane2.add(card7);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLayeredPane2)
                                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 889,
                                                Short.MAX_VALUE)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1))
                                .addContainerGap(44, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 181,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(25, Short.MAX_VALUE)));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private store.view.component.Card card1;
    private store.view.component.Card card10;
    private store.view.component.Card card11;
    private store.view.component.Card card12;
    private store.view.component.Card card2;
    private store.view.component.Card card3;
    private store.view.component.Card card4;
    private store.view.component.Card card5;
    private store.view.component.Card card6;
    private store.view.component.Card card7;
    private store.view.component.Card card8;
    private store.view.component.Card card9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    // End of variables declaration//GEN-END:variables
}