package de.adesso.junitinsights

import de.adesso.junitinsights.extensions.SpringInsightExtension
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders

@ExtendWith(SpringInsightExtension::class)
@SpringBootTest
@AutoConfigureMockMvc
class AnotherHelloControllerTest {

    @Autowired
    lateinit var mvc : MockMvc

    @Test
    fun getHello() {
        println("### Test 1 started ###")
        mvc.perform(MockMvcRequestBuilders
                .get("/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Greetings from Spring Boot!")))
    }

    @Test
    fun getAnotherHello() {
        println("### Test 2 started ###")
        mvc.perform(MockMvcRequestBuilders
                .get("/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Greetings from Spring Boot!")))
    }

}