package com.pradeep.testing.service;

import com.pradeep.testing.exception.ResourceNotFoundException;
import com.pradeep.testing.model.Employee;
import com.pradeep.testing.repository.EmployeeRepository;
import com.pradeep.testing.service.impl.EmployeeServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

//import static org.hamcrest.Matchers.any;
//import static org.mockito.BDDMockito.given;
////import static org.mockito.Mockito.never;
////import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.*;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.BDDMockito.willDoNothing;
//import static org.mockito.Mockito.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTests {

    @Mock
    private EmployeeRepository employeeRepository;
   @InjectMocks
    private EmployeeServiceImpl employeeService;
    private Employee employee;

   @BeforeEach
   public void setUp() {
       //employeeRepository= Mockito.mock(EmployeeRepository.class);
       //employeeService= new EmployeeServiceImpl(employeeRepository);

       // Mock test for saveEmployee
       employee = Employee.builder()
               .id(1L)
               .firstName("Pradeep")
               .lastName("Kumar")
               .email("abc@gmail.com")
               .build();
   }
    @DisplayName("Mock test for saveEmployeeService")
    @Test
    public void givenEmployeeObject_whenSavedEmployee_thenReturnEmployeeObject(){
            // given - precondition or setup

        given(employeeRepository.findByEmail(employee.getEmail()))
                .willReturn(Optional.empty());
                      //  .willReturn(Optional.of(employee)); // for throw Exception
        given(employeeRepository.save(employee)).willReturn(employee);
        System.out.println(employeeRepository.toString());
        System.out.println(employeeService.toString());
        // when- action or behaviour
        Employee savedEmployee=employeeService.saveEmployee(employee);
        System.out.println(savedEmployee.toString());
        // then - verify
        Assertions.assertThat(savedEmployee).isNotNull();
    }
    @DisplayName("Mock test for saveEmployeeService throw Exception")
    @Test
    public void givenEmployeeEmailExistingException_whenSavedEmployee_thenReturnEmailExistingExcep(){
        // given - precondition or setup

        given(employeeRepository.findByEmail(employee.getEmail()))
                //.willReturn(Optional.empty());
                .willReturn(Optional.of(employee)); // for throw Exception
       // given(employeeRepository.save(employee)).willReturn(employee);
        System.out.println(employeeRepository.toString());
        System.out.println(employeeService.toString());
        // when- action or behaviour
       // Employee savedEmployee=employeeService.saveEmployee(employee);
        org.junit.jupiter.api.Assertions.assertThrows(ResourceNotFoundException.class,
                ()->{
            employeeService.saveEmployee(employee);
                });
        // then - verify
        verify(employeeRepository, never()).save(any(Employee.class));

    }

}



