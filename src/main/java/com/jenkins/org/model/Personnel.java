package com.jenkins.org.model;

import java.util.UUID;

import com.jenkins.org.util.AddressConverter;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

@Table(name = "personnel")

public class Personnel {
    @Id
    private UUID id;

    @PrePersist

    public void prePersist() {

        if (id == null) {

            id = UUID.randomUUID();

        }

    }

    @Nonnull
    private String firstName;
    @Nonnull
    private String lastName;
    @Nonnull
    private String email;
    @Nonnull
    private String mobile;
    @Convert(converter = AddressConverter.class)
    private Address address; 
    @Nonnull
    private String profession;

}

