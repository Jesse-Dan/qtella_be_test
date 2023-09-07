package qtella.com.qtella_backend.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import qtella.com.qtella_backend.Service.UserService
import qtella.com.qtella_backend.exceptions.PasswordWrongException
import qtella.com.qtella_backend.exceptions.UserAlreadyExistException
import qtella.com.qtella_backend.model.CustomResponse
import qtella.com.qtella_backend.model.LoginPayload
import qtella.com.qtella_backend.model.User


@RestController
@RequestMapping("/api/users")
class UserController (val service : UserService) {

    @ExceptionHandler(UserAlreadyExistException::class)
    fun userAlreadyExistException(e:UserAlreadyExistException):Map<Any,Any> =
        mapOf<Any,Any>( "error" to  ResponseEntity(e.message, HttpStatus.FORBIDDEN))

    @ExceptionHandler(HttpRequestMethodNotSupportedException::class)
    fun handleRequestError(e:HttpRequestMethodNotSupportedException):Map<Any,Any> =
        mapOf<Any,Any>( "error" to  ResponseEntity(e.message, HttpStatus.METHOD_NOT_ALLOWED))


    @ExceptionHandler(PasswordWrongException::class)
    fun handlePassowrdError(e:PasswordWrongException):Map<Any,Any> =
        mapOf<Any,Any>( "error" to  ResponseEntity(e.message, HttpStatus.METHOD_NOT_ALLOWED))


    @PostMapping("add_user")
    fun addUser(@RequestBody user: User): Map<Any,Any>{
       var res =  service.addUser(user = user)
        return mapOf<Any,Any>(
            "data" to CustomResponse(response = res, response_status = ResponseEntity("User Has been Created", HttpStatus.CREATED,)),

        )

    }

    @PostMapping("login")
    fun login(@RequestBody loginDetails : LoginPayload):Map<Any,Any>{
        var res =  service.logIn(loginPayload = loginDetails)
        return mapOf<Any,Any>(
            "data" to CustomResponse(response = res, response_status = ResponseEntity("User Has been Logged In", HttpStatus.CREATED,))
            )
    }

}