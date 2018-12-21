package com.sda.bookingproject.reservation.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewsletterModel {

    private long id;
    private Date createdAt;
    @Email
    private String email;

}
