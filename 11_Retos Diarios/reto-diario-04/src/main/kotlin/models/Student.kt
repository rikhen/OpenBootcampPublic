package models

import User

class Student(id: Int, name: String, lastname: String, email: String, var grade: String) :
    User(id, name, lastname, email) {

    // ATTRIBUTES
    private var deliveriesList: MutableList<Course> = arrayListOf()

    // METHODS
    fun makeDelivery(course: Course) {
        if (!course.isStudent(this)) {
            println("El estudiante ${this.name} no forma parte del curso ${course.name}.")
        } else if (course in deliveriesList) {
            println("El estudiante ${this.name} ya ha hecho la entrega del curso ${course.name}.")
        } else {
            println("Se ha realizado la entrega de ${this.name} al curso ${course.name}.")
            deliveriesList.add(course)
        }
    }

    fun checkDelivery(course: Course): Boolean {
        if (course in deliveriesList) {
            return true
        }
        return false
    }

    // toString
    override fun toString(): String {
        return "User(name='$name', lastname='$lastname', email='$email', isLoggedIn=$isLoggedIn, grade='$grade', listDeliveries='$deliveriesList')"
    }


}