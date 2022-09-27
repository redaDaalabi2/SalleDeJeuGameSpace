package salle;

import java.util.UUID;

public class Joueur {
    //Declaration des attributes
    private String Prenom;
    private String Nom;
    private String Code;

    //function qui permet générer le code de joueur
    public Joueur(String Nom, String Prenom){
        this.Code = UUID.randomUUID().toString();
        this.Nom = Nom;
        this.Prenom = Prenom;
    }

    //Getters
    public String getPrenom() {
        return Prenom;
    }
    public String getNom() {
        return Nom;
    }
    public String getCode() {
        return Code;
    }

    //Setters
    public void setPrenom(String prenom) {
        this.Prenom = prenom;
    }
    public void setNom(String nom) {
        this.Nom = nom;
    }
    public void setCode(String code) {
        this.Code = code;
    }
}
