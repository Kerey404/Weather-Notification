package facade;

import builder.User;
import core.*;
import core.observer.UserObserver;
import core.strategies.*;
import java.util.Scanner;

public class WeatherFacade {
    private WeatherStation station =
            new WeatherStation(new RandomWeatherStrategy());

    public void registerUser(User user) {
        station.addObserver(new UserObserver(user));
        System.out.println("✅ User " + user + " registered.");
        station.updateWeather(user.getCity());
    }

    public void showCurrentWeather(User user) {
        station.updateWeather(user.getCity());
    }

    public void showMultiCountryWeather(User user) {
        String[] countries = {"Astana", "Tokyo", "Paris", "Berlin", "London"};
        for (String c : countries)
            station.updateWeather(c);
    }

    public void changeStrategy() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Choose strategy (1-Random, 2-API, 3-Manual): ");
        int ch = sc.nextInt();
        sc.nextLine();

        switch (ch) {
            case 1 -> station.setStrategy(new RandomWeatherStrategy());
            case 2 -> station.setStrategy(new APIWeatherStrategy());
            case 3 -> station.setStrategy(new ManualWeatherStrategy());
            default -> System.out.println("Unknown strategy!");
        }
        System.out.println("✅ Strategy updated successfully!");
    }
}
