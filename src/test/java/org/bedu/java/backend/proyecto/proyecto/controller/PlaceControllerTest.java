package org.bedu.java.backend.proyecto.proyecto.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bedu.java.backend.proyecto.proyecto.dto.PlaceDto;
import org.bedu.java.backend.proyecto.proyecto.service.PlaceService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@AutoConfigureRestDocs
class PlaceControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlaceService placeService;


    @Test
    @DisplayName("Save")
    public void save() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/places")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"KM 118\",\"category\":\"Cafeteria\",\"phone\":\"1234567899\",\"address\":\"No1 col x\",\"wheelChair\":\"Yes\",\"blindFriendly\":\"Yes\"}"))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

}
