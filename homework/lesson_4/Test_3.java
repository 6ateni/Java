package homework.lesson_4;


import java.util.ArrayDeque;

public class Test_3 {
    //Калькулятор с отменой последней операции
    //В обычный калькулятор без логирования добавьте возможность отменить последнюю операцию.
    //Отмена последней операции должна быть реализована следующим образом: если передан оператор '<' 
    //калькулятор должен вывести результат предпоследней операции.
    
    // Пример
    //calculate('+', 3, 7)
    //calculate('+', 4, 7)
    //calculate('<', 0, 0)
        // 10.0
        // 11.0
        // 10.0
    // calculate('*', 3, 2)
    // calculate('-', 7, 4)
    // calculate('<', 0, 0)
            // 6.0
            // 3.0
            // 6.0

            
            class Calculator {
                private ArrayDeque<Integer> results;

public Calculator() {
    results = new ArrayDeque<Integer>();
}

public int calculate(char op, int a, int b) {

    int result = 0;
    if (op == '+')
        result = a + b;
    else if (op == '-')
        result =  a - b;
    else if (op == '*')
        result =  a * b;
    else if (op == '/')
        result =  a / b;

    if (op == '<') {
        results.removeLast();
        result = results.removeLast();

        /* Вариант без удаления элементов
        Integer beforeLast = null;
        Integer last = null;
        for (Integer item : results) {
            beforeLast = last;
            last = item;
        }
        result = beforeLast;
         */
    } else
        results.add(result);


    return result;
}
            
            }
            
            
            // Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
            public class Printer {
                public static void main(String[] args) {
                    int a, b, c, d;
                    char op, op2, undo;
            
                    if (args.length == 0) {
                    // При отправке кода на Выполнение, вы можете варьировать эти параметры
                        a = 3;
                        op = '+';
                        b = 7;
                        c = 4;
                        op2 = '+';
                        d = 7;
                        undo = '<';
                    } else {
                        a = Integer.parseInt(args[0]);
                        op = args[1].charAt(0);
                        b = Integer.parseInt(args[2]);
                        c = Integer.parseInt(args[3]);
                        op2 = args[4].charAt(0);
                        d = Integer.parseInt(args[5]);
                        undo = args[6].charAt(0);
                    }
            
                    Calculator calculator = new Test_3().new Calculator();
                    float result = calculator.calculate(op, a, b);
                    System.out.println(result);
                    float result2 = calculator.calculate(op2, c, d);
                    System.out.println(result2);
                    float prevResult = calculator.calculate(undo, 0, 0);
                    System.out.println(prevResult);
                }
            }
}
