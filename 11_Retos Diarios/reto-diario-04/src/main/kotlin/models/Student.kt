package models

/**
 * OpenBootcamp - Reto diario 05
 * Child class student of the clase user
 * @author Rikhen
 * @version 1.0
 */

import models.User

// Extend user class with student class
class Student(id: Int, role: String, name: String, lastname: String, email: String, var grade: String) :
    User(id, role, name, lastname, email) {

    // ATTRIBUTES
    private var deliveriesList: MutableList<Course> = arrayListOf()

    // METHODS
    fun makeDelivery(course: Course) {
        if (!course.isStudent(this)) {
            println("The student ${this.name} is not part of the course ${course.name}.")
        } else if (course in deliveriesList) {
            println("The student ${this.name} has already delivered the course ${course.name}.")
        } else {
            println("Delivery of ${this.name} has been made to the ${course.name} course.")
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
        return "User(id='$id', role='$role', name='$name', lastname='$lastname', email='$email', isLoggedIn=$isLoggedIn, grade='$grade', listDeliveries='$deliveriesList')"
    }


}