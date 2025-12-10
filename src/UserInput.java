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
                redigerSvømmer();
                break;
            case"3":
                System.out.println("Slet svømmer");
                gemStævne();

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
        System.out.println("Indtast svømmers telefonnummer: ");
        String tlf=keyboard.nextLine().trim();
        Svømmer s=fM.findSvømmerByTlf(tlf);
        if(s==null){
            System.out.println("Ingen svømmer fundet med dette telefonnummer.");
            return;
        }
        MotionistSvømmer msFundet=null;
        KonkSvømmer ksFundet=null;

        for(MotionistSvømmer ms : FileManager.motionistFil){
            if(ms.getTlf().equals(tlf)){
                msFundet=ms;
                break;
            }
        }
        if(msFundet==null){
            for(KonkSvømmer ks : FileManager.konkurrencistFil){
                if(ks.getTlf().equals(tlf)){
                    ksFundet=ks;
                    break;
                }
            }
        }
        if(msFundet!=null){ //Redigering af motionistsvømmer
            System.out.println("Hvad vil du ændre?\n"+
                    "1. Telefonnummer\n"+
                    "2. Navn\n"+
                    "3. Alder\n" +
                    "4. Status\n" +
                    "5. Aktivitet\n" +
                    "6. Slet svømmer");
            int valg=keyboard.nextInt();
            keyboard.nextLine();

            switch (valg){
                case 1:
                    String nytTlf;
                    while(true){
                        System.out.println("Indtast nyt telefonnummer: ");
                        nytTlf=keyboard.nextLine().trim();
                        if(!nytTlf.matches("^\\d{8}$")){
                            System.out.println("Ugyldigt telefonnummer.");
                            continue;
                        }
                        break;
                    }
                    msFundet.setTlf(nytTlf);
                    break;
                case 2:
                    System.out.println("Indtast nyt navn: ");
                    msFundet.setNavn(keyboard.nextLine());
                    break;
                case 3:
                    System.out.println("Indtast ny alder: ");
                    msFundet.setAlder(keyboard.nextInt());
                    keyboard.nextLine();
                    break;
                case 4:
                    System.out.println("Indtast ny status (aktiv/passiv): ");
                    msFundet.setStatus(keyboard.nextLine().toLowerCase());
                    break;
                case 5: {
                    System.out.println("Indtast ny aktivitet (motionist/konkurrence): ");
                    String nyAktivitet = keyboard.nextLine().toLowerCase();
                    if (nyAktivitet.equals("konkurrence")) {
                        System.out.println("Indtast disciplin: ");
                        String disciplin = keyboard.nextLine();
                        KonkSvømmer nyKs = new KonkSvømmer(
                                msFundet.getTlf(),
                                msFundet.getNavn(),
                                msFundet.getAlder(),
                                msFundet.getStatus(),
                                disciplin); //Hvis en motionistsvømmer skal laves til konkSvømmer, skal disciplin tilføjes.
                        FileManager.motionistFil.remove(msFundet); //Vi skal fjerne svømmeren fra motionist.
                        FileManager.konkurrencistFil.add(nyKs); //For derefter at flytte svømmer i konkurrence.
                    } else if (nyAktivitet.equals("motionist")) {
                        msFundet.setAktivitet("motionist");
                    } else {
                        System.out.println("Ugyldigt valg");
                    }
                    break;
                }
                case 6:
                    System.out.println(msFundet);
                    System.out.println("Er du sikker på du vil slette svømmer? ja/nej");
                    String svar = keyboard.nextLine().toLowerCase();
                    if (svar.equals("ja")) {
                        fM.sletObjekt("Motionister.txt", msFundet.getTlf());
                        System.out.println("Svømmer er slettet.");
                    } else if (svar.equals("nej")) {
                        System.out.println("Sletning annulleret.");
                    }
                    break;
                default:
                    System.out.println("Ugyldigt valg.");
            }
        } //redigering af motionistsvømmer slut
        else if(ksFundet!=null) { //redigering af konkurrencesvømmer
            System.out.println("Hvad vil du ændre?\n" +
                    "1. Telefonnummer\n" +
                    "2. Navn\n" +
                    "3. Alder\n" +
                    "4. Status\n" +
                    "5. Aktivitet\n" +
                    "6. Disciplin\n" +
                    "7. Slet svømmer");
            int valg = keyboard.nextInt();
            keyboard.nextLine();

            switch (valg) {
                case 1: {
                    String nytTlf;
                    while (true) { //betingelse af hvad telefonnummer skal indeholde
                        System.out.println("Indtast nyt telefonnummer: ");
                        nytTlf = keyboard.nextLine().trim();
                        if (!nytTlf.matches("^\\d{8}$")) {
                            System.out.println("Ugyldigt telefonnummer.");
                            continue;
                        }
                        break;
                    }
                    ksFundet.setTlf(nytTlf);
                    break;
                }
                case 2:
                    System.out.println("Indtast nyt navn: ");
                    ksFundet.setNavn(keyboard.nextLine());
                    break;
                case 3:
                    System.out.println("Indtast ny alder: ");
                    ksFundet.setAlder(keyboard.nextInt());
                    keyboard.nextLine();
                    break;
                case 4:
                    System.out.println("Indtast ny status (aktiv/passiv)");
                    ksFundet.setStatus(keyboard.nextLine().toLowerCase());
                    break;
                case 5: { //Hvis en konkurrence svømmer skal laves til motionist, skal vi slette konkSvømmer objektet først og lave nyt motionist
                    System.out.println("Indtast ny aktivitet (motionist/konkurrence): ");
                    String nyAktivitet = keyboard.nextLine().toLowerCase();
                    if (nyAktivitet.equals("motionist")) {
                        MotionistSvømmer nyMs = new MotionistSvømmer(
                                ksFundet.getTlf(),
                                ksFundet.getNavn(),
                                ksFundet.getAlder(),
                                ksFundet.getStatus());
                        FileManager.konkurrencistFil.remove(ksFundet); //vi fjerner svømmeren fra konkurrencefil
                        FileManager.motionistFil.add(nyMs); //Tilføjer den nye motionist svømmer til motionistfil
                    } else if (nyAktivitet.equals("konkurrence")) {
                        ksFundet.setAktivitet("konkurrence");
                    } else {
                        System.out.println("Ugyldigt input.");
                    }
                    break;
                }
                case 6:
                    System.out.println("Vælg ny disciplin: ");
                    String nyDisciplin = vælgDisciplin();
                    ksFundet.setDisciplin(nyDisciplin);
                    break;
                case 7:
                    System.out.println(ksFundet);
                    System.out.println("Er du sikker på du vil slette svømmer? ja/nej");
                    String svar = keyboard.nextLine().toLowerCase();
                    if (svar.equals("ja")) {
                        fM.sletObjekt("Konkurrencister.txt", ksFundet.getTlf());
                        System.out.println("Svømmer er slettet.");
                    } else if (svar.equals("nej")) {
                        System.out.println("Sletning annulleret.");
                    }
                    break;
                default:
                    System.out.println("Ugyldigt input.");
            }
        } //redigering af konkSvømmer slut

        System.out.println("Svømmer er opdateret i fil.");
        //Vi skal gemme ændringerne til filerne.
        fM.gemTilFil("Motionister.txt");
        fM.gemTilFil("Konkurrencister.txt");
    }

    public void gemStævne() {
        String tlf="12345678"; String navn="Navn"; String disciplin="crawl";

        String tid="";
        Scanner inputTid= new Scanner(System.in);
        System.out.println("Hvilken tid fik svømmeren?");
        tid=inputTid.nextLine();

        String stævneNavn="";
        Scanner inputStævne=new Scanner(System.in);
        System.out.println("Hvilket stævne har svømmeren deltaget i?");
        stævneNavn=inputStævne.nextLine();

        String dato="";
        Scanner inputDato=new Scanner(System.in);
        System.out.println("Hvilke dato har svømmeren deltaget?");
        dato=inputDato.nextLine();

        String placering="";
        Scanner inputPlacering=new Scanner(System.in);
        System.out.println("Hvilken placering har svøammeren?");
        placering=inputPlacering.nextLine();

        fM.tilføjTilArrayList("Stævner.txt",tlf+";"+navn+";"+disciplin+";"+tid+";"+stævneNavn+";"+dato+";"+placering);
    }

    public void stævneOversigt(){
        fM.udskrivAltFraAL("Stævner.txt");
    }
}
