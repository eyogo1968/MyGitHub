package com.example.demoBdd.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ADRESSE")
public class AdresseJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "RUE")
    private String rue;
    @Column(name = "VILLE", length = 100)
    private String ville;
    @Column(name="CODEPOSTAL", length = 10)
    private String codePostal;
    @Column(name="PAYS")
    private String pays;

    public AdresseJpa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AdresseJpa {");
        sb.append("id=").append(id);
        sb.append(", rue='").append(rue).append('\'');
        sb.append(", ville='").append(ville).append('\'');
        sb.append(", codePostal='").append(codePostal).append('\'');
        sb.append(", pays='").append(pays).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
