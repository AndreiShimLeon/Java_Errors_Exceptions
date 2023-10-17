package Seminar1.Group2Variant;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Program {

        //        Делим на 0
//    public static Double  calculate(int num1, int num2){
//        if(num2 != 0){
//            return (double)num1 / num2;
//        }else{
//            System.out.println("На 0 делить нельзя");
//            return null;
//        }
//    }

//    Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
//    и возвращающий новый массив, каждый элемент которого равен сумме элементов двух
//    входящих массивов в той же ячейке.
//    Если длины массивов не равны, необходимо как-то оповестить пользователя.

//    public static int[] arrayCalculate(int[] arr1, int[] arr2){
//        try {
//            int[] resultArray = new int[arr2.length];
//            for (int i = 0; i < resultArray.length; i++) {
//                resultArray[i] = arr1[i] + arr2[i];
//            }
//            return resultArray;
//        }catch (ArrayIndexOutOfBoundsException e){
//            return null;
//        }
//    }

   /*
Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив.
Необходимо посчитать и вернуть сумму элементов этого массива.
При этом накладываем на метод 2 ограничения: метод может работать только с
квадратными массивами (кол-во строк = кол-ву столбцов), и в каждой ячейке может
лежать только значение 0 или 1.
Если нарушается одно из условий, метод должен вернуть код ошибки.
Программа должна корректно обработать код ошибки и вывести соответствующее
сообщение пользователю.
    */

        public static int sumArray(int[][] array){
            if(array.length != array[0].length){
                return -1;
            }
            int sum = 0;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[0].length; j++) {
                    if(array[i][j] <= 1 && array[i][j] >= 0){
                        sum += array[i][j];
                    }else{
                        return -2;
                    }
                }
            }
            return sum;
        }


        public static void main(String[] args) {
            //    Прочесть не существующий файл
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            System.out.println("Введите имя файла -> ");
//            String name = scanner.nextLine();
//            try {
//                FileReader fileReader = new FileReader(name);
//                break;
//            } catch (FileNotFoundException e) {
//                System.out.println("Такого файла не существует");
//            }
//        }
//        System.out.println(Arrays.toString(arrayCalculate(new int[]{1, 2, 3,4}, new int[]{1, 2, 3, 4})));

            int i = sumArray(new int[][]{{1, 0,1},{1, 0}});
            if(i == -1){
                System.out.println("Массив не является квадратным!");
            }
            else if(i == -2) {
                System.out.println("В массиве есть недопустимые значения");
            }
            else {
                System.out.println(i);
            }

        }

}
