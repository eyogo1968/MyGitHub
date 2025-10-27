package com.example.fouille.service;

import com.example.fouille.entity.SiteFouille;
import com.example.fouille.repository.SiteFouilleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class SiteFouilleService {

    private final SiteFouilleRepository siteFouilleRepository;

    public SiteFouilleService(SiteFouilleRepository siteFouilleRepository) {
        this.siteFouilleRepository = siteFouilleRepository;
    }
    public List<SiteFouille> findAll() {
        return siteFouilleRepository.findAll();
    }

    public SiteFouille findById(Long id) {
        Optional<SiteFouille> optionalSiteFouille = siteFouilleRepository.findById(id);
        if (optionalSiteFouille.isPresent()){
            return optionalSiteFouille.get();
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public SiteFouille create(SiteFouille item) {
        return siteFouilleRepository.save(item);
    }

    public void update(SiteFouille item) {
        if (! siteFouilleRepository.existsById(item.getId())){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        siteFouilleRepository.save(item);
    }

    public SiteFouille delete(Long id) {
        if (!siteFouilleRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "SiteFouille not found");
        }
        SiteFouille backup = this.findById(id);
        siteFouilleRepository.deleteById(id);
        if (siteFouilleRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
                    "Error suppression");
        }
        return backup;
    }
}
