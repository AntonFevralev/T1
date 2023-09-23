package com.github.fevralevanton.T1.controller;

import com.github.fevralevanton.T1.service.SymbolCountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/count")
@RequiredArgsConstructor
public class SymbolCountController {

    private final SymbolCountService service;

    @GetMapping
    @Tag(name = "Считает количество символов в строке")
    @Operation(description = "Введите произвольную строку")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Успешно"),
            @ApiResponse(
                    responseCode = "400",
                    description = "Параметры запроса имеют некорректный формат"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Данные не найдены"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Произошла ошибка, не зависящая от вызывающей стороны"
            )
    })
    public ResponseEntity<String> count(@PathParam(value = "string") String string ){
        return ResponseEntity.ok().body(service.stringConverter(string));

    }
}
