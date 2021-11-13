package models

import models.Instructor
import models.Student

class Course(var id: Int, var name: String, var instructor: Instructor) {

    // ATTRIBUTES
    private var studentsList: MutableList<Student> = arrayListOf()

    // METHODS
    fun isStudent(student: Student): Boolean {
        if (student in studentsList) {
            return true
        }
        return false
    }

    fun enrol(student: Student) {
        if (!isStudent(student)) {
            studentsList.add(student)
            println("The student ${student.name} has been enrolled in the course ${this.name}.")
        } else {
            println("The student ${student.name} is already part of the course ${this.name}.")
        }
    }

    fun unenrol(student: Student) {
        if (isStudent(student)) {
            studentsList.remove(student)
            println("The student ${student.name} has been de-enrolled from the course ${this.name}.")
        } else {
            println("The student ${student.name} is not part of the course ${this.name}.")
        }
    }

    // toString
    override fun toString(): String {
        return "Course(id='$id', name='$name', instructor=$instructor, studentsList=$studentsList)"

    }

}