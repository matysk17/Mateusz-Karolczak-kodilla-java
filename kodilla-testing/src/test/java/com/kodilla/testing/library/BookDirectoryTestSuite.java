package com.kodilla.testing.library;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

class BookDirectoryTestSuite {
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
    private LibraryDatabase libraryDatabaseMock;
    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for (int n = 1; n <= booksQuantity; n++) {
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }
    @Test
    void testListBooksWithConditionsReturnList() {

            // Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> resultListOfBooks = new ArrayList<>();
            Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
            Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
            Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
            Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
            resultListOfBooks.add(book1);
            resultListOfBooks.add(book2);
            resultListOfBooks.add(book3);
            resultListOfBooks.add(book4);
            when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);

            // When
            List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

            // Then
            assertEquals(4, theListOfBooks.size());
        }

        @Test
    void testListBooksWithConditionMoreThan20() {
            // Given
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> resultListOf0Books = new ArrayList<>();
            List<Book> resultListOf15Books = generateListOfNBooks(15);
            List<Book> resultListOf40Books = generateListOfNBooks(40);
            when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                    .thenReturn(resultListOf15Books);
            when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks"))
                    .thenReturn(resultListOf0Books);
            when(libraryDatabaseMock.listBooksWithCondition("FortyBooks"))
                    .thenReturn(resultListOf40Books);

            // When
            List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
            List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
            List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");
            // Then

            assertEquals(0, theListOfBooks0.size());
            assertEquals(15, theListOfBooks15.size());
            assertEquals(40, theListOfBooks40.size());
        }

    @Test
    void testListBooksWithConditionFragmentShorterThan3() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);            // [2]
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);               // [3]

        // When
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");       // [4]

        // Then
        assertEquals(0, theListOfBooks10.size());                                     // [5]
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());    // [6]
    }
    @Nested
    @DisplayName("Test for Books in Hands")

    class TestListForBooksInHands {
        @Test
        public void testListBooksInHandsOf() {

            //Given
            LibraryUser libraryUser = new LibraryUser("Jan", "Kowalski", "862546205");
            LibraryUser libraryUser2 = new LibraryUser("Artur", "Duda", "91205876");
            LibraryUser libraryUser3 = new LibraryUser("Grzegorz", "Piotrowski", "856321789");
            BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
            List<Book> resultListOfZeroBooks = new ArrayList<>();
            List<Book> resultListOfOneBook = generateListOfNBooks(1);
            List<Book> resultListOfFiveBooks = generateListOfNBooks(5);


            when(libraryDatabaseMock.listBooksInHandsOf(libraryUser3)).thenReturn(resultListOfFiveBooks);
            when(libraryDatabaseMock.listBooksInHandsOf(libraryUser2)).thenReturn(resultListOfOneBook);
            when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(resultListOfZeroBooks);

            //When
            List<Book> listOfFiveBooks = bookLibrary.listBooksInHandsOf(libraryUser3);
            List<Book> listOfOneBook = bookLibrary.listBooksInHandsOf(libraryUser2);
            List<Book> listOfZeroBooks = bookLibrary.listBooksInHandsOf(libraryUser);

            //Then
            assertEquals(0, listOfZeroBooks.size());
            assertEquals(1, listOfOneBook.size());
            assertEquals(5, listOfFiveBooks.size());

        }
    }
}
