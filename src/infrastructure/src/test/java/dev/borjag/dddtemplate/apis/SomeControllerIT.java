package dev.borjag.dddtemplate.apis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext
public class SomeControllerIT {

    @Autowired
    protected MockMvc mockMvc;

    @Test
    void create_resource_for_a_valid_request() throws Exception {
        String body = "{\n" +
                "  \"name\": \"dummyName\",\n" +
                "  \"date\": \"01/01/2020\"\n" +
                "}";

        mockMvc.perform(
                post("/api/v1/resources")
                        .param("gateway", "redsys")
                        .content(body)
                        .contentType(APPLICATION_JSON)
        )
        .andExpect(status().isCreated())
        .andExpect(content().json(
        "{\"resourceId\":\"dummyId\"}"
        ));
    }

    @Test
    void not_allow_missing_request_fields() throws Exception {
        String body = "{\n" +
                "  \"name\": \"dummyName\"\n" +
                "}";

        mockMvc.perform(
                post("/api/v1/resources")
                        .param("gateway", "redsys")
                        .content(body)
                        .contentType(APPLICATION_JSON)
        )
        .andExpect(status().isBadRequest());
    }

}
