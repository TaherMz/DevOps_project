package com.example.devopsproject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idp;
    private String firstnamep;
    private String lastnamep;
    private String phonep;
    private String emailp;
    private String passwordp;

    public Long getIdp() {
        return idp;
    }

    public void setIdp(Long idp) {
        this.idp = idp;
    }

    public String getFirstnamep() {
        return firstnamep;
    }

    public void setFirstnamep(String firstnamep) {
        this.firstnamep = firstnamep;
    }

    public String getLastnamep() {
        return lastnamep;
    }

    public void setLastnamep(String lastnamep) {
        this.lastnamep = lastnamep;
    }

    public String getPhonep() {
        return phonep;
    }

    public void setPhonep(String phonep) {
        this.phonep = phonep;
    }

    public String getEmailp() {
        return emailp;
    }

    public void setEmailp(String emailp) {
        this.emailp = emailp;
    }

    public String getPasswordp() {
        return passwordp;
    }

    public void setPasswordp(String passwordp) {
        this.passwordp = passwordp;
    }
}
