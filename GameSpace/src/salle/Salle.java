package salle;

//pour lire les entrées du clavier
import java.util.Scanner;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;

public class Salle {
    //utiliser pour scan simplifier les chose
    private final static Scanner scan = new Scanner(System.in);
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
    static int day = Integer.parseInt(LocalDate.now().format(formatter));
    static int dailytarif;
    //function menu() qui represente le menu de l'application
    public static void menu(){
        int a;
        // presentation
        System.out.println("--------Programme : Game Space-------");
        System.out.println("------Realisé par: Reda DAALABI------");
        System.out.println("----Encadré par : My youssef SBAI----");
        System.out.println("----------------MENU-----------------");
        System.out.println("-------------Game Space--------------");
        do {
            System.out.println("<1> - Ajouter une reservation !");
            System.out.println("<2> - Les tarifs du jour");
            System.out.println("<3> - Les tarifs du mois");
            System.out.println("<4> - pour quitter l'application");
            System.out.print("Choisir svp : ");
            a = scan.nextInt();
            switch (a) {
                case 1 -> InfoJoueur();
                case 2 -> revenue(0);
                case 3 -> System.out.println("le revenu du mois est : 0 DH");
                case 4 -> {
                    System.out.println("A bientôt !!");
                    System.exit(0);
                }
                default -> System.out.println("plz choisir une autre fois");
            }
        }
        while(true);
    }

    //function InfoJoueur pour la reservation
    public static void InfoJoueur() {
        String code, Game;
        double HeureDebut;
        int chose, Duree;
        String jeux= "FIFA, PES, Assassin's Creed, Counter-Strike";
        Poste p1 = new Poste(1,"HP","Xbox",jeux);
        Poste p2 = new Poste(2,"Xbox","Asus",jeux);
        Poste p3 = new Poste(3,"Samsung","Xbox",jeux);
        Poste p4 = new Poste(4,"Dell","Xbox",jeux);
        Poste p5 = new Poste(5,"Asus","PlayStation5",jeux);
        Poste p6 = new Poste(6,"PlayStation5","Dell",jeux);
        Poste p7 = new Poste(7,"Samsung","PlayStation5",jeux);
        Poste p8 = new Poste(8,"Nintendo switch","Asus",jeux);
        Poste p9 = new Poste(9,"Dell","Nintendo switch",jeux);
        code = NouveauJoueur();
        System.out.println("Votre code est : " + code );
        System.out.println("-----Bienvenue chez Salle de Game----------");
        System.out.println("Quel jeu veux-tu jouer ?");
        Game = scan.nextLine();
        System.out.printf("---------------- Game[%s]-------------------\n",Game);
        System.out.println("Entrer Heure de début : ");
        HeureDebut =Double.parseDouble(scan.nextLine());
        if(!CheckDebut(HeureDebut))
        {
            System.out.println("Désole on travaille pas cette heure");
            System.out.println("Les horraires de travaille");
            System.out.println("08:00 h ==> 12:00 h et 14:00 h ==> 20:00 h");
        }
        else
        {
            System.out.println("les horaires disponible :");
            System.out.println("<1> 30 min ==> 5 dh");
            System.out.println("<2> 1 h ==> 10dh");
            System.out.println("<3> 2 h ==> 18 dh");
            System.out.println("<4> 5 h ==> 40 dh");
            System.out.println("<5> Luxe ==> 65 dh");
            System.out.println("Pour combien de temps : ");
            Duree = scan.nextInt();
            if(CheckFin(HeureDebut, num(Duree)))
            {
                System.out.println("--------------------------------------------------------------------------------------------------------------");
                System.out.println("<1> Poste : "+p1.getNum()+" | Écran : " +p1.getEcran() +" | Console : " +p1.getConsole() +" | Games : " +p1.getGames());
                System.out.println("--------------------------------------------------------------------------------------------------------------");
                System.out.println("<2> Poste : "+p2.getNum()+" | Écran : " +p2.getEcran() +" | Console : " +p2.getConsole() +" | Games : " +p2.getGames());
                System.out.println("--------------------------------------------------------------------------------------------------------------");
                System.out.println("<3> Poste : "+p3.getNum()+" | Écran : " +p3.getEcran() +" | Console : " +p3.getConsole() +" | Games : " +p3.getGames());
                System.out.println("--------------------------------------------------------------------------------------------------------------");
                System.out.println("<4> Poste : "+p4.getNum()+" | Écran : " +p4.getEcran() +" | Console : " +p4.getConsole() +" | Games : " +p4.getGames());
                System.out.println("--------------------------------------------------------------------------------------------------------------");
                System.out.println("<5> Poste : "+p5.getNum()+" | Écran : " +p5.getEcran() +" | Console : " +p5.getConsole() +" | Games : " +p5.getGames());
                System.out.println("--------------------------------------------------------------------------------------------------------------");
                System.out.println("<6> Poste : "+p6.getNum()+" | Écran : " +p6.getEcran() +" | Console : " +p6.getConsole() +" | Games : " +p6.getGames());
                System.out.println("--------------------------------------------------------------------------------------------------------------");
                System.out.println("<7> Poste : "+p7.getNum()+" | Écran : " +p7.getEcran() +" | Console : " +p7.getConsole() +" | Games : " +p7.getGames());
                System.out.println("--------------------------------------------------------------------------------------------------------------");
                System.out.println("<8> Poste : "+p8.getNum()+" | Écran : " +p8.getEcran() +" | Console : " +p8.getConsole() +" | Games : " +p8.getGames());
                System.out.println("--------------------------------------------------------------------------------------------------------------");
                System.out.println("<9> Poste : "+p9.getNum()+" | Écran : " +p9.getEcran() +" | Console : " +p9.getConsole() +" | Games : " +p9.getGames());
                System.out.println("--------------------------------------------------------------------------------------------------------------");
                System.out.println("Tu peut me choisir svp : ");
                chose = scan.nextInt();
                switch (chose) {
                    case 1 -> {
                        p1.Reserver(ConvertHour(HeureDebut), ConvertHour(HeureDebut + Duree), code);
                        revenue(tarif(Duree));
                    }
                    case 2 -> {
                        p2.Reserver(ConvertHour(HeureDebut), ConvertHour(HeureDebut + Duree), code);
                        revenue(tarif(Duree));
                    }
                    case 3 -> {
                        p3.Reserver(ConvertHour(HeureDebut), ConvertHour(HeureDebut + Duree), code);
                        revenue(tarif(Duree));
                    }
                    case 4 -> {
                        p4.Reserver(ConvertHour(HeureDebut), ConvertHour(HeureDebut + Duree), code);
                        revenue(tarif(Duree));
                    }
                    case 5 -> {
                        p5.Reserver(ConvertHour(HeureDebut), ConvertHour(HeureDebut + Duree), code);
                        revenue(tarif(Duree));
                    }
                    case 6 -> {
                        p6.Reserver(ConvertHour(HeureDebut), ConvertHour(HeureDebut + Duree), code);
                        revenue(tarif(Duree));
                    }
                    case 7 -> {
                        p7.Reserver(ConvertHour(HeureDebut), ConvertHour(HeureDebut + Duree), code);
                        revenue(tarif(Duree));
                    }
                    case 8 -> {
                        p8.Reserver(ConvertHour(HeureDebut), ConvertHour(HeureDebut + Duree), code);
                        revenue(tarif(Duree));
                    }
                    case 9 -> {
                        p9.Reserver(ConvertHour(HeureDebut), ConvertHour(HeureDebut + Duree), code);
                        revenue(tarif(Duree));
                    }
                    default -> System.out.println("Operation invalide");
                }
            }
            else
            {
                System.out.println("Désole on travaille pas cette heure");
                System.out.println("Les horraires de travaille");
                System.out.println("08:00 ==> 12:00 et 14:00 ==> 20:00");
            }
        }
    }

