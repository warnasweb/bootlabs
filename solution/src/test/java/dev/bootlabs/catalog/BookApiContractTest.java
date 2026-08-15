package dev.bootlabs.catalog;

import static org.hamcrest.Matchers.startsWith;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class BookApiContractTest {
    @Autowired MockMvc mvc;

    @Test void consumerContractForCreateBook() throws Exception {
        mvc.perform(post("/api/v1/books").contentType(MediaType.APPLICATION_JSON)
                .content("""{"isbn":"9781617297571","title":"Spring in Action","author":"Craig Walls","price":54.99}"""))
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", startsWith("/api/v1/books/")))
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.isbn").value("9781617297571"))
                .andExpect(jsonPath("$.price").value(54.99));
    }
}
