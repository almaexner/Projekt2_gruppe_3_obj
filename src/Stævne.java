public class Stævne {
    //skal indeholde tlfnr[0], navn[1], disciplin[2], tid[3], stævnenavn[4], dato[5], placering[6]

    String tlf;
    String navn;
    String disciplin;
    String tid;
    String stævneNavn;
    String dato;
    String placering;

    //constructor
    public Stævne(String tlf, String navn, String disciplin, String tid, String stævneNavn, String dato,String placering ) {
        this.tlf=tlf;
        this.navn=navn;
        this.disciplin=disciplin;
        this.tid=tid;
        this.stævneNavn=stævneNavn;
        this.dato=dato;
        this.placering=placering;
    }

    //getters
    public String getTlf(){
        return tlf;
    }
    public String getNavn(){
        return navn;
    }
    public String getDisciplin(){
        return disciplin;
    }
    public String getTid(){
        return tid;
    }
    public String getStævneNavn(){
        return stævneNavn;
    }
    public String getDato(){
        return dato;
    }
    public String getPlacering(){
        return placering;
    }
    /*public String getAlt(){
        return tlf+";"+navn+";"+disciplin+";"+tid+";"+stævneNavn+";"+dato+";"+placering;
    }*/

    public String lavFilLinje(){
        return tlf+";"+navn+";"+disciplin+";"+tid+";"+stævneNavn+";"+dato+";"+placering;
    }

    //setters
    public void setTlf(String nyTlf){
        this.tlf = nyTlf;
    }
    public void setNavn(String nyNavn){
        this.navn = nyNavn;
    }
    public void setDisciplin(String nyDis){
        this.disciplin=nyDis;
    }
    public void setTid(String nyTid){
        this.tid = nyTid;
    }
    public void setStævneNavn(String nyStævneNavn){
        this.stævneNavn = nyStævneNavn;
    }
    public void setDato(String nyDato){
        this.dato = nyDato;
    }
    public void setPlacering(String nyPlacering){
        this.placering = nyPlacering;
    }
}
