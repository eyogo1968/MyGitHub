package com.example.demo.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Transient;
import org.springframework.data.annotation.Id;

@Entity
public class Greeting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;
    @Transient
    private String textInSomeLanguage;

    public Greeting() {
        super();
    }

    public Greeting(String text) {
        super();
        this.text = text;
        //this.textInSomeLanguage = getTextTranslationSpecifiedLanguage(text);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTextInSomeLanguage() {
        return textInSomeLanguage;
    }

    public void setTextInSomeLanguage(String textInSomeLanguage) {
        this.textInSomeLanguage = textInSomeLanguage;
    }
}
