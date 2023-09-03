package qtella.com.qtella_backend.DataSource

import qtella.com.qtella_backend.model.Banks

interface BanksDataSource {

    fun retrieveBanks() :Collection<Banks>

    fun deleteBanks(bankDataSource: Collection<Banks>) : MutableList<Banks>

}