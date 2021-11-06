package Client;

public class Repository {

    // ATTRIBUTES
    private String name;
    private String branch;
    private int numberOfFiles;

    // CONSTRUCTORS
    public Repository() {};

    // METHODS
    @Override
    public String toString() {
        return "Repository{" +
                "name='" + name + '\'' +
                "branch='" + branch + '\'' +
                '}';
    }

    // GETTER & SETTER
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getNumberOfFiles() {
        return numberOfFiles;
    }

    public void setNumberOfFiles(int numberOfFiles) {
        this.numberOfFiles = numberOfFiles;
    }
}
