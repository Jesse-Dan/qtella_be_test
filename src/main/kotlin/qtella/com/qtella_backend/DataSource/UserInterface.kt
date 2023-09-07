package qtella.com.qtella_backend.DataSource

import qtella.com.qtella_backend.model.LoginPayload
import qtella.com.qtella_backend.model.User

interface UserInterface {

    fun createAccount(user:User):User

    fun deleteAccount(user:User):String

    fun editAccount(user:User):User

    fun getAllUsers():MutableList<User>


    fun login(loginPayload: LoginPayload):User

}