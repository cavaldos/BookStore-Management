package store.Model;

import java.util.Date;

public class Book {
    private Long bookID; // Assuming bookID is a numeric identifier
    private String title;
    private String author; // Assuming author is referenced by ID
    private String publisher;
    private Double price;
    private String category; // Assuming category is referenced by ID
    private Boolean status;
    private Long volume; // Assuming volume is a numeric field

    public Book(Long bookID, String title, String author,
            String publisher,
            Double price, String category, Boolean status, Long volume) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.category = category;
        this.status = status;
        this.volume = volume;
    }

    // Getters
    public Long getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public Double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public Boolean getStatus() {
        return status;
    }

    public Long getVolume() {
        return volume;
    }

    // Setters
    public void setBookID(Long bookID) {
        this.bookID = bookID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Book[ " +
                "bookID=" + bookID +
                ", title='" + title + '\'' +
                ", authorName='" + author + '\'' +
                ", publisherName='" + publisher + '\'' +
                ", price=" + price +
                ", categoryName='" + category + '\'' +
                ", status=" + status +
                ", volume=" + volume +
                ']';
    }

}