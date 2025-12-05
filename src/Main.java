import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard=new Scanner(System.in);
        UserInput test=new UserInput(keyboard);

        Svømmer t1 =test.opretSvømmer();
        System.out.println(t1);
    }
}
