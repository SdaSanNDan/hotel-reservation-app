package com.sda.bookingproject.reservation.app.repository;


import com.sda.bookingproject.reservation.app.domain.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomPropertyRepository extends JpaRepository<AddressEntity, Long>, JpaSpecificationExecutor {
}
