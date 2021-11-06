package Client;

//import services.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        GitHubAPI gitHubAPI = new GitHubAPI();
        User user = new User();

        ArrayList<Repository> repositories = new ArrayList();
        ArrayList<Commit> commits = new ArrayList();
        ArrayList<File> files = new ArrayList();
        ArrayList<Directory> directories = new ArrayList();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce GitHub usuario:");
        user.setName(scanner.nextLine());

        gitHubAPI.getRepositories(user);
        repositories = gitHubAPI.getRepositoryList();

        for (Repository repository : repositories) {
            System.out.println("-------------------------------------------");
            int numberFilesXml = gitHubAPI.countFiles(user, repository, "xml");
            int numberFilesJava = gitHubAPI.countFiles(user, repository, "java");
            System.out.print("Repository: " + repository.getName());
            System.out.println(" (" + numberFilesXml + " xml " +  "," + numberFilesJava + " java" + ")");
            System.out.println("-------------------------------------------");
            System.out.println("Commits: ");

            gitHubAPI.getCommits(user, repository);
            commits = gitHubAPI.getCommitList();
            for (Commit commit : commits) {
                System.out.println(" --> " + commit.getMessage());
            }
            System.out.println("Files:");
            gitHubAPI.getRepositoryTree(user, repository);
        }
    }
}
