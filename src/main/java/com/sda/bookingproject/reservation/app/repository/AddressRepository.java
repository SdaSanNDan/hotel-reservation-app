package com.sda.bookingproject.reservation.app.repository;

import com.sda.bookingproject.reservation.app.domain.AddressEntity;
import com.sda.bookingproject.reservation.app.model.TopDestinationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

    @Query("select new com.sda.bookingproject.reservation.app.model.TopDestinationModel(count(distinct a.room.property),a.city,a.country) from AddressEntity a group by a.city, a.country order by count(distinct a.room.property) desc")
    List<TopDestinationModel> findTopDestinations();

}
