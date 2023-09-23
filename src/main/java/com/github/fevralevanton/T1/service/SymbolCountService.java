package com.github.fevralevanton.T1.service;

import com.github.fevralevanton.T1.util.Validator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<Character> characterList = new ArrayList<>();
        for(int i=0; i<string.length(); i++){
            characterList.add(string.charAt(i));
        }
        Map<Character, Integer> symbolsMap = characterList.stream().collect(Collectors.toMap(character->character,
                character -> 1, Integer::sum));
        return symbolsMap.entrySet().stream().sorted(Map.Entry.<Character, Integer>comparingByValue().reversed()).
                map(k->'"'+Character.toString(k.getKey())+'"'+": "+k.getValue()).collect(Collectors.joining(", "));

    }

}
