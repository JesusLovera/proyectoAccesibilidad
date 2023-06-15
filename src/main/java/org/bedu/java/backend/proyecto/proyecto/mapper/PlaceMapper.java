package org.bedu.java.backend.proyecto.proyecto.mapper;
import org.bedu.java.backend.proyecto.proyecto.dto.PlaceDto;
import org.bedu.java.backend.proyecto.proyecto.model.Place;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PlaceMapper {
    PlaceMapper INSTANCE = Mappers.getMapper(PlaceMapper.class);

    @Mapping(target = "wheelChair", source = "wheelChair"/*, qualifiedByName = "mapToBoolean"*/)
    @Mapping(target = "blindFriendly", source = "blindFriendly"/*, qualifiedByName = "mapToBoolean"*/)
    Place toPlace(PlaceDto dto);

    default Boolean mapToBoolean(String value) {
        //return "Yes".equalsIgnoreCase(value);
        return value != null && value.equalsIgnoreCase("Yes");
    }
}
