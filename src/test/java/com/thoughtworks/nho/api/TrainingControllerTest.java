package com.thoughtworks.nho.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TrainingControllerTest {

    @Autowired
    private WebApplicationContext wac;

    protected MockMvc mockMvc;


    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    void should_greeting_to_server_side() throws Exception {
//        TrainingDTO trainingDTO = TrainingDTO.builder().title("testTitle").description("testDescription").build();
//
//        mockMvc.perform(post("/api/training")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(new ObjectMapper().writeValueAsString(trainingDTO)))
//                .andExpect(status().isOk());
    }
}
