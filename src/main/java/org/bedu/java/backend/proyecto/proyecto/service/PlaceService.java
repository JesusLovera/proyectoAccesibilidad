package org.bedu.java.backend.proyecto.proyecto.service;

import org.bedu.java.backend.proyecto.proyecto.model.Place;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.bedu.java.backend.proyecto.proyecto.persistence.PlaceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceService {
    private static PlaceRepository placeRepository ;
    @Autowired
    public PlaceService(PlaceRepository placeRepository){
        this.placeRepository=placeRepository;
    }
    public static void  savePlace(Place place) {
        String formatedPhone=place.getPhone();
        formatedPhone=formatPhoneNumber(formatedPhone);
        place.setPhone(formatedPhone);
        placeRepository.save(place);
        //System.out.println(place.getName() + " ha sido agregado");
    }

    public List<Place> getAllPlaces() {
        return placeRepository.findAll();
    }

    public Optional<Place> getPlaceById(Long id) {
        return placeRepository.findById(id);
    }

    public ResponseEntity<Place> updatePlace(Long id, Place updatedPlace) {
        Optional<Place> optionalPlace = placeRepository.findById(id);
        if (optionalPlace.isPresent()) {
            Place place = optionalPlace.get();
            place.setName(updatedPlace.getName());
            place.setCategory(updatedPlace.getCategory());
            place.setPhone(updatedPlace.getPhone());
            place.setAddress(updatedPlace.getAddress());
            place.setWheelChair(updatedPlace.getWheelChair());
            place.setBlindFriendly(updatedPlace.getBlindFriendly());
            placeRepository.save(place);
            return ResponseEntity.ok(place);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public void deletePlace(Long id) {
        Optional<Place> optionalPlace = placeRepository.findById(id);

        optionalPlace.ifPresent(place -> placeRepository.delete(place));
    }


    private static boolean isValidPhoneNumber(String telefono) {
        // Phone number regex pattern
        String phonePattern = "^\\d{2}[- ]?\\d{4}[- ]?\\d{4}$";
        if (digitsOnly(telefono).length() != 10) {
            return false;
        }
        return telefono.matches(phonePattern);
    }
    private static String digitsOnly(String telefono){
        String digitsOnly = telefono.replaceAll("[^\\d]", "");
        return  digitsOnly;
    }
    private static String formatPhoneNumber(String telefono) {
        String formattedPhoneNumber = digitsOnly(telefono); // Remove non-digit characters
        formattedPhoneNumber = formattedPhoneNumber.replaceFirst("(\\d{2})(\\d{4})(\\d{4})", "$1-$2-$3"); // Format phone number
        return formattedPhoneNumber;
    }
}
