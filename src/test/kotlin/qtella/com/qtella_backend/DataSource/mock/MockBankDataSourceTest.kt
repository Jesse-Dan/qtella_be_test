package qtella.com.qtella_backend.DataSource.mock

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class MockBankDataSourceTest{
private val mockBankDataSource :MockBankDataSource = MockBankDataSource()

    @Test
    fun  should() {
        //  when
        val banks = mockBankDataSource.retrieveBanks()

        //  then
        assertThat(banks.size).isGreaterThanOrEqualTo(3)

    }
    @Test
    fun  shouldNotBeEmpty(){

        //  when
        val banks = mockBankDataSource.retrieveBanks()

        //  then
        assertThat(banks).allMatch {it.accountNumber.isNotBlank()}
        assertThat(banks).anyMatch {it.trust != 0.0}
        assertThat(banks).allMatch {it.transactionFee != 0}

    }
}