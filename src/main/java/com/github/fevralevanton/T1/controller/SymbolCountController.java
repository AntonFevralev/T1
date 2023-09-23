package com.github.fevralevanton.T1.controller;

import com.github.fevralevanton.T1.error.ValidationError;
import com.github.fevralevanton.T1.exception.WrongStringException;
import com.github.fevralevanton.T1.service.SymbolCountService;
import com.github.fevralevanton.T1.util.Validator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


import javax.websocket.server.PathParam;
@RestController
@RequestMapping("/count")
public class SymbolCountController {

    private final SymbolCountService service;

    public SymbolCountController(SymbolCountService service) {
        this.service = service;
    }

    @GetMapping
    @Tag(name = "Считает количество символов в строке")
    @Operation(description = "Введите строку из латинских символов от 1-100 знаков")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Успешно"),
            @ApiResponse(
                    responseCode = "400",
                    description = "Параметры запроса имеют некорректный формат"),
            @ApiResponse(
                    responseCode = "500",
                    description = "Произошла ошибка, не зависящая от вызывающей стороны"
            )
    })
    public ResponseEntity<String> count(@PathParam(value = "string") String string) {
        return ResponseEntity.ok().body(service.stringConverter(string));
    }
    @ExceptionHandler(WrongStringException.class)
    public ResponseEntity<ValidationError> handler (WrongStringException ex) {
        return ResponseEntity.badRequest().body(new ValidationError(ex.getMessage()));
    }

}
