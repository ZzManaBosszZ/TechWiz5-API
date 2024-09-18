package com.techwiz5.techwiz5.dtos.trip;

import com.techwiz5.techwiz5.dtos.UserDTO;
import com.techwiz5.techwiz5.dtos.category.CategoryDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TripDTO {
    private long id;
    private String tripName;
    private String tripDescription;
    private Integer groupSize;
    private BigDecimal budget;
    private Integer endDate;
    private Integer startDate;
    private CategoryDTO category;
    private Timestamp createdDate;
    private Timestamp modifiedDate;
    private String createdBy;
    private String modifiedBy;
}
