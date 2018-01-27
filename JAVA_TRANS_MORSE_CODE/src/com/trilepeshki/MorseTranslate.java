package com.trilepeshki;

import com.sun.xml.internal.fastinfoset.util.CharArray;

public class MorseTranslate {
    protected static char[] characters = {
            'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ж', 'З', 'И',
            'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С',
            'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ',
            'Ы', 'Ь', 'Э', 'Ю', 'Я',
            '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', ' ' };
    protected static String[] codeMorze = {
            "*–", "–***", "*––", "––*", "–**", "*", "***–", "––**", "**",
            "*–––", "–*–", "*–**", "––", "–*", "–––", "*––*", "*–*", "***",
            "–", "**–", "**–*", "****", "–*–*", "–––*", "––––", "−−*−", "--*--",
            "−*−−", "−**−", "**−**", "**−−", "*−*−",
            "*−−−−", "**−−−", "***−−", "****−", "*****", "−****", "−−***",
            "−−−**", "−−−−*", "−−−−−", "_" };

    public static String toMorze (String text){
        String output = "";
        int index;
        char[] chars = text.toCharArray();
        for (char c : chars){
                index = new String(characters).indexOf(c);
                output += codeMorze[index] + " ";
        }
       return output;
    }
    public static String toChar(String textM){
        String input = "";
        String[] str = textM.split(" ");
        for(int i = 0; i < str.length; i++){
            for(int j = 0; j < codeMorze.length; j++) {
                if (str[i].equals(codeMorze[j])){
                    input = input + characters[j];
                }
            }
        }
        return input;
    }
}
