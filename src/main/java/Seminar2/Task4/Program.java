package Seminar2.Task4;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;


/*Запишите в файл следующие строки:
Анна=4
Елена=5
Марина=6
Владимир=?
Константин=?
Иван=4
Реализуйте метод, который считывает данные из файла и сохраняет в двумерный массив (либо HashMap, если
студенты с ним знакомы). В отдельном методе нужно будет пройти по структуре данных, если сохранено
значение ?, заменить его на соответствующее число.Если на каком-то месте встречается символ, отличный от
числа или ?, бросить подходящее исключение.Записать в тот же файл данные с замененными символами ?
*/
public class Program {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("text.txt");
        String s = "Анна=4\nЕлена=5\nМарина=6\nВладимир=?\nКонстантин=?\nИван=4";
        fw.write(s.trim());
        fw.close();
        FileReader fileReader = new FileReader("text.txt");
        LinkedHashMap<String, Integer> hashMap = new LinkedHashMap<>();
        String temp = "";
        try {
            while (fileReader.ready()) { //ready возвращает true, когда файл доступен и не полностью прочитан
                temp += (char) fileReader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] tempArray = temp.split("\n");
        //System.out.println(parseStringArray(tempArray));
        hashMap = replace(parseStringArray(tempArray));
        FileWriter fileWriter = new FileWriter("text");
        for (String key : hashMap.keySet()) {
            fileWriter.write(key + "=" + hashMap.get(key) + "\n");
        }
        fileWriter.close();

    }

    public static LinkedHashMap<String, String> parseStringArray(String[] array) {
        LinkedHashMap<String, String> result = new LinkedHashMap<>();
        for (int i = 0; i < array.length; i++) {
            String[] temp = array[i].split("=");
            result.put(temp[0], temp[1]);
        }
        return result;
    }

    public static LinkedHashMap<String, Integer> replace(LinkedHashMap<String, String> source) {
        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
        for (String key : source.keySet()) {
            if (source.get(key).equals("?")) {
                int temp = key.length();
                result.put(key, temp);
            } else {
                result.put(key, Integer.parseInt(source.get(key)));
            }
        }
        return result;
    }

}