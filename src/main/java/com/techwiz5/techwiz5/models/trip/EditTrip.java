package com.techwiz5.techwiz5.models.trip;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class EditTrip {
    private Long id;
    private String tripName;
    private String tripDescription;
    private BigDecimal budget;
    private Integer groupSize;

}
