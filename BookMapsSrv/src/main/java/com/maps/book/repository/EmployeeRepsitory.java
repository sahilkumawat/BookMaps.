package com.maps.book.repository;

import com.maps.book.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepsitory extends JpaRepository<Employee,Long> {
    //crud
}
