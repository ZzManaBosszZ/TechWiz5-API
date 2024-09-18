package com.techwiz5.techwiz5.controllers;

import com.techwiz5.techwiz5.dtos.ResponseObject;
import com.techwiz5.techwiz5.dtos.expense.ExpenseDTO;
import com.techwiz5.techwiz5.entities.User;
import com.techwiz5.techwiz5.models.expense.CreateExpense;
import com.techwiz5.techwiz5.models.expense.EditExpense;
import com.techwiz5.techwiz5.services.ExpenseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class ExpenseController {
    private final ExpenseService expenseService;

    @GetMapping("/any/expense")
    ResponseEntity<ResponseObject> getAll() {
        List<ExpenseDTO> list = expenseService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(true, 200, "ok", list)
        );
    }
    @GetMapping("/expense")
    ResponseEntity<ResponseObject> getAllByUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) auth.getPrincipal();
        List<ExpenseDTO> list = expenseService.findAllByUser(currentUser);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(true, 200, "ok", list)
        );
    }
    @PostMapping("/expense")
    ResponseEntity<ResponseObject> create(@Valid @RequestBody CreateExpense createExpense) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) auth.getPrincipal();
         ExpenseDTO expenseDTO= expenseService.create(createExpense, currentUser);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(true, 200, "Create Success", expenseDTO)
        );
    }
    @PutMapping("/expense")
    ResponseEntity<ResponseObject> update(@Valid @RequestBody EditExpense editExpense) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) auth.getPrincipal();
        ExpenseDTO expenseDTO = expenseService.update(editExpense, currentUser);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(true, 200, "Update Success", expenseDTO)
        );
    }

    @DeleteMapping("/expense")
    ResponseEntity<ResponseObject> update(@RequestBody Long[] ids) {
        expenseService.delete(ids);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject(true, 200, "Delete success", "")
        );
    }
}
