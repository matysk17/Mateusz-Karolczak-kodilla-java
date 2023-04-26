package com.kodilla.exception.main;

import com.kodilla.exception.io.FileReader;
import com.kodilla.exception.io.FileReaderException;
import org.junit.Test;

import static org.junit.Assert.assertThrows;

public class ExceptionModuleRunner {


    @Test
    void whenFileDosentExistsReadFileShouldThrowException() {
        // given
        FileReader fileReader = new FileReader();
        String fileName = "nie_ma_takiego_pliku.txt";
        // when & then
        assertThrows(FileReaderException.class, () -> fileReader.readFile(fileName));
    }
}