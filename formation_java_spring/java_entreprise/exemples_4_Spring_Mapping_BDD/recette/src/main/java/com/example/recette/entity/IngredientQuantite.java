package com.example.recette.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ingredientQuantity")
public class IngredientQuantite {

    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "ingredient_id", referencedColumnName = "id")
    private Ingredient ingredient;

    public IngredientQuantite() {
    }

    public IngredientQuantite(Integer quantity, Ingredient ingredient) {
        this.quantity = quantity;
        this.ingredient = ingredient;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("IngredientQuantite{");
        sb.append("id=").append(id);
        sb.append(", quantity=").append(quantity);
        sb.append(", ingredient=").append(ingredient);
        sb.append('}');
        return sb.toString();
    }
}
