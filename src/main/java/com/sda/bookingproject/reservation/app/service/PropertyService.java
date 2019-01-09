package com.sda.bookingproject.reservation.app.service;

import com.sda.bookingproject.reservation.app.converter.EntityToModelConverter;
import com.sda.bookingproject.reservation.app.domain.AddressEntity;
import com.sda.bookingproject.reservation.app.model.PropertyModel;
import com.sda.bookingproject.reservation.app.model.SearchPropertyModel;
import com.sda.bookingproject.reservation.app.repository.CustomPropertyRepository;
import com.sda.bookingproject.reservation.app.repository.PropertyRepository;
import com.sda.bookingproject.reservation.app.repository.specification.PropertySpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private EntityToModelConverter entityToModelConverter;

    @Autowired
    private CustomPropertyRepository customPropertyRepository;

    public List<PropertyModel> getAllPropertie(){

        return entityToModelConverter.propertyEntitiesToModels(propertyRepository.findAll());
    }

    public Page<PropertyModel> getSearchedProperties(final SearchPropertyModel searchPropertyModel){

        List<AddressEntity> addressEntities = customPropertyRepository
                .findAll(PropertySpecification.prepareSearchPropertyQuery(searchPropertyModel));

        List<PropertyModel>propertyModels = entityToModelConverter
                .addressEntitiesToPropertyModels(addressEntities);


        return new PageImpl<>(propertyModels, PageRequest.of(0, 10), propertyModels.size());



    }
}
