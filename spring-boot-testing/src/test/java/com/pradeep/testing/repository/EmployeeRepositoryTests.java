package com.pradeep.testing.repository;

import com.pradeep.testing.model.Employee;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
public class EmployeeRepositoryTests {
    @Autowired
    private EmployeeRepository employeeRepository;

    // JUnit Test case for save employee
    @Test
    @DisplayName("JUNIT test for employee operation")
    public void givenEmployeeObject_whenSave_thenReturnSavedEmployee() {
        // given -precondition or setup
        Employee employee = Employee.builder()
                .firstName("Pradeep")
                .lastName("Kumar")
                .email("pfm110820@gmail.com")
                .build();

        // when - action or behaviour thart we are test
        Employee savedEmployee = employeeRepository.save(employee);


        //then - verify the output
        assertThat(savedEmployee).isNotNull();
        assertThat(savedEmployee.getId()).isGreaterThan(0);
    }

    // JUnit test for
    @Test
    public void givenEmployeeList_whenFindAll_thenEmployeeList() {
        // given - precondition or setup
        Employee employee = Employee.builder()
                .firstName("Pradeep")
                .lastName("Kumar")
                .email("pfm110820@gmail.com")
                .build();
        Employee employee1 = Employee.builder()
                .firstName("Prakhush")
                .lastName("Yadav")
                .email("erpky@gmail.com")
                .build();
        employeeRepository.save(employee);
        employeeRepository.save(employee1);
        // when - action or the behaviour
        List<Employee> employeeList = employeeRepository.findAll();
        // then - verify
        assertThat(employeeList).isNotNull();
        assertThat(employeeList.size()).isEqualTo(2);
    }

    // Junit test for get employee by id
    @Test
    public void givenEmployeeObject_whenfindById_thenReturnEmployeeObject() {
        // given - precondition or setup
        Employee employee = Employee.builder()
                .firstName("Pradeep")
                .lastName("Kumar")
                .email("pfm110820@gmail.com")
                .build();
        employeeRepository.save(employee);
        // when- action or behaviour
        Employee employeeDB = employeeRepository.findById(employee.getId()).get();
        // then - verify
        assertThat(employeeDB).isNotNull();
    }

    // JUNIT test to get employee email operation
    @DisplayName("JUNIT test to get employee email operation")
    @Test
    public void givenEmployeeEmail_whenFindByEmail_thenReturnEmploeeObject() {
        // given - precondition or setup
        Employee employee = Employee.builder()
                .firstName("Pradeep")
                .lastName("Kumar")
                .email("pfm110820@gmail.com")
                .build();
        employeeRepository.save(employee);
        // when- action or behaviour
        Employee employeeDB = employeeRepository.findByEmail(employee.getEmail()).get();
        // then - verify
        assertThat(employeeDB).isNotNull();
    }

    // JUNIT test for update employee operation
    @Test
    @DisplayName("JUNIT test for update employee operation")
    public void givenEmployeeObject_whenUpdateEmployee_thenReturnUpdatedEmployee() {
        // given - precondition or setup
        Employee employee = Employee.builder()
                .firstName("Pradeep")
                .lastName("Kumar")
                .email("pfm110820@gmail.com")
                .build();
        employeeRepository.save(employee);
        // when - action or behaviour
        Employee savedEmployee = employeeRepository.findById(employee.getId()).get();
        savedEmployee.setEmail("pfm@gmail.com");
        savedEmployee.setFirstName("Pradip");
        Employee updatedEmployee = employeeRepository.save(savedEmployee);
        // then - verify
        assertThat(updatedEmployee.getEmail()).isEqualTo("pfm@gmail.com");
        assertThat(updatedEmployee.getFirstName()).isEqualTo("Pradip");
    }

    @Test
    @DisplayName("JUNIT test for update employee operation")
    public void givenEmployeeObject_whenDeleteEmployee_thenReturnDeleteEmployee() {
        // given - precondition or setup
        Employee employee = Employee.builder()
                .firstName("Pradeep")
                .lastName("Kumar")
                .email("pfm110820@gmail.com")
                .build();
        employeeRepository.save(employee);
        // when - action or behaviour
        employeeRepository.delete(employee);
        Optional<Employee> employeeOptional = employeeRepository.findById(employee.getId());
        // then - verify
        assertThat(employeeOptional.isEmpty());
    }

    @DisplayName("JUNIT test for JPQL employee operation")
    @Test
    public void givenFirstNameANDLastName_whenFindByJPQL_thenEmployeeObject() {
        // given - precondition or setup
        Employee employee = Employee.builder()
                .firstName("Pradeep")
                .lastName("Kumar")
                .email("pfm110820@gmail.com")
                .build();
        employeeRepository.save(employee);
        String firstName = "Pradeep";
        String lastName = "Kumar";

//            // when- action or behaviour
//        Employee savedEmployee=employeeRepository.findByJPQL(firstName,lastName);
//            // then - verify
//        assertThat(savedEmployee).isNotNull();
//        }

    }
}
