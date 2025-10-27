package com.example.fouille.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "fouille")
@IdClass(FouillePK.class)
public class Fouille {

    @Id
    private Long equipeId;
    @Id
    private Long parcelleId;
    @Id
    private Date date;
//    @EmbeddedId
//    private MaCompositeKey maCompositeKey;


    public Fouille() {
    }

    public Long getEquipeId() {
        return equipeId;
    }

    public void setEquipeId(Long equipeId) {
        this.equipeId = equipeId;
    }

    public Long getParcelleId() {
        return parcelleId;
    }

    public void setParcelleId(Long parcelleId) {
        this.parcelleId = parcelleId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
