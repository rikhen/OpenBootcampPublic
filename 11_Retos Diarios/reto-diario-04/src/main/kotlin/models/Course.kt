package models

class Course(var name: String, var instructor: models.Instructor) {

    // Inicializamos fuera del constructor un atributo privado
    private var studentsList: MutableList<models.Student> = arrayListOf()

    // Métodos
    fun isStudent(student: models.Student): Boolean {
        if (student in studentsList) {
            return true
        }
        return false
    }

    fun enrol(student: models.Student) {
        if (!isStudent(student)) {
            studentsList.add(student)
            println("El estudiante ${student.name} ha sido matriculado en el curso ${this.name}.")
        } else {
            println("El estudiante ${student.name} ya forma parte del curso ${this.name}.")
        }
    }

    fun unenrol(student: models.Student) {
        if (isStudent(student)) {
            studentsList.remove(student)
            println("El estudiante ${student.name} ha sido desmatriculado del curso ${this.name}.")
        } else {
            println("El estudiante ${student.name} no forma parte del curso ${this.name}.")
        }
    }

    // toString
    override fun toString(): String {
        return "Course(name='$name', instructor=$instructor, studentsList=$studentsList)"
    }

}