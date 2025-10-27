package com.example.recette.config;

import com.example.recette.entity.Category;
import com.example.recette.entity.Ingredient;
import com.example.recette.entity.IngredientQuantite;
import com.example.recette.entity.Recette;
import com.example.recette.repository.CategoryRepository;
import com.example.recette.repository.IngredientQuantiteRepository;
import com.example.recette.repository.IngredientRepository;
import com.example.recette.repository.RecetteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    public CommandLineRunner initDatabase(
            IngredientRepository ingredientRepository,
            IngredientQuantiteRepository ingredientQuantiteRepository,
            RecetteRepository recetteRepository,
            CategoryRepository categoryRepository) {
        return args -> {
            if(ingredientRepository.count() == 0L &&
                    categoryRepository.count() == 0L &&
                    recetteRepository.count() == 0L &&
                    ingredientQuantiteRepository.count() == 0L
            ){
                log.info("====== 1. load ingredients ======");
                Ingredient i1 = new Ingredient("Tomate");
                Ingredient i2 = new Ingredient("Poivron");
                Ingredient i3 = new Ingredient("Courgette");
                Ingredient i4 = new Ingredient("Filet poulet");
                Ingredient i5 = new Ingredient("Kiwi");
                Ingredient i6 = new Ingredient("Bannane");
                Ingredient i7 = new Ingredient("Cerise");
                Ingredient i8 = new Ingredient("Merlant");

                ingredientRepository.saveAll(List.of(i1,i2,i3,i4,i5,i6,i7,i8));

                log.info("====== 2. load Category ======");
                Category c1 = new Category("fruit");
                Category c2 = new Category("legume");
                Category c3 = new Category("viande");
                Category c4 = new Category("poisson");
                Category c5 = new Category("vegetarien");
                Category c6 = new Category("sucree");
                categoryRepository.saveAll(List.of(c1,c2,c3,c4,c5,c6));

                log.info("====== 3. load recette ======");
                Recette r1 = new Recette("plat du soleil",
                        "un plat de poulet au legumes");

                Recette r2 = new Recette("salade de fruit",
                        "une salade de fruit");

                Recette r3 = new Recette("plat merlant",
                        "un merlant avec des courgettes");

                recetteRepository.saveAll(List.of(r1,r2,r3));
                r1.setCategories(List.of(c2,c3));
                r2.setCategories(List.of(c1,c5,c6));
                r3.setCategories(List.of(c4,c5));
                recetteRepository.saveAll(List.of(r1,r2,r3));

                log.info("====== 4. load ingredientQuantite ======");
                IngredientQuantite iq1 = new IngredientQuantite(2,i4);
                IngredientQuantite iq2 = new IngredientQuantite(3,i2);
                IngredientQuantite iq3 = new IngredientQuantite(4,i1);
                IngredientQuantite iq4 = new IngredientQuantite(1,i8);
                IngredientQuantite iq5 = new IngredientQuantite(3,i3);
                IngredientQuantite iq6 = new IngredientQuantite(2,i5);
                IngredientQuantite iq7 = new IngredientQuantite(1,i6);
                IngredientQuantite iq8 = new IngredientQuantite(5,i7);

                ingredientQuantiteRepository.saveAll(List.of(iq1,iq2,iq3,iq4,iq5,iq6,iq7,iq8));

                log.info("====== 5. update recette ======");
                r1.setIngredientQuantites(List.of(iq1,iq2,iq3));
                r2.setIngredientQuantites(List.of(iq6,iq7,iq8));
                r3.setIngredientQuantites(List.of(iq4,iq5));
                recetteRepository.saveAll(List.of(r1,r2,r3));

            };
        };
    }
}
