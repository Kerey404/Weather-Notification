import builder.*;
import core.*;
import core.observer.*;
import facade.WeatherFacade;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        WeatherFacade facade = new WeatherFacade();

        System.out.println("=== Weather Notification System ===");
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your city: ");
        String city = sc.nextLine();

        User user = new UserBuilder()
                .setName(name)
                .setCity(city)
                .build();

        facade.registerUser(user);

        System.out.println("\n1. Watch current city weather");
        System.out.println("2. Watch multiple countries' weather");
        System.out.println("3. Switch strategy (Random / API / Manual)");
        System.out.println("4. Exit");

        while (true) {
            System.out.print("\nSelect: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> facade.showCurrentWeather(user);
                case 2 -> facade.showMultiCountryWeather(user);
                case 3 -> facade.changeStrategy();
                case 4 -> {
                    System.out.println("Bye!");
                    return;
                }
                default -> System.out.println("Invalid!");
            }
        }
    }
}
