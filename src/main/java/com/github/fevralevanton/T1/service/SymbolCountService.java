package com.github.fevralevanton.T1.service;

import com.github.fevralevanton.T1.util.Validator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SymbolCountService {

    /**
     * Конвертер строки в строку-отчет о частоте вхождения символов
     * @param string исходная строка
     * @return Строку-подсчет вхождение символов в исходной строке
     */
    public String stringConverter(String string) {
        Validator.ValidateString(string);
        Map<Character, Integer> symbolsMap = new HashMap<>();
        for(int i=0; i<string.length(); i++){
            if(symbolsMap.containsKey(string.charAt(i))){
            symbolsMap.put(string.charAt(i), symbolsMap.get(string.charAt(i))+1);}
        else{
            symbolsMap.put(string.charAt(i), 1);
        }}
        return symbolsMap.entrySet().stream().sorted(Map.Entry.<Character, Integer>comparingByValue().reversed()).
                map(k->'"'+Character.toString(k.getKey())+'"'+": "+k.getValue()).collect(Collectors.joining(", "));

    }

}
