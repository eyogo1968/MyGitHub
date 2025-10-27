package com.example.fouille.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

@Embeddable
public class MaCompositeKey {

    @Column
    private Long equipe_id;
    @Column
    private Long parcelle_id;
    @Temporal(TemporalType.DATE)
    @Column
    private Date date;

    public MaCompositeKey() {
    }

    public Long getEquipe_id() {
        return equipe_id;
    }

    public void setEquipe_id(Long equipe_id) {
        this.equipe_id = equipe_id;
    }

    public Long getParcelle_id() {
        return parcelle_id;
    }

    public void setParcelle_id(Long parcelle_id) {
        this.parcelle_id = parcelle_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
