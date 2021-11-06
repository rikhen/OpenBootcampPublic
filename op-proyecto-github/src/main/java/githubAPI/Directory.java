package githubAPI;

public class Directory {

    private String sha;
    private String name;
    private String path;

    public Directory() {};

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
