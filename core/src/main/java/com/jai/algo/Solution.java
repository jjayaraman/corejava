package com.jai.algo;

public class Solution {

    public int solution(int[] in) {

        // preliminary check to see if its already valid
        if (isValid(in)) {
            return 0;
        }
        // Check the valid combinations by rearranging the array
        else {
            int count = 0;
            int[] modified = new int[in.length - 1];
            int idx = 0;
            for (int i = 0; i < in.length; i++) {
                for (int j = 0; j < in.length - 1; j++) {
                    if (idx == i) idx++;
                    modified[j] = in[idx++];
                }
                idx = 0;
//                System.out.println(Arrays.toString(modified));
                if (isValid(modified)) {
                    count++;
                }
                modified = new int[in.length - 1];

            }
            return count;
        }


    }


    public static boolean isValid(int[] input) {

        int previous = -10;
        for (int i = 0; i < input.length - 1; i++) {
            int current = Integer.compare(input[i], input[i + 1]);
//            System.out.println(previous + " === " + current);
            if (previous != -10) {
                if (previous + current != 0) {
                    //                  System.out.println(Arrays.toString(input) + " false");
                    return false;
                }
            }
            previous = current;
        }
//        System.out.println(Arrays.toString(input) + " true");
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{1, 3, 1, 2}));  // 0
        System.out.println(s.solution(new int[]{3, 4, 5, 3, 7})); // 3
    }
}
