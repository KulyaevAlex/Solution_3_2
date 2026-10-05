package org.example;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayMerge {
    /**
     * Метод получения массива из только из четных элементов
     *
     * @param array - Входящий массив
     * @return - Массив из четных элементов
     */
    public static int[] getEvenArray(int[] array) {
        return Arrays.stream(array).filter(x -> x % 2 == 0).toArray();
    }

    /**
     * Метод соединяет два отсортированных массива в один общий
     *
     * @param array1 - Первый массив
     * @param array2 - Второй массив
     * @return - Объединенный массив
     */
    public static int[] merge(int[] array1, int[] array2) {
        int lengthArray1 = array1.length;
        int lengthArray2 = array2.length;
        int[] mergedArray = new int[lengthArray1 + lengthArray2];
        int i = 0; //Индексы массивов
        int j = 0;
        int k = 0;
        while (i < lengthArray1 && j < lengthArray2) {
            if (array1[i] <= array2[j]) {
                mergedArray[k++] = array1[i++];
            } else {mergedArray[k++] = array2[j++];}
        }
        while (i < lengthArray1) {
            mergedArray[k++] = array1[i++];
        }
        while (j < lengthArray2) {
            mergedArray[k++] = array2[j++];
        }
        return mergedArray;
    }

    public static void main(String[] args) {
        int[] array1 = new int[10];
        int[] array2 = new int[8];
        Set<int[]> arraysSet = new HashSet<>();
        arraysSet.add(array1);
        arraysSet.add(array2);
        for (int[] array : arraysSet) {
            for (int i = 0; i < array.length; i++) {
                array[i] = (int) (Math.random() * 10);
            }
        }
        Arrays.sort(array1);
        Arrays.sort(array2);
        System.out.println("Первый отсортированный массив: " + Arrays.toString(array1));
        System.out.println("Второй отсортированный массив: " + Arrays.toString(array2));
        System.out.println("Объединеный масиив: " + Arrays.toString(merge(array1, array2)));
        System.out.println("Массив из четных элементов: " + Arrays.toString(getEvenArray(merge(array1, array2))));
    }
}
