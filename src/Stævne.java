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
    public Stævne(String tlf, String navn, String disciplin, String tid, String stævneNavn, String dato,String placering ) {this.disciplin=disciplin;

    this.tid=tid;
    this.stævneNavn=stævneNavn;
    this.dato=dato;
    this.placering=placering;
    }

    //getters
    public String getTlf(){
        return tlf;
    }
    public String getDisciplin(){
        return disciplin;
    }
    public String getAlt(){
        return tlf+";"+navn+";"+disciplin+";"+tid+";"+stævneNavn+";"+dato+";"+placering;
    }


    //setters
    public void setDisciplin(String nyDis){
        this.disciplin=nyDis;
    }





}
