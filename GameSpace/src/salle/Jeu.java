package salle;

public class Jeu {
    //Declaration des attributes
    private double DateDebut;
    private double DateFin;
    private String Code ;

    //function qui permet de setter toutes les attributes
    public Jeu(double debut, double fin, String code){
        this.DateDebut = debut;
        this.DateFin = fin;
        this.Code = code;
    }

    //Getters
    public double getDateDebut() {
        return DateDebut;
    }
    public double getDateFin() {
        return DateFin;
    }
    public String getCode() {
        return Code;
    }

    //Setters
    public void setDateDebut(double dateDebut) {
        this.DateDebut = dateDebut;
    }
    public void setDateFin(double dateFin) {
        this.DateFin = dateFin;
    }
    public void setCode(String code) {
        this.Code = code;
    }
}
