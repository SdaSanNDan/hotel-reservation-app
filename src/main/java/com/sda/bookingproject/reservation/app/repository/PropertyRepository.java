package com.sda.bookingproject.reservation.app.repository;

import com.sda.bookingproject.reservation.app.domain.PropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<PropertyEntity, Long> {
}
