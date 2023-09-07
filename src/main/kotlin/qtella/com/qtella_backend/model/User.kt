package qtella.com.qtella_backend.model

import java.net.PasswordAuthentication

data class User(
    val id          : Int,
    val fullName    : String,
    val email       : String,
    val phoneNumber : Int,
    val gender      : Gender,
    val age         : Int,
    val password: String,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (id != other.id) return false
        if (fullName != other.fullName) return false
        if (email != other.email) return false
        if (phoneNumber != other.phoneNumber) return false
        if (gender != other.gender) return false
        if (age != other.age) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + fullName.hashCode()
        result = 31 * result + email.hashCode()
        result = 31 * result + phoneNumber.hashCode()
        result = 31 * result + gender.hashCode()
        result = 31 * result + age
        return result
    }

    override fun toString(): String {
        return "User(id=$id, fullName='$fullName', email='$email', phoneNumber=$phoneNumber, gender=$gender, age=$age)"
    }
}

enum class Gender { Male,Female}