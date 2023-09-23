package com.github.fevralevanton.T1.util;

import com.github.fevralevanton.T1.exception.WrongStringException;
import org.springframework.boot.autoconfigure.template.PathBasedTemplateAvailabilityProvider;

import java.util.regex.Pattern;

public class Validator {

    /**
     * Проверяет, что строка - латинские символы и ее длина не более 100 символов. Иначе бросает исключение
     * @param string
     */
    public static void ValidateString(String string)  {
        if(string==null||string.isBlank()||string.length()>100||!string.matches("^[a-zA-Z]+$")){
          throw new WrongStringException("Строка не соответствует шаблону, введите корректную строку");
        }
    }

}
