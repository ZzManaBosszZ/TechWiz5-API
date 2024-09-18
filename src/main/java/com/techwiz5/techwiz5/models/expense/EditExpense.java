package com.techwiz5.techwiz5.models.expense;

import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditExpense {
    private long id;
    private String expenseCategory;
    private String note;
    private BigDecimal amountExpense;
    private long tripId;
}
