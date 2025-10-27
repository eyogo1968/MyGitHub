package com.example.recette.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name = "recette")
public class Recette {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String name;
    @Column
    private String description;
    @OneToMany
    private List<IngredientQuantite> ingredientQuantites;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "recette_category",
            joinColumns = @JoinColumn(name = "recette_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    @JsonBackReference
    private List<Category> categories;

    public Recette() {
    }

    public Recette(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<IngredientQuantite> getIngredientQuantites() {
        return ingredientQuantites;
    }

    public void setIngredientQuantites(List<IngredientQuantite> ingredientQuantites) {
        this.ingredientQuantites = ingredientQuantites;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Recette{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", ingredientQuantite=").append(ingredientQuantites);
        sb.append(", categories=").append(categories);
        sb.append('}');
        return sb.toString();
    }
}
