package com.sda.bookingproject.reservation.app.service;

import com.sda.bookingproject.reservation.app.model.TopDestinationModel;
import com.sda.bookingproject.reservation.app.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;


    public List<TopDestinationModel> getTopDestinations(){

        List<TopDestinationModel> topDestinationModels = addressRepository.findTopDestinations();

        return topDestinationModels.size() > 8 ? topDestinationModels.subList(0,7) : topDestinationModels;
    }

}
