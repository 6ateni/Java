package homework.lesson_2;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

public class Test_2 {

    // Сортировка пузырьком с логированием

    // Реализуйте алгоритм сортировки пузырьком числового массива, результат после
    // каждой итерации запишите в лог-файл.
    // Напишите свой код в методе sort класса BubbleSort. Метод sort принимает на
    // вход один параметр:
    // int[] arr - числовой массив
    // После каждого прохода по массиву ваш код должен делать запись в лог-файл
    // 'log.txt' в формате год-месяц-день час:минуты {массив на данной итерации}.
    // Для логирования использовать логгер logger класса BubbleSort.

    // Пример

    // arr = new int[]{9, 4, 8, 3, 1};
    // sort(arr)

    // При чтении лог-файла получим:
    // 2023-05-19 07:53 [4, 8, 3, 1, 9]
    // 2023-05-19 07:53 [4, 3, 1, 8, 9]
    // 2023-05-19 07:53 [3, 1, 4, 8, 9]
    // 2023-05-19 07:53 [1, 3, 4, 8, 9]
    // 2023-05-19 07:53 [1, 3, 4, 8, 9]

    class BubbleSort {
        // private static File log;
        private static FileWriter fileWriter;

        static String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm ").format(Calendar.getInstance().getTime());

        public static void sort(int[] mas) throws IOException {
            boolean isSorted = false;
            int buf;
            fileWriter = new FileWriter("log.txt");

            while (!isSorted) {

                isSorted = true;
                for (int i = 0; i < mas.length - 1; i++) {
                    if (mas[i] > mas[i + 1]) {
                        isSorted = false;

                        buf = mas[i];
                        mas[i] = mas[i + 1];
                        mas[i + 1] = buf;
                    }
                }
                try {

                    fileWriter.write(timeStamp + Arrays.toString(mas) + "\n");

                    fileWriter.flush();
                } catch (IOException e) {
                }

            }
        }
    }

    // Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
    public class Printer {
        public static void main(String[] args) throws IOException {
            int[] arr = {};

            if (args.length == 0) {
                // При отправке кода на Выполнение, вы можете варьировать эти параметры
                arr = new int[] { 9, 4, 8, 3, 1 };
            } else {
                arr = Arrays.stream(args[0].split(", "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }

            BubbleSort.sort(arr);

            try (BufferedReader br = new BufferedReader(new FileReader("log.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}