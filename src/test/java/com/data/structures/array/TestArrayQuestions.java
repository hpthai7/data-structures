package com.data.structures.array;

import jdk.internal.cmm.SystemResourcePressureImpl;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class TestArrayQuestions {

    private static final Logger log = LoggerFactory.getLogger(TestArrayQuestions.class);

    private ArrayQuestions arrayQuestions = new ArrayQuestions();

    @Test
    public void testExtractLongestPositiveSequences() {
        List<Integer> list = Arrays.asList(1, 2, -3, 2, 3, 4, -6, 1, 2, 3, 4, 5, -8, 5, 6, 6, 5, 4);
        List<List<Integer>> output = arrayQuestions.findLongestPositiveSequence(list);
        System.out.println("Input list: " + list);
        System.out.println("Extracted lists: " + output);
    }

    @Test
    public void testSortArrayOfArraysAsc() {
        int[][] arrays = new int[][] {
                {1, 2, 4},
                {3, 1},
                {2, 4, 6, 8}
        };

        System.out.println("Before sorting: " + Arrays.deepToString(arrays));

        arrayQuestions.sortArrayOfArrays(arrays);

        System.out.println("After sorting: " + Arrays.deepToString(arrays));
    }

    @Test
    public void testMultiplyArray() {
        int[] array = new int[] {1, 2, 3, 5};
        int ignoredIndex = 2;
        int product = arrayQuestions.multiplyArrayElements(array, ignoredIndex);

        System.out.println("Input array: " + Arrays.toString(array));
        System.out.println("Ignored index: " + ignoredIndex);
        System.out.println("Product: " + product);
    }

    @Test
    public void testArray2DIterator() {
        Integer[][] input = new Integer[][] {
                {1, 2, 4},
                {3, 1},
                {2, 4, 6, 8},
                {},
                {3, 9}
        };
        Array2D<Integer> array2D = new Array2D<>(input);

        System.out.println("Attention: input[position++] <=> input[position], position++");

        System.out.println("\nLoop:");
        for (Integer[] i : input) {
            for (Integer j : i) {
                System.out.print(j + ", ");
            }
        }

        System.out.println("\nIterator:");

        Iterator<Integer> iter = array2D.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + ", ");
        }
    }

}
