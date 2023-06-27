package com.pradeep.testing.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pradeep.testing.model.Employee;
import com.pradeep.testing.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.CoreMatchers.is;
@WebMvcTest
public class EmployeeControllerTests {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private EmployeeService employeeService;
    @Autowired
    private ObjectMapper objectMapper;
    @Test
    public void givenEmployeeObject_whenCreateEmployee_thenReturnsSavedEmployee() throws Exception{
        //given - PreCondition

        Employee employee= Employee.builder()
                .firstName("Pradeep")
                .lastName("Kumar")
                .email("xyz@gmail.com")
                .build();
        given(employeeService.saveEmployee(any(Employee.class)))
                .willAnswer((invocation) -> invocation.getArgument(0));
        //when - action or behaviour that we are providing
        ResultActions response= mockMvc.perform((post("/api/employees"))
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(employee)));


        // then - verify the result or output
        response.andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName", is(employee.getFirstName())))
                .andExpect(jsonPath("$.lastName",is(employee.getLastName())))
                .andExpect(jsonPath("$.email", is(employee.getEmail())));

    }

    // junit test for Get All employees
    @Test
    public void givenListEployees_whenGetAllEmployees_thenReturnEmployeeList() throws Exception {
            // given - precondition or setup
        List<Employee> listOfEmployees= new ArrayList<>();
        listOfEmployees.add(Employee.builder().firstName("Pradeep").lastName("Kumar").email("xyz@gmail.com").build());
        listOfEmployees.add(Employee.builder().firstName("Rahul").lastName("Dravid").email("rahul@gmail.com").build());
        given(employeeService.getAllEmployees()).willReturn(listOfEmployees);
            // when - action or behaviour
          ResultActions response=   mockMvc.perform(get("/api/employees"));
            // then - verify
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()",
                        is(listOfEmployees.size())));

        }


        // Junit test for positive scenario get Employee by id
    @Test
    public void givenEmployeeId_whenGetEmployeeById_thenReturnEmployeeObjectById() throws Exception {
            // given - precondition or setup
        long employeeId=1L;
        Employee employee= Employee.builder()
                .firstName("Pradeep")
                .lastName("Kumar")
                .email("xyz@gmail.com")
                .build();
        given(employeeService.getEmployeeById(employeeId)).willReturn(Optional.of(employee));
            // when - action or behaviour
       ResultActions response= mockMvc.perform(get("/api/employees/{id}", employeeId));
            // then - verify
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.firstName", is(employee.getFirstName())))
                .andExpect(jsonPath("$.lastName", is(employee.getLastName())))
                .andExpect(jsonPath("$.email", is(employee.getEmail())));
        }
    // Junit test for get Employee by id
    @Test
    public void givenInvalidEmployeeId_whenGetEmployeeById_thenReturnInvalidEmployeeObjectById() throws Exception {
        // given - precondition or setup
        long employeeId=1L;
        Employee employee= Employee.builder()
                .firstName("Pradeep")
                .lastName("Kumar")
                .email("xyz@gmail.com")
                .build();
        given(employeeService.getEmployeeById(employeeId)).willReturn(Optional.empty());
        // when - action or behaviour
        ResultActions response= mockMvc.perform(get("/api/employees/{id}", employeeId));
        // then - verify
        response.andExpect(status().isNotFound())
                .andDo(print());
    }
    //Junit test for updated employee poisitive scenario
    @Test
    public void givenUpdateEmployee_whenUpdatedEmploee_thenReturnUpdatedObject() throws Exception {
            // given - precondition or setup
        long employeeId=1L;
        Employee savedemployee= Employee.builder()
                .firstName("Pradeep")
                .lastName("Kumar")
                .email("qwerty@gmail.com")
                .build();
        Employee updatedemployee= Employee.builder()
                .firstName("Prakhush")
                .lastName("Yadav")
                .email("xyz@gmail.com")
                .build();

        given(employeeService.getEmployeeById(employeeId)).willReturn(Optional.of(savedemployee));
        given(employeeService.updateEmployee(any(Employee.class)))
                .willAnswer((invocation)->invocation.getArgument(0));
            // when- action or behaviour
//     ResultActions response=mockMvc.perform(put("/api/employees/{id}",employeeId)
        ResultActions response = mockMvc.perform(put("/api/employees/{id}", employeeId)
             .contentType(MediaType.APPLICATION_JSON)
             .content(objectMapper.writeValueAsString(updatedemployee)));
            // then - verify
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.firstName", is(updatedemployee.getFirstName())))
                .andExpect(jsonPath("$.lastName",is(updatedemployee.getLastName())))
                .andExpect(jsonPath("$.email", is(updatedemployee.getEmail())));
        }

        //Junit test for updated employee negative scenario
        @Test
        public void givenUpdateEmployee_whenUpdatedEmploee_thenReturn404Negative() throws Exception {
            // given - precondition or setup
            long employeeId=1L;
            Employee savedemployee= Employee.builder()
                    .firstName("Pradeep")
                    .lastName("Kumar")
                    .email("qwerty@gmail.com")
                    .build();
            Employee updatedemployee= Employee.builder()
                    .firstName("Prakhush")
                    .lastName("Yadav")
                    .email("xyz@gmail.com")
                    .build();

            given(employeeService.getEmployeeById(employeeId)).willReturn(Optional.empty());
            given(employeeService.updateEmployee(any(Employee.class)))
                    .willAnswer((invocation)->invocation.getArgument(0));
            // when- action or behaviour
//     ResultActions response=mockMvc.perform(put("/api/employees/{id}",employeeId)
            ResultActions response = mockMvc.perform(put("/api/employees/{id}", employeeId)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(updatedemployee)));
            // then - verify
            response.andExpect(status().isNotFound())
                    .andDo(print());

        }
        // Junit test for delete employee
    @Test
        public void givenEmployeeId_whenDeleteEmployeeById_thenReturn200() throws Exception {
                // given - precondition or setup
              long employeeId=1L;
              willDoNothing().given(employeeService).deleteEmployee(employeeId);
                // when - action or behaviour
        ResultActions response=   mockMvc.perform(delete("/api/employees/{id}",employeeId));
                // then - verify
        response.andExpect(status().isOk())
                .andDo(print());
            }
}










