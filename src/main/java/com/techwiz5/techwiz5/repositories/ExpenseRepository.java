package com.techwiz5.techwiz5.repositories;

import com.techwiz5.techwiz5.entities.Category;
import com.techwiz5.techwiz5.entities.Expense;
import com.techwiz5.techwiz5.entities.Trip;
import com.techwiz5.techwiz5.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findAllByUser(User user);
    List<Expense> findByTripIdAndDateBetween(Long tripId, Timestamp startDate, Timestamp endDate);
}
