package salle;

//importé qui représente pour afficher la date actuelle.
import java.time.LocalDate;
//utilisé pour analyser les dates dans différents formats
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
//qui fournit des méthodes pour convertir la date entre un instant précis dans le temps et un ensemble de champs de calendrier
import java.util.Calendar;
//fournit le système de calendrier standard utilisé par la plupart des pays du monde
import java.util.GregorianCalendar;

public class Poste {
    //Declaration des attributes
    private int Num;
    private String Console;
    private String Ecran;
    private String Games;
    private ArrayList<Jeu> Times;
    int SalleAttente = 0;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
    int day = Integer.parseInt(LocalDate.now().format(formatter));

    ////function qui permet de setter toutes les attributes
    public Poste(int num, String ecran, String console,String games) {
        this.Num = num;
        this.Ecran = ecran;
        this.Console = console;
        this.Games=games;
        Times = new ArrayList<Jeu>();
    }

    //Getters
    public int getNum() {
        return Num;
    }
    public String getConsole() {
        return Console;
    }
    public String getEcran() {
        return Ecran;
    }
    public String getGames() {
        return Games;
    }
    public ArrayList<Jeu> getTimes(){
        return Times;
    }

    //Setters
    public void setId(int num) {
        this.Num= num;
    }
    public void setConsole(String console) {
        this.Console = console;
    }
    public void setEcran(String ecran) {
        this.Ecran = ecran;
    }
    public void setGames(String games) {
        this.Games = games;
    }

    //function pour la reservation du poste
    public void Reserver(Double debut, Double fin, String code)
    {
        double hour,min,day;
        boolean res=true;
        GregorianCalendar now1 = new GregorianCalendar();
        //get now hour
        hour = now1.get(Calendar.HOUR_OF_DAY);
        //get now minutes
        min = now1.get(Calendar.MINUTE)*(0.01);
        //date debut de jouer
        day = hour+min;
        for(Jeu j : Times)
        {
            if((debut >= j.getDateDebut() && debut < j.getDateFin()) || (fin > j.getDateDebut() && fin < j.getDateFin()))
            {
                res=false;
                break;
            }
            else
            {
                if(debut != day && SalleAttente < 8)
                {
                    SalleAttente ++;
                    res=true;
                    System.out.println("Salle d'attente : "+SalleAttente);
                }
                else
                {
                    if(SalleAttente == 8)
                    {
                        System.out.println("Salle d'attente plein a la prochaine fois");
                        System.out.println("Salle d'attente : "+SalleAttente);
                        break;
                    }
                    else
                    {
                        res=true;
                        SalleAttente--;
                        System.out.println("Salle d'attente : "+SalleAttente);
                    }
                }
            }
        }
        if(res)
        {
            Times.add(new Jeu(debut,fin,code));
            System.out.println("Bien Reserver pour  le poste : "+Num);
            System.out.printf("Code du joueur : %s\n",code);
            System.out.printf("Heure de debut : %.2f\n",debut);
        }
        else
        {
            System.out.println("Poste Occupé !! Poste : "+ Num);
        }
    }

    //function pour la revenue par jour
    public void Revenue(int Tarif) {
        int dailytarif=0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
        int dnow = Integer.parseInt(LocalDate.now().format(formatter));
        if(day == dnow) {
            dailytarif=dailytarif+Tarif;
        }
        else
        {
            dailytarif=Tarif;
            this.day = Integer.parseInt(LocalDate.now().format(formatter));
        }
        System.out.printf("les revenu du jour : %t DH",dailytarif);
    }

}