    //function NouveauJoueur pour créer un nouveau joueur
    public static String NouveauJoueur() {
        String nom , prenom;
        System.out.println("Entrer votre nom : ");
        scan.nextLine();
        nom = scan.nextLine();
        System.out.println("Entrer votre prenom : ");
        prenom = scan.nextLine();
        Joueur j = new Joueur(nom,prenom);
        return j.getCode();
    }

    //function CheckDebut() check si la date saisie est entre 8.00 et 12.00 ou 14.00 et 20.00
    public static boolean CheckDebut(double debut) {
        return (debut >= 8.00 && debut < 12.00) || (debut >= 14.00 && debut < 20.00);
    }

    //function CheckFin() qui permet de
    public  static boolean CheckFin(double debut,double periode){
        double fin;
        fin = ConvertHour(debut+periode);
        System.out.printf("Heure du fin : %.2f\n",fin);
        return (fin >= 8.00 && fin <= 12.00) || (fin >= 14.00 && fin <= 20.00);
    }

    public static double ConvertHour(double time){
        int hours;
        float min;
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(time));
        hours = bigDecimal.intValue();
        min =(float) ((Double.parseDouble(bigDecimal.subtract( new BigDecimal(hours)).toPlainString())*100)+ (hours * 60)) / 60;
        return min;
    }

    public static double num(double num)
    {
        double res=0;
        if(num == 1 ) res = 0.3;
        else if(num == 2 ) res = 1;
        else if(num == 3) res =2;
        else if(num == 4) res =5;
        return res;
    }

    public static int tarif(int a)
    {
        int tarif=0;
        if(a==1) tarif=5;
        else if (a==2) tarif = 10;
        else if (a==3) tarif = 18;
        else if (a==4) tarif = 40;
        return tarif;
    }

    public static void revenue(int tarif) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
        int dnow = Integer.parseInt(LocalDate.now().format(formatter));
        if(day == dnow) {
            dailytarif=dailytarif+tarif;
        }
        else
        {
            dailytarif=0;
            day = Integer.parseInt(LocalDate.now().format(formatter));
        }
        JSONObject file = new JSONObject();
        file.put("Tarif par jour : ",dailytarif);
        FileWriter test = null;
        try {
            test = new FileWriter("db.json");
            test.write(file.toJSONString());
            test.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("les revenu du jour : %s DH\n",dailytarif);
    }

    public static void main(String[] args) {
        menu();
    }
}
