package com.github.fevralevanton.T1.error;


/**
 * Объект для передачи сообщения ошибки ваоидации
 */
public class ValidationError {

    public String message;

    public ValidationError(String message) {
        this.message = message;
    }
}
