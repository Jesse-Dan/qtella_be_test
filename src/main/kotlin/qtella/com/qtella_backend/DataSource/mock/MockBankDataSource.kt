package qtella.com.qtella_backend.DataSource.mock

import org.springframework.stereotype.Repository
import qtella.com.qtella_backend.DataSource.BanksDataSource
import qtella.com.qtella_backend.model.Banks


@Repository
class MockBankDataSource : BanksDataSource{

    var banks = mutableListOf<Banks>(
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
    Banks(accountNumber = "4040", trust = 94.0, transactionFee =2 ))
    override fun retrieveBanks(): Collection<Banks> {
        return banks
    }

    override fun deleteBanks(bankDataSource: Collection<Banks>): (MutableList<Banks>) {
        return try {
            banks.removeAll(banks); banks
        }catch (e:Exception){
            mutableListOf(Banks(transactionFee = 0, accountNumber = "0", trust = 0.0))


        }

    }

    override fun getBanksById(accountNumber: String): Banks {
    return banks.firstOrNull() {it.accountNumber == accountNumber}
        ?: throw NoSuchElementException("Bank with $accountNumber was not found")
    }

    override fun addNewBank(bank: Banks): Banks {
         try {
            banks.add(bank)
             return  bank
        }catch (e:Exception){
            Banks(transactionFee = 0, accountNumber = "0", trust = 0.0)
             return bank
        }
    }
}