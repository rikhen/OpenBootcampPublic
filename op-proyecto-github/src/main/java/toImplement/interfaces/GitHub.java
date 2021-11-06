package toImplement.interfaces;

import Client.Commit;
import Client.Directory;
import Client.File;
import Client.Repository;

import java.util.ArrayList;

public interface GitHub {

    public ArrayList<Commit> getCommits();
    public ArrayList<Repository> getRepositories();
    public ArrayList<File> getFiles();
    public ArrayList<Directory> getDirectories();

}
