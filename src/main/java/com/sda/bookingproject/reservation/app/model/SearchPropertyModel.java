package com.sda.bookingproject.reservation.app.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchPropertyModel {

    private String destination;
    private Date checkInDate;
    private Date checkOutDate;
    private BigDecimal startsFrom;
    private int rooms;
    private int adults;
    private int children;
}
