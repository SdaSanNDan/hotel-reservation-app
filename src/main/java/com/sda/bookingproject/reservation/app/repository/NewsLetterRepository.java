package com.sda.bookingproject.reservation.app.repository;

import com.sda.bookingproject.reservation.app.domain.NewsletterEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsLetterRepository extends CrudRepository<NewsletterEntity, Long> {

    public List<NewsletterEntity> findAll();


}
