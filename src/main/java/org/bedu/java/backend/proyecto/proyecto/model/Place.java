package org.bedu.java.backend.proyecto.proyecto.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
@Table(name="PLACE")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "El nombre es un campo obligatorio.")
    private String name;
    @NotBlank(message = "La categoria es un campo obligatorio.")
    private String category;
    @Pattern(regexp = "^\\d{2}[- ]?\\d{4}[- ]?\\d{4}$", message = "El teléfono debe tener un formato de ##-####-####")
    private String phone;
    @NotBlank(message = "La dirección es un campo obligatorio.")
    private String address;
    private Boolean wheelChair;
    private Boolean blindFriendly;

}
