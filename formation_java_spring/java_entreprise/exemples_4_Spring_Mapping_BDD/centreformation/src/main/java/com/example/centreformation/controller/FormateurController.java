package com.example.centreformation.controller;

import com.example.centreformation.entity.Formateur;
import com.example.centreformation.service.FormateurService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/formateurs")
public class FormateurController {

    private final FormateurService formateurService;

    public FormateurController(FormateurService formateurService) {
        this.formateurService = formateurService;
    }

    @GetMapping("")
    public List<Formateur> getAllFormateur(){
        return this.formateurService.findAllFormateur();
    }
}
