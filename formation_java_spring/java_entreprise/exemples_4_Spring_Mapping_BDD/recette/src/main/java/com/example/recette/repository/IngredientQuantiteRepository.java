package com.example.recette.repository;

import com.example.recette.entity.IngredientQuantite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientQuantiteRepository extends JpaRepository<IngredientQuantite, Integer> {
}
