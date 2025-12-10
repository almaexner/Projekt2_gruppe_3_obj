public class MotionistSvømmer extends Svømmer {

    public MotionistSvømmer(String tlf, String navn, int alder, String status){
        super(tlf, navn, alder, status, "motionist");
    }

    /*public String getAlt(){
        return tlf + ";" + navn + ";" + alder + ";" + status +";"+kontingent;
    }*/
} //Motionist svømmer er meget det samme som Svømmer, men aktivitet er en fast værdi
//"motionist", plus Svømmer er abstract og der kan ikke oprettes objekter derfra,
//Svømmer skal bruges til at nedarve fra.
