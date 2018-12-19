package com.sda.bookingproject.reservation.app.controller;

import com.sda.bookingproject.reservation.app.repository.NewsLetterRepository;
import com.sda.bookingproject.reservation.app.service.NewsletterService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController("/api")
public class NewsletterController {


    @Autowired
    private NewsletterService newsletterService;


    @GetMapping("/newsletter")
    public String createNewsLetter(@RequestParam("email") String email){

       newsletterService.insertNewsletter(email);
       return email;

    }

    @GetMapping("/")
    public String getNewsletter(){

        return null;
    }

}
