package com.employeepayrollapp.EmployeePayRollApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private Integer id;
    private String name;
    private String Department;
    private Double salary;
    private LocalDate joiningDate;
}
