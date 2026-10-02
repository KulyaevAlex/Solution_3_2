package org.example;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayStats {
    /**
     * Константа, определяющая длину массива
     */
    public static int ARRAY_LENGTH = 8;

    /**
     * Метод получения суммы массива
     *
     * @param array - Массив чисел типа int
     * @return - Cумма элементов массива
     */
    public static long arraySum(int[] array) {
        long sum = 0;
        for (int element : array) {
            sum += element;
        }
        return sum;
    }

    /**
     * Метод получения среднего арифметоческого значения массива
     *
     * @param array - Массив чисел типа int
     * @return - Среднее арифметическое значение
     */
    public static double average(int[] array) {
        return (double) arraySum(array) / ARRAY_LENGTH;
    }

    /**
     * Метод определения максимума и минимума массива и их индексов
     *
     * @param array - Массив чисел типа int
     */
    public static void minMax(int[] array) {
        int min = array[0];
        int minIndex = 0;
        int max = array[0];
        int maxIndex = 0;
        for (int i = 1; i < ARRAY_LENGTH; i++) {
            if (array[i] < min) {
                min = array[i];
                minIndex = i;
            }
            if (array[i] > max) {
                max = array[i];
                maxIndex = i;
            }
        }
        System.out.println("Максимум: " + max + " Индекс максимума: " + maxIndex);
        System.out.println("Минимум: " + min + " Индекс минимума: " + minIndex);
    }

    /**
     * Метод определения количества четных и нечетных чисел в массиве
     *
     * @param array - Массив чисел типа int
     */
    public static void getEvenOddCounts(int[] array) {
        int even = 0, odd = 0;
        for (int value : array) {
            if (value % 2 == 0) even++;
            else odd++;
        }
        System.out.println("Четных: " + even + ", Нечетных: " + odd);
    }

    /**
     * Метод определения количества положительных и отрицательных чисел в массиве
     *
     * @param array - Массив чисел типа int
     */
    public static void getPositiveNegativeCounts(int[] array) {
        int positive = 0, negative = 0;
        for (int value : array) {
            if (value > 0) positive++;
            else if (value < 0) negative++;
        }
        System.out.println("Положительных: " + positive + ", отрицательных: " + negative);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите " + ARRAY_LENGTH + " целых чисел через пробел для создания массива: ");
        int[] array = new int[ARRAY_LENGTH];
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println("Массив: " + Arrays.toString(array));
        System.out.println("Сумма: " + arraySum(array));
        System.out.printf("Среднее: %.2f%n", average(array));
        minMax(array);
        getEvenOddCounts(array);
        getPositiveNegativeCounts(array);
        sc.close();
    }
}