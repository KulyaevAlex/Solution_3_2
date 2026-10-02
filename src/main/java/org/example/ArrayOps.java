package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayOps {
    /**
     * Константа, определяющая длину массива
     */
    public static int ARRAY_LENGTH = 7;

    /**
     * Метод для переворота массива
     *
     * @param array - Входной массив
     * @return - Перевернутый массив
     */
    public static int[] getReverseArray(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int left = 0, right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
        return array;
    }

    /**
     * Метод молучения массива со сдвигом вправо на один знак
     *
     * @param array - Входной массив
     * @return - Массив со сдвигом вправо на один знак
     */
    public static int[] getArrayWithShift(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int[] arrayWithShift = new int[array.length];
        arrayWithShift[0] = array[array.length - 1];
        for (int i = 1; i < array.length; i++) {
            arrayWithShift[i] = array[i - 1];
        }
        return arrayWithShift;
    }

    /**
     * Метод вывода массива
     *
     * @param array - Входной массив
     */
    public static void printArray(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Используется нулевой массив");
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    /**
     * Метод вывода массива в обратном поорядке
     *
     * @param array - Входной массив
     */
    public static void printReverseArray(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Используется нулевой массив");
        }
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите " + ARRAY_LENGTH + " целых чисел через пробел для создания массива: ");
        int[] array = new int[ARRAY_LENGTH];
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            array[i] = sc.nextInt();
        }
        System.out.print("Прямой порядок: ");
        printArray(array);
        System.out.println();
        System.out.print("Обратный порядок: ");
        printReverseArray(array);
        System.out.println();
        System.out.println("После переворота: " + Arrays.toString(getReverseArray(array)));
        System.out.println("После сдвига вправо: " + Arrays.toString(getArrayWithShift(array)));
        sc.close();
    }
}
