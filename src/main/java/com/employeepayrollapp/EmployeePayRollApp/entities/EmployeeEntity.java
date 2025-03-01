package com.employeepayrollapp.EmployeePayRollApp.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotBlank(message = "Name Cannot be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}" , message = "Name must start with a capital letter and be least 3 characters long")
    private String name;
    private String Department;
    private Double salary;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate joiningDate;
}
