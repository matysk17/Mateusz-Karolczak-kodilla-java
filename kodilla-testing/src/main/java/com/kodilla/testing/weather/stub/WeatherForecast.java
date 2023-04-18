package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0); // [1]
        }
        return resultMap;
    }
    public double calculateTemperaturesAverage() {
        double temperatureSum = 0.0;
        List<Double> temp = new ArrayList<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {
            temp.add(temperature.getValue());
            temperatureSum = temperatureSum + temperature.getValue();
        }
        double average = temperatureSum / temp.size();
        return average;
    }

    public double calculateMedian() {
        int index = 0;
        double median = 0.0;
        List<Double> temp = new ArrayList<>();


        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()) {
            temp.add(temperature.getValue());
        }
        Collections.sort(temp);
        int listSize = temp.size();

        if (temp.size() % 2 == 0) {
            index = listSize / 2;
            median = (temp.get(index -1) + temp.get(index)) / 2;

        } else {
            index = (listSize) / 2;
            median = temp.get(index);
        }

        return median;

    }
}