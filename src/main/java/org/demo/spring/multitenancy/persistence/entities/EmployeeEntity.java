package org.demo.spring.multitenancy.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "employee")
public class EmployeeEntity {
    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="employee_sequence")
    @SequenceGenerator(allocationSize=1,  name="employee_sequence", sequenceName = "employee_sequence")
    private Long id;

    @Column
    private String name;

    @Column
    private String department;

}
