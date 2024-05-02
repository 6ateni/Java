package homework.lesson_3;

import java.util.Arrays;

public class Test_1 {
// Сортировка слиянием

// Внутри класса MergeSort напишите метод mergeSort, который принимает массив целых чисел, реализует алгоритм сортировки слиянием. Метод должен возвращать отсортированный массив.

// Пример
// a = {5, 1, 6, 2, 3, 4} -> [1, 2, 3, 4, 5, 6]

class MergeSort {
    public int[] mergeSort(int[] a) {
        // Напишите свое решение ниже
        int length = a.length;
        if(length <= 1) return a;

        int middle = length / 2;
        int[]left = new int[middle];
        int[]right = new int[length - middle];

        int i = 0;
        int j = 0;
        for (; i < length; i++) {
            if(i < middle){
                left[i] = a[i];
            }
            else{
                right[j] = a[i];
                j++;
            }
        }

        mergeSort(left);
        mergeSort(right);
        merge(a, left, right);
        return a;

    }
    public static void merge(int[] a, int[]left, int[]right) {
        int leftSize = a.length / 2;
        int rightSize = a.length - leftSize;
        int i = 0, l = 0, r = 0;

        while (l < leftSize && r < rightSize) {
            if (left[l] < right[r]) {
                a[i] = left[l];
                i++;
                l++;
            }
            else{
                a[i] = right[r];
                i++;
                r++;
            }
        }
        while (l < leftSize) {
            a[i] = left[l];
            i++;
            l++;
        }
        while (r < rightSize) {
            a[i] = right[r];
            i++;
            r++;
        }
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Printer{ 
    public static void main(String[] args) { 
        int[] a;

        if (args.length == 0) {
        // При отправке кода на Выполнение, вы можете варьировать эти параметры
            a = new int[]{5, 1, 6, 2, 3, 4};
        } else {
            a = Arrays.stream(args[0].split(", ")).mapToInt(Integer::parseInt).toArray();
        }

        MergeSort answer = new Test_1().new MergeSort();
        String itresume_res = Arrays.toString(answer.mergeSort(a));
        System.out.println(itresume_res);
    }
}
}
