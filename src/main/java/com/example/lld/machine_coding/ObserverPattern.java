package com.example.lld.machine_coding;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {
    public static void main(String[] args) {
        WeatherDetails weatherDetails = new WeatherDetails();
        new DisplayWeather(weatherDetails);
        new DisplayWeather(weatherDetails);
        new DisplayWeather(weatherDetails);
        weatherDetails.setState(10);
    }

    private static class WeatherDetails {
        private int state;
        private final List<DisplayWeather> displayWeathers = new ArrayList<>();

        public void attach(DisplayWeather displayWeather) {
            displayWeathers.add(displayWeather);
        }

        public void setState(int state) {
            this.state = state;
            notifyAllObservers();
        }

        public int getState() {
            return state;
        }

        private void notifyAllObservers() {
            for (DisplayWeather displayWeather : displayWeathers) {
                displayWeather.update();
            }
        }
    }

    private static class DisplayWeather {
        private final WeatherDetails weatherDetails;

        public DisplayWeather(WeatherDetails weatherDetails) {
            this.weatherDetails = weatherDetails;
            weatherDetails.attach(this);
        }

        public void update() {
            System.out.println("State: " + weatherDetails.getState());
        }
        public void remove() {
            weatherDetails.displayWeathers.remove(this);
        }
    }
}
