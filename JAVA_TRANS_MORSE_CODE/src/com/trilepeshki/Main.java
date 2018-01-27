package com.trilepeshki;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text= reader.readLine();
        String morse = MorseTranslate.toMorze(text);
        System.out.println(morse);
        String str = MorseTranslate.toChar(morse);
        System.out.println(str);
    }
}
