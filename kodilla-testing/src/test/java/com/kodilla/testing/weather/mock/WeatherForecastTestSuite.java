package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WeatherForecastTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @AfterEach
    public void after() {
        System.out.println("Test #" + testCounter + " has ended");
    }

    @AfterAll
    public static void afterClass() {
        System.out.println("All tests are finished.");
    }

    @Mock
    private Temperatures temperaturesMock;

    public Map<String, Double> generateDataMap() {
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow", 25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);

        Map<String, Double> temperaturesDataMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperaturesMap.entrySet()) {
            temperaturesDataMap.put(temperature.getKey(), temperature.getValue());
        }

        return temperaturesDataMap;
    }

    @Nested
    @DisplayName("Test for Wheather")
    class TestWheather {
        @Test
        void testCalculateForecastWithMock() {
            //Given
            Map<String, Double> temperaturesData = generateDataMap();
            when(temperaturesMock.getTemperatures()).thenReturn(temperaturesData);
            WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

            //When
            int quantityOfSensors = weatherForecast.calculateForecast().size();

            //Then
            Assertions.assertEquals(5, quantityOfSensors);
        }

        @Test
        void testCalculateTemperaturesAverage() {

            //Given
            Map<String, Double> temperaturesData = generateDataMap();
            when(temperaturesMock.getTemperatures()).thenReturn(temperaturesData);
            WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

            //When
            double temperaturesAverage = weatherForecast.calculateTemperaturesAverage();

            //Then
            Assertions.assertEquals(25.56, temperaturesAverage);
        }

        @Test
        void testCalculateMedian() {

            //Given
            Map<String, Double> temperaturesData = generateDataMap();
            when(temperaturesMock.getTemperatures()).thenReturn(temperaturesData);
            WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

            //When
            double median = weatherForecast.calculateMedian();

            //Then
            Assertions.assertEquals(25.5, median);
        }
    }
}