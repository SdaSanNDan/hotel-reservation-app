package com.sda.bookingproject.reservation.app.converter;

import com.sda.bookingproject.reservation.app.domain.NewsletterEntity;
import com.sda.bookingproject.reservation.app.model.NewsletterModel;
import org.springframework.stereotype.Component;

@Component
public class NewsletterEntityToModelConverter {
    public NewsletterModel toModel(NewsletterEntity newsletterEntity) {

        return NewsletterModel.builder()
                .id(newsletterEntity.getId())
                .email(newsletterEntity.getEmail())
                .createdAt(newsletterEntity.getCreatedOn())
                .build();

    }
}
