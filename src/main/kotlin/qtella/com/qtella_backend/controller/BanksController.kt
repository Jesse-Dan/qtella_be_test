package qtella.com.qtella_backend.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import qtella.com.qtella_backend.Service.BankService
import qtella.com.qtella_backend.Service.DeleteResponse
import qtella.com.qtella_backend.model.Banks

@RestController
@RequestMapping("/api/banks")
class BanksController constructor(val bankService: BankService) {




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
}

