import com.kodilla.testing.collection.OddNumbersExterminator;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import org.junit.jupiter.api.*;

public class CollectionTestSuite {


    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @DisplayName("When ArrayList numbers is empty," +
            "Then ArrayList evenNumber should be empty too")

    @Test
    void testOddNumbersExterminatorEmptyList(){

        //Given
        List<Integer> numbers = new ArrayList<>();
        OddNumbersExterminator ext = new OddNumbersExterminator();

        //When
        List<Integer> evenNumbers = ext.exterminate(numbers);
        int result = evenNumbers.size();

        //Then
        Assertions.assertEquals(0, result);

    }


    @DisplayName("When ArrayList numbers contain odd and even numbers," +
            "Then ArrayList evenNumber should be contain only even numbers")
    @Test
    void testOddNumbersExterminatorNormalList(){

        //Given
        List<Integer> numbers = new ArrayList<>();
        OddNumbersExterminator ext = new OddNumbersExterminator();
        numbers.add(20);
        numbers.add(4);
        numbers.add(19);

        //When
        List<Integer> evenNumbers = ext.exterminate(numbers);
        int result = evenNumbers.size();
        List<Integer> expectedNumbers = Arrays.asList(20,4);


        //Then
        Assertions.assertEquals(2, result);
        Assertions.assertEquals(expectedNumbers, evenNumbers);


    }
}