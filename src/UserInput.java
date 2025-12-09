import java.util.Scanner;

public class UserInput {
    FileManager fM = new FileManager();
    private final Scanner keyboard;

    public UserInput(Scanner keyboard){
        this.keyboard=keyboard;
    }

    public void menu() {
        System.out.println("Svømmeklubben Delfinen");
        System.out.println("1. Opret ny svømmer\n" +
                "2. Rediger\n" +
                "3. ");
        String userInput = keyboard.nextLine();
        switch (userInput) {
            case "1":
                System.out.println("Opret ny Svømmer");
                opretSvømmer();
                break;
            case "2":
                break;
            case"3":
                System.out.println("Slet svømmer");


        }
    }
    public void opretSvømmer(){
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
            fM.tilføjTilArrayList("Konkurrencister.txt", tlf+";"+navn+";"+alder+";"+status+";"+disciplin);
        }else{
            fM.tilføjTilArrayList("Motionister.txt",tlf+";"+navn+";"+alder+";"+status);
        }
    }
    private String vælgStatus(){
        while(true){
            System.out.println("Vælg status: \n"+
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
                    "1. motionist \n"+
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
                    "1. Rygcrawl\n"+
                    "2. Butterfly\n"+
                    "3. Brystsvømning\n"+
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
    public void redigerSvømmer(){
        FileManager.loadFiles();
        System.out.println("Indtast svømmers telefonnummer: ");

    }
}
