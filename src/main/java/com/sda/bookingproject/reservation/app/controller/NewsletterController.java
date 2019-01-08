package com.sda.bookingproject.reservation.app.controller;


import com.sda.bookingproject.reservation.app.model.NewsletterModel;
import com.sda.bookingproject.reservation.app.service.NewsletterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class NewsletterController {

    @Autowired
    private NewsletterService newsletterService;

    @GetMapping("/newsletter")
    public ModelAndView indexPage(){

        return new ModelAndView("index")
                .addObject("newsletter", new NewsletterModel())
                .addObject("user", "SANDER");

    }

    @PostMapping("/newsletter")
    public ModelAndView insertNewsLetter(@ModelAttribute("email") final String email){

        newsletterService.insertNewsletter(email);
        return new ModelAndView("index").addObject("newsletter", new NewsletterModel());
    }

}
