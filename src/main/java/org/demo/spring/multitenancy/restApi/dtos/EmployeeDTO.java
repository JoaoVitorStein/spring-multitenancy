package org.demo.spring.multitenancy.restApi.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {
    private Long id;

    private String name;

    private String department;
}
