
package store.view.employee.book;

import store.Model.Book;
import store.Service.BookService;
import javax.swing.JOptionPane;

/**
 *
 * @author bourbon
 */
public class AddBookFrame extends javax.swing.JFrame {

    /**
     * Creates new form AddBookFrame
     */
    BookService bookService = new BookService();

    public AddBookFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Title = new javax.swing.JLabel();
        Author = new javax.swing.JLabel();
        Publisher = new javax.swing.JLabel();
        Price = new javax.swing.JLabel();
        Category = new javax.swing.JLabel();
        Volume = new javax.swing.JLabel();
        TitleField = new javax.swing.JTextField();
        AuthorField = new javax.swing.JTextField();
        PriceField = new javax.swing.JTextField();
        PublisherField = new javax.swing.JTextField();
        CategoryField = new javax.swing.JTextField();
        VolumeField = new javax.swing.JTextField();
        CancelButton = new javax.swing.JButton();
        AddButton = new javax.swing.JButton();

        Title.setText("Title");
        Title.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Author.setText("Author");
        Author.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Publisher.setText("Publisher");
        Publisher.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Price.setText("Price");
        Price.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Category.setText("Category");
        Category.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Volume.setText("Volume");
        Volume.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        TitleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TitleFieldActionPerformed(evt);
            }
        });

        AuthorField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AuthorFieldActionPerformed(evt);
            }
        });

        PriceField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PriceFieldActionPerformed(evt);
            }
        });

        PublisherField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PublisherFieldActionPerformed(evt);
            }
        });

        CategoryField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoryFieldActionPerformed(evt);
            }
        });

        VolumeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolumeFieldActionPerformed(evt);
            }
        });

        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        AddButton.setText("Add");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(104, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Author, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Publisher, javax.swing.GroupLayout.DEFAULT_SIZE, 80,
                                                Short.MAX_VALUE)
                                        .addComponent(Price, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Category, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Volume, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(68, 68, 68)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(TitleField, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                302, Short.MAX_VALUE)
                                                        .addComponent(AuthorField)
                                                        .addComponent(PriceField,
                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(CategoryField)
                                                        .addComponent(VolumeField)
                                                        .addComponent(PublisherField)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                .createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        206, Short.MAX_VALUE)
                                                .addComponent(CancelButton)
                                                .addGap(29, 29, 29)
                                                .addComponent(AddButton)))
                                .addGap(23, 23, 23)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 33,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TitleField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Author, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(AuthorField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Publisher, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(PublisherField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Price, javax.swing.GroupLayout.PREFERRED_SIZE, 37,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(PriceField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Category, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(CategoryField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(Volume, javax.swing.GroupLayout.PREFERRED_SIZE, 39,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(VolumeField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87,
                                                        Short.MAX_VALUE)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(AddButton)
                                                        .addComponent(CancelButton))
                                                .addGap(20, 20, 20)))));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    private void TitleFieldActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void AuthorFieldActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void PriceFieldActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void PublisherFieldActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void CategoryFieldActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void VolumeFieldActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            // Tạo một đối tượng Book mới với thông tin từ các trường nhập liệu
            Book newBook = new Book(
                    TitleField.getText(),
                    AuthorField.getText(),
                    PublisherField.getText(),
                    Double.parseDouble(PriceField.getText()),
                    CategoryField.getText(),
                    true, // Hoặc false, tùy vào logic của bạn để xác định trạng thái sách
                    Integer.parseInt(VolumeField.getText()));

            // Gọi phương thức insertBook từ bookService để thêm sách mới
            bookService.insertBook(newBook);

            // Hiển thị thông báo sách đã được thêm
            JOptionPane.showMessageDialog(this, "Book added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

            // Xóa các trường nhập để chuẩn bị thêm sách mới tiếp theo
            TitleField.setText("");
            AuthorField.setText("");
            PublisherField.setText("");
            PriceField.setText("");
            CategoryField.setText("");
            VolumeField.setText("");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values for price and volume.",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error adding book: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JLabel Author;
    private javax.swing.JTextField AuthorField;
    private javax.swing.JButton CancelButton;
    private javax.swing.JLabel Category;
    private javax.swing.JTextField CategoryField;
    private javax.swing.JLabel Price;
    private javax.swing.JTextField PriceField;
    private javax.swing.JLabel Publisher;
    private javax.swing.JTextField PublisherField;
    private javax.swing.JLabel Title;
    private javax.swing.JTextField TitleField;
    private javax.swing.JLabel Volume;
    private javax.swing.JTextField VolumeField;
    // End of variables declaration//GEN-END:variables
}
