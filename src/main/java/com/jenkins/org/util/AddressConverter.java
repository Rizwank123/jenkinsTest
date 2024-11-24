package com.jenkins.org.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jenkins.org.model.Address;
import org.hibernate.mapping.AttributeContainer;
import org.hibernate.mapping.Property;
import org.hibernate.mapping.Table;


import jakarta.persistence.AttributeConverter;

public class AddressConverter implements AttributeConverter<Address, String> {

	private static final ObjectMapper objectMapper = new ObjectMapper();


    @Override

    public String convertToDatabaseColumn(Address address) {

        if (address == null) {

            return null;

        }

        try {

            return objectMapper.writeValueAsString(address);

        } catch (Exception e) {

            throw new RuntimeException("Error converting Address to JSON", e);

        }

    }


    @Override

    public Address convertToEntityAttribute(String addressJson) {

        if (addressJson == null) {

            return null;

        }

        try {

            return objectMapper.readValue(addressJson, Address.class);

        } catch (Exception e) {

            throw new RuntimeException("Error converting JSON to Address", e);

        }

    }
}


	