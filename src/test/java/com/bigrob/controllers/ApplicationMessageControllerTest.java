package com.bigrob.controllers;

import com.bigrob.models.ManagedMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@SpringBootTest(classes = {ApplicationMessageController.class, ManagedMessage.class}, properties = "logging.level.com.bigrob=debug")
@AutoConfigureMockMvc(addFilters = false)
public class ApplicationMessageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHappyPathDataCall() throws Exception {
        MvcResult result = mockMvc.perform(get("/")
                    .contentType(MediaType.APPLICATION_JSON_VALUE)):wq
                    .andDo(print())
                    .andReturn();

        assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    }


}
