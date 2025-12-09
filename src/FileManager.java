import java.io.*;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class FileManager {
    FileReader fraFil;
    static ArrayList<MotionistSvømmer> motionistFil = new ArrayList<>();
    static ArrayList<KonkSvømmer> konkurrencistFil = new ArrayList<>();
    static ArrayList<Stævne> stævneFil = new ArrayList<>();

    // Tekstlinjerne fra alle filer læses og bliver omdannet til deres respæktive objekttyper,
    // som så bliver lagt i ArrayLister, der også passer med filerne - Altså er der en ArrayListe til hver fil.
    public static void loadFiles(){
        String[] filer = {"Motionister.txt","Konkurrencister.txt"};
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

        int size;
        switch (filNavn){
            case "Motionister.txt":
                size = motionistFil.size();
                for (int j=0; j<size; j++){
                    skrivTilFil(filNavn, motionistFil.get(j).getAlt());
                }
                break;
            case "Konkurrencister.txt":
                size = konkurrencistFil.size();
                for (int j=0; j<size; j++){
                    skrivTilFil(filNavn, konkurrencistFil.get(j).getAlt());
                }
                break;
            }
            System.out.println("Gemt objekter til fil: "+filNavn);
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
            case "Konkurrencister.txt":
                for (int i=0; i<konkurrencistFil.size(); i++){
                    if (konkurrencistFil.get(i).getTlf().equals(findIndex)){
                        indexKonkurrencist(retIndex, retTil, i);
                        break;
                    }
                }
            case "Stævner.txt":
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
                break;
            case 3:
                konkurrencistFil.get(i).setStatus(retTil);
                break;
            case 4:
                konkurrencistFil.get(i).setDisciplin(retTil);
                break;
            case 5:
                konkurrencistFil.get(i).setDisciplinTid(parseInt(retTil));
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
                break;
        }
        gemTilFil(filNavn);
    }
    // Hvad skal den her helt præcist?
    public String læsFraArray(String filNavn, String findIndex, int getIndex){

        return "hej";
    }
    // Ikke sikker på hvad denne skal bruges til
    public String toString(int index){
        return "toString, FileManager";
    }
}
