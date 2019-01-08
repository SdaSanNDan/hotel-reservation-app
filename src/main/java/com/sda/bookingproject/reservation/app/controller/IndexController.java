package com.sda.bookingproject.reservation.app.controller;


import com.sda.bookingproject.reservation.app.model.NewsletterModel;
import com.sda.bookingproject.reservation.app.model.SearchPropertyModel;
import com.sda.bookingproject.reservation.app.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/")
    public ModelAndView indexPage(){

//        List<TopDestinationModel> topDestinationModels = addressService.getTopDestinations();

        return new ModelAndView("index").addObject("searchPropertyModel", new SearchPropertyModel())
                .addObject("newsletter", new NewsletterModel())
                .addObject("topDestinations", addressService.getTopDestinations());
    }

    @GetMapping("/search")
    public ModelAndView searchProperty(@ModelAttribute SearchPropertyModel searchPropertyModel){

        return new ModelAndView("result");
    }

//    @GetMapping("/search")
//    public ModelAndView searchPropertyByCity(@ModelAttribute String city){
//
//        return new ModelAndView("result");
//    }

}
