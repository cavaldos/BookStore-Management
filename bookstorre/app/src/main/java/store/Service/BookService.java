package store.Service;

import java.sql.SQLException;
import java.util.List;
import store.Model.Author;
import store.Model.Book;
import store.Model.Category;
import store.Model.Publisher;
import store.Repository.AuthorDAO;
import store.Repository.BookDAO;
import store.Repository.CategoryDAO;
import store.Repository.PublisherDAO;

public class BookService {
    private BookDAO bookDAO;
    private AuthorDAO authorDAO;
    private CategoryDAO categoryDAO;
    private PublisherDAO publisherDAO;

    public BookService() {
        this.bookDAO = new BookDAO();
        this.authorDAO = new AuthorDAO();
        this.categoryDAO = new CategoryDAO();
        this.publisherDAO = new PublisherDAO();
    }

    public List<Book> getAllBooks() throws SQLException {
        return bookDAO.getAllBooks();
    }

    // delete book
    public void deleteBook(int bookID) throws SQLException {
        bookDAO.deleteBook(bookID);
    }

    // insert Book
    public void insertBook(Book book) throws SQLException {
        bookDAO.insertBook(book);
    }

    // update Book
    public void updateBook(Book book) throws SQLException {
        bookDAO.updateBook(book);
    }

    // get Book by ID
    public Book selectBook(int bookID) throws SQLException {
        return bookDAO.selectBook(bookID);
    }

    // AUTHOR
    // get all authors
    public List<Author> getAllAuthors() throws SQLException {
        return authorDAO.getAllAuthors();
    }

    // delete author
    public void deleteAuthor(int authorID) throws SQLException {
        authorDAO.deleteAuthor(authorID);
    }

    // insert author
    public void addAuthor(Author author) throws SQLException {
        authorDAO.addAuthor(author);
    }

    // update author
    public void updateAuthor(Author author) throws SQLException {
        authorDAO.updateAuthor(author);
    }

    // get author by ID
    public Author selectAuthor(int authorID) throws SQLException {
        return authorDAO.selectAuthor(authorID);
    }

    // CATEGORY

    // get all categories
    public List<Category> getAllCategories() throws SQLException, ClassNotFoundException {
        return categoryDAO.getAllCategories();
    }

    // delete category
    public void deleteCategory(int categoryID) throws SQLException {
        categoryDAO.deleteCategory(categoryID);
    }

    // insert category
    public void addCategory(Category category) throws SQLException {
        categoryDAO.addCategory(category);
    }

    // update category
    public void updateCategory(Category category) throws SQLException {
        categoryDAO.updateCategory(category);
    }

    // get category by ID
    public Category selectCategory(int categoryID) throws SQLException {
        return categoryDAO.selectCategory(categoryID);
    }

    // PUBLISHER

    // get all publishers
    public List<Publisher> getAllPublishers() throws SQLException {
        return publisherDAO.getAllPublishers();
    }

    // delete publisher

    public void deletePublisher(int publisherID) throws SQLException {
        publisherDAO.deletePublisher(publisherID);
    }

    // insert publisher
    public void addPublisher(Publisher publisher) throws SQLException {
        publisherDAO.addPublisher(publisher);
    }

    // update publisher

    public void updatePublisher(Publisher publisher) throws SQLException {
        publisherDAO.updatePublisher(publisher);
    }

    // get publisher by ID
    public Publisher selectPublisher(int publisherID) {
        return publisherDAO.selectPublisher(publisherID);
    }

}
