package store.Model;

public class Author {
    private int authorID;
    private String authorName;
    private Boolean status;

    public Author(int authorID, String authorName, Boolean status) {
        this.authorID = authorID;
        this.authorName = authorName;
        this.status = status;
    }

    public Author(String authorName, Boolean status) {
        this.authorName = authorName;
        this.status = status;
    }

    // Getters
    public int getAuthorID() {
        return authorID;
    }

    public String getAuthorName() {
        return authorName;
    }

    public Boolean getStatus() {
        return status;
    }

    // Setters

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }


}
