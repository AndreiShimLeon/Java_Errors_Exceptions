package Seminar2;

import java.io.FileReader;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        HashMap<String, String> source = new HashMap<>();
        source.put("Анна", "4");
        source.put("Владимир", "?");
        source.put("Константин", "?");

        HashMap<String, Integer> result = replace(source);
        System.out.println(result);


    }

    public static HashMap<String, Integer> replace(HashMap<String, String> source){
        HashMap<String, Integer> result = new HashMap<>();
        for (String key: source.keySet()){
            if(source.get(key).equals("?")){
                int temp = key.length();
                result.put(key, temp);
            } else {
                result.put(key, Integer.parseInt(source.get(key)));
            }
            };
        return result;
    }

    public static HashMap<String, String> parseStringArray(String[] array){
        HashMap<String, String> result = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            String[] temp = array[i].split("=");
            result.put(temp[0], temp[1]);
        }
        return result;
    }
}
