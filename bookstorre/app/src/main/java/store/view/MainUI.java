
package store.view;

import store.view.employee.book.TableBook;
import store.view.employee.author.TableAuthor;

/**
 *
 * @author bourbon
 */
public class MainUI<ActionEvent> extends javax.swing.JFrame {
    private TableBook tableBookPanel; // Biến cho TableBook
    private TableAuthor tableAuthorPanel; // Biến cho TableAuthor

    /**
     * Creates new form MainUI
     */
    public MainUI() {
        // initComponents();
        // this.setLocationRelativeTo(null);
        // tableBookPanel = new TableBook();
        // this.add(tableBookPanel);
        // tableBookPanel.setBounds(50, 50, 1100, 600);
        // tableBookPanel.setVisible(true);
        
        
        initComponents();
        this.setLocationRelativeTo(null);
        tableAuthorPanel = new TableAuthor();
        this.add(tableAuthorPanel);
        tableAuthorPanel.setBounds(0, 0, 1100, 600);
        tableAuthorPanel.setVisible(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1200, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 800, Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

}

// Variables declaration - do not modify//GEN-BEGIN:variables
// End of variables declaration//GEN-END:variables
