package com.employeepayrollapp.EmployeePayRollApp.repositories;


import com.employeepayrollapp.EmployeePayRollApp.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
}
