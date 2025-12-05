public class KonkSvømmer extends Svømmer{
    String disciplin;

    //Constructor
    public KonkSvømmer(String navn, int alder, String tlf, String status, String disciplin) {
        super(navn, alder, tlf, status, "konkurrence");
        this.disciplin=disciplin;
    }

    //getter
    public String getDisciplin(){
        return disciplin;
    }
    //setter
    public String setDisciplin(){
        return disciplin;
    }

    @Override
    public String toString(){
        return super.toString()+"Disciplin: "+disciplin+"\n";
    }

}
