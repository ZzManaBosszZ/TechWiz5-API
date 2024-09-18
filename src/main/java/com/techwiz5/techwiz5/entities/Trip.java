package com.techwiz5.techwiz5.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.sql.Timestamp;
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@SuperBuilder
@Table(name = "trip")
public class Trip extends  BaseEntity{
    @Column(name = "Password", nullable = false)
    private String tripName;

    @Column(name = "Description", nullable = false)
    private String tripDescription;

    @Column(name = "budget", nullable = false)
    private BigDecimal budget;

    @Column(name = "groupSize", nullable = false)
    private Integer groupSize;

    @Column(name = "createddate")
    @CreatedDate
    private Timestamp createdDate;

    @Column(name = "modifieddate")
    @LastModifiedDate
    private Timestamp modifiedDate;

    @Column(name = "createdby")
    @CreatedBy
    private String createdBy;

    @Column(name = "modifiedby")
    @LastModifiedBy
    private String modifiedBy;
}
