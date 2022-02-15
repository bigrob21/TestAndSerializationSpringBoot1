package com.bigrob.controllers;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.TestPropertySources;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@Slf4j
@WebMvcTest({ApplicationMessageController.class})
@TestPropertySources(
        @TestPropertySource(properties = "logging.level.com.bigrob=debug")
)
public class ApplicationMessageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHappyPathDataCall() throws Exception {
        MvcResult result = mockMvc.perform(get("/")
                    .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andDo(print())
                    .andReturn();

        assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
        assertNotNull(result.getResponse().getContentAsString());
        log.debug("> {}",result.getResponse().getContentAsString());
    }


}
