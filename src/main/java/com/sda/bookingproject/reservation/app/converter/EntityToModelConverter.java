package com.sda.bookingproject.reservation.app.converter;

import com.sda.bookingproject.reservation.app.domain.AddressEntity;
import com.sda.bookingproject.reservation.app.domain.NewsletterEntity;
import com.sda.bookingproject.reservation.app.domain.PropertyEntity;
import com.sda.bookingproject.reservation.app.domain.RoomEntity;
import com.sda.bookingproject.reservation.app.model.AddressModel;
import com.sda.bookingproject.reservation.app.model.NewsletterModel;
import com.sda.bookingproject.reservation.app.model.PropertyModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
public class EntityToModelConverter {
    public NewsletterModel newsletterEntityToModel(NewsletterEntity newsletterEntity) {

        return NewsletterModel.builder()
                .id(newsletterEntity.getId())
                .email(newsletterEntity.getEmail())
                .createdAt(newsletterEntity.getCreatedOn())
                .build();

    }

    public List<PropertyModel> propertyEntitiesToModels(List<PropertyEntity> propertyEntities){

        List<PropertyModel> propertyModels = new ArrayList<>();
        for (PropertyEntity propertyEntity : propertyEntities){
            List<AddressModel> addressModels = new ArrayList<>();
            for (RoomEntity roomEntity : propertyEntity.getRooms()){
                addressModels.add(AddressModel.builder().addressId(roomEntity.getAddress().getId()).street(roomEntity.getAddress().getStreet())
                .postalCode(roomEntity.getAddress().getPostalCode()).city(roomEntity.getAddress().getCity()).country(roomEntity.getAddress().getCountry()).build());
            }
            propertyModels.add(PropertyModel.builder().addressModels(addressModels).propertyId(propertyEntity.getPropertyId())
                    .startsFrom(propertyEntity.getStartsFrom()).propertyName(propertyEntity.getPropertyName()).build());
        }


        return propertyModels;
    }

    public List<PropertyModel> addressEntitiesToPropertyModels(final List<AddressEntity> addressEntities){
        List<PropertyModel> propertyModels = new ArrayList<>();
        for (AddressEntity addressEntity : addressEntities){
            PropertyModel propertyModel = new PropertyModel();
            propertyModel.setPropertyId(addressEntity.getRoom().getProperty().getPropertyId());
            propertyModel.setPropertyName(addressEntity.getRoom().getProperty().getPropertyName());
            propertyModel.setStartsFrom(addressEntity.getRoom().getProperty().getStartsFrom());

            AddressModel addressModel = new AddressModel();
            addressModel.setAddressId(addressEntity.getId());
            addressModel.setCity(addressEntity.getCity());
            addressModel.setCountry(addressEntity.getCountry());
            addressModel.setPostalCode(addressEntity.getPostalCode());
            addressModel.setStreet(addressEntity.getStreet());
            propertyModel.getAddressModels().add(addressModel);

            propertyModels.add(propertyModel);
        }
        return propertyModels.stream().filter(distinctBy(p -> p.getPropertyName())).collect(Collectors.toList());
        }


    public static <T> Predicate<T> distinctBy (Function<? super T, ? > f) {
        Set<Object> objects = new HashSet<>();
        return t -> objects.add(f.apply(t));
    }
}
