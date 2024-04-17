
package store.view.component;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import store.Model.Author;

public class AuthorSelector extends JPanel {

    public static Author selectAuthor(Author[] authors) {
        JComboBox<Author> authorComboBox = new JComboBox<>(authors);
        authorComboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public java.awt.Component getListCellRendererComponent(JList<?> list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Author) {
                    Author author = (Author) value;
                    setText(author.getAuthorName());
                }
                return this;
            }
        });

        int result = JOptionPane.showConfirmDialog(null, authorComboBox, "Select Author", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            return (Author) authorComboBox.getSelectedItem();
        } else {
            return null; // Or any other value indicating the selection was cancelled.
        }
    }

    // // Main method for testing the AuthorSelector
    // public static void main(String[] args) {
    //     // Sample authors for testing
    //     Author[] authors = {
    //             new Author(1, "Author One", true),
    //             new Author(2, "Author Two", false),
    //             new Author(3, "Author Three", true)
    //     };

    //     Author selectedAuthor = AuthorSelector.selectAuthor(authors);
    //     if (selectedAuthor != null) {
    //         System.out.println("You selected: " + selectedAuthor.getAuthorName());
    //     } else {
    //         System.out.println("No author selected.");
    //     }
    // }
}
