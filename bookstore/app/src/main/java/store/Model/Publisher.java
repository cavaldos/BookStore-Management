package store.Model;

public class Publisher {
    int publisherID;
    String publisherName;
    Boolean status;

    public Publisher(int publisherID, String publisherName, Boolean status) {
        this.publisherID = publisherID;
        this.publisherName = publisherName;
        this.status = status;
    }

    // Getters

    public int getPublisherID() {
        return publisherID;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public Boolean getStatus() {
        return status;
    }

    // Setters

    public void setPublisherID(int publisherID) {
        this.publisherID = publisherID;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "publisherID='" + publisherID + '\'' +
                ", publisherName='" + publisherName + '\'' +
                ", status=" + status +
                '}';
    }

}
