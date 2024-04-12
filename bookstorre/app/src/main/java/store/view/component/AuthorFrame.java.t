// package store.view.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AuthorPanel extends JPanel {
    private JComboBox<Author> authorComboBox;
    private JButton selectButton;

    public AuthorPanel(Author[] authors) {
        // Set the layout
        setLayout(new BorderLayout());

        // Create the combo box with authors
        authorComboBox = new JComboBox<>(authors);
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

        // Create the select button
        selectButton = new JButton("Select Author");
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Author selectedAuthor = (Author) authorComboBox.getSelectedItem();
                if (selectedAuthor != null) {
                    JOptionPane.showMessageDialog(AuthorPanel.this,
                            "You selected: " + selectedAuthor.getAuthorName(),
                            "Author Selected",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // Add components to the panel
        add(authorComboBox, BorderLayout.CENTER);
        add(selectButton, BorderLayout.SOUTH);
    }
}

// Example usage in a JFrame
public class AuthorFrame extends JFrame {
    public AuthorFrame() {
        // Create sample authors for testing
        Author[] authors = {
                new Author(1, "Author One", true),
                new Author(2, "Author Two", false),
                new Author(3, "Author Three", true)
        };

        // Create the AuthorPanel with the authors array
        AuthorPanel authorPanel = new AuthorPanel(authors);

        // Set up the frame
        setTitle("Select Author");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(authorPanel);
    }

    public static void main(String[] args) {
        // Run the frame
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                AuthorFrame frame = new AuthorFrame();
                frame.setVisible(true);
            }
        });
    }
}