import models.Administrator
import models.Course
import models.Student
import models.Instructor

/**
 * OpenBootcamp - Reto diario 04
 * @author Rikhen
 * @version 1.0
 * @thanks to https://github.com/Ceskkk/Reto4_Kotlin
 */

fun main(args: Array<String>) {
    println("Welcome to the Bootcamp!")

    // Initialize administrator
    val juanC = Administrator(1,"Admin", "Juan", "Carlos", "jc@hotmail.com")

    // Initialize courses instructors
    val angelaG = Instructor(2, "Instructor","Ángela", "Gonzalez", "angig@gmail.com")
    val pabloE = Instructor(3, "Instructor","Pablo", "Escobar", "ScarletJ@gmail.com")

    // Initialize students
    val alexM = Student(3, "Student","Alex", "Morde", "amorde0@ted.com", "Beginner")
    val ethelinF = Student(5, "Student","Ethelin", "Fancet", "efancet1@woothemes.com", "Intermediate")
    val toddyY = Student(6, "Student","Toddy", "Yoakley", "tyoakley2@fastcompany.com", "Professional")

    // Initialize courses
    val java = Course(1, "Java", angelaG)
    val python = Course(2, "Python", pabloE)

    // Login users
    alexM.login()
    ethelinF.login()
    alexM.login()
    toddyY.logout()

    // Enroll students
    java.enrol(alexM)
    java.enrol(ethelinF)
    java.enrol(toddyY)

    python.enrol(ethelinF)
    python.enrol(toddyY)

    // Make deliveries
    alexM.makeDelivery(java)
    alexM.makeDelivery(python)

    // Check deliveries
    angelaG.checkDelivery(java, alexM)
    angelaG.checkDelivery(python, ethelinF)
    pabloE.checkDelivery(python, toddyY)

    // Unroll students
    java.unenrol(toddyY)

    // Exploit Bootcamp
    juanC.exploitBootcamp();
}