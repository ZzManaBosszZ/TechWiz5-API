package com.techwiz5.techwiz5.dtos.trip;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class TripDTO {
    private int tripID;
    private String tripName;
    private String tripDescription;
    private Integer groupSize;
    private BigDecimal budget;
    private Timestamp createdDate;
    private Timestamp modifiedDate;
    private String createdBy;
    private String modifiedBy;
}
