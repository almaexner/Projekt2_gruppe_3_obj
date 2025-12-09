import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileManager.loadFiles();
        Scanner keyboard=new Scanner(System.in);
        UserInput test=new UserInput(keyboard);
        test.menu();

    }
}
