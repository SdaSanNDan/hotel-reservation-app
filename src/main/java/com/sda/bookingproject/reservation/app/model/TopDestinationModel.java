package com.sda.bookingproject.reservation.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TopDestinationModel {
    private long amount;
    private String city;
    private String country;
}
