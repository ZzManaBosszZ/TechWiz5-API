package com.techwiz5.techwiz5.mappers;

import com.techwiz5.techwiz5.dtos.trip.TripDTO;
import com.techwiz5.techwiz5.entities.Trip;
import com.techwiz5.techwiz5.exceptions.AppException;
import com.techwiz5.techwiz5.exceptions.ErrorCode;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class TripMapper {
    private final UserMapper userMapper;
    private final CategoryMapper categoryMapper;

    public TripMapper(UserMapper userMapper, CategoryMapper categoryMapper) {
        this.userMapper = userMapper;
        this.categoryMapper = categoryMapper;
    }

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
                .user(userMapper.toUserSummaryDTO(model.getUser()))
                .categories(model.getCategories().stream()
                        .map(categoryMapper::toCategoryDTO)
                        .collect(Collectors.toList()))
                .build();
        return tripDTO;
    }
}
