package homework.lesson_5;

import java.util.Arrays;

public class Test_3 {
    // Сортировка массива с использованием кучи

    // Необходимо разработать программу для сортировки массива целых чисел с использованием сортировки кучей (Heap Sort). 
    // Программа должна работать следующим образом:
    // Принимать на вход массив целых чисел для сортировки. Если массив не предоставлен, программа использует массив по умолчанию.
    // Сначала выводить исходный массив на экран.
    // Затем применять сортировку кучей (Heap Sort) для сортировки элементов массива в порядке возрастания.
    // Выводить отсортированный массив на экран.
    // Ваше решение должно содержать два основных метода: buildTree, который строит сортирующее дерево на основе массива, 
    // и heapSort, который выполняет собственно сортировку кучей.
    // Программа должна быть способной сортировать массив, даже если он состоит из отрицательных чисел и имеет дубликаты.

    // На входе:
    //     '5 8 12 3 6 9'
    // На выходе:
    //     Initial array:
    //     [5, 8, 12, 3, 6, 9]
    //     Sorted array:
    //     [3, 5, 6, 8, 9, 12]


class HeapSort {
    
    public static void buildTree(int[] tree, int sortLength) {
           // Введите свое решение ниже
        
        for (int i = sortLength/2 -1; i >=0; i--) {
            int largest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            
            if (right < sortLength){
                if(tree[right] > tree[largest]){
                    int temp = tree[right];
                    tree[right] = tree[largest];
                    tree[largest] = temp;
                }
                if(tree[right]>tree[largest] && tree[left]>tree[largest] && tree[right]>tree[left]){
                    int temp = tree[right];
                    tree[right] = tree[largest];
                    tree[largest] = temp;
                }
            }  

            if (left < sortLength){
                if(tree[left] > tree[largest]){
                    int temp = tree[left];
                    tree[left] = tree[largest];
                    tree[largest] = temp;
                }
                if(tree[left]>tree[largest] && tree[right]>tree[largest] && tree[left]>tree[right]){
                    int temp = tree[left];
                    tree[left] = tree[largest];
                    tree[largest] = temp;
                }
            }   
        }
    }


    public static void heapSort(int[] sortArray, int sortLength) {
// Введите свое решение ниже
        buildTree(sortArray, sortLength);

        for (int i = sortLength-1, j=1; i >0; i--, j++) {
            // buildTree(sortArray, sortLength);
            int temp = sortArray[0];
            sortArray[0] = sortArray[i];
            sortArray[i] = temp;
            buildTree(sortArray, sortLength-j);

        }

    } 
}

// Не удаляйте и не меняйте метод Main! 
public class Printer {
    public static void main(String[] args) {
        int[] initArray;

        if (args.length == 0) {
            initArray = new int[]{17, 32, 1, 4, 25, 17, 0, 3, 10, 7, 64, 1};
        } else {
            initArray = Arrays.stream(args[0].split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        System.out.println("Initial array:");
        System.out.println(Arrays.toString(initArray));
        HeapSort.heapSort(initArray, initArray.length);
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(initArray));
    }
}
}
