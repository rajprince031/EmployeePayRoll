package com.employeepayrollapp.EmployeePayRollApp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

   private String name;
    private String Department;
    private Double salary;
    private LocalDate joiningDate;
}
