package com.example.fouille.service;

import com.example.fouille.entity.Fouille;
import com.example.fouille.entity.FouillePK;
import com.example.fouille.repository.FouilleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class FouilleService {

    private final FouilleRepository fouilleRepository;
    @Autowired
    private ParcelleService parcelleService;
    @Autowired
    private EquipeService equipeService;

    public FouilleService(FouilleRepository fouilleRepository) {
        this.fouilleRepository = fouilleRepository;
    }
    public List<Fouille> findAll() {
        return fouilleRepository.findAll();
    }

    // GET("/equipe/{eq}/parcelle/{parc}/date/date)
    public Fouille findById(FouillePK fouillePK) {
        Optional<Fouille> optionalFouille = fouilleRepository.findById(fouillePK);
        if (optionalFouille.isPresent()){
            return optionalFouille.get();
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public Fouille create(Fouille item) {
        // besoin de verifier existance de ma parcelle
        if (! parcelleService.existById(item.getParcelleId())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "parcelle not found with id : "+item.getParcelleId());
        }
        //besoin de verifier existance de mon equipe
        if (! equipeService.existById(item.getEquipeId())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "equipe not found with id : "+item.getEquipeId());
        }
        return fouilleRepository.save(item);
    }

    @Transactional
    public void update(Fouille item) {
        // besoin de verifier existance de ma parcelle
        if (! parcelleService.existById(item.getParcelleId())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "parcelle not found with id : "+item.getParcelleId());
        }
        //besoin de verifier existance de mon equipe
        if (! equipeService.existById(item.getEquipeId())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "equipe not found with id : "+item.getEquipeId());
        }
        // recuperer id de fouille
        FouillePK fouille_id = new FouillePK();
        fouille_id.setEquipeId(item.getEquipeId());
        fouille_id.setParcelleId(item.getParcelleId());
        fouille_id.setDate(item.getDate());
        // verifie que la fouille existe pas deja
        if (! fouilleRepository.existsById(fouille_id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "fouille not found with id : "+fouille_id);
        }
        fouilleRepository.save(item);
    }

    public Fouille delete(FouillePK fouillePK) {
        if (!fouilleRepository.existsById(fouillePK)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Fouille not found");
        }
        Fouille backup = this.findById(fouillePK);
        fouilleRepository.deleteById(fouillePK);
        if (fouilleRepository.existsById(fouillePK)){
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
                    "Error suppression");
        }
        return backup;
    }
}
