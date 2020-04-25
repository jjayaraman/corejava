package com.jai.algo;


import java.util.Arrays;

/**
 * For example, given
 * <p>
 * A = [3, 8, 9, 7, 6]
 * K = 3
 * the function should return [9, 7, 6, 3, 8]. Three rotations were made:
 * <p>
 * [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
 * [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
 * [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
 */
public class ArrayCyclicRotation {


    /**
     * [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
     *
     * @param input            - input array for data
     * @param numberOfRotation - number of rotation to be done on the array
     */
    public static int[] rotateArray(int[] input, int numberOfRotation) {
        int[] output = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            //int index = numberOfRotation + i < input.length ? (numberOfRotation + i) : (numberOfRotation + i - input.length);
            int index = (input.length - numberOfRotation) + i < input.length ? (input.length - numberOfRotation) + i : ((numberOfRotation + i) - input.length);
            System.out.println(index + " : " +(input.length - numberOfRotation));
            output[i] = input[index];
        }
        return output;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 4, 5};
        int[] output = rotateArray(input, 1);
        System.out.println(Arrays.toString(input));
        System.out.println(Arrays.toString(output));
    }
}
