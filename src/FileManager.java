import com.sun.source.tree.SwitchTree;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class FileManager {
    FileReader fraFil;
    static ArrayList<MotionistSvømmer> motionistFil = new ArrayList<>();
    static ArrayList<KonkSvømmer> konkurrencistFil = new ArrayList<>();

    // Tekstlinjerne fra alle filer læses og bliver omdannet til deres respæktive objekttyper,
    // som så bliver lagt i ArrayLister, der også passer med filerne - Altså er der en ArrayListe til hver fil.
    public static void loadFiles(){
        String[] filer = {"Motionister.txt","Konkurrencister.txt"};
        String filNavn;
        int antalFiler = filer.length;
        for (int i = 0; i<antalFiler; i++){
            //motionistFil.clear();
            filNavn = filer[i];
            try(BufferedReader bReader = new BufferedReader(new FileReader(filNavn))){
                String linje;
                switch (filNavn){
                    case "Motionister.txt":
                        while ((linje = bReader.readLine()) != null ){
                            String[] bidder = linje.split(";");
                            // int antalBidder = bidder.length;
                            motionistFil.add(new MotionistSvømmer(bidder[0], parseInt(bidder[1]), bidder[2], bidder[3]));
                        }
                        break;
                    case "Konkurrencister.txt":
                        break;
                }
            } catch (IOException e){
                System.out.println("Fejl ved loading af fil-ArrayLister");
            }
        }
    }
    // Gemmer IKKE på filen, men blot på en ArrayList, gemTilFil() skal kaldes for at gemme fra ArrayListen til dens fil
    // Modtager navnet på filen der skal gemmes til, og tekststrengen som skal gemmes.
    public void tilføjTilArray(String filNavn, String filString){
        String[] bidder = filString.split(";");
        switch (filNavn){ // I første omgang gemmes tekststrengen som objekt i ArrayListen for den givne fil
            case "svømmerFil.txt":
                motionistFil.add(new MotionistSvømmer(bidder[0], parseInt(bidder[1]), bidder[2], bidder[3]));
                break;
            case "test":
        }
    }

    // Modtager det teksten der skal gemmes, og hvilken fil
    void skrivTilFil(String filNavn, String toWrite){
        try (BufferedWriter bWriter = new BufferedWriter (new FileWriter(filNavn, true))){

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

        try (BufferedWriter bWriter = new BufferedWriter (new FileWriter(filNavn, true))){
            int antalObjekter;
            switch (filNavn){
                case "Motionister.txt":
                    antalObjekter = motionistFil.size();
                    for (int j=0; j<antalObjekter; j++){
                        //MotionistSvømmer tO = motionistFil.get(j);
                        skrivTilFil(filNavn, motionistFil.get(j).getAlt());
                        //bWriter.write(tO.getAlt());
                        bWriter.newLine();
                    }
                    break;
                case "test":
                    antalObjekter = 0;
                    for (int j=0; j<antalObjekter; j++){
                        MotionistSvømmer tO = motionistFil.get(j);
                        bWriter.write(tO.getAlt());
                        bWriter.newLine();
                    }

            }
            System.out.println("Gemt objekter til fil: "+filNavn);
        } catch (IOException e){
            System.out.println("Fejl ved indskrivning til Fil: "+filNavn);
        }
    }


    // Bør være ligetil at lave nu
    public void redigerArrayList(String filNavn, String findIndex, int retIndex, String retTil){
        int size;
        switch (filNavn){
            case "Motionister.txt":
                size = motionistFil.size();
                for (int i=0; i<size; i++){
                    if (motionistFil.get(i).getTlf().equals(findIndex)){
                        indexMotionist(retIndex, retTil, i);
                    }
                    /*String linje = motionistFil.get(i).getAlt();
                    String[] bidder = linje.split(";");
                    if (bidder[0].equals(findIndex)){

                    } */
                }
                break;
            case "Konkurrencister.txt":
                size = konkurrencistFil.size();
                for (int i=0; i<size; i++){
                    if (konkurrencistFil.get(i).getTlf().equals(findIndex)){
                        indexKonkurrencist(retIndex, retTil, i);
                    }
                }
                break;
        }
    }

    public void indexMotionist(int retIndex, String retTil, int i){
        switch (retIndex){
            case 0:
                motionistFil.get(i).setTlf(retTil);
            case 1:
                motionistFil.get(i).setNavn(retTil);

        }
    }

    public void indexKonkurrencist(int retIndex, String retTil, int i){
        switch (retIndex){
            case 0:
                break;
        }
    }

    public void sletObjekt(String filNavn, String findIndex){
        int size;
        switch (filNavn){
            case "Motionister.txt":

                break;
        }
    }

    // Ikke sikker på hvad denne skal bruges til
    public String toString(int index){
        MotionistSvømmer mS = motionistFil.get(index);
        String tilString = mS.getTlf();
        return tilString;
    }
}
