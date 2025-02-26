package com.employeepayrollapp.EmployeePayRollApp.controllers;


import com.employeepayrollapp.EmployeePayRollApp.dto.EmployeeDTO;
import com.employeepayrollapp.EmployeePayRollApp.entities.EmployeeEntity;
import com.employeepayrollapp.EmployeePayRollApp.services.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class EmployeeController {

    private final EmployeeService employeeService;


    public static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Integer id){
        logger.info("get employee details by id");
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody EmployeeEntity employeeEntity){
        logger.info("Create new employee");
        return employeeService.createNewEmployee(employeeEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployeeDetails(@PathVariable Integer id ,@RequestBody EmployeeEntity employeeEntity){
        logger.info("update existing employee");
        return employeeService.updateEmployeeDetails(id ,employeeEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EmployeeDTO> deleteEmployee(@PathVariable Integer id){
        logger.info("delete employee");
        return employeeService.deleteEmployee(id);
    }
}
