package com.sda.bookingproject.reservation.app.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressModel {

    private Long addressId;

    private String country;

    private String city;

    private String street;

    private String postalCode;

    private RoomModel room;

    private PropertyModel property;
}
