package com.sda.bookingproject.reservation.app.controller;


import com.sda.bookingproject.reservation.app.model.NewsletterModel;
import com.sda.bookingproject.reservation.app.model.PropertyModel;
import com.sda.bookingproject.reservation.app.model.SearchPropertyModel;
import com.sda.bookingproject.reservation.app.service.AddressService;
import com.sda.bookingproject.reservation.app.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/")
    public ModelAndView indexPage(){

//        List<TopDestinationModel> topDestinationModels = addressService.getTopDestinations();

        return new ModelAndView("index")
                .addObject("searchPropertyModel", new SearchPropertyModel())
                .addObject("newsletter", new NewsletterModel())
                .addObject("topDestinations", addressService.getTopDestinations());
    }

    @GetMapping("/search")
    public ModelAndView searchProperty(@ModelAttribute SearchPropertyModel searchPropertyModel){

        Page<PropertyModel> propertyModelPage = propertyService.getSearchedProperties(searchPropertyModel);

        return new ModelAndView("result")
                .addObject("searchPropertyModel", new SearchPropertyModel())
                .addObject("propertyModelPage", propertyModelPage);
    }

//    @GetMapping("/search/{city}")
//    public ModelAndView searchPropertyByCity(@PathVariable("city") String city){
//
//        return new ModelAndView("result");
//    }

}
