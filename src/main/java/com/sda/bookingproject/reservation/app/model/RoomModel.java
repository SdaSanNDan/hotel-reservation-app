package com.sda.bookingproject.reservation.app.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoomModel {
    private Long roomId;
    private String roomName;
    private String includes;
    private int maximumPerson;
    private BigDecimal pricePerNight;
    private PropertyModel property;

}
