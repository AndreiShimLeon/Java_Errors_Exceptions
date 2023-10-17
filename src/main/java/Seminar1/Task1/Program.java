package Seminar1.Task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Program {

    public static Integer divide(int a, int b) {
        if (b != 0) return a / b;
        return null;
    }

    public static void readFile() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String file = scanner.nextLine();
            try {
                FileReader fr = new FileReader(new File(file));
                break;
            } catch (FileNotFoundException e) {
                System.out.println("File doesn't exist. Try again");
            }
        }
    }

    public static int[] sumArrays(int[] a, int[] b) {
        int max = Math.max(a.length, b.length);
        int[] sum = new int[max];

        try {
            for (int i = 0; i < max; i++) {
                sum[i] = a[i] + b[i];
            }
            return sum;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Разные размеры массивов");
            return null;
        }
    }

    public static int sum2DArray(int[][] array) throws IllegalArgumentException, IndexOutOfBoundsException, NullPointerException {
        int result = 0;
        int rows = array.length;
        int columns = array[1].length;
        if (rows == columns) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (array[i][j] == 0 || array[i][j] == 1) result += array[i][j];
                    else {
                        throw new IllegalArgumentException("Неверные элементы массива");
                    }
                }
            }
        } else {
           throw new IndexOutOfBoundsException("Не квадратная матрица");
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(divide(1,0));
//        readFile(new File("1.txt"));
////        readFile();
//        int[] a = new int[]{1, 2, 3, 4};
//        int[] b = new int[]{1, 2, 3, 4, 5};
////        int[] b = new int[]{1, 2, 4, 5};
//        System.out.println(Arrays.toString(sumArrays(a, b)));

//        System.out.println(1/0);

//        int[][] matrix = new int[][]{ {1,2,3}, {1,2,3}, {1,-2,3}};
//        int[][] matrix = new int[][]{ {1,0,1}, {1,0,1}};
        int[][] matrix = new int[][]{{1, 2}, {1, 2}};
        try{
            System.out.println(sum2DArray(matrix));
        } catch (IndexOutOfBoundsException | IllegalArgumentException | NullPointerException e){
            e.printStackTrace();
//            System.out.println(e.getMessage());
        }

        System.out.println("end");
    }

}
