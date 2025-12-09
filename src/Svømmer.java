public abstract class Svømmer {
    //Variabler
    protected String navn;
    protected int alder;
    protected String tlf;
    protected String status; //aktiv/passiv
    protected String aktivitet; //motionist/konkurrence

    //Constructor
    public Svømmer(String tlf, String navn, int alder, String status, String aktivitet){
        this.navn=navn;
        this.alder=alder;
        this.tlf=tlf;
        this.status=status;
        this.aktivitet=aktivitet;
    }

    //getters
    public String getNavn(){
        return navn;
    }
    public int getAlder(){
        return alder;
    }
    public String getTlf(){
        return tlf;
    }
    public String getStatus(){
        return status;
    }
    public String getAktivitet(){
        return aktivitet;
    }
    public String getAlt(){
        return tlf+";"+navn+";"+alder+";"+status+";"+aktivitet;
    }

    //setters
    public void setNavn(String nyNavn){
        this.navn = nyNavn;
    }
    public void setAlder(int nyAlder){
        this.alder= nyAlder;
    }
    public void setTlf(String nyTlf){
        this.tlf = nyTlf;
        // return tlf;
    }
    public void setStatus(String nyStatus){
        this.status = nyStatus;
    }
    public void setAktivitet(String nyAktivitet){
        this.aktivitet = nyAktivitet;
    }

    public int beregnKontingent(){
         int kVærdi=0;
         if(status.equals("passiv"))
             kVærdi=500;
         if(alder<18)
             kVærdi=1000;
         if(alder<60)
             kVærdi=1600;
         if(alder>=60)
             kVærdi=1200;
         return kVærdi;
    }

    public String lavFilLinje(){
        return tlf+";"+navn+";"+status+";"+aktivitet+";"+beregnKontingent();
    }

 /*   public static Svømmer opretSvømmer() {

         Scanner keyboard = new Scanner(System.in);
        System.out.println("Indtast navn: ");
        String navn = keyboard.nextLine();
        System.out.println("Indtast alder: ");
        int alder = keyboard.nextInt();
        keyboard.nextLine();
        String tlf;

        while(true){
            System.out.println("Indtast gyldigt telefonnummer: ");
            tlf= keyboard.nextLine().trim(); //.trim() for at "ignorere" mellemrum ved start og slut.
            if(tlf.matches("^\\d{8}$")){ // ^\\d{8}$ laves for at sikre der ikke må være tegn, og {8} at det er 8 cifre der skal indtastes.
                break;
            } else{
                System.out.println("Du har indtastet et ugyldigt telefonnummer. Prøv igen.");
            }
        }

        String status="";
        int valgStatus;
        while (true){
            System.out.println("Vælg om svømmer ønsker at være et aktivt eller passivt medlem:");
            System.out.println("Tast 1 for aktiv");
            System.out.println("Tast 2 for passiv");
            valgStatus=keyboard.nextInt();
            if(valgStatus==1){
                status="aktiv";
                break;
            } else if (valgStatus==2){
                status="passiv";
                break;
            } else {
                System.out.println("Forkert input, prøv igen.");
            }
        }
        String aktivitet="";
        int valgAktivitet;
        while (true){
            System.out.println("Vælg om svømmer er motionistsvømmer eller konkurrencesvømmer:");
            System.out.println("Tast 1 for motionist");
            System.out.println("Tast 2 for konkurrence");
            valgAktivitet= keyboard.nextInt();
            if(valgAktivitet==1){
                aktivitet="motionist";
                break;
            } else if (valgAktivitet==2){
                aktivitet="konkurrence";
                break;
            } else{
                System.out.println("Forkert input, prøv igen.");
            }
        }
       // Fil.gemFil(tlf+";"+navn+";"+alder+";"+status+";"+aktivitet+";"+kontingent(status,alder), "svømmerFil.txt");
      //  Svømmer s = new Svømmer(navn, alder, tlf, status, aktivitet);
        return Svømmer.opretSvømmer();
    }*/
  //  public static void main(String[] args) {
      //  Svømmer s=opretSvømmer();
  //  }
}
