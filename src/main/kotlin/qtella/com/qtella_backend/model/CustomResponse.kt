package qtella.com.qtella_backend.model

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

data class CustomResponse(
    var response:Any,
    var response_status: ResponseEntity<Any>

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CustomResponse

        if (response != other.response) return false
        if (response_status != other.response_status) return false

        return true
    }

    override fun hashCode(): Int {
        var result = response.hashCode()
        result = 31 * result + response_status.hashCode()
        return result
    }

    override fun toString(): String {
        return "CustomResponse(response=$response, response_status=$response_status)"
    }
}
