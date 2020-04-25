//package com.jai.algo;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
///**
// *
// * Write a function:
// *
// * class Solution { public int solution(int[] A); }
// *
// * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
// *
// * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
// *
// * Given A = [1, 2, 3], the function should return 4.
// *
// * Given A = [−1, −3], the function should return 1.
// *
// * Write an efficient algorithm for the following assumptions:
// *
// * N is an integer within the range [1..100,000];
// * each element of array A is an integer within the range [−1,000,000..1,000,000].
// * Copyright 2009–2020 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
// * Solution
// * Files
// * task1
// *
// * solution.java
// *
// * test-input.txt
// *
// * solution.java
// * test-input.txt
// * All changes saved
// * Test Output
// * Test Output
// * Set active file solution.java
// */
//public class Relay {
//
//    static void find(int[] in) {
//
//        List input = Arrays.asList(in).stream().sorted().collect(Collectors.toList());
//        System.out.println(input);
//
//        List result = new ArrayList<>();
//        for (int i = 0; i < input.length; i++) {
//            for (int j = i+1; j < input.length; j++) {
//                result.add(input[i] + input[j]);
//            }
//        }
//        result.stream().sorted().collect(Collectors.toList());
//
//        result.stream().filter(r -> inpu)
//        System.out.println(result);
//    }
//
//    public static void main(String[] args) {
//
//        int[] input = new int[] {1, 3, 6, 4, 1, 2};
//        find(input);
//    }
//}
