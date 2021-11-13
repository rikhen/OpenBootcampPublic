package models

/**
 * OpenBootcamp - Reto diario 05
 * Child class administrator of the clase user
 * @author Rikhen
 * @version 1.0
 */

import models.User
import kotlin.system.exitProcess

// Extend user class with administrator class
class Administrator(id: Int, role: String, name: String, lastname: String, email: String) :
    User(id, role, name, lastname, email) {

    // METHODS
    fun exploitBootcamp() {
        println("The administrator ${this.name} has decided to exploit Bootcamp and abort the program.")
        exitProcess(0);
    }

    override fun toString(): String {
        return "User(id='$id', role='$role', name='$name', lastname='$lastname', email='$email', isLoggedIn=$isLoggedIn)"
    }



}