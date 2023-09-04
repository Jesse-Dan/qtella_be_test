package qtella.com.qtella_backend.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post


@SpringBootTest
@AutoConfigureMockMvc
internal class BanksControllerTest{

    @Autowired
    lateinit var mockMvc: MockMvc


    @Test
    fun  runTest() {
        //  when
        mockMvc.get("/api/banks/get_banks")
            .andDo { print() }
            .andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("$[2].trust"){value("1.447")}
            }

        //  then

    }

    @Test
    fun  runTest2() {
        //given
        val accountNumber = "1606"

        //  when
        mockMvc.post("/api/banks/$accountNumber")
            .andDo { print() }
            .andExpect {
                content { contentType(MediaType.APPLICATION_JSON) }
                status { isOk() }
                jsonPath("$.accountNumber"){value("2.5")}
//                jsonPath("$.transactionFee"){value("21")}

            }



        //  then

    }

}