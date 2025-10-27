package com.example.recette.repository;

import com.example.recette.entity.Recette;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecetteRepository extends JpaRepository<Recette, Integer> {
}
