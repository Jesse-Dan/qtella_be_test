package qtella.com.qtella_backend.DataSource.mock

import org.springframework.stereotype.Repository
import qtella.com.qtella_backend.DataSource.BanksDataSource
import qtella.com.qtella_backend.model.Banks


@Repository
class MockBankDataSource : BanksDataSource{
    override fun retrieveBanks(): Collection<Banks> {
        return listOf(
            Banks(accountNumber = "2308", trust = 3.6, transactionFee =10 ),
            Banks(accountNumber = "1606", trust = 2.5, transactionFee =21 ),
            Banks(accountNumber = "6402", trust = 1.447, transactionFee =4 ),
            Banks(accountNumber = "2308", trust = 3.6, transactionFee =10 ),
            Banks(accountNumber = "1606", trust = 2.5, transactionFee =21 ),
            Banks(accountNumber = "6402", trust = 1.447, transactionFee =4 ),
            Banks(accountNumber = "2308", trust = 3.6, transactionFee =10 ),
            Banks(accountNumber = "1606", trust = 2.5, transactionFee =21 ),
            Banks(accountNumber = "6402", trust = 1.447, transactionFee =4 ),
            Banks(accountNumber = "2308", trust = 3.6, transactionFee =10 ),
            Banks(accountNumber = "1606", trust = 2.5, transactionFee =21 ),
            Banks(accountNumber = "6402", trust = 1.447, transactionFee =4 ),
            Banks(accountNumber = "2308", trust = 3.6, transactionFee =10 ),
            Banks(accountNumber = "1606", trust = 2.5, transactionFee =21 ),
            Banks(accountNumber = "6402", trust = 1.447, transactionFee =4 ),
            Banks(accountNumber = "2308", trust = 3.6, transactionFee =10 ),
            Banks(accountNumber = "1606", trust = 2.5, transactionFee =21 ),
            Banks(accountNumber = "6402", trust = 1.447, transactionFee =4 ),
            Banks(accountNumber = "2308", trust = 3.6, transactionFee =10 ),
            Banks(accountNumber = "1606", trust = 2.5, transactionFee =21 ),
            Banks(accountNumber = "6402", trust = 1.447, transactionFee =4 ),
            Banks(accountNumber = "4040", trust = 94.0, transactionFee =2 )
        )
    }

    override fun deleteBanks(bankDataSource: Collection<Banks>): (MutableList<Banks>) {
        return try {
            val banks: MutableList<Banks> = bankDataSource.toMutableList()
            banks.removeAll(banks); banks
        }catch (e:Exception){
            mutableListOf(Banks(transactionFee = 0, accountNumber = "0", trust = 0.0))


        }

    }
}