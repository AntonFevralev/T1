package com.github.fevralevanton.T1.exception;

/**
 * Исключение - неверная строка
 */
public class WrongStringException extends RuntimeException{

    public WrongStringException(String message){
        super(message);
    }

}
