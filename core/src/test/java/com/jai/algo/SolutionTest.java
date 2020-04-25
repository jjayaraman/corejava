package com.jai.algo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

    private Solution solution;

    @Before
    public void init() {
        solution = new Solution();
    }

    @Test
    public void solution() {
        Assert.assertEquals(0,solution.solution(new int[]{1,3,1,2}));
        Assert.assertEquals(3,solution.solution(new int[]{3,4,5,3,7}));
//        Assert.assertEquals(-1,solution.solution(new int[]{1,2,3,4}));
    }
}