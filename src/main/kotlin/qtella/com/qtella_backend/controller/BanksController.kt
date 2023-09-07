package qtella.com.qtella_backend.controller

import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import qtella.com.qtella_backend.Service.BankService
import qtella.com.qtella_backend.Service.DeleteResponse
import qtella.com.qtella_backend.model.Banks

@RestController
@RequestMapping("/api/banks")
class BanksController constructor(val bankService: BankService) {


    @ExceptionHandler(NoSuchElementException::class)
    fun handleNoElement(e:NoSuchElementException):Map<Any,Any> =
        mapOf<Any,Any>( "message" to  ResponseEntity(e.message,HttpStatus.NOT_FOUND ) )
    @ExceptionHandler(NotImplementedError::class)
    fun handleNoImplimentation(e:NotImplementedError):Map<Any,Any> =
        mapOf<Any,Any>( "message" to  ResponseEntity(e.message,HttpStatus.NOT_FOUND ) )

    @GetMapping("get_banks")
    fun getAllBanks() = mapOf<Any,Any>(
        "data" to   bankService.getBanks(),
        "message" to "Banks List Fetched"
    )
    @PostMapping("delete_banks")
    fun delete() : Map<Any,Any>{
        val res: DeleteResponse = bankService.deleteBanks()
        res.toString()

    return mapOf(
        "data" to res.response,
        "message" to res.responseMessage
    )
    }

    @GetMapping("{accountNumber}")
    fun getBankById(@PathVariable accountNumber : String) : Map<Any,Any> {
        val res: Banks = bankService.getBanksById(accountNumber=accountNumber)
       return mapOf(
           "data" to  res,
            "message" to "you're looking for data $accountNumber"
        )
    }

    @PostMapping("new_bank")
    @ResponseStatus(HttpStatus.CREATED)
    fun newBank(@RequestBody bank: Banks) :Map<Any,Any>{
        val res : Banks = bankService.addBank(bank)
        return mapOf<Any,Any>(
            "data" to  res,
            "message" to "New Bank Created"
        )
    }
}

