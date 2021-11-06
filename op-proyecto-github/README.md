# OpenBootcamp - Java - Projecto GitHub

---

## Introducción del programa:

El programa es un cliente para usar la GitHub API

### Contenido
* Main
    * `Main` <-- Clase principal del programa
* Clases
    * `Authentication`
    * `Commit`
    * `Directory`
    * `File`
    * `GitHub`
    * `OkHTTP`
    * `Repository`
    * `User`

### Funciones implementadas

* `GitHub`:
    * `getCommits()`
    * `getRepositories()`
    * `getFiles()`
    * `getRepositoryTree()`
* `OkHTTP`:
  * `getResponse()`
  * `sendRequest()`

### Funciones previstas
* `GitHub`:
    * ...
* `OkHTTP`:
    * ...

### Inicio del programa

1. Añade un **personal access token** de GitHub via https://github.com/settings/tokens

2. Abre el fichero`Authentication.java`
   * Inserta el token aquí: `private String token = "<your token here>";`
3. Inicia el programa `main` y inserta el nombre del usuario de GitHub a través de la consola.