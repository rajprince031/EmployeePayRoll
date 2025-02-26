package com.employeepayrollapp.EmployeePayRollApp.services;


import com.employeepayrollapp.EmployeePayRollApp.dto.EmployeeDTO;
import com.employeepayrollapp.EmployeePayRollApp.entities.EmployeeEntity;
import com.employeepayrollapp.EmployeePayRollApp.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.time.LocalDate;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);
    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    //get the employee details by id
    public ResponseEntity<EmployeeDTO> getEmployeeById(Integer id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElse(null);
        if(employeeEntity == null){
            logger.warn("Employee is not exist with id : {}",id);
            return new ResponseEntity<>(HttpStatusCode.valueOf(404));
        }
        logger.info("Employee Details fetched successfully.");
        return new ResponseEntity<EmployeeDTO>(modelMapper.map(employeeEntity,EmployeeDTO.class),HttpStatusCode.valueOf(200));
    }

    //Create new employee
    public ResponseEntity<EmployeeDTO> createNewEmployee(EmployeeEntity employeeEntity) {
        if(employeeEntity == null) {
            logger.warn("Employee details is null");
            return new ResponseEntity<EmployeeDTO>(HttpStatusCode.valueOf(400));
        }
        EmployeeDTO employeeDTO = modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class);
        logger.info("new employee created successfully.");
        return new ResponseEntity<EmployeeDTO>(employeeDTO,HttpStatusCode.valueOf(200));
    }

    //Update the employee details
    public ResponseEntity<EmployeeDTO> updateEmployeeDetails(Integer id, EmployeeEntity employeeEntity) {
        System.out.println("I am post method");
        EmployeeEntity employee = employeeRepository.findById(id).orElse(null);
        if(employee == null){
            logger.warn("Employee do not exist with id : {}",id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        employeeRepository.save(employeeEntity);
        logger.info("Employee Details is update successfully.");
        return new ResponseEntity<EmployeeDTO>(modelMapper.map(employeeEntity,EmployeeDTO.class),HttpStatusCode.valueOf(200));
    }

    //Delete the employee
    public ResponseEntity<EmployeeDTO> deleteEmployee(Integer id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElse(null);
        if(employeeEntity == null){
            logger.warn("Employee do not exist with id : {}",id);
            return new ResponseEntity<>(HttpStatusCode.valueOf(404));
        }
        employeeRepository.deleteById(id);
        employeeEntity = employeeRepository.findById(id).orElse(null);
        if(employeeEntity != null){
            logger.warn("Something Wet Wrong");
            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }

        logger.info("Employee details deleted successfully");
        return new ResponseEntity<EmployeeDTO>(modelMapper.map(employeeEntity,EmployeeDTO.class),HttpStatusCode.valueOf(200));
    }
}
