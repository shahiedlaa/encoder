package com.luv2code.springcoredemo.common;

import java.util.Arrays;

public class Characters {

    String[] characters = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T",
            "U","V","W","X","Y","Z","0","1","2","3","4","5","6","7","8","9","(",")","*","+",",","-",".","/"};

    public Characters() {}

    public String[] offsetCharacters(int offset) {
        String[] charactersList = new String[characters.length];
        for (int i = 0; i < characters.length; i++) {
            int newIndex = (offset + i) % characters.length;
            charactersList[newIndex] = characters[i];
        }
        return charactersList;
    }

    public int toGetOffset(String text){
        String textRaw = text.toUpperCase().trim();
        String firstCharacter = textRaw.substring(0, 1);
        return Arrays.asList(characters).indexOf(firstCharacter);
    }

    public String decode(String encodedText) {
        String encodedTextTrimmed = encodedText.toUpperCase().trim().substring(1);
        String[] offsetCharacters = offsetCharacters(toGetOffset(encodedText));

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < encodedTextTrimmed.length(); i++) {
            String character = encodedTextTrimmed.substring(i, i + 1);
            int offsetIndex = Arrays.asList(offsetCharacters).indexOf(character);

            if (offsetIndex == -1 && character.equals(" ")) {
                builder.append(" ");
            }
            else if (offsetIndex == -1) {
                builder.append(character);
            }
            else {
                builder.append(characters[offsetIndex]);
            }
        }
        return builder.toString();
    }

    public String encode(String plainText) {
        String plainTextTrimmed = plainText.toUpperCase().trim().substring(1);
        String[] offsetCharacters = offsetCharacters(toGetOffset(plainText));

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < plainTextTrimmed.length(); i++) {
            String character = plainTextTrimmed.substring(i, i + 1);
            int offsetIndex = Arrays.asList(characters).indexOf(character);

            if (offsetIndex == -1 && character.equals(" ")) {
                builder.append(" ");
            }
            else if (offsetIndex == -1) {
                builder.append(character);
            }
            else {
                builder.append(offsetCharacters[offsetIndex]);
            }
        }
        return builder.toString();
    }
}
