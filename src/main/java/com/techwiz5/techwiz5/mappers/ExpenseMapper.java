package com.techwiz5.techwiz5.mappers;

import com.techwiz5.techwiz5.dtos.category.CategoryDTO;
import com.techwiz5.techwiz5.dtos.expense.ExpenseDTO;

import com.techwiz5.techwiz5.entities.Expense;
import com.techwiz5.techwiz5.exceptions.AppException;
import com.techwiz5.techwiz5.exceptions.ErrorCode;
import org.springframework.stereotype.Component;

@Component
public class ExpenseMapper {
    private final TripMapper tripMapper;
    private final UserMapper userMapper;
    public ExpenseMapper(TripMapper tripMapper, UserMapper userMapper) {
        this.tripMapper = tripMapper;
        this.userMapper = userMapper;
    }

    public ExpenseDTO toExpenseDTO(Expense model){
        if (model == null) throw new AppException(ErrorCode.NOTFOUND);
        ExpenseDTO expenseDTO = ExpenseDTO.builder()
                .id(model.getId())
                .amountExpense(model.getAmountExpense())
                .expenseCategory(model.getExpenseCategory())
                .note(model.getNote())
                .trip(tripMapper.toTripDTO(model.getTrip()))
                .user(userMapper.toUserSummaryDTO(model.getUser()))
                .createdBy(model.getCreatedBy())
                .createdDate(model.getCreatedDate())
                .modifiedBy(model.getModifiedBy())
                .modifiedDate(model.getModifiedDate())
                .build();
        return expenseDTO;
    }
}
