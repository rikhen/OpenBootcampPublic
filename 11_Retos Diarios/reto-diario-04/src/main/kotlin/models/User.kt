abstract class User(var id: Int, val name: String, val lastname: String, val email: String, var isLoggedIn: Boolean = false) {

    // METHODS
    fun login() {
        if (!isLoggedIn) {
            isLoggedIn = true
            println("Inicia sesión...")
        } else {
            println("Sesión ya está iniciado!")
        }
    }

    fun logout() {
        if (isLoggedIn) {
            isLoggedIn = false
            println("Cierra sesión...")
        } else {
            println("Sesión ya está cerrada!")
        }
    }

}