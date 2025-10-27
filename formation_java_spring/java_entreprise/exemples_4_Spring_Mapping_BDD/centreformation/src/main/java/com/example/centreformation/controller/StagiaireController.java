package com.example.centreformation.controller;

import com.example.centreformation.entity.Stagiaire;
import com.example.centreformation.service.StagiaireService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stagiaires")
public class StagiaireController {

    private final StagiaireService stagiaireService;

    public StagiaireController(StagiaireService stagiaireService) {
        this.stagiaireService = stagiaireService;
    }

    @GetMapping("")
    public List<Stagiaire> getAllStagiaire(){
        return this.stagiaireService.findAllStagiaire();
    }
}
