package com.techwiz5.techwiz5.services.impl;

import com.techwiz5.techwiz5.dtos.expense.ExpenseDTO;
import com.techwiz5.techwiz5.entities.Expense;
import com.techwiz5.techwiz5.entities.Trip;
import com.techwiz5.techwiz5.entities.User;
import com.techwiz5.techwiz5.exceptions.AppException;
import com.techwiz5.techwiz5.exceptions.ErrorCode;
import com.techwiz5.techwiz5.mappers.ExpenseMapper;
import com.techwiz5.techwiz5.models.expense.CreateExpense;
import com.techwiz5.techwiz5.models.expense.EditExpense;
import com.techwiz5.techwiz5.repositories.ExpenseRepository;
import com.techwiz5.techwiz5.repositories.TripRepository;
import com.techwiz5.techwiz5.services.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IExpenseService implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final ExpenseMapper expenseMapper;
    private final TripRepository tripRepository;

    @Override
    public List<ExpenseDTO> findAll() {
        return expenseRepository.findAll().stream().map(expenseMapper::toExpenseDTO).collect(Collectors.toList());
    }

    @Override
    public List<ExpenseDTO> findAllByUser(User user) {
        List<Expense> categories = expenseRepository.findAllByUser(user);
        return categories.stream()
                .map(expenseMapper::toExpenseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ExpenseDTO create(CreateExpense createExpense, User user) {
        Trip trip = tripRepository.findById(createExpense.getTripId())
                .orElseThrow(() -> new AppException(ErrorCode.TRIP_NOTFOUND));
        Expense expense = Expense.builder()
                .amountExpense(createExpense.getAmountExpense())
                .expenseCategory(createExpense.getExpenseCategory())
                .note(createExpense.getNote())
                .trip(trip)
                .user(user)
                .createdBy(user.getFullName())
                .modifiedBy(user.getFullName())
                .createdDate(new Timestamp(System.currentTimeMillis()))
                .modifiedDate(new Timestamp(System.currentTimeMillis()))
                .build();
        expenseRepository.save(expense);
        return expenseMapper.toExpenseDTO(expense);
    }

    @Override
    public ExpenseDTO update(EditExpense editExpense, User user) {
       Expense expense = expenseRepository.findById(editExpense.getId())
                .orElseThrow(() -> new AppException(ErrorCode.CATEGORY_NOTFOUND));
        Trip trip = tripRepository.findById(editExpense.getTripId())
                .orElseThrow(() -> new AppException(ErrorCode.TRIP_NOTFOUND));
        expense.setAmountExpense(editExpense.getAmountExpense());
        expense.setNote(editExpense.getNote());
        expense.setExpenseCategory(editExpense.getExpenseCategory());
        if (!expense.getTrip().getId().equals(editExpense.getTripId()))
        {
            expense.setTrip(trip);
        }
        expense.setCreatedBy(user.getFullName());
        expense.setModifiedBy(user.getFullName());
        expense.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        expense.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        expenseRepository.save(expense);
        return expenseMapper.toExpenseDTO(expense);
    }

    @Override
    public void delete(Long[] ids) {
        expenseRepository.deleteAllById(List.of(ids));
    }
}
