package toImplement.services;

import Client.Repository;

public interface RepositoryService {

  public Repository getRepository(String userName, String repositoryName);

  public Repository getRepositories(String userName);
}
