package com.jai.algo;

import java.util.Arrays;

public class Solution2 {

    public int solution(int[] in) {

        // preliminary check to see if its already valid
        int result = validate(in);
        if (result == 0) {
            return 0;
        }
        // Check the valid combinations by rearranging the array
        else if(result == 1){
            int count = 0;
            int[] modified = new int[in.length - 1];
            int idx = 0;
            for (int i = 0; i < in.length; i++) {
                for (int j = 0; j < in.length - 1; j++) {
                    if (idx == i) idx++;
                    modified[j] = in[idx++];
                }
                idx = 0;
                System.out.println(Arrays.toString(modified));
                if (validate(modified) == 1) {
                    count++;
                }
                modified = new int[in.length - 1];

            }
            return count;
        }


        return -1;
    }


    public static int validate(int[] input) {

        int previous = -10;
        boolean valid = false;
        boolean cantOptimise = true;
        for (int i = 0; i < input.length - 1; i++) {
            int current = Integer.compare(input[i], input[i + 1]);
//            System.out.println(previous + " === " + current);
            if (previous != -10) {
                if (previous + current != 0) {
  //                  System.out.println(Arrays.toString(input) + " false");
                    return 1;
                }
                else if (previous + current == 0) {
                    valid = true;
                }
                else {
                    if(previous == -1 && current == -1) {

                    }
                }
            }
            previous = current;
        }
//        System.out.println(Arrays.toString(input) + " true");
        return 0; // already valid (eg. 1,3,1,2)
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        //int[] input = new int[]{1, 3, 1, 2};
        //int[] input = new int[] {1,2,3,4};
        int[] x = new int[]{3, 4, 5, 3, 7};
        System.out.println(s.solution(x));
    }
}
