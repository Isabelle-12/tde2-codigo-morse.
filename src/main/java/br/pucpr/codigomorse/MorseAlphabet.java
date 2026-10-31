package br.pucpr.codigomorse;

import java.util.LinkedHashMap;
import java.util.Map;

public class MorseAlphabet {

    public static Map<Character, String> getAlphabet() {
        Map<Character, String> alphabet = new LinkedHashMap<>();

        //Letras
        alphabet.put('A', ".-");
        alphabet.put('B', "-...");
        alphabet.put('C', "-.-.");
        alphabet.put('D', "-..");
        alphabet.put('E', ".");
        alphabet.put('F', "..-.");
        alphabet.put('G', "--.");
        alphabet.put('H', "....");
        alphabet.put('I', "..");
        alphabet.put('J', ".---");
        alphabet.put('K', "-.-");
        alphabet.put('L', ".-..");
        alphabet.put('M', "--");
        alphabet.put('N', "-.");
        alphabet.put('O', "---");
        alphabet.put('P', ".--.");
        alphabet.put('Q', "--.-");
        alphabet.put('R', ".-.");
        alphabet.put('S', "...");
        alphabet.put('T', "-");
        alphabet.put('U', "..-");
        alphabet.put('V', "...-");
        alphabet.put('W', ".--");
        alphabet.put('X', "-..-");
        alphabet.put('Y', "-.--");
        alphabet.put('Z', "--..");

        // Números
        alphabet.put('0', "-----");
        alphabet.put('1', ".----");
        alphabet.put('2', "..---");
        alphabet.put('3', "...--");
        alphabet.put('4', "....-");
        alphabet.put('5', ".....");
        alphabet.put('6', "-....");
        alphabet.put('7', "--...");
        alphabet.put('8', "---..");
        alphabet.put('9', "----.");

        return alphabet;
    }
}