package com.data.structures.array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class ArrayQuestions {

    private static final Logger log = LoggerFactory.getLogger(ArrayQuestions.class);

    private List<List<Integer>> extractPositiveSubLists(List<Integer> list) {
        List<Integer> nNegativePositions = new ArrayList<Integer>();

        List<List<Integer>> subLists = new ArrayList<List<Integer>>();

        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i) <= 0) {
                nNegativePositions.add(i);
            }
        }

        for (int i = 0; i < nNegativePositions.size(); ++i) {
            List<Integer> subList;
            if (i == 0) {
                subList = list.subList(0, nNegativePositions.get(i));
            } else {
                subList = list.subList(nNegativePositions.get(i - 1) + 1, nNegativePositions.get(i));
            }
            subLists.add(subList);
        }
        List<Integer> endSubList = list.subList(nNegativePositions.get(nNegativePositions.size() - 1) + 1, list.size());
        subLists.add(endSubList);
        log.debug("Extracted sublists: {}", subLists);
        return subLists;
    }

    private List<Integer> extractSubListSize(List<List<Integer>> list) {
        Iterator<List<Integer>> i = list.iterator();
        List<Integer> sizes = new ArrayList<Integer>();
        while (i.hasNext()) {
            List<Integer> j = i.next();
            sizes.add(j.size());
        }
        log.debug("Extracted subListSizes: {}", sizes);
        return sizes;
    }

    public List<List<Integer>> findLongestPositiveSequence(List<Integer> list) {
        List<List<Integer>> outputLists = new ArrayList<List<Integer>>();
        List<List<Integer>> subLists = extractPositiveSubLists(list);
        List<Integer> subListSize = extractSubListSize(subLists);

        int max = Collections.max(subListSize);
        for (int i = 0; i < subListSize.size(); ++i) {
            if (subListSize.get(i) == max) {
                outputLists.add(subLists.get(i));
            }
        }

        return outputLists;
    }

    public void sortArrayOfArrays(int[][] arrays) {

        Comparator<int[]> comparator = new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1.length > o2.length) return 1;
                if (o1.length < o2.length) return -1;
                for (int i = 0; i < o1.length; ++i) {
                    if (o1[i] > o2[i]) return 1;
                    if (o1[i] < o2[i]) return -1;
                    continue;
                }
                return 0;
            }
        };

        Arrays.sort(arrays, comparator);
    }

    public int multiplyArrayElements(int[] array, int excluded_index) {
        int product = Arrays.stream(array).reduce(1, (a, b) -> a * b);
        return product / array[excluded_index];
    }

}