package com.example.grid;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GridController.class)
public class GridControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GridService service;  // Mock service (no repo needed)

    @Test
    public void testGenerateGridDefault() throws Exception {
        when(service.saveRequest(any(GridRequest.class))).thenReturn(new GridRequest());
        mockMvc.perform(get("/grid"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(" 0 ")));
    }

    @Test
    public void testGenerateGridCustom() throws Exception {
        when(service.saveRequest(any(GridRequest.class))).thenReturn(new GridRequest());
        mockMvc.perform(get("/grid")
                        .param("width", "2")
                        .param("length", "2")
                        .param("depth", "2"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(" 3 ")));
    }
}