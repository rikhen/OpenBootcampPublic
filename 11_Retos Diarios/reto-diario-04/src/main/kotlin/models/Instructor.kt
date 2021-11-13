package models

/**
 * OpenBootcamp - Reto diario 05
 * Child class instructor of the clase user
 * @author Rikhen
 * @version 1.0
 */

import models.User

// Extend user class with instructor class
class Instructor(id: Int, role: String, name: String, lastname: String, email: String) :
    User(id, role, name, lastname, email) {

    // ATTRIBUTES
    private var CorrectionsList: HashMap<Student, Course> = hashMapOf()

    // METHODS
    fun checkDelivery(course: Course, student: Student) {
        if (!course.isStudent(student)) {
            println("The student ${student.name} is not part of the course ${course.name}.")
        } else if (!student.checkDelivery(course)) {
            println("The student ${student.name} has not delivered anything to the course ${course.name}.")
        } else if (course.instructor != this) {
            println("The instructor ${this.name} is not the instructor of the course ${course.name}.")
        } else if (course == CorrectionsList.get(student)) {
            println("The delivery of the student ${student.name} of the course ${course.name} has been corrected.")
        } else {
            CorrectionsList[student] = course
            println("The student's ${student.name} delivery of the ${course.name} course has been corrected by the instructor ${this.name}.")
        }
    }

    // toString
    override fun toString(): String {
        return "User(id='$id', role='$role', name='$name', lastname='$lastname', email='$email', isLoggedIn=$isLoggedIn, CorrectionsList='$CorrectionsList')"
    }

}