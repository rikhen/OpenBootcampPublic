package githubAPI;

//import services.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        GitHub gitHub = new GitHub();
        User user = new User();

        ArrayList<Repository> repositories = new ArrayList();
        ArrayList<Commit> commits = new ArrayList();
        ArrayList<File> files = new ArrayList();
        ArrayList<Directory> directories = new ArrayList();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce GitHub usuario:");
        user.setName(scanner.nextLine());

        gitHub.getRepositories(user);
        repositories = gitHub.getRepositoryList();

        for (Repository repository : repositories) {
            System.out.println("-------------------------------------------");
            int numberFilesXml = gitHub.countFiles(user, repository, "xml");
            int numberFilesJava = gitHub.countFiles(user, repository, "java");
            System.out.print("Repository: " + repository.getName());
            System.out.println(" (" + numberFilesXml + " xml " +  "," + numberFilesJava + " java" + ")");
            System.out.println("-------------------------------------------");
            System.out.println("Commits: ");

            gitHub.getCommits(user, repository);
            commits = gitHub.getCommitList();
            for (Commit commit : commits) {
                System.out.println(" --> " + commit.getMessage());
            }
            System.out.println("Files:");
            gitHub.getRepositoryTree(user, repository);
        }
    }
}
