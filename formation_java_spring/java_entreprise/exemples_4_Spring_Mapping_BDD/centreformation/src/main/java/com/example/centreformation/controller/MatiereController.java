package com.example.centreformation.controller;

import com.example.centreformation.entity.Matiere;
import com.example.centreformation.service.MatiereService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/matieres")
public class MatiereController {
    
    private final MatiereService matiereService;

    public MatiereController(MatiereService matiereService) {
        this.matiereService = matiereService;
    }

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Matiere> findAll(){
        return this.matiereService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Matiere findById(@PathVariable Long id){
        return this.matiereService.findById(id);
    }

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Matiere create(@RequestBody Matiere matiere){
        return this.matiereService.create(matiere);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void update(@PathVariable Long id,@RequestBody Matiere matiere){
        if(!id.equals(matiere.getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "wrond id and matiere");
        }
        this.matiereService.update(matiere);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Matiere delete(@PathVariable Long id){
        return this.matiereService.delete(id);
    }
}
