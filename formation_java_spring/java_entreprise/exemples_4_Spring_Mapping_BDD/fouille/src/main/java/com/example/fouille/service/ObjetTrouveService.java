package com.example.fouille.service;

import com.example.fouille.entity.ObjetTrouve;
import com.example.fouille.repository.ObjetTrouveRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ObjetTrouveService {

    private final ObjetTrouveRepository objetTrouveRepository;


    public ObjetTrouveService(ObjetTrouveRepository objetTrouveRepository) {
        this.objetTrouveRepository = objetTrouveRepository;
    }

    public List<ObjetTrouve> findAll() {
        return objetTrouveRepository.findAll();
    }

    public ObjetTrouve findById(Long id) {
        Optional<ObjetTrouve> optionalSObjetTrouve = objetTrouveRepository.findById(id);
        if (optionalSObjetTrouve.isPresent()){
            return optionalSObjetTrouve.get();
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public ObjetTrouve create(ObjetTrouve item) {
        return objetTrouveRepository.save(item);
    }

    public void update(ObjetTrouve item) {
        if (! objetTrouveRepository.existsById(item.getId())){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        objetTrouveRepository.save(item);
    }

    public ObjetTrouve delete(Long id) {
        if (!objetTrouveRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "SObjetTrouve not found");
        }
        ObjetTrouve backup = this.findById(id);
        objetTrouveRepository.deleteById(id);
        if (objetTrouveRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED,
                    "Error suppression");
        }
        return backup;
    }
}
