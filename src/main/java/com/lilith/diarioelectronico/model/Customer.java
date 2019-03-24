package com.lilith.diarioelectronico.model;

import lombok.Data;
import lombok.Generated;

@Data
public class Customer {

    @Generated
    private int id;

    private String firstname;

    private String lastname;

    public Customer(String firstname, String lastname) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Customer() {
    }
}
