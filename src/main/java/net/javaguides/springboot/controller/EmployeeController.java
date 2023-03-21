package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repositiory.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

     @Autowired
    private EmployeeRepository employeeRepository;

     @GetMapping
     public List<Employee> getAllEmployees(){
         return employeeRepository.findAll();
     }

     //build create employee REST API
     @PostMapping
     public  Employee createEmployee(@RequestBody Employee employee){
      return  employeeRepository.save(employee);
     }

     //Build get Employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
         Employee employee = employeeRepository.findById(id).orElseThrow
                 (()-> new RuntimeException("Employee not Exists with that id:"+id));
         return ResponseEntity.ok(employee);
    }

    //Build update  Employee  REST API
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails){
     Employee updateEmployee = employeeRepository.findById(id)
             .orElseThrow(() -> new RuntimeException("Employee not Exists with that id:"+id));

     updateEmployee.setFirstName(employeeDetails.getFirstName());
     updateEmployee.setLastName(employeeDetails.getLastName());
     updateEmployee.setEmail(employeeDetails.getEmail());

     employeeRepository.save(updateEmployee);

     return ResponseEntity.ok(updateEmployee);
    }

    //Build delete  Employee  REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){
         Employee employee = employeeRepository.findById(id)
                 .orElseThrow(() -> new RuntimeException("Employee not Exists with that id:"+id));

         employeeRepository.delete(employee);

         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
