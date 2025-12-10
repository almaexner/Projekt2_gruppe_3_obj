public class KonkSvømmer extends Svømmer{
    String disciplin;
    int disciplinTid;

    //Constructor
    public KonkSvømmer(String tlf, String navn, int alder, String status, String disciplin) {
        super(tlf, navn, alder, status, "konkurrence");
        this.disciplin=disciplin;
        this.disciplinTid = 0;
    }

    //getter
    public String getDisciplin(){
        return disciplin;
    }
    public int getDisciplinTid(){
        return disciplinTid;
    }

    @Override
    public String lavFilLinje(){
        return super.lavFilLinje()+";"+disciplin+";"+disciplinTid;
    }
    /*public String getAlt() {
        return tlf + ";" + navn + ";" + alder + ";" + status +";"+kontingent+";" + disciplin + ";" + disciplinTid;
    } */
    //setter
    public void setDisciplin(String nyDisciplin){
        this.disciplin = nyDisciplin;
    }
    public void setDisciplinTid(int nyTid){
        this.disciplinTid = nyTid;
    }



}
