package org.demo.spring.multitenancy.service;

import org.demo.spring.multitenancy.persistence.entities.EmployeeEntity;
import org.demo.spring.multitenancy.persistence.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Cacheable(value = "employee")
    public EmployeeEntity getById(Long id) {
        Optional<EmployeeEntity> employee = employeeRepository.findById(id);
        return employee.orElse(null);
    }

    @CacheEvict(value = "employee", key = "#p0.id")
    public void save(EmployeeEntity employee) {
        employeeRepository.save(employee);
    }

    @CacheEvict(value = "employee", key = "#p0.id")
    public void delete(EmployeeEntity employee) {
        employeeRepository.delete(employee);
    }

}
