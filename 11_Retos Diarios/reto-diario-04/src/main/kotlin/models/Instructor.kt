package models

import User

// Iniciamos clase extendida de Usuario con constructor principal
class Instructor(id: Int, name: String, lastname: String, email: String, var especialidad: String) :
    User(id, name, lastname, email) {

    // Inicializamos fuera del constructor un atributo privado
    private var CorrectionsList: HashMap<Student, Course> = hashMapOf()

    // METHODS
    fun checkDelivery(course: Course, student: Student) {
        if (!course.isStudent(student)) {
            println("El estudiante ${student.name} no forma parte del course ${course.name}.")
        } else if (!student.checkDelivery(course)) {
            println("El estudiante ${student.name} no ha hecho la entrega del course ${course.name}.")
        } else if (course.instructor != this) {
            println("El instructor ${this.name} no es el instructor del course ${course.name}.")
        } else if (course == CorrectionsList.get(student)) {
            println("La entrega del estudiante ${student.name} del course ${course.name} ya ha sido corregida.")
        } else {
            CorrectionsList[student] = course
            println("La entrega del estudiante ${student.name} del course ${course.name} ha sido corregida por el instructor ${this.name}")
        }
    }

    // toString
    override fun toString(): String {
        return "Usuario(name='$name', lastname='$lastname', email='$email', isLoggedIn=$isLoggedIn, especialidad='$especialidad', CorrectionsList='$CorrectionsList')"
    }

}