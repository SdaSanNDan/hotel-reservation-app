package com.sda.bookingproject.reservation.app.service;

import com.sda.bookingproject.reservation.app.converter.NewsletterEntityToModelConverter;
import com.sda.bookingproject.reservation.app.domain.NewsletterEntity;
import com.sda.bookingproject.reservation.app.model.NewsletterModel;
import com.sda.bookingproject.reservation.app.repository.NewsLetterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NewsletterService {

    @Autowired
    private NewsLetterRepository newsLetterRepository;

    @Autowired
    private NewsletterEntityToModelConverter newsletterEntityToModelConverter;

    public void insertNewsletter(final String email){

        Optional<NewsletterEntity> checkedEmail = newsLetterRepository.findByEmail(email);

        if(!checkedEmail.isPresent()) {
            newsLetterRepository.save(NewsletterEntity.builder().email(email).build());
        }
    }

    public List<NewsletterEntity> getAllNewsletterEntities() {

        return newsLetterRepository.findAll();

    }

    public List<NewsletterModel> getAllNewsletters() {

        List<NewsletterEntity> newsletterEntities = newsLetterRepository.findAll();

        return newsletterEntities.stream().map(newsletterEntityToModelConverter::toModel).collect(Collectors.toList());
    }

    public void removeNewsletter(String email) {



        Optional<NewsletterEntity> newsletterEntity = newsLetterRepository.findByEmail(email);

        if(newsletterEntity.isPresent()) newsLetterRepository.delete(newsletterEntity.get());

    }

    public NewsletterModel getNewsLetterById(final Long id) {

        Optional<NewsletterEntity> newsletterEntity = newsLetterRepository.findById(id);
        if(newsletterEntity.isPresent()) {

           return newsletterEntityToModelConverter.toModel(newsletterEntity.get());
        }
       return NewsletterModel.builder().build();
    }

    public void updateNewsletter(NewsletterModel newsletterModel) {

        Optional<NewsletterEntity> currentNewsletterEntity = newsLetterRepository.findById(newsletterModel.getId());

        if(currentNewsletterEntity.isPresent()){
            NewsletterEntity newNewsletterEntity = currentNewsletterEntity.get();
            newNewsletterEntity.setEmail(newsletterModel.getEmail());
            newsLetterRepository.save(newNewsletterEntity);
        }

    }
}
