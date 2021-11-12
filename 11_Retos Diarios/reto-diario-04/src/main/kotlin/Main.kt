import models.Administrator
import models.Course
import models.Student
import models.Instructor

fun main(args: Array<String>) {
    println("Hello World!")

    // Inicializamos el administrador
    val jesusN = Administrator(1,"Jesus", "de Nazaret", "jesusN@gmail.com")
    // Inicializamos los instructores
    val jasonM = Instructor(2, "Jason", "Momoa", "JasonM@gmail.com", "Backend")
    val scarlettJ = Instructor(3, "Scarlett", "Johansson", "ScarletJ@gmail.com", "FullStack")
    val chrisE = Instructor(4, "Chris", "Evans", "ChrisE@gmail.com", "Frontend")
    val emilyB = Instructor(5, "Emily", "Blunt", "EmilyB@gmail.com", "Backend")
    // Inicializamos los Students
    val mickJ = Student(6, "Mick", "Jagger", "MickJ@gmail.com", "Inicial")
    val mileyC = Student(7, "Miley", "Cyrus", "MileyC@gmail.com", "Intermedio")
    val alejandroS = Student(8, "Alejandro", "Sanz", "alejandroS@gmail.com", "Avanzado")
    val ladyG = Student(9, "Lady", "Gaga", "ladyG@gmail.com", "Inicial")
    val marcA = Student(10, "Marc", "Anthony", "marcA@gmail.com", "Intermedio")
    val whitneyH = Student(11, "Whitney", "Houston", "whitneyH@gmail.com", "Avanzado")
    val michaelJ = Student(12, "Michael", "Jackson", "michaelJ@gmail.com", "Inicial")
    val nickiN = Student(13, "Nicki", "Nicole", "nickiN@gmail.com", "Intermedio")
    // Inicializamos los cursos
    val java = Course("Java", jasonM)
    val htmlCss = Course("HtmlCss", scarlettJ)
    val javaScript = Course("JavaScript", chrisE)
    val mySql = Course("MySQL", emilyB)
    // Inscribimos a algunos usuarios en diferentes cursos
    java.enrol(mickJ)
    java.enrol(mileyC)
    java.enrol(marcA)
    java.enrol(nickiN)
    java.enrol(alejandroS)
    htmlCss.enrol(ladyG)
    htmlCss.enrol(whitneyH)
    htmlCss.enrol(mickJ)
    javaScript.enrol(ladyG)
    javaScript.enrol(michaelJ)
    javaScript.enrol(whitneyH)
    javaScript.enrol(mileyC)
    mySql.enrol(michaelJ)
    mySql.enrol(mickJ)
    // Probando el programa
    mickJ.makeDelivery(mySql)
    mickJ.makeDelivery(javaScript)
    jasonM.checkDelivery(mySql, mickJ)
    emilyB.checkDelivery(mySql, mickJ)
    emilyB.checkDelivery(mySql, mickJ)
    mySql.unenrol(mickJ)

    jesusN.explotarBootcamp();
}