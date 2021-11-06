package toImplement.interfaces;

import githubAPI.Commit;
import githubAPI.Directory;
import githubAPI.File;
import githubAPI.Repository;

import java.util.ArrayList;

public interface GitHub {

    public ArrayList<Commit> getCommits();
    public ArrayList<Repository> getRepositories();
    public ArrayList<File> getFiles();
    public ArrayList<Directory> getDirectories();

}
