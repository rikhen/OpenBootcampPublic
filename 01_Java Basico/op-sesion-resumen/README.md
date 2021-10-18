# OpenBootcamp - Java Básico - Resumen

---

## Introducción del programa:

El programa es un resumen del curso Java Básico de OpenBootcamp para procesar un archivo `userdata.csv`

### Contenido
* Main
  * `Main` <-- Clase principal del programa
* Clases
  * `CSV`
  * `User`
  * `ProcessFile`
  * `ProcessUser`
* Clases hija
  * `Password`
* Interfaces
  * `CSVProcessing`
  * `UserProcessing`
* Ficheros
  * `userdata.csv`

### Funciones implementadas 

* `ProcessFile`:
  * `openCSV()`
  * `readCSV()`
  * `createCSV()`
  * `writeCSV()`
* `ProcessUser`:
  * `creadeUser()`
  * `addUser()`

### Funciones previstas
* `ProcessUser`:
  * `selectUser()`
  * `deleteUser()`
* `Password`:
  * `generatePassword()`
  * `changePassword()`
* ...

### Inicio del programa

Inicia el programa `main` y inserta los nuevos usuarios a través de la consola:

```java
C:\Java\openjdk-17\bin\java.exe "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2021.2.2\lib\idea_rt.jar=61251:C:\Program Files\JetBrains\IntelliJ IDEA 2021.2.2\bin" -Dfile.encoding=UTF-8 -classpath "D:\Dropbox\03_Projekte\OpenBootcamp\01_Java Basico\op-sesion-resumen\out\production\op-sesion-resumen" Main
```

#### Salida de la consola:
```java
Abriendo fichero...Fichero abierto!
Leyendo fichero...
User{ID='001', name='Roberto', lastname='Matinez', email='r.matinez@hotmail.com'}
User{ID='002', name='Ángela', lastname='De la Huerta', email='angelitaH@googlemail.com'}
User{ID='003', name='Juan', lastname='Carlos', email='juanCarlos@web.de'}
Fichero leído!
Crear nuevo usuario
Introduce nombre:
 Henrik
Introduce apellido:
 Liebel
Introduce email:
 henrik.liebel@hotmail.de
¿Añadir más usuarios? [s/n]
...
```