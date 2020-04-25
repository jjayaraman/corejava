package com.jai.algo;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Find binary gaps. That is number of maximum 0s between two 1s
 */
public class BinaryGap {

    /// 10000010001
    public static int findLargestBinaryGapWithMap(int input) {

        String[] inputStringArray = Integer.toBinaryString(input).split("");
        int[] data = Arrays.asList(inputStringArray).stream().mapToInt(Integer::parseInt).toArray();

        Map<Integer, Boolean> map = new HashMap();
        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            int digit = data[i];
            if (digit == 1) {
                map.putIfAbsent(1, true);
                if (count > maxCount) {
                    maxCount = count;
                }
                count = 0;
            } else {
                if (map.containsKey(1)) {
                    count++;
                }
            }
        }

        return maxCount;
    }

    // Refer test cases for more tests for this class
    public static void main(String[] args) {
        System.out.println(BinaryGap.findLargestBinaryGapWithMap(1041));
        System.out.println(BinaryGap.findLargestBinaryGapWithMap(1041));
    }
}
