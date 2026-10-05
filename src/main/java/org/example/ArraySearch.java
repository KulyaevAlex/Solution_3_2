package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class ArraySearch {
    /**
     * Метод линейного поиска числа в массиве
     *
     * @param arr    - Входной массив
     * @param target - Число, которое необходимо найти во входном массиве
     * @return - Индекс найденного числа или -1 (означает, что число не найдено в массиве)
     */
    public static int useLinearSearch(int[] arr, int target) {
        int foundIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                foundIndex = i;
                break;
            }
        }
        return foundIndex;
    }

    /**
     * Метод бинарного поиска числа в массиве
     *
     * @param arr    - Входной массив
     * @param target - Число, которое необходимо найти во входном массиве
     * @return - Индекс найденного числа или -1 (означает, что число не найдено в массиве)
     */
    public static int useBinarySearch(int[] arr, int target) {
        int foundIndex = -1;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                foundIndex = mid;
                break;
            }
            if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            }
        }
        return foundIndex;
    }

    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10);
        }
        System.out.print("Введите число для поиска в массиве: ");
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        System.out.println("Массив: " + Arrays.toString(array));
        System.out.println("Линейный поиск");
        System.out.println((useLinearSearch(array, target) == -1) ? "Не найдено" : "Найдено на индексе: " + useLinearSearch(array, target));
        System.out.println("Бинарный поиск");
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println((useBinarySearch(array, target) == -1) ? "Не найдено" : "Найдено на индексе: " + useBinarySearch(array, target));
    }
}