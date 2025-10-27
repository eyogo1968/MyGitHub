package com.example.fouille.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class FouillePK implements Serializable {

    private static final Long seriaVersionUID = 1L;

    private Long equipeId;
    private Long parcelleId;
    private Date date;

    public FouillePK() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FouillePK fouillePK = (FouillePK) o;
        return Objects.equals(equipeId, fouillePK.equipeId) && Objects.equals(parcelleId, fouillePK.parcelleId) && Objects.equals(date, fouillePK.date);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(equipeId);
        result = 31 * result + Objects.hashCode(parcelleId);
        result = 31 * result + Objects.hashCode(date);
        return result;
    }
}
