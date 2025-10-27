package com.example.demoboot.controller;

import com.example.demoboot.model.Employee;
import com.example.demoboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/employees") // Mapping parental --> Toutes les requetes commencent par /employees"
public class EmployeeController {
    /*
     Le controller recoit et valide la requete puis il la transmet au service
     Le service recoit une requete et fait de l'algo pour satisfaire les specifications
     Le service va contruire une reponse et la renvoyer au controller. Le service demande
     au repository de persister les donnees ou le recuperer ---> correspond au SSI
     */
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/") // => GET http://localhost:8080/employees/
    @ResponseStatus(code = HttpStatus.OK) // Pour customiser mes erreurs -> gere les exceptions au besoin
    public List<Employee> getAll(){
        return employeeService.getAll();
    }

    @GetMapping("/{id}") // => GET http://localhost:8080/employees/{id}
    @ResponseStatus(code = HttpStatus.OK)
    public Employee getEmployeeById(@PathVariable("id") Integer id){
        // @PathVariable signifie que :
        // la variable id_url sera recuperee dans la requete
        // et chargee dans la methode getEmployeeById(Integer id_url)
        try{
            return employeeService.getById(id);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PostMapping("/") // L'information sera recuperee dans le body de la requete
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void create(@RequestBody Employee newEmployee){
        // @RequestBody signifie que il faudra un body :
        // l'objet newEmployee sera recupere dans le body json de la requete
        // et charge dans la methode save(Employee newEmployee)
        // le body json doit etre de structure de Employee
        employeeService.create(newEmployee);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void update(@PathVariable("id") Integer id,
                       @RequestBody Employee employeeToUptdate){
        // @PathVariable et @RequestBody vu ci-dessus
        employeeService.update(id, employeeToUptdate);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Employee delete(@PathVariable("id") Integer id){
        // @PathVariable vu ci-dessus
        return employeeService.delete(id);
    }
}
