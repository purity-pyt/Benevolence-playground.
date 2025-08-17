package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.transaction.annotation.Transactional

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class HelloControllerSpec extends spock.lang.Specification {

    @Autowired
    MockMvc mvc

    def "GET /api/hello returns greeting"() {
        expect:
        mvc.perform(get("/api/hello"))
           .andExpect(status().isOk())
           .andExpect(content().string("Hello Benevolence!"))
    }

    def "POST then GET users works"() {
        when:
            mvc.perform(post("/api/users")
               .contentType("application/json")
               .content('{"name":"Alice"}'))
               .andExpect(status().isOk())

        then:
            mvc.perform(get("/api/users"))
               .andExpect(status().isOk())
               .andExpect(content().string(org.hamcrest.Matchers.containsString("Alice")))
    }
}
