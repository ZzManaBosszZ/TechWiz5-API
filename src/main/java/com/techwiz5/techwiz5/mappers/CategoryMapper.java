package com.techwiz5.techwiz5.mappers;


import com.techwiz5.techwiz5.dtos.category.CategoryDTO;
import com.techwiz5.techwiz5.entities.Category;
import com.techwiz5.techwiz5.exceptions.AppException;
import com.techwiz5.techwiz5.exceptions.ErrorCode;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public CategoryDTO toCategoryDTO(Category model){
        if (model == null) throw new AppException(ErrorCode.NOTFOUND);
        CategoryDTO categoryDTO = CategoryDTO.builder()
                .id(model.getId())
                .name(model.getName())
                .createdBy(model.getCreatedBy())
                .createdDate(model.getCreatedDate())
                .modifiedBy(model.getModifiedBy())
                .modifiedDate(model.getModifiedDate())
                .build();
        return categoryDTO;
    }
}
