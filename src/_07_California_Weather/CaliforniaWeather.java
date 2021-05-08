package _07_California_Weather;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

/*
 * OBJECTIVE:
 * 1. Create a program that allows the user to search for the weather
 * conditions of a given city in California. Use the example program below
 * and the Utilities class inside this project to get the temperature data
 * from a day in December 2020.
 * Example: User: Encinitas
 *          Program: Encinitas is Overcast with a tempeature of 59.01 °F
 * 
 * 2. Create a way for the user to specify the weather condition and then
 * list the cities that have those conditions.
 * Example: User: Mostly Cloudy
 *          Program: Long Beach, Pomona, Oceanside, ...
 * 
 * 3. Create a way for the user to enter a minimum and maximum temperature
 * and then list the cities that have temperatures within that range
 * Example: User: minimum temperature °F = 65.0, max temperature °F = 70.0
 *          Program: Fortana, Glendale, Escondido, Del Mar, ...
 *          
 * EXTRA:
 * Feel free to add pictures for specific weather conditions or a thermometer
 * for the temperature. Also If you want your program to get the current day's
 * temperature, you can get a free API key at: https://openweathermap.org/api 
 */

public class CaliforniaWeather {
    
    void start() {
        HashMap<String, WeatherData> weatherData = Utilities.getWeatherData();
        
        // All city keys have the first letter capitalized of each word
//        String cityName = Utilities.capitalizeWords( "National City" );
//        WeatherData datum = weatherData.get(cityName);
        String objective = JOptionPane.showInputDialog(null, "Would you like to search for a city's weather? (Enter \"1\")"
        		+ "\n Would you like to enter a weather condition? (Enter \"2\")"
        		+ "\n Would you like to enter a min and max temp? (Enter \"3\")");
        if (objective.equals("1")) {
        	String city = JOptionPane.showInputDialog(null, "What city do you want the weather for?");
        	city = Utilities.capitalizeWords(city);
        	WeatherData data = weatherData.get(city);
        	if( data == null ) {
                System.out.println("Unable to find weather data for: " + city);
            } else {
                System.out.println(city + " is " + data.weatherSummary + " with a temperature of " + data.temperatureF + " F");
            }
        }else if (objective.equals("2")) {
        	String cities = "";
        	String weather = JOptionPane.showInputDialog(null, "Enter a weather condition to search for:");
        	weather = Utilities.capitalizeWords(weather);
        	for (String s : weatherData.keySet()) {
        		if (weatherData.get(s).weatherSummary.equals(weather)) {
        			cities += s + "\n";
        		}
        	}
        	if (cities.equals("")) {
        		System.out.println("There are no cities with the entered weather statement"); 
        	}else {
        		System.out.println(cities);
        	}
        }else if (objective.equals("3")) {
        	String cities = "";
        	String minimum = JOptionPane.showInputDialog(null, "Enter a min temp:");
        	String maximum = JOptionPane.showInputDialog(null, "Enter a max temp:");
        	int min = Integer.parseInt(minimum);
        	int max = Integer.parseInt(maximum);
        	for (String s : weatherData.keySet()) {
        		if (weatherData.get(s).temperatureF >= min && weatherData.get(s).temperatureF <= max) {
        			cities += s + "\n";
        		}
        	}
        	if (cities.equals ("")) {
            	System.out.println("There are no cities within that temperature range");
        	}else {
        		System.out.println(cities);
        }
        
        }
        
    }
}
