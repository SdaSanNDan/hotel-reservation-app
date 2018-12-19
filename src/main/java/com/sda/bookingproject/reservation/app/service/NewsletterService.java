package com.sda.bookingproject.reservation.app.service;

import com.sda.bookingproject.reservation.app.domain.NewsletterEntity;
import com.sda.bookingproject.reservation.app.repository.NewsLetterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsletterService {

    @Autowired
    private NewsLetterRepository newsLetterRepository;

    public void insertNewsletter(final String email){

        newsLetterRepository.save(NewsletterEntity.builder().email(email).build());

    }

}
