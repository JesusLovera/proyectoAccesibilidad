package org.bedu.java.backend.proyecto.proyecto.mapper;

import org.bedu.java.backend.proyecto.proyecto.dto.PlaceDto;
import org.bedu.java.backend.proyecto.proyecto.model.Place;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PlaceMapperTest {
    private final PlaceMapper placeMapper = Mappers.getMapper(PlaceMapper.class);
    @Test
    @DisplayName("Prueba de mapeo de strings a booleanos")
    public void testToPlaceMapping() {
        // Create a PlaceDTO with sample data
        PlaceDto placeDTO = new PlaceDto();
        placeDTO.setName("Sample Place");
        placeDTO.setCategory("Category");
        placeDTO.setPhone("123456789");
        placeDTO.setWheelChair("Yes");
        placeDTO.setBlindFriendly("No");

        // Map the PlaceDTO to Place
        Place place = placeMapper.toPlace(placeDTO);

        // Assert the mapping results
        assertEquals(placeDTO.getName(), place.getName());
        assertEquals(placeDTO.getCategory(), place.getCategory());
        assertEquals(placeDTO.getPhone(), place.getPhone());
        assertEquals(true, place.getWheelChair());
        assertEquals(false, place.getBlindFriendly());
    }

}