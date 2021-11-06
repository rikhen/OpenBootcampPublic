package toImplement.services;

import Client.Commit;

import java.util.List;

public interface CommitService {

  public List<Commit> getCommits(String userName, String repositoryName, String branch);
}
