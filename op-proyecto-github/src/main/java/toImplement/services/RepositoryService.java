package toImplement.services;

import githubAPI.Repository;

public interface RepositoryService {

  public Repository getRepository(String userName, String repositoryName);

  public Repository getRepositories(String userName);
}
