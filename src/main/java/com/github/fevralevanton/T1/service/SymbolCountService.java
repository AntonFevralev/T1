package com.github.fevralevanton.T1.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SymbolCountService {
    public String stringConverter(String string){
        List<Character> characterList = new ArrayList<>();
        for(int i=0; i<string.length(); i++){
            characterList.add(string.charAt(i));
        }
        Map<Character, Integer> symbolsMap = characterList.stream().collect(Collectors.toMap(character->character, character -> 1, Integer::sum));
        return symbolsMap.entrySet().stream().sorted(Map.Entry.<Character, Integer>comparingByValue().reversed()).toString();

    }


}
