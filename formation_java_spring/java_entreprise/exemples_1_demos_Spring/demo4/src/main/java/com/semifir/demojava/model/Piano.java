package com.semifir.demojava.model;

import com.semifir.demojava.interfaces.Instrument;
import org.springframework.stereotype.Component;

// @Primary
@Component
public class Piano implements Instrument {

    private String model;

    public Piano() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String jouer() {
        return "ping ping ping";
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Piano{");
        sb.append("model='").append(model).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
