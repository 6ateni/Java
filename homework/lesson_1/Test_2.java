package homework.lesson_1;

public class Test_2{

// Вывести простые числа
// Напишите функцию printPrimeNums, которая выведет на экран все простые числа в промежутке от 1 до 1000, каждое на новой строке.
// Напишите свой код в методе printPrimeNums класса Answer.

// Пример

// 2
// 3
// 5
// 7
// 11
// ...

class Answer {
  public void printPrimeNums(){
      // Напишите свое решение ниже
    for (int i = 2; i < 1001; i++) {
      int count = 0;
      for (int j = 2; j < 1001; j++) {
        if (i % j == 0 & i != j & j != 1) {
          count ++;
         }
       }
       if (count == 0) {
         System.out.println(i);
       }
     }
  }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer{
  public static void main(String[] args) {

    Answer ans = new Test_2().new Answer();
    ans.printPrimeNums();
  }
}


}