package com.techwiz5.techwiz5.mappers;

import com.techwiz5.techwiz5.dtos.trip.TripDTO;
import com.techwiz5.techwiz5.entities.Trip;
import com.techwiz5.techwiz5.exceptions.AppException;
import com.techwiz5.techwiz5.exceptions.ErrorCode;
import org.springframework.stereotype.Component;

@Component
public class TripMapper {

    public TripDTO toTripDTO (Trip model){
        if (model == null) throw new AppException(ErrorCode.NOTFOUND);
        TripDTO tripDTO = TripDTO.builder()
                .id(model.getId())
                .budget(model.getBudget())
                .tripName(model.getTripName())
                .tripDescription(model.getTripDescription())
                .endDate(model.getEndDate())
                .startDate(model.getStartDate())
                .createdBy(model.getCreatedBy())
                .createdDate(model.getCreatedDate())
                .modifiedBy(model.getModifiedBy())
                .modifiedDate(model.getModifiedDate())
                .build();
        return tripDTO;
    }
}
