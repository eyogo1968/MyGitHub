package com.example.fouille.service;

import com.example.fouille.entity.Archeologue;
import com.example.fouille.repository.ArcheologueRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ArcheologueService {

    private final ArcheologueRepository archeologueRepository;

    public ArcheologueService(ArcheologueRepository archeologueRepository) {
        this.archeologueRepository = archeologueRepository;
    }

    public List<Archeologue> findAll() {
        return archeologueRepository.findAll();
    }

    public Archeologue findById(Long id) {
        Optional<Archeologue> optionalArcheologue = archeologueRepository.findById(id);
        if (optionalArcheologue.isPresent()){
            return optionalArcheologue.get();
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public Archeologue create(Archeologue item) {
        return archeologueRepository.save(item);
    }

    public void update(Archeologue item) {
        if (! archeologueRepository.existsById(item.getId())){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        archeologueRepository.save(item);
    }

    public Archeologue delete(Long id) {
        if (!archeologueRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Archeologue not found");
        }
        Archeologue backup = this.findById(id);
        archeologueRepository.deleteById(id);
        if (archeologueRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
                    "Error suppression");
        }
        return backup;
    }
}
