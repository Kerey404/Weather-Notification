package core;

public class WeatherData {
    private String city;
    private double temperature;
    private double windSpeed;

    public WeatherData(String city, double temperature, double windSpeed) {
        this.city = city;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
    }

    @Override
    public String toString() {
        return String.format("City: %s | Temp: %.1f°C | Wind: %.1f m/s",
                city, temperature, windSpeed);
    }
}