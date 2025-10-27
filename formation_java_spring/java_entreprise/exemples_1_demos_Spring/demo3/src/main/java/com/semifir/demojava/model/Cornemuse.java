package com.semifir.demojava.model;

import com.semifir.demojava.interfaces.Instrument;

public class Cornemuse implements Instrument {

    private String model;

    public Cornemuse() {
    }

    public Cornemuse(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String jouer() {
        return "tzing tzing";
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Cornemuse{");
        sb.append("model='").append(model).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
