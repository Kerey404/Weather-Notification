package facade;

import builder.User;
import core.WeatherStation;
import core.WeatherUpdateStrategy;
import core.observer.MultiCountryObserver;
import core.observer.UserObserver;
import core.strategies.APIWeatherStrategy;
import core.strategies.ManualWeatherStrategy;
import core.strategies.RandomWeatherStrategy;
import adapters.APIWeatherAdapter;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WeatherFacade {
    private final User user;
    private final WeatherStation station;
    private final UserObserver observer;
    private final Scanner sc = new Scanner(System.in);

    private WeatherUpdateStrategy strategy;

    public WeatherFacade(User user) {
        this.user = user;
        this.strategy = new RandomWeatherStrategy();
        this.station = new WeatherStation(strategy);
        this.observer = new UserObserver(user);
        this.station.attach(observer);
    }

    public void updateWeather() {
        station.notifyObservers(user.getCity());
    }

    public void switchStrategy() {
        System.out.println("Choose strategy:");
        System.out.println("1. Random");
        System.out.println("2. Manual");
        System.out.println("3. API");
        System.out.print("Select: ");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1 -> strategy = new RandomWeatherStrategy();
            case 2 -> strategy = new ManualWeatherStrategy();
            case 3 -> strategy = new APIWeatherStrategy(new APIWeatherAdapter());
            default -> {
                System.out.println("Invalid option, keeping previous strategy.");
                return;
            }
        }
        station.setStrategy(strategy);
        System.out.println("✅ Strategy switched successfully!");
    }

    public void changeCity() {
        System.out.print("Enter new city: ");
        String newCity = sc.nextLine();
        user.setCity(newCity);
        System.out.println("🏙️ City updated to " + newCity);
    }

    public void showMultiCountryWeather() {
        List<String> countries = Arrays.asList("Astana", "Almaty", "London", "New York", "Tokyo");
        MultiCountryObserver multi = new MultiCountryObserver(strategy);
        multi.showAll(countries);
    }
}
