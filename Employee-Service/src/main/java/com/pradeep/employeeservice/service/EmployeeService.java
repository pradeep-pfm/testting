package com.pradeep.employeeservice.service;

import com.pradeep.employeeservice.dto.APIResponseDto;
import com.pradeep.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    APIResponseDto getEmployeeById(Long employeeId);
}
