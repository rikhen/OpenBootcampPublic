package githubAPI;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class GitHub {

    // ATTRIBUTES
    private final String baseUrl = "https://api.github.com/";
    private final String mediatype = "application/vnd.github.v3+json";

    private String userName;
    private String repositoryName;
    private String branchName;
    private String filePath;

    private String responseMessage;

    private OkHTTP okHTTP = new OkHTTP();
    private final File file = new File();

    private ArrayList<File> files = new ArrayList<>();
    private ArrayList<Directory> directories = new ArrayList<>();
    private ArrayList<Commit> commits = new ArrayList<>();
    private ArrayList<Repository> repositories = new ArrayList<>();

    // CONSTRUCTORS
    public GitHub() {
        okHTTP.setMediatype(mediatype);
    }

    // METHODS
    public void getRepositories(User user) throws IOException, InterruptedException {
        userName = user.getName();

        // https://api.github.com/users/:user/repos
        okHTTP.setUrl(baseUrl + "users/" + userName + "/repos");
        responseMessage = okHTTP.getResponse(okHTTP.sendRequest());
        try {
            JSONArray jsonArray = new JSONArray(responseMessage);
            for (int i = 0; i < jsonArray.length(); i++) {
                Repository repository = new Repository();
                JSONObject object = jsonArray.getJSONObject(i);
                repository.setName(object
                        .getString("name"));
                repository.setBranch(object
                        .getString("default_branch"));
                repositories.add(repository);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.setRepositoryList(repositories);
        }
    }

    /**
     * Método que devuelve los commit del repositorio dado
     * @param user, objeto usuario
     * @param repository objeto repository
     */
    public void getCommits(User user, Repository repository) throws IOException, InterruptedException {
        userName = user.getName();
        repositoryName = repository.getName();

        commits = new ArrayList<>();
        // https://api.github.com/repos/:user/:repo/commits
        okHTTP.setUrl(baseUrl + "repos/" + userName + "/" + repositoryName + "/commits");
        responseMessage = okHTTP.getResponse(okHTTP.sendRequest());
        if (responseMessage.startsWith("[")) {
            try {
                JSONArray jsonArray = new JSONArray(responseMessage);
                for (int i = 0; i < jsonArray.length(); i++) {
                    Commit commit = new Commit();
                    JSONObject object = jsonArray
                            .getJSONObject(i)
                            .getJSONObject("commit");
                    commit.setMessage(object.getString("message"));
                    commits.add(commit);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                Commit commit = new Commit();
                commit.setMessage("no commits");
                commits.add(commit);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.setCommitList(commits);
    }

    /**
     * Método que devuelve las carpetas del repositorio dado
     * @param user, objeto del usuario
     * @param repository objeto del repository
     */
    public void getDirectories(User user, Repository repository) throws IOException, InterruptedException {
        Directory directory = new Directory();
        try {
            JSONArray jsonArray = new JSONArray(responseMessage);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                directory.setSha(object
                        .getString("sha")
                );
                directory.setName(object
                        .getString("name")
                );
                directory.setPath(object
                        .getString("path")
                );
                directories.add(directory);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setDirectoryList(directories);
    }

    /**
     * Método que devuelve los ficheros del repositorio dado
     * @param user, objeto del usuario
     * @param repository objeto del repository
     */
    public void getFiles(User user, Repository repository) throws IOException, InterruptedException {

        userName = user.getName();
        repositoryName = repository.getName();
        branchName = repository.getBranch();
        filePath = file.getPath();

        // https://api.github.com/repos/:owner/:repo/contents/:path
        okHTTP.setUrl(baseUrl + "repos/" + userName + "/" + repositoryName + "/contents/" + filePath);
        responseMessage = okHTTP.getResponse(okHTTP.sendRequest());
        try {
            JSONObject object = new JSONObject(responseMessage);
            file.setSha(object
                    .getString("sha"));
            file.setName(object
                    .getString("name"));
            file.setPath(object
                    .getString("path"));
            file.setType(object
                    .getString("type"));
            file.setDownloadUrl(object
                    .getString("download_url"));
            files.add(file);

            int numberOfLines = file.countNumberOfLines(file.getDownloadUrl());
            System.out.println(" --> " + file.getName() + " (" + numberOfLines + " Lines of code)");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.setFileList(files);
        }
    }

    /**
     * Método que devuelve todas las carpetas y ficheros del repositorio dado
     * @param user, objeto del usuario
     * @param repository objeto del repository
     */
    public void getRepositoryTree(User user, Repository repository) throws IOException, InterruptedException {
        Directory directory = new Directory();
        userName = user.getName();
        repositoryName = repository.getName();
        branchName = repository.getBranch();

        // https://api.github.com/repos/:user/:repo/git/trees/:branch?recursive=1
        okHTTP.setUrl(baseUrl + "repos/" + userName + "/" + repositoryName + "/git/trees/" + branchName + "?recursive=1");
        responseMessage = okHTTP.getResponse(okHTTP.sendRequest());

        try {
            JSONObject jsonObject = new JSONObject(responseMessage);
            if(jsonObject.has("tree")) {
                JSONArray jsonArray = new JSONArray(jsonObject.getJSONArray("tree"));
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject object = jsonArray.getJSONObject(i);
                    if (object.getString("type").equals("tree")) {
                        System.out.println("Directory: " + object.getString("path"));
                        directories.add(directory);
                    } else if (object.getString("type").equals("blob")) {
                        file.setPath(object
                                .getString("path")
                        );
                        getFiles(user, repository);
                    }
                }
            } else {
                System.out.println(" --> " + "no files");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que cuenta el número de archivos del repositorio dado según la extensión de archivo especificada.
     * @param user, objeto del usuario
     * @param repository objeto del repository
     * @param extension extensión del archivo como filtro
     */
    public int countFiles(User user, Repository repository, String extension) throws IOException, InterruptedException {
        userName = user.getName();
        repositoryName = repository.getName();

        // https://api.github.com/search/code?q=extension:xml+repo:user/:repo
        okHTTP.setUrl(baseUrl + "search/" + "code?q=extension:" + extension + "+repo:" + userName + "/" + repositoryName);
        responseMessage = okHTTP.getResponse(okHTTP.sendRequest());
        try {
            JSONObject object = new JSONObject(responseMessage);
            repository.setNumberOfFiles(object
                    .getInt("total_count")
            );
            return repository.getNumberOfFiles();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    // GETTER & SETTER
    public void setDirectoryList(ArrayList<Directory> directories) { this.directories = directories; }

    public void setCommitList(ArrayList<Commit> commits) {
        this.commits = commits;
    }

    public void setRepositoryList(ArrayList<Repository> repositories) {
        this.repositories = repositories;
    }

    public ArrayList<Commit> getCommitList() {
        return commits;
    }

    public ArrayList<Repository> getRepositoryList() {
        return repositories;
    }

    public void setFileList(ArrayList<File> files) { this.files = files; }

    public ArrayList<File> getFileList() {
        return files;
    }

    public ArrayList<Directory> getDirectoryList() {
        return directories;
    }
}
