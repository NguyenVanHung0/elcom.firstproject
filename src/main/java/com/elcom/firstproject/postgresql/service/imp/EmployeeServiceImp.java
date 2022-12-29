
package com.elcom.firstproject.postgresql.service.imp;

import com.elcom.firstproject.convert.Mapper;
import com.elcom.firstproject.postgresql.dto.EmployeeDto;
import com.elcom.firstproject.postgresql.model.Employee;
import com.elcom.firstproject.postgresql.repository.EmployeeRepository;
import com.elcom.firstproject.postgresql.service.EmployeeService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImp implements EmployeeService{
    
    @Autowired
    EmployeeRepository employeeRepository;
    
    @Autowired
    Mapper mapper;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        if(employeeDto == null){
            return null;
        }
        employee = mapper.toEmployee(employeeDto);
        employee.setCreatedDate(new Date());
        employeeRepository.save(employee);
        return mapper.toEmployeeDto(employee);
        
    }
    
}
