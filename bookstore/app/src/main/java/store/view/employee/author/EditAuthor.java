/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package store.view.employee.author;

import store.Model.Author;
import store.Service.BookService;

/**
 *
 * @author bourbon
 */
public class EditAuthor extends javax.swing.JFrame {

    private BookService bookService;
    private int authorID;

    public EditAuthor(int authorID) {

        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.bookService = new BookService();
        this.authorID = authorID; // Set the bookId before loading details
        loadAuthorDetails();
    }

    private void loadAuthorDetails() {
        try {
            Author author = bookService.selectAuthor(authorID);
            if (author != null) {
                ID.setText(String.valueOf(author.getAuthorID()));
                InputName.setText(author.getAuthorName());
                if (author.getStatus()) {
                    Active.setSelected(true);
                } else {
                    InActice.setSelected(true);
                }
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
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        IDLabel = new javax.swing.JLabel();
        NameLabel = new javax.swing.JLabel();
        SatusLabel = new javax.swing.JLabel();
        InputName = new javax.swing.JTextField();
        ID = new javax.swing.JTextField();
        Active = new javax.swing.JRadioButton();
        InActice = new javax.swing.JRadioButton();
        CancelButton = new javax.swing.JButton();
        OKButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        IDLabel.setText("ID");

        NameLabel.setText("Name");

        SatusLabel.setText("Status");

        InputName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputNameActionPerformed(evt);
            }
        });

        ID.setEditable(false);
        ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDActionPerformed(evt);
            }
        });

        buttonGroup1.add(Active);
        Active.setText("Active");

        buttonGroup1.add(InActice);
        InActice.setText("InActice");

        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        OKButton.setText("OK");
        OKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(SatusLabel)
                                        .addComponent(NameLabel)
                                        .addComponent(IDLabel))
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(Active)
                                                .addGap(18, 18, 18)
                                                .addComponent(InActice))
                                        .addComponent(ID)
                                        .addComponent(InputName))
                                .addContainerGap(211, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CancelButton)
                                .addGap(29, 29, 29)
                                .addComponent(OKButton)
                                .addGap(33, 33, 33)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(IDLabel)
                                        .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(NameLabel)
                                        .addComponent(InputName, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(SatusLabel)
                                        .addComponent(Active)
                                        .addComponent(InActice))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87,
                                        Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(CancelButton)
                                        .addComponent(OKButton))
                                .addGap(42, 42, 42)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IDActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_IDActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_IDActionPerformed

    private void InputNameActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_InputNameActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_InputNameActionPerformed

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_OKButtonActionPerformed
        // TODO add your handling code here:
        try {
            String authorName = InputName.getText();
            Boolean status = Active.isSelected();
            Author author = new Author(authorID, authorName, status);
            bookService.updateAuthor(author);
            this.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }// GEN-LAST:event_OKButtonActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_CancelButtonActionPerformed
        this.dispose();
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Active;
    private javax.swing.JButton CancelButton;
    private javax.swing.JTextField ID;
    private javax.swing.JLabel IDLabel;
    private javax.swing.JRadioButton InActice;
    private javax.swing.JTextField InputName;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JButton OKButton;
    private javax.swing.JLabel SatusLabel;
    private javax.swing.ButtonGroup buttonGroup1;
    // End of variables declaration//GEN-END:variables
}