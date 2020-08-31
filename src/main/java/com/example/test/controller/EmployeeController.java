package com.example.test.controller;

import com.example.test.model.Employee;
import com.example.test.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeRepository repository;

    @PostMapping("/employee")
    public Employee save(@RequestBody Employee employee){
        Employee emp =null;
        try{
            repository.save(employee);
        }catch (NullPointerException e){

        }catch (Exception e){

        }
        return emp;
    }

    @PutMapping("/employee")
    public Employee update(@RequestBody Employee employee){

        Optional<Employee> emp = repository.findById(employee.getId());
        emp.get().setAge(employee.getAge());
        emp.get().setName(employee.getName());
        return repository.save(emp.get());
    }


    @GetMapping("/get-employees")
    public List<Employee> getEmployees(){
        return repository.findAll();
    }
    @GetMapping("/get-employee-by-id/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable("id")Integer id){
        return  repository.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id")Integer id){
        repository.deleteById(id);
    }


}
