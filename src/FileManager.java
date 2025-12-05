import java.io.*;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class FileManager {
    FileReader fraFil;
    static ArrayList<MotionistSvømmer> motionistFil = new ArrayList<>();
    //ArrayList<TestObjekt> fil2;

    /*public FileManager() throws FileNotFoundException {
        listOfLists.add(list1);
        listOfLists.add(list2);
    } */

    public static void loadFiles(){
        Boolean keepGoing = true;
        while (keepGoing){
            motionistFil.clear();
            try(BufferedReader bReader = new BufferedReader(new FileReader("svømmerFil.txt"))){
                String linje;
                while ((linje = bReader.readLine()) != null ){
                    String[] bidder = linje.split(";");
                    int antalBidder = bidder.length;


                    // TestObjekt tON = TestObjekt.opretTestObjekt(bidder[0], bidder[1], bidder[2]);
                    motionistFil.add(new MotionistSvømmer(bidder[0], parseInt(bidder[1]), bidder[2], bidder[3]));
                }
            } catch (IOException e){
                System.out.println("Fejl ved loading af fil-ArrayLister");
            }
            keepGoing = false;
        }
    }

    public void tilføjTilArray(String filNavn, String filString){
        String[] bidder = filString.split(";");
        switch (filNavn){
            case "svømmerFil.txt":
                motionistFil.add(new MotionistSvømmer(bidder[0], parseInt(bidder[1]), bidder[2], bidder[3]));
                break;
            case "test":
        }
    }

    /*public void gemAltTilFiler() throws IOException {
        String filer = "svømmerFil.txt";
        String[] filBidder = filer.split("-");
        int antalFiler = filBidder.length;
        for(int t=0; t<antalFiler; t++){
            try(FileWriter filRydder = new FileWriter(filBidder[t], false)){
                filRydder.write("");
            } catch (IOException e){
                System.out.println("Fejl ved rydning af fil: "+filBidder[t]);
            }

            try (BufferedWriter bWriter = new BufferedWriter(new FileWriter(filBidder[t],true))){
                for()
            }
        }

    }*/

    void test(){
        //gemFiltest(FileTypes.SWIMMER);
    }

    void skrivTilFil(String filename, String toWrite){

    }

    /*void gemAlt(String filename){
            for(Entity2 e: list2){
                skrivTilFil(filename, e.toTextFile());
            }
            //gem svømmer
            Entity2 entity = new Entity2();
            skrivTilFil("svømmere.txt", entity.toTextFile());

            //for liste af tider
            //gem Tid

    }*/

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
                        MotionistSvømmer tO = motionistFil.get(j);
                        bWriter.write(tO.getAlt());
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
    /*public static void loadFile(){
        svømmerFil = new ArrayList<>();
        TestObjekt tON1 = TestObjekt.opretTestObjekt("1234");
        TestObjekt tON2 = TestObjekt.opretTestObjekt("0000");
        svømmerFil.add(tON1);
        svømmerFil.add(tON2);
    } */

    public void redigerFil(String filNavn, int findIndex, int retIndex, String retTil){

    }

    public void sletObjekt(){
        MotionistSvømmer mS = motionistFil.remove(0);
    }

    public String toString(int index){
        MotionistSvømmer mS = motionistFil.get(index);
        String tilString = mS.getTlf();
        return tilString;
    }
}
