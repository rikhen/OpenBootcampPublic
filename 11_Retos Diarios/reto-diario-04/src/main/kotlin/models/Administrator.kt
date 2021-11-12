package models

import User
import kotlin.system.exitProcess

// Iniciamos clase extendida de Usuario con constructor principal
class Administrator(id: Int, name: String, lastname: String, email: String) :
    User(id, name, lastname, email) {

    fun explotarBootcamp() {
        println("El administrador ${this.name} ha decidido explotar el Bootcamp y abortar el programa.")
        exitProcess(0);
    }

    override fun toString(): String {
        return "Usuario(name='$name', lastname='$lastname', email='$email', isLoggedIn=$isLoggedIn, idAdmin='$id')"
    }

}