package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayStats {
    /**
     * Константа, определяющая длину массива
     */
    public static int ARRAY_LENGTH = 8;

    /**
     * Результат поиска минимума и максимума в массиве
     *
     * @param min      - Минимальное значение в массиве
     * @param indexMin - Индекс минимального значения
     * @param max      - Максимальное значение в массиве
     * @param indexMax - Индекс максимального значения
     */
    public record MinMaxResult(int min, int indexMin, int max, int indexMax) {
    }

    /**
     * Результат определения четных и нечетных значений массива
     *
     * @param even - Количество четных значений
     * @param odd  - Количество нечетных значений
     */
    public record EvenOddElements(int even, int odd) {
    }

    /**
     * Результат определения количества положительных и отрицательных чисел в массиве.
     *
     * @param positive - Количество положительных чисел
     * @param negative - Количество отрицательных чисел
     */
    public record PositiveNegativeResult(int positive, int negative) {
    }

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
     * @return - record из минимального и максимального значения и их индексов
     */
    public static MinMaxResult minMax(int[] array) {
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
        return new MinMaxResult(min, minIndex, max, maxIndex);
    }

    /**
     * Метод определения количества четных и нечетных чисел в массиве
     *
     * @param array - Массив чисел типа int
     * @return - record из количества четных и нечетных чисел массива
     */
    public static EvenOddElements getEvenOddCounts(int[] array) {
        int even = 0, odd = 0;
        for (int value : array) {
            if (value % 2 == 0) even++;
            else odd++;
        }
        return new EvenOddElements(even, odd);
    }

    /**
     * Метод определения количества положительных и отрицательных чисел в массиве
     *
     * @param array - Массив чисел типа int
     * @return - record из количества положительных и отрицательных чисел массива
     */
    public static PositiveNegativeResult getPositiveNegativeCounts(int[] array) {
        int positive = 0, negative = 0;
        for (int value : array) {
            if (value > 0) positive++;
            else if (value < 0) negative++;
        }
        return new PositiveNegativeResult(positive, negative);
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
        System.out.println("Максимум: " + minMax(array).max + " Индекс максимума: " + minMax(array).indexMax);
        System.out.println("Минимум: " + minMax(array).min + " Индекс минимума: " + minMax(array).indexMin);
        System.out.println("Четных: " + getEvenOddCounts(array).even + ", Нечетных: " + getEvenOddCounts(array).odd);
        System.out.println("Положительных: " + getPositiveNegativeCounts(array).positive + ", отрицательных: " + getPositiveNegativeCounts(array).negative);
        sc.close();
    }
}