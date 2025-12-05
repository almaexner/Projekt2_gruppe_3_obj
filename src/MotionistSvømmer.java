public class MotionistSvømmer extends Svømmer {

    public MotionistSvømmer(String navn, int alder, String tlf, String status){
        super(navn, alder, tlf, status, "motionist");
    }
} //Motionist svømmer er meget det samme som Svømmer, men aktivitet er en fast værdi
//"motionist", plus Svømmer er abstract og der kan ikke oprettes objekter derfra,
//Svømmer skal bruges til at nedarve fra.
