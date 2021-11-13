package models
/**
 * OpenBootcamp - Reto diario 05
 * Class user
 * @author Rikhen
 * @version 1.0
 */

abstract class User(var id: Int, var role: String, val name: String, val lastname: String, val email: String, var isLoggedIn: Boolean = false) {

    // METHODS
    fun login() {
        if (!isLoggedIn) {
            isLoggedIn = true
            println("Log in as ${this.name}...")
        } else {
            println("${this.name} is already logged in!")
        }
    }

    fun logout() {
        if (isLoggedIn) {
            isLoggedIn = false
            println("Log out ${this.name}...")
        } else {
            println("${this.name} is already logged out!")
        }
    }

}