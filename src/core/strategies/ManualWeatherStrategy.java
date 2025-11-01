package core.strategies;

import core.UpdateStrategy;
import core.WeatherData;
import java.util.Scanner;

public class ManualWeatherStrategy implements UpdateStrategy {
    @Override
    public WeatherData update(String city) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter temperature for " + city + ": ");
        double temp = sc.nextDouble();
        System.out.print("Enter wind speed: ");
        double wind = sc.nextDouble();
        sc.nextLine();
        return new WeatherData(city, temp, wind);
    }
}