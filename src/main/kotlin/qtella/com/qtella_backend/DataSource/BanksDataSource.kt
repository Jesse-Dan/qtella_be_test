package qtella.com.qtella_backend.DataSource

import qtella.com.qtella_backend.model.Banks

interface BanksDataSource {

    fun retrieveBanks() :Collection<Banks>

    fun deleteBanks(bankDataSource: Collection<Banks>) : MutableList<Banks>

    fun getBanksById(accountNumber: String) : Banks
    abstract fun addNewBank(bank: Banks): Banks

}