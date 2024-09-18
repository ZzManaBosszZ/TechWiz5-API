package com.techwiz5.techwiz5.dtos.trip;

import com.techwiz5.techwiz5.dtos.UserDTO;
import com.techwiz5.techwiz5.dtos.category.CategoryDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TripDTO {
    private long id;
    private String tripName;
    private String destination;
    private Integer groupSize;
    private BigDecimal budget;
    private UserDTO user;
    private List<CategoryDTO> categories;
    private Timestamp endDate;
    private Timestamp startDate;
    private Timestamp createdDate;
    private Timestamp modifiedDate;
    private String createdBy;
    private String modifiedBy;
}
