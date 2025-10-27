package com.example.fouille.repository;

import com.example.fouille.entity.Fouille;
import com.example.fouille.entity.FouillePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FouilleRepository extends JpaRepository<Fouille, FouillePK> {
}
