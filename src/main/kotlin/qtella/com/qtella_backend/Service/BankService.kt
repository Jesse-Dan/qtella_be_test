package qtella.com.qtella_backend.Service

import org.springframework.stereotype.Service
import qtella.com.qtella_backend.DataSource.BanksDataSource
import qtella.com.qtella_backend.model.Banks


@Service
class BankService(val dataSource: BanksDataSource){
    fun getBanks(): Collection<Banks> = dataSource.retrieveBanks()

    fun deleteBanks(): DeleteResponse {
        val response: MutableList<Banks>  = dataSource.deleteBanks(bankDataSource = getBanks().toList())
            return if (response.isNotEmpty())
                DeleteResponse(responseMessage = "Error Deleting Banks [LIST IS MESSED UP]", response = response)

            else DeleteResponse(responseMessage = "Banks Successfully Deleted", response = response)

    }

    fun getBanksById(accountNumber: String): Banks = dataSource.getBanksById(accountNumber)
    fun addBank(bank: Banks): Banks = dataSource.addNewBank(bank)


}

data class DeleteResponse(
    val responseMessage :String,
    val response: Any,
) {
    override fun toString(): String {
        return "DeleteResponse(responseMessage='$responseMessage', response=$response)"
    }
}