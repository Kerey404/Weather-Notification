import builder.User;
import builder.UserBuilder;
import facade.WeatherFacade;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== 🌤️ Welcome to Weather Notification System ===");
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your city: ");
        String city = sc.nextLine();

        User user = new UserBuilder()
                .setName(name)
                .setCity(city)
                .build();

        WeatherFacade facade = new WeatherFacade(user);

        while (true) {
            System.out.println("\n========= MENU =========");
            System.out.println("1. Get current weather");
            System.out.println("2. Switch update strategy");
            System.out.println("3. Change city");
            System.out.println("4. Show multi-country weather");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> facade.updateWeather();
                case 2 -> facade.switchStrategy();
                case 3 -> facade.changeCity();
                case 4 -> facade.showMultiCountryWeather();
                case 5 -> {
                    System.out.println("👋 Goodbye, " + user.getName() + "!");
                    return;
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }
}
