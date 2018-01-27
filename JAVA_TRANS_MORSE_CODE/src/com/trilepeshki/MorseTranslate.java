package com.trilepeshki;

public class MorseTranslate {
    protected static char[] characters = { 'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ж', 'З', 'И',
            'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С',
            'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ы', 'Ь',
            'Э', 'Ю', 'Я', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', '0' };
    protected static String[] codeMorze = { "*–", "–***", "*––", "––*",
            "–**", "*", "***–", "––**",
            "**", "*–––", "–*–", "*–**",
            "––", "–*", "–––", "*––*",
            "*–*", "***", "–", "**–",
            "**–*", "****", "–*–*",
            "–––*", "––––", "−−*−",
            "−*−−", "−**−", "**−**",
            "**−−", "*−*−", "*−−−−",
            "**−−−", "***−−", "****−",
            "*****", "−****", "−−***",
            "−−−**", "−−−−*", "−−−−−" };
    public String toMorze (String text){
        String output = "";
        int index;
        char[] chars = text.toCharArray();
        for (char c : chars){
            if (c != ' ')
            {
                index = text.indexOf(c);
                output += codeMorze[index] + " ";
            }
        }
        return output;
    }
}
