package org.demo.spring.multitenancy.restApi.controllers;

import org.demo.spring.multitenancy.persistence.entities.EmployeeEntity;
import org.demo.spring.multitenancy.restApi.dtos.EmployeeDTO;
import org.demo.spring.multitenancy.restApi.dtos.ResponseDTO;
import org.demo.spring.multitenancy.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final ModelMapper modelMapper;

    @Autowired
    public EmployeeController(EmployeeService employeeService,
                              ModelMapper modelMapper) {
        this.employeeService = employeeService;
        this.modelMapper = modelMapper;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<EmployeeDTO> getById(@PathVariable("id") Long id) {
        EmployeeDTO response = modelMapper.map(employeeService.getById(id), EmployeeDTO.class);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<ResponseDTO> createEmployee(@RequestBody EmployeeDTO employee) {
        if (employee.getId() != null) {
            ResponseDTO response = new ResponseDTO(HttpStatus.BAD_REQUEST.value(), "Can't complete request, can't save new employee informing it's ID");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        EmployeeEntity entity = modelMapper.map(employee, EmployeeEntity.class);
        employeeService.save(entity);
        ResponseDTO response = new ResponseDTO(HttpStatus.CREATED.value(), "success");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<ResponseDTO> updateEmployee(@RequestBody EmployeeDTO employee) {
        if (employee.getId() == null) {
            ResponseDTO response = new ResponseDTO(HttpStatus.BAD_REQUEST.value(), "Can't complete request, can't update a employee without informing it's ID");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        EmployeeEntity entity = modelMapper.map(employee, EmployeeEntity.class);
        employeeService.save(entity);
        ResponseDTO response = new ResponseDTO(HttpStatus.OK.value(), "success");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public ResponseEntity delete(@RequestBody EmployeeDTO employee) {
        EmployeeEntity entity = modelMapper.map(employee, EmployeeEntity.class);
        employeeService.delete(entity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
