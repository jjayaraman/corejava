package com.jai.algo;

public class Relay2 {


    public static void find(int[] input) {

        //System.out.println(Arrays.toString(input));
        System.out.println(isValid(input));
    }

    // {3,4,5,3,7};
    public static boolean isValid(int[] in) {
        int previous = -10;
        for (int i = 0; i < in.length-1; i++) {
            int current = Integer.compare(in[i],in[i+1]);
            System.out.println(previous +" === " +current);
            if(previous != -10) {
                if(previous + current != 0) {
                    return false;
                }
            }
            previous = current;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] input = new int[] {1,2,3,4};
        find(input);
    }
}
