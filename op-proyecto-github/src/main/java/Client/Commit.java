package githubAPI;

public class Commit {

    // ATTRIBUTES
    private String sha;
    private String author;
    private String message;

    // CONSTRUCTORS
    public Commit () {};

    public Commit(String sha) {
        this.sha = sha;
    }

    public Commit(String sha, String author, String message) {
        this.sha = sha;
        this.author = author;
        this.message = message;
    }

    // METHODS
    @Override
    public String toString() {
        return "Commit{" +
                "sha='" + sha + '\'' +
                ", author='" + author + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    // GETTER & SETTER
    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
