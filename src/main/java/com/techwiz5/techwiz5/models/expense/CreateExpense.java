package com.techwiz5.techwiz5.models.expense;

import jakarta.persistence.Column;
import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateExpense {
    private String expenseCategory;
    private String note;

    private BigDecimal amountExpense;
}
