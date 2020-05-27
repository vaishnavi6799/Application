package com.employee.Application.repositories;
import com.employee.Application.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


public interface DepartmentRepository extends CrudRepository<Department, Integer> {

}
