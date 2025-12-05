import java.util.Scanner;

public class UserInput {
    private final Scanner keyboard;

    public UserInput(Scanner keyboard){
        this.keyboard=keyboard;
    }

    public Svømmer opretSvømmer(){
        System.out.println("Indtast navn: ");
        String navn=keyboard.nextLine();
        System.out.println("Indtast alder: ");
        int alder=keyboard.nextInt();
        keyboard.nextLine();

        String tlf;
        while(true){
            System.out.println("Indtast gyldigt telefonnummer: ");
            tlf=keyboard.nextLine().trim();
            if(tlf.matches("^\\d{8}$")) {
                break;
            }else{
                System.out.println("Ugyldigt telefonnummer. Prøv igen.");
            }
        }
        String status=vælgStatus();
        String aktivitet=vælgAktivitet();
        if(aktivitet.equals("konkurrence")){
            String disciplin=vælgDisciplin();
            return new KonkSvømmer(navn,alder,tlf,status,disciplin);
        }else{
            return new MotionistSvømmer(navn,alder,tlf,status);
        }
    }
    private String vælgStatus(){
        while(true){
            System.out.println("Vælg status: "+
                    "1. aktiv\n" +
                    "2. passiv");
            int valg=keyboard.nextInt();
            keyboard.nextLine();
            if(valg==1)
                return "aktiv";
            if(valg==2)
                return "passiv";
            System.out.println("Forkert input. Prøv igen.");
        }
    }
    private String vælgAktivitet(){
        while(true){
            System.out.println("Vælg aktivitet: \n"+
                    "1. motionist"+
                    "2. konkurrence");
            int valg= keyboard.nextInt();
            keyboard.nextLine();
            if(valg==1)
                return "motionist";
            if(valg==2)
                return "konkurrence";
            System.out.println("Forkert input. Prøv igen.");
        }
    }

    private String vælgDisciplin(){
        while(true){
            System.out.println("Vælg disciplin: \n"+
                    "1. Rygcrawl"+
                    "2. Butterfly"+
                    "3. Brystsvømning"+
                    "4. Crawl");
            int valg= keyboard.nextInt();
            keyboard.nextLine();
            if(valg==1)
                return "rygcrawl";
            if(valg==2)
                return "butterfly";
            if(valg==3)
                return "brystsvømning";
            if(valg==4)
                return "crawl";
            System.out.println("Forkert input. Prøv igen.");
        }
    }

}
