package com.example.calculatrice.model;


import org.springframework.stereotype.Component;

@Component
public class Calculatrice {

    private String operation;
    private Integer nombre1;
    private Integer nombre2;

    public Calculatrice() {
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Integer getNombre1() {
        return nombre1;
    }

    public void setNombre1(Integer nombre1) {
        this.nombre1 = nombre1;
    }

    public Integer getNombre2() {
        return nombre2;
    }

    public void setNombre2(Integer nombre2) {
        this.nombre2 = nombre2;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Calculette{");
        sb.append("operation='").append(operation).append('\'');
        sb.append(", nombre1=").append(nombre1);
        sb.append(", nombre2=").append(nombre2);
        sb.append('}');
        return sb.toString();
    }
}
