package org.bedu.java.backend.proyecto.proyecto.dto;

import lombok.Data;

@Data
public class PlaceDto {
    private Long id;
    private String name;
    private String category;
    private String phone;
    private String address;
    private String wheelChair;
    private String blindFriendly;
}
