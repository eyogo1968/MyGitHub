package com.example.fouille.service;

import com.example.fouille.entity.Parcelle;
import com.example.fouille.repository.ParcelleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ParcelleService {
    
    private final ParcelleRepository parcelleRepository;

    public ParcelleService(ParcelleRepository parcelleRepository) {
        this.parcelleRepository = parcelleRepository;
    }
    public List<Parcelle> findAll() {
        return parcelleRepository.findAll();
    }

    public Parcelle findById(Long id) {
        Optional<Parcelle> optionalParcelle = parcelleRepository.findById(id);
        if (optionalParcelle.isPresent()){
            return optionalParcelle.get();
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public Parcelle create(Parcelle item) {
        return parcelleRepository.save(item);
    }

    public void update(Parcelle item) {
        if (! parcelleRepository.existsById(item.getId())){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        parcelleRepository.save(item);
    }

    public Parcelle delete(Long id) {
        if (!parcelleRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Parcelle not found");
        }
        Parcelle backup = this.findById(id);
        parcelleRepository.deleteById(id);
        if (parcelleRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
                    "Error suppression");
        }
        return backup;
    }

    public Boolean existById(Long id){
        return this.parcelleRepository.existsById(id);
    }
}
