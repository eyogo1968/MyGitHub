package com.semifir.demojava.configs;

import com.semifir.demojava.interfaces.Instrument;
import com.semifir.demojava.model.Cornemuse;
import com.semifir.demojava.model.Guitariste;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean(name = "cornemuse")
    public Instrument getCornemuse(){
        Instrument inst = new Cornemuse();
        return inst;
    }

    @Bean(name = "guitariste")
    public Guitariste getGuitaristeWithCornemuse(){
        Guitariste gui = new Guitariste();
        gui.setGuitare(this.getCornemuse());
        return gui;
    }


}
