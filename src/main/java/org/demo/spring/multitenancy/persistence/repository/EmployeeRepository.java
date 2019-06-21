package org.demo.spring.multitenancy.persistence.repository;

import org.demo.spring.multitenancy.persistence.entities.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {
}
