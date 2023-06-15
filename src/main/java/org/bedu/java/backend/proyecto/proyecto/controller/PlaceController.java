package org.bedu.java.backend.proyecto.proyecto.controller;

import org.bedu.java.backend.proyecto.proyecto.dto.PlaceDto;
import org.bedu.java.backend.proyecto.proyecto.mapper.PlaceMapper;
import org.bedu.java.backend.proyecto.proyecto.model.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.bedu.java.backend.proyecto.proyecto.service.PlaceService;

import java.util.List;

@RestController
@RequestMapping("/places")
public class PlaceController {

    private final PlaceService placeService;
    private final PlaceMapper placeMapper;

    @Autowired
    public PlaceController(PlaceService placeService, PlaceMapper placeMapper) {
        this.placeService = placeService;
        this.placeMapper = placeMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void savePlace(@RequestBody PlaceDto placeDTO) {
        Place place = placeMapper.toPlace(placeDTO);
        placeService.savePlace(place);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Place> getPlaceById(@PathVariable("id") Long id) {
        return placeService.getPlaceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Place> updatePlace(@PathVariable("id") Long id, @RequestBody Place updatedPlace) {
        return placeService.updatePlace(id, updatedPlace);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePlace(@PathVariable("id") Long id) {
        placeService.deletePlace(id);
    }

    @GetMapping
    public List<Place> getAllPlaces() {
        return placeService.getAllPlaces();
    }
}