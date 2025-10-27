package com.example.centreformation.controller;

import com.example.centreformation.entity.Personne;
import com.example.centreformation.service.PersonneService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/personnes")
public class PersonneController {
    
    private final PersonneService personneService;
    
    public PersonneController(PersonneService personneService) {
        this.personneService = personneService;
    }
    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Personne> findAll(){
        return this.personneService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Personne findById(@PathVariable Long id){
        return this.personneService.findById(id);
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Personne create(@RequestBody Personne personne){
        return this.personneService.create(personne);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void update(@PathVariable Long id,@RequestBody Personne personne){
        if(!id.equals(personne.getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "wrond id and personne");
        }
        this.personneService.update(personne);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Personne delete(@PathVariable Long id){
        return this.personneService.delete(id);
    }
}
