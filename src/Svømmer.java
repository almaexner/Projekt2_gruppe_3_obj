public abstract class Svømmer {
    //Variabler
    protected String navn;
    protected int alder;
    protected String tlf;
    protected String status; //aktiv/passiv
    protected String aktivitet; //motionist/konkurrence
    protected int kontingent;

    //Constructor
    public Svømmer(String tlf, String navn, int alder, String status, String aktivitet){
        this.navn=navn;
        this.alder=alder;
        this.tlf=tlf;
        this.status=status;
        this.aktivitet=aktivitet;
        this.kontingent = beregnKontingent();
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

    public int beregnKontingent2(){
        int kVærdi=0;
        if(status.equals("passiv"))
            kVærdi =500;
        else{
            if(alder<18)
                kVærdi=1000;
            if(alder<60)
                kVærdi=1600;
            if(alder>=60)
                kVærdi=1200;
        }
        return kVærdi;
    }

    public String lavFilLinje(){ /// Hvad betyder det for subklasserne at aktivitet er med her?
        return tlf+";"+navn+";"+status+";"+kontingent;
    }
}
