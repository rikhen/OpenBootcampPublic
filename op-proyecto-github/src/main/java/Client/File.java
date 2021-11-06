package Client;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class File {

    // ATTRIBUTES
    private String sha;
    private String name;
    private String path;
    private String type;
    private String extension;
    private String downloadUrl;
    private int numberOfLines;

    // CONSTRUCTORS
    public File() {
    }

    // METHODS
    public int countNumberOfLines(String path) {
        try (InputStream is = new URL(path).openStream()) {
            byte[] c = new byte[1024];
            int count = 0;
            int readChars = 0;
            boolean endsWithoutNewLine = false;
            while ((readChars = is.read(c)) != -1) {
                for (int i = 0; i < readChars; ++i) {
                    if (c[i] == '\n')
                        ++count;
                }
                endsWithoutNewLine = (c[readChars - 1] != '\n');
            }
            if (endsWithoutNewLine) {
                ++count;
            }
            numberOfLines = count;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return numberOfLines;
    }

    // GETTER & SETTER
    public String getSha() { return sha; }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public int getNumberOfLines() {
        return numberOfLines;
    }

    public void setNumberOfLines(int numberOfLines) {
        this.numberOfLines = numberOfLines;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
