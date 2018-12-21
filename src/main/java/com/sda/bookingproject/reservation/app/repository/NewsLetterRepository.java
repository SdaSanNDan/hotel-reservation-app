package com.sda.bookingproject.reservation.app.repository;

import com.sda.bookingproject.reservation.app.domain.NewsletterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NewsLetterRepository extends JpaRepository<NewsletterEntity, Long> {

    List<NewsletterEntity> findAll();

    Optional<NewsletterEntity> findByEmail(final String email);


}
