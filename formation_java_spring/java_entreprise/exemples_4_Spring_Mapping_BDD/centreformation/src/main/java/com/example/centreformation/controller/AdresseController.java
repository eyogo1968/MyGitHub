package com.example.centreformation.controller;

import com.example.centreformation.entity.Adresse;
import com.example.centreformation.service.AdresseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/adresses")
public class AdresseController {

    private final AdresseService adresseService;

    public AdresseController(AdresseService adresseService) {
        this.adresseService = adresseService;
    }

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Adresse> findAll(){
        return this.adresseService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Adresse findById(@PathVariable Long id){
        return this.adresseService.findById(id);
    }

    @GetMapping("/personne/{id}")
    public Adresse findByPersonne(@PathVariable Long id){
        return this.adresseService.findByPersonne(id);
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Adresse create(@RequestBody Adresse adresse){
        return this.adresseService.create(adresse);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void update(@PathVariable Long id,@RequestBody Adresse adresse){
        if(!id.equals(adresse.getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "wrond id and adress");
        }
        this.adresseService.update(adresse);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Adresse delete(@PathVariable Long id){
        return this.adresseService.delete(id);
    }
}
