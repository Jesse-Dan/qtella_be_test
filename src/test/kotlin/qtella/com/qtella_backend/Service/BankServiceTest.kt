package qtella.com.qtella_backend.Service

import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import qtella.com.qtella_backend.DataSource.BanksDataSource

internal class BankServiceTest{

    private var bankDataSource:BanksDataSource = mockk(relaxed = true)

    private var bankService: BankService  = BankService(dataSource = bankDataSource)

    @Test
    fun  shouldNotBeEmpty(){
        //  when
        bankService.getBanks()

        //  then
       verify(exactly = 1) { bankDataSource.retrieveBanks() }

    }

}