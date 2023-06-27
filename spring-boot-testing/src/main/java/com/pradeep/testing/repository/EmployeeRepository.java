package com.pradeep.testing.repository;

import com.pradeep.testing.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByEmail(String email);
//    @Query("select e from Employee e where e.firstName=?1 and e.lastName=?2")
//    Employee findByJPQL(String firstName, String lastName);
}
