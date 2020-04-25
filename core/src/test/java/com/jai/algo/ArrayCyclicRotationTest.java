package com.jai.algo;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ArrayCyclicRotationTest {

    @Test
    public void rotateArray() {

        int[] result = ArrayCyclicRotation.rotateArray(new int[]{3, 8, 9, 7, 6}, 1);
        System.out.println(Arrays.toString(result));

    }
}