package Seminar3.Task5;

//1. Напишите метод,на вход которогоподаётся двумерный строковый массив
//        размером 4х4. При подаче массива другого размера необходимо бросить
//        исключение MyArraySizeException.
//        2. Далееметод должен пройтись по всем элементам массива,преобразоватьв
//        int и просуммировать. Если в каком-то элементе массива преобразование
//        не удалось (например, в ячейке лежит символ или текст вместо числа),
//        должно быть брошено исключение MyArrayDataException с детализацией, в
//        какой именно ячейкележат неверныеданные.
//        3. В методе main() вызвать полученный метод, обработать возможные
//        исключения MyArraySizeException и MyArrayDataException и вывести
//        результатрасчета (сумму элементов,при условиичто подали на вход
//        корректныймассив).
public class Program {
    public static int sumMatrix(String[][] matr, int limit) {
        if (matr.length != limit) {
            throw new MyArraySizeException(); // если число вложенных массивов не равно параметру Limit
        } else {
            for (int i = 0; i < matr.length; i++) {
                if (matr[i].length != limit) {
                    throw new MyArraySizeException(); // если длина любого вложенного массива не равна параметру Limit
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < matr.length; i++) {
            for (int j = 0; j < matr[1].length; j++) { //Integer.valueOf() and Integer.parseInt()
                try {
                    sum += Integer.parseInt(matr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Ошибка в ячейке " + "[" + i + "] " + "[" + j + "]"); // Ловим ошибку парсинга строки в число и кидаем свою ошибку
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        // Правильная матрица
        String[][] matrix = {
                {"1", "2", "3", "4"},
                {"1", "20", "3", "4"},
                {"1", "2", "3", "3"},
                {"1", "2", "3", "4"}
        };

//        // Матрица с нечисловой ячейкой
//        String[][] matrix = {
//                {"1", "2", "3", "4"},
//                {"1", "20", "ривет", "4"},
//                {"1", "2", "ыы", "3"},
//                {"1", "2", "3", "4"}
//        };
//        // Массив, не являющийся матрицей.
//        String[][] matrix = {
//                {"1", "2", "3", "4", "4"},
//                {"1", "20", "3", "4"},
//                {"1", "2", "3", "3", "3"},
//                {"1", "2", "3", "4"}
//        };
        try {
            System.out.println("Сумма элементов переданной матрицы равна " +
                    sumMatrix(matrix, 4));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e){
            e.printStackTrace();
        }
        System.out.println("Конец программы");
    }
}

class MyArraySizeException extends RuntimeException {
    private String detailedMessage = "Неверный размер массива.";

    @Override
    public String getMessage() {
        return detailedMessage;
    }

    public MyArraySizeException() {
    }
}

class MyArrayDataException extends RuntimeException {
    private String detailedMessage = "Элемент не является целым числом.";

    @Override
    public String getMessage() {
        return detailedMessage;
    }

    public MyArrayDataException() {
    }

    public MyArrayDataException(String message) {
        this.detailedMessage += " " + message;
    }
}
