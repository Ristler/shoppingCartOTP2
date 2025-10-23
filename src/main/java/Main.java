
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OutputGenerator generator = new OutputGenerator();

        System.out.println("Select language");
        System.out.println("1. Finnish");
        System.out.println("2. Japanese");
        System.out.println("3. Swedish");
        System.out.println("4. English");

        int language = scanner.nextInt();


        switch (language) {
            case 1:
                generator.generateLocalization("fi", "FI");
                break;
            case 2:
                generator.generateLocalization("ja", "JP");
                break;
            case 3:
                generator.generateLocalization("sv", "SE");
                break;

            case 4:
                generator.generateLocalization("en", "US");
                break;
        }
    }
}
