import java.io.*;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class FileManager {
    static ArrayList<MotionistSvømmer> motionistFil = new ArrayList<>();
    static ArrayList<KonkSvømmer> konkurrencistFil = new ArrayList<>();
    static ArrayList<Stævne> stævneFil = new ArrayList<>();

    // Tekstlinjerne fra alle filer læses og bliver omdannet til deres respæktive objekttyper,
    // som så bliver lagt i ArrayLister, der også passer med filerne - Altså er der en ArrayListe til hver fil.
    public static void loadFiles(){
        String[] filer = {"Motionister.txt","Konkurrencister.txt", "Stævner.txt"};
        String filNavn;
        int antalFiler = filer.length;
        for (int i = 0; i<antalFiler; i++){
            filNavn = filer[i];
            try(BufferedReader bReader = new BufferedReader(new FileReader(filNavn))){
                String linje;
                switch (filNavn){
                    case "Motionister.txt":
                        while ((linje = bReader.readLine()) != null ){
                            String[] bidder = linje.split(";");
                            // int antalBidder = bidder.length;
                            motionistFil.add(new MotionistSvømmer(bidder[0], bidder[1], parseInt(bidder[2]), bidder[3]));
                        }
                        break;
                    case "Konkurrencister.txt":
                        while ((linje = bReader.readLine()) != null){
                            String[] bidder = linje.split(";");
                            konkurrencistFil.add(new KonkSvømmer(bidder[0], bidder[1], parseInt(bidder[2]), bidder[3], bidder[4]));
                        }
                        break;
                    case "Stævner.txt":
                        while ((linje = bReader.readLine()) != null){
                            String[] bidder = linje.split(";");
                            stævneFil.add(new Stævne(bidder[0], bidder[1], bidder[2], bidder[3], bidder[4], bidder[5], bidder[6]));
                        }
                        break;
                }
            } catch (IOException e){
                System.out.println("Fejl ved loading af fil-ArrayLister");
            }
        }
    }
    // Gemmer IKKE på filen, men blot i en ArrayList, gemTilFil() skal kaldes for at gemme fra ArrayListen til dens fil
    // Modtager navnet på filen der skal gemmes til, og tekststrengen som skal gemmes.
    public void tilføjTilArrayList(String filNavn, String filString){
        String[] bidder = filString.split(";");
        switch (filNavn){ // I første omgang gemmes tekststrengen som objekt i ArrayListen for den givne fil
            case "Motionister.txt":
                motionistFil.add(new MotionistSvømmer(bidder[0],bidder[1], parseInt(bidder[2]), bidder[3]));
                break;

            case "Konkurrencister.txt":
                konkurrencistFil.add(new KonkSvømmer(bidder[0], bidder[1], parseInt(bidder[2]), bidder[3], bidder[4]));
                break;

            case "Stævner.txt":
                stævneFil.add(new Stævne(bidder[0],bidder[1],bidder[2],bidder[3],bidder[4],bidder[5],bidder[6]));
                break;
        }
        gemTilFil(filNavn);
    }

    // Modtager det teksten der skal gemmes, og hvilken fil
    void skrivTilFil(String filNavn, String toWrite){
        try (BufferedWriter bWriter = new BufferedWriter (new FileWriter(filNavn, true))){
            bWriter.write(toWrite);
            bWriter.newLine();
       //     System.out.println("Objekt er gemt i filen: "+filNavn);
        } catch (IOException e){
            System.out.println("Fejl ved skrivning til Fil: "+filNavn);
        }
    }

    // Skal ikke selv gemme til filen, for så se skrivTilFil() lige ovenfor
    public void gemTilFil(String filNavn){
        try (FileWriter filRydder = new FileWriter(filNavn,false)){
            filRydder.write("");
        }   catch (IOException e){
            System.out.println("Fejl ved rydning af fil: "+filNavn);
        }

        switch (filNavn){
            case "Motionister.txt":
                for (int j=0; j<motionistFil.size(); j++){
                    skrivTilFil(filNavn, motionistFil.get(j).lavFilLinje());
                }
                break;
            case "Konkurrencister.txt":
                for (int j=0; j<konkurrencistFil.size(); j++){
                    skrivTilFil(filNavn, konkurrencistFil.get(j).lavFilLinje());
                }
                break;
            case "Stævner.txt":
                for (int j=0; j<stævneFil.size(); j++){
                    skrivTilFil(filNavn, stævneFil.get(j).lavFilLinje());
                }
                break;
            }
    }

    public void redigerArrayList(String filNavn, String findIndex, int retIndex, String retTil){
        switch (filNavn){
            case "Motionister.txt":
                for (int i=0; i<motionistFil.size(); i++){
                    if (motionistFil.get(i).getTlf().equals(findIndex)){
                        indexMotionist(retIndex, retTil, i);
                        break;
                    }
                }
                break;
            case "Konkurrencister.txt":
                for (int i=0; i<konkurrencistFil.size(); i++){
                    if (konkurrencistFil.get(i).getTlf().equals(findIndex)){
                        indexKonkurrencist(retIndex, retTil, i);
                        break;
                    }
                }
                break;
            case "Stævner.txt":
                for (int i=0; i<stævneFil.size(); i++){
                    if (stævneFil.get(i).getTlf().equals(findIndex)){
                        indexStævne(retIndex, retTil, i);
                        break;
                    }
                }
                break;
        }
        gemTilFil(filNavn);
    }

    public void indexMotionist(int retIndex, String retTil, int i){
        switch (retIndex){
            case 0:
                motionistFil.get(i).setTlf(retTil);
                break;
            case 1:
                motionistFil.get(i).setNavn(retTil);
                break;
            case 2:
                motionistFil.get(i).setAlder(parseInt(retTil));
                motionistFil.get(i).setKontingent();
                break;
            case 3:
                motionistFil.get(i).setStatus(retTil);
                break;

        }
    }

    public void indexKonkurrencist(int retIndex, String retTil, int i){
        switch (retIndex){
            case 0:
                konkurrencistFil.get(i).setTlf(retTil);
                break;
            case 1:
                konkurrencistFil.get(i).setNavn(retTil);
                break;
            case 2:
                konkurrencistFil.get(i).setAlder(parseInt(retTil));
                konkurrencistFil.get(i).setKontingent();
                break;
            case 3:
                konkurrencistFil.get(i).setStatus(retTil);
                konkurrencistFil.get(i).setKontingent();
                break;
            case 4:
                konkurrencistFil.get(i).setDisciplin(retTil);
                break;
            case 5:
                konkurrencistFil.get(i).setDisciplinTid(parseInt(retTil));
                break;
        }
    }

    public void indexStævne(int retIndex, String retTil, int i){
        switch (retIndex){
            case 0:
                stævneFil.get(i).setTlf(retTil);
                break;
            case 1:
                stævneFil.get(i).setNavn(retTil);
                break;
            case 2:
                stævneFil.get(i).setDisciplin(retTil);
                break;
            case 3:
                stævneFil.get(i).setTid(retTil);
                break;
            case 4:
                stævneFil.get(i).setStævneNavn(retTil);
                break;
            case 5:
                stævneFil.get(i).setDato(retTil);
                break;
            case 6:
                stævneFil.get(i).setPlacering(retTil);
                break;
        }
    }
    // sletter et objekt fra en ArrayList
    public void sletObjekt(String filNavn, String findIndex){
        switch (filNavn){
            case "Motionister.txt":
                for(int i=0; i<motionistFil.size(); i++){
                   if (motionistFil.get(i).getTlf().equals(findIndex)){
                       motionistFil.remove(i);
                       break;
                   }
                }
            case "Konkurrencister.txt":
                for (int i=0; i<konkurrencistFil.size(); i++){
                    if (konkurrencistFil.get(i).getTlf().equals(findIndex)){
                        konkurrencistFil.remove(i);
                        break;
                    }
                }
                break;
            case "Stævner.txt":
                for (int i=0; i<stævneFil.size(); i++){
                    if (stævneFil.get(i).getTlf().equals(findIndex)){
                        konkurrencistFil.remove(i);
                        break;
                    }
                }
                break;
        }
        gemTilFil(filNavn);
    }
    // Hvad skal den her helt præcist?
    public void udskrivAltFraAL(String filNavn){
        String toString;
        switch (filNavn){
            case "Motionister.txt":
                break;
            case "Konkurrencister.txt":
                break;
            case "Stævner.txt":
                for (int i=0; i<stævneFil.size(); i++){
                    /*for (int j=0; j<6; j++){
                        switch (j){
                            case 0:
                                System.out.print(stævneFil.get(i).getNavn()+":\t");

                                break;
                            case 1:

                                System.out.print(stævneFil.get(i).getStævneNavn()+" ");

                                break;
                            case 2:
                                //System.out.printf("%-5s"," ");
                                System.out.print("Dato:"+stævneFil.get(i).getDato()+" ");
                                break;
                            case 3:
                                //System.out.printf("%-5s"," ");
                                System.out.print("Disciplin: "+stævneFil.get(i).getDisciplin()+" ");
                                break;
                            case 4:
                                //System.out.printf("%-5s"," ");
                                System.out.print("Placering: "+stævneFil.get(i).getPlacering()+" ");
                                break;
                            case 5:
                                //System.out.printf("%-5s"," ");
                                System.out.print("med tiden: "+stævneFil.get(i).getTid());
                        }
                    }*/
                    //System.out.println();
                    System.out.println(stævneFil.get(i).getTilUdskriv());

                }
                break;
        }
    }

    public Svømmer findSvømmerByTlf(String tlf){
        for(MotionistSvømmer ms : motionistFil){
            if(ms.getTlf().equals(tlf)){
                return ms;
            }
            for(KonkSvømmer ks : konkurrencistFil){
                if(ks.getTlf().equals(tlf)){
                    return ks;
                }
            }
        }
        return null; //Hvis tlfnr ikke findes i nogle af filerne.
    }
    // Ikke sikker på hvad denne skal bruges til
    public String toString(int index){
        return "toString, FileManager";
    }
}
