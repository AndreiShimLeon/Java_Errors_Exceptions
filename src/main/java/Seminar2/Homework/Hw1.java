package Seminar2.Homework;
/*
Напишите программу, которая проверяет, является ли введенная текстовая строка числом с плавающей точкой (float).
Программа пытается преобразовать введенную строку в число float, и если это успешно, она выводит полученное число.
Если преобразование не удалось, программа выдаёт сообщение об ошибке и возвращает специальное значение Float.NaN, чтобы обозначить ошибку.

На входе:
'3.14'
'Ivan'
На выходе:


3.14
 */
public class Hw1 {
    public static void main(String[] args) {
        String input;

        if (args.length == 0) {
            input = "Dbrnj"; // По умолчанию используем "3.14", если аргумент не передан
        }
        else {
            input = args[0];
        }

        float result = IsFloat.isFloat(input);
        System.out.println(result);
}
class IsFloat {
    public static float isFloat(String input) {
// Введите свое решение ниже
        try {
            return Float.parseFloat(input);
        } catch (NullPointerException e) {
            System.out.println("Ничего не передано");
        } catch (NumberFormatException e) {
            System.out.println("Передано не число с плавающей точкой");
        }
        return Float.NaN;
    }

    }
}