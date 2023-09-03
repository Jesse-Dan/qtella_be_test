package qtella.com.qtella_backend.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import qtella.com.qtella_backend.DataSource.BanksDataSource
import qtella.com.qtella_backend.DataSource.mock.MockBankDataSource
import qtella.com.qtella_backend.Service.BankService
import qtella.com.qtella_backend.model.Banks


@RestController
@RequestMapping("api/greet")
class HelloWorldController {
    var bank = Banks(accountNumber = "009492838488", trust = 3.23, transactionFee = 300)
    var  bankDataSource :  BanksDataSource  = MockBankDataSource()
    var  bankService :  BankService  =  BankService(dataSource = bankDataSource)
    var banksController :  BanksController  =  BanksController(bankService= bankService)



    @GetMapping
    fun getString()=
            "<h2>Account Number: ${bank.accountNumber}</h1><br>" +
            "<h1>Bank Trust:  ${bank.trust}</h1><br>" +
            "<h1>Transaction Fee: ${bank.transactionFee}</h1>"


}