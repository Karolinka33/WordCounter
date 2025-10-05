package com.example.wordcounter.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class TextCounter {
    public static int getCharsCount(String userInput){
        return userInput.length();//return char count
    };

    public static int getWordCount(String userInput){ // W/O REGEX

        Pattern p = Pattern.compile("\\p{L}+(?:['-]\\p{L}+)*");
        Matcher m = p.matcher(userInput);

        int count = 0;
        while (m.find()) count++;
        return count;
    };

    public static int countSentenceNotations(String userInput) {

        int count = 0;

        for (int i = 0; i < userInput.length(); i++) {
            char ch = userInput.charAt(i);
            if (ch == ' ' || ch == ',' || ch == '.') { //sentence notations, but should include !? as well i think... well, the teacher knows best and asked only for this so lets not sweat it!
                count++;
            }
        }
        return count;
    }

    public static int countNumbers(String userInput) {// W/O REGEX
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(userInput);

        int count = 0;
        while (m.find()) count++;
        return count;

    }
}
