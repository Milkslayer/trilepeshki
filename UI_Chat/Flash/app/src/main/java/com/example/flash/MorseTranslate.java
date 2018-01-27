package com.example.flash;

import android.hardware.Camera;

public class MorseTranslate {
    protected static char[] characters = {
            'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ж', 'З', 'И',
            'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С',
            'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ',
            'Ы', 'Ь', 'Э', 'Ю', 'Я',
            '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', ' ' };
    protected static String[] codeMorze = {
            "*–", "–***", "*--", "--*", "–**", "*", "***–", "--**", "**",
            "*---", "–*–", "*–**", "--", "–*", "---", "*--*", "*–*", "***",
            "–", "**–", "**–*", "****", "–*–*", "---*", "----", "−−*−", "--*--",
            "−*−−", "−**−", "**−**", "**−−", "*−*−",
            "*−−−−", "**−−−", "***−−", "****−", "*****", "−****", "−−***",
            "−−−**", "−−−−*", "−−−−−", "_" };

    public static String toMorze (String text){
        String output = "";
        int index;
        char[] chars = text.toCharArray();
        for (char c : chars){
            if(Character.isLowerCase(c)){
                c = Character.toUpperCase(c);
            }
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
    public static void Code(Camera camera, Camera.Parameters param, char[] str, int dot) throws InterruptedException {
        for(int i = 0; i < str.length; i++){
            if(str[i]=='*'){
                param.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                camera.setParameters(param);
                camera.startPreview();
                Thread.sleep(dot);
                param.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                camera.setParameters(param);
                camera.stopPreview();
                Thread.sleep(dot);
            }else if(str[i]=='-'){
                param.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                camera.setParameters(param);
                camera.startPreview();
                Thread.sleep(3*dot);
                param.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                camera.setParameters(param);
                camera.stopPreview();
                Thread.sleep(dot);
            }else if(str[i]==' '){
                Thread.sleep(3*dot);
            }else if(str[i]=='_'){
                Thread.sleep(7*dot);
            }
        }
    }
}
