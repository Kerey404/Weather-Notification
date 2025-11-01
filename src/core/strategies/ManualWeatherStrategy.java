package core.strategies;

import core.WeatherUpdateStrategy;
import java.util.Scanner;

public class ManualWeatherStrategy implements WeatherUpdateStrategy {
    private final Scanner sc = new Scanner(System.in);

    @Override
    public String updateWeather(String city) {
        System.out.print("Enter weather condition for " + city + ": ");
        String condition = sc.nextLine();
        System.out.print("Enter temperature: ");
        int temp = sc.nextInt();
        sc.nextLine();
        return city + ": " + condition + " (" + temp + "°C)";
    }
}
