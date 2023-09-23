package com.github.fevralevanton.T1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fevralevanton.T1.exception.WrongStringException;
import com.github.fevralevanton.T1.service.SymbolCountService;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SymbolCountControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    SymbolCountService service;

    @Test
    void countsCorrectString () throws Exception {
        mockMvc.perform(get("http://localhost:8080/count/?string=aaaasssccscd")).andExpect(status()
                .isOk()).andExpect(content().string("\"a\": 4, \"s\": 4, \"c\": 3, \"d\": 1"));
    }

    @Test
    void ifStringIsWrongThrowsException () throws Exception {
        mockMvc.perform(get("http://localhost:8080/count/?string=!@#")).andExpect(status().isBadRequest()).
                andExpect(result -> assertTrue(result.getResolvedException() instanceof WrongStringException))
                .andExpect(result -> assertEquals("Строка не соответствует шаблону, введите корректную строку",
                        result.getResolvedException().getMessage()));
    }




}