package com.jai.algo;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryGapTest {


    @Test
    public void findLargestBinaryGapWithMap() {
        Assert.assertEquals(2,BinaryGap.findLargestBinaryGapWithMap(9));
        Assert.assertEquals(4,BinaryGap.findLargestBinaryGapWithMap(529));
        Assert.assertEquals(1,BinaryGap.findLargestBinaryGapWithMap(20));
        Assert.assertEquals(0,BinaryGap.findLargestBinaryGapWithMap(15));
        Assert.assertEquals(0,BinaryGap.findLargestBinaryGapWithMap(32));
        Assert.assertEquals(5,BinaryGap.findLargestBinaryGapWithMap(1041));
    }
}