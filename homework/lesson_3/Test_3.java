package homework.lesson_3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.ArrayList;

public class Test_3 {
// Анализатор списка

// Реализуйте метод, который принимает на вход целочисленный массив arr:
// - Создаёт список ArrayList, заполненный числами из исходого массива arr.
// - Сортирует список по возрастанию и выводит на экран.
// - Находит минимальное значение в списке и выводит на экран - Minimum is {число} 
// - Находит максимальное значение в списке и выводит на экран - Maximum is {число}
// - Находит среднее арифметическое значений списка и выводит на экран - Average is =  {число}
// Напишите свой код в методе analyzeNumbers класса Answer. Метод analyzeNumbers принимает на вход один параметр:

// Integer[] arr - массив целых чисел.

// Пример.
// Исходный массив:
// 4, 2, 7, 5, 1, 3, 8, 6, 9
// Результаты:
// [1, 2, 3, 4, 5, 6, 7, 8, 9]
// Minimum is 1
// Maximum is 9


class Answer {
    public static void analyzeNumbers(Integer[] arr) {
      // Введите свое решение ниже
      List <Integer> array = new ArrayList<Integer>(Arrays.asList(arr));
      Collections.sort(array);
      System.out.println(array);
      System.out.println("Minimum is " + Collections.min(array));
      System.out.println("Maximum is " + Collections.max(array));
      if (array.size() > 0){
        double sum = 0;
        for (int j = 0; j < array.size(); j++) {
          sum += array.get(j);
        }
      
      double average = sum / array.size();
      System.out.println("Average is = " + average);
    }
      
    }

}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer{ 
    public static void main(String[] args) { 
      Integer[] arr = {};
      
      if (args.length == 0) {
        // При отправке кода на Выполнение, вы можете варьировать эти параметры
        arr = new Integer[]{4, 2, 7, 5, 1, 3, 8, 6, 9};
      }
      else{
        arr = Arrays.stream(args[0].split(", "))
                        .map(Integer::parseInt)
                        .toArray(Integer[]::new);
      }     
      
      Answer ans = new Test_3().new Answer();      
      ans.analyzeNumbers(arr);
    }
}
}
