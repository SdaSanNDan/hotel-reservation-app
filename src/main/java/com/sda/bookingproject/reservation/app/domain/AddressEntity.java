package com.sda.bookingproject.reservation.app.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Builder
@Data
@EntityListeners(AuditingEntityListener.class)
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String country;

    @Column
    private String city;

    @Column
    private String street;

    @Column
    private String postalCode;


    @ManyToOne(targetEntity = PropertyEntity.class)
    @JoinColumn(name="propertyId", referencedColumnName = "propertyId")
    private PropertyEntity property;
}