package com.sda.bookingproject.reservation.app.controller;

import com.sda.bookingproject.reservation.app.domain.NewsletterEntity;
import com.sda.bookingproject.reservation.app.model.NewsletterModel;
import com.sda.bookingproject.reservation.app.repository.NewsLetterRepository;
import com.sda.bookingproject.reservation.app.service.NewsletterService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@Data
@RestController
@RequestMapping("/api")
public class NewsletterRestController {


    @Autowired
    private NewsletterService newsletterService;


    @GetMapping("/newsletter")
    public HttpStatus createNewsLetter(@RequestParam("email") String email) {

        newsletterService.insertNewsletter(email);

        return HttpStatus.OK;
    }


    @GetMapping(value = "/newsletters")
    public List<NewsletterModel> getNewsletters() {

        return newsletterService.getAllNewsletters();
    }

    @PostMapping("/newsletter")
    public HttpStatus addNewsLetter(@RequestParam("email") final String email) {

        newsletterService.insertNewsletter(email);


        return HttpStatus.OK;

    }

    @PutMapping("/newsletter")
    public HttpStatus updateNewsletterById(@Valid @RequestBody final NewsletterModel newsletterModel){

        newsletterService.updateNewsletter(newsletterModel);

        return HttpStatus.OK;

    }

    @DeleteMapping("/newsletter/remove/{email}")
    public HttpStatus removeNewsletter(@PathVariable("email") String email) {

        newsletterService.removeNewsletter(email);

        return HttpStatus.OK;
    }

    @GetMapping("/newsletter/{id}")
    public NewsletterModel getNewsletterById(@PathVariable("id") final Long id) {


        return newsletterService.getNewsLetterById(id);
    }

}
