package com.github.fevralevanton.T1.service;

import com.github.fevralevanton.T1.exception.WrongStringException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SymbolCountServiceTest {
    @Autowired
    private SymbolCountService service;

    @Test
    void countsCorrectlyWithCorrectString() {
        String strIn = "aaaasssccscd";
        String strOut = service.stringConverter(strIn);
        Assertions.assertEquals("\"a\": 4, \"s\": 4, \"c\": 3, \"d\": 1", strOut);
    }

    @Test
    void throwsExceptionWithLongerString() {
        String strIn = "dfsdsdfsdfsdfssdfsdfdsffdsfdfsdfdsfdssdfsfdfdsfdsdfsfdfdsfsdfdssdffsdsfdfdsfdsfdsfdfdfdssfdfdsfd" +
                "fdsfd";
        Assertions.assertThrows(WrongStringException.class, ()->service.stringConverter(strIn));
        Assertions.assertEquals(101, strIn.length());
    }
    @Test
    void throwsExceptionWithEmptyString() {
        String strIn = "";
        Assertions.assertThrows(WrongStringException.class, ()->service.stringConverter(strIn));
    }

    @Test
    void throwsExceptionWithStringContainsRussianLetters() {
        String strIn = "Ыв";
        Assertions.assertThrows(WrongStringException.class, ()->service.stringConverter(strIn));
    }
    @Test
    void throwsExceptionWithStringContainsDigits() {
        String strIn = "322";
        Assertions.assertThrows(WrongStringException.class, ()->service.stringConverter(strIn));
    }
    @Test
    void throwsExceptionWithStringContainsAnotherSymbols() {
        String strIn = "!@#$";
        Assertions.assertThrows(WrongStringException.class, ()->service.stringConverter(strIn));
    }

}