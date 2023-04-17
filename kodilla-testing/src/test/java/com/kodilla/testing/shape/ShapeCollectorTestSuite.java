package com.kodilla.testing.shape;


import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("TDD: ShapeCollector Test Suite")
public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @BeforeEach
    public void beforeEverytests() {
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

    @Nested
    @DisplayName("Test for Shapes")
    class TestShapes {
        @Test
        void testAddShape() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape = new Square(20);
            //When
            shapeCollector.addShape(shape);
            //Then
            assertEquals("Square", shape.getShapeName());
            assertEquals(400, shape.getField(), 1);
            assertEquals(1, shapeCollector.getListSize());
        }

        @Test
        void testRemoveShape() {
            //Given
            Shape shape = new Circle(30);
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addShape(shape);
            int positionNumber = 0;
            //When
            Shape result1 = shapeCollector.getShape(positionNumber);
            boolean result = shapeCollector.removeShape(shape);
            //Then
            assertEquals(shape, result1);
            assertTrue(result);
            assertEquals(0, shapeCollector.getListSize());
        }

        @Test
        void testremoveShape() {
            //Given
            Shape shape = new Triangle(40, 20);
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addShape(new Circle(50));
            //When
            boolean result = shapeCollector.removeShape(shape);
            //Then
            assertFalse(result);
        }

        @Test
        void testShowFigures() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape = new Square(4);
            shapeCollector.addShape(shape);
            ArrayList<Shape> shapeList= new ArrayList<>();
            shapeList.add(shape);
            //When
            List<Shape> shapeResultList = shapeCollector.getShapeCollector();
            //Then
            assertEquals(shapeList.toString(), shapeResultList.toString());
        }
    }
}