package com.sda.bookingproject.reservation.app.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PropertyModel {

    private Long propertyId;

    private String propertyName;

    private String propertyDescription;

    private BigDecimal startsFrom;

    private String resultPageImageUrl;

    private List<String> mediaLinks;

    private List<AddressModel> addressModels = new ArrayList<>();

    private List<RoomModel> rooms = new ArrayList();

    private List<String> amenities;

}
