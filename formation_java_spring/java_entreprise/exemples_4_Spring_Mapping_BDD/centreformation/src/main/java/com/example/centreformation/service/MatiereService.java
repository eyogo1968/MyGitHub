package com.example.centreformation.service;

import com.example.centreformation.entity.Matiere;
import com.example.centreformation.entity.Matiere;
import com.example.centreformation.repository.MatiereRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MatiereService implements CrudService<Matiere, Long> {
    
    private final MatiereRepository matiereRepository;

    public MatiereService(MatiereRepository matiereRepository) {
        this.matiereRepository = matiereRepository;
    }

    @Override
    public List<Matiere> findAll() {
        return matiereRepository.findAll();
    }

    @Override
    public Matiere findById(Long id) {
        Optional<Matiere> optionalMatiere = matiereRepository.findById(id);
        if (optionalMatiere.isPresent()){
            return optionalMatiere.get();
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Matiere create(Matiere item) {
        item.setMiseajour(new Date());
        return matiereRepository.save(item);
    }

    @Override
    public void update(Matiere item) {
        if (! matiereRepository.existsById(item.getId())){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        item.setMiseajour(new Date());
        matiereRepository.save(item);
    }

    @Override
    public Matiere delete(Long id) {
        if (!matiereRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Adress not found");
        }
        Matiere backup = this.findById(id);
        matiereRepository.deleteById(id);
        if (matiereRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
                    "Error suppression");
        }
        return backup;
    }
}
