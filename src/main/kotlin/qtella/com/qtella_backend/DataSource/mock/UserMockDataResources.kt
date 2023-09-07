package qtella.com.qtella_backend.DataSource.mock

import org.springframework.stereotype.Repository
import qtella.com.qtella_backend.DataSource.UserInterface
import qtella.com.qtella_backend.exceptions.PasswordWrongException
import qtella.com.qtella_backend.exceptions.UserAlreadyExistException
import qtella.com.qtella_backend.exceptions.UserDoesNotExistException
import qtella.com.qtella_backend.exceptions.UserUnKnownError
import qtella.com.qtella_backend.model.Gender
import qtella.com.qtella_backend.model.LoginPayload
import qtella.com.qtella_backend.model.User


@Repository
class UserMockDataResources:UserInterface {

    private val users :MutableList<User> = mutableListOf<User>(
        User(id = 1, fullName="Jesse Dan", email="jessedan160@gmail.com", phoneNumber= 906881439, gender= Gender.Male, age=23, password="jesse"),
        User(id = 2, fullName="Finn Amuda", email="finnamuda@gmail.com", phoneNumber= 808775597, gender= Gender.Female, age=18,password="dannie")
        )


    override fun createAccount(user: User): User {
        if (users.contains(user)){
            throw UserAlreadyExistException(message = "user ${user.toString()} Already Exists" , cause = Throwable(message = user.toString()) )
        }else{
            users.add(user)
            return user;
        }
    }

    override fun deleteAccount(user: User): String {
        TODO("Not yet implemented")
    }

    override fun editAccount(user: User): User {
        TODO("Not yet implemented")
    }

    override fun getAllUsers(): MutableList<User> {
        TODO("Not yet implemented")
    }


    override fun login(loginPayload: LoginPayload): User {
       val user : User? =  getSingleUser(loginPayload = loginPayload)
        return if(user?.password != loginPayload.password){
            throw PasswordWrongException(message ="Password is Incorrect" , cause = Throwable(message = loginPayload.toString()))
        }else {
            user
        }

    }



    fun getSingleUser(loginPayload:LoginPayload) : User? =  users.firstOrNull(){ it.email == loginPayload.email} ?:
    throw UserDoesNotExistException(message ="User ${loginPayload.email} does not Exist" , cause = Throwable(message = loginPayload.toString()) )


}
