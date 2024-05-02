package homework.lesson_3;


import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Test_2 {
//Удаление четных элементов

//Дан произвольный массив целых чисел. Создайте список ArrayList, заполненный данными из этого массива. 
// Необходимо удалить из списка четные числа и вернуть результирующий.

// Напишите свой код в методе removeEvenNumbers класса Answer. 
// Метод removeEvenNumbers принимает на вход один параметр: Integer[] arr - список целых чисел, 
// возвращает список ArrayList<Integer>

// Примеры.
// Исходный массив:
// 1, 2, 3, 4, 5, 6, 7, 8, 9
// Результат:
// [1, 3, 5, 7, 9]
// Исходный массив:
// 2, 4, 6, 8
// Результат:
// []


class Answer {
  public static void removeEvenNumbers(Integer[] arr) {
    // Введите свое решение ниже
    List <Integer> array = new ArrayList<Integer>(Arrays.asList(arr));

    for (int i = 0; i < array.size(); i++) {
      int item = array.get(i);
      if (item % 2 == 0) {
        array.remove(i);
        i--;
      }
    }
    System.out.println(array);

  }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer{ 
  public static void main(String[] args) { 
    Integer[] arr = {};
    
    if (args.length == 0) {
      // При отправке кода на Выполнение, вы можете варьировать эти параметры
      arr = new Integer[]{2, 4, 6, 8};
    }
    else{
      arr = Arrays.stream(args[0].split(", "))
                      .map(Integer::parseInt)
                      .toArray(Integer[]::new);
    }     
    
    Answer ans = new Test_2().new Answer();      
    ans.removeEvenNumbers(arr);
  }
}
}