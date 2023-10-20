package Seminar2.Task1;

import java.util.InputMismatchException;
import java.util.Scanner;
//        ● ClassCastException - unchecked
//        ● StackOverflowError - error
//        ● IOError - error
//        ● IOException - checked
//        ● NullPointerException - unchecked
//        ●ConcurrentModificationException - unchecked!
//        ● IllegalArgumentException - unchecked
//        ● EOFException - checked
//        ● ClassNotFoundException - checked
//        ● ThreadDeath - error


public class Program {
    //    Посмотрите на этот код. Все ли с ним хорошо? Если нет, то скорректируйте его и
        //    обоснуйте свое решение.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[10];
        System.out.println("Укажите индекс элемента массива, в который хотите записать значение 1");
        try {
            int index = scanner.nextInt();
            arr[index] = 1;
        } catch (IndexOutOfBoundsException e) { //Замена Exception на IndexOutOfBoundsException
            System.out.println("Указан индекс за пределами массива.");
        } catch (InputMismatchException e) { //Замена Exception на InputMismatchException
            System.out.println("Указано не целое число");
        } catch (Exception e) { //Замена Exception на IndexOutOfBoundsException
            System.out.println("Исключение другого типа");
        } finally {
            scanner.close();
        }
    }
}

