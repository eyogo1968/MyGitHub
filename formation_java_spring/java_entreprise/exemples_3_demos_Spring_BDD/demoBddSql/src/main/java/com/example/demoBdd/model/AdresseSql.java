package com.example.demoBdd.model;

public class AdresseSql {

    private Long id;
    private String rue;
    private String ville;
    private String codePostal;
    private String pays;

    public AdresseSql() {
    }

    public AdresseSql(Long id, String rue, String ville, String codePostal, String pays) {
        this.id = id;
        this.rue = rue;
        this.ville = ville;
        this.codePostal = codePostal;
        this.pays = pays;
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
        final StringBuffer sb = new StringBuffer("AdresseSql {");
        sb.append("id=").append(id);
        sb.append(", rue='").append(rue).append('\'');
        sb.append(", ville='").append(ville).append('\'');
        sb.append(", codePostal='").append(codePostal).append('\'');
        sb.append(", pays='").append(pays).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
