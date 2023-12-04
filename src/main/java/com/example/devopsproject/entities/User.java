package com.example.devopsproject.entities;


import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idu;

    private String firstNameu;
    private String lastNameu;
    private String emailu;
    private String phoneu;
    private String roleu="admin";
    private String passwordu;

    public Long getIdu() {
        return idu;
    }

    public void setIdu(Long idu) {
        this.idu = idu;
    }

    public String getFirstNameu() {
        return firstNameu;
    }

    public void setFirstNameu(String firstNameu) {
        this.firstNameu = firstNameu;
    }

    public String getLastNameu() {
        return lastNameu;
    }

    public void setLastNameu(String lastNameu) {
        this.lastNameu = lastNameu;
    }

    public String getEmailu() {
        return emailu;
    }

    public void setEmailu(String emailu) {
        this.emailu = emailu;
    }

    public String getPhoneu() {
        return phoneu;
    }

    public void setPhoneu(String phoneu) {
        this.phoneu = phoneu;
    }

    public String getRoleu() {
        return roleu;
    }

    public void setRoleu(String roleu) {
        this.roleu = roleu;
    }

    public String getPasswordu() {
        return passwordu;
    }

    public void setPasswordu(String passwordu) {
        this.passwordu = passwordu;
    }
}
