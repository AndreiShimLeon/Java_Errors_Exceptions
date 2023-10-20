package Seminar2.Task3;

import java.io.FileReader;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Scanner;

public class Program {
    public static Integer sum2d(String[][] arr) { //Integer вместо int для считывания null
        int sum = 0;
        try {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) { //исключение IndexOutOfBoundsException можно не отлавливать, если указать arr[i].length
                    try {
                        int val = Integer.parseInt(arr[i][j]);
                        sum += val;
                    } catch (NumberFormatException e){ //важно указать здесь, чтобы учесть битые значения
                        System.out.println("Обнаружено битое значение с индексом " + i + ", " + j);
                    }
                }
            }
            return sum;
        } catch (IndexOutOfBoundsException e){
            System.out.println("Размер массива меньше 5");
        } catch (NullPointerException e){
            System.out.println("Не передан массив");
        }
        return null; //нужна другая реализация ошибки!
    }
    public static void main(String[] args) {
        String [][] test = new String[][] { {"1", "2", "парр", "куеу", "5", "6"},
                {"1", "2", "3", "4", "5"},
                {"1", "2", "3", "4", "5", "1"}};
        System.out.println(sum2d(test));
        //System.out.println(sum2d(null)); //для обработки NullPointer
    }

}
