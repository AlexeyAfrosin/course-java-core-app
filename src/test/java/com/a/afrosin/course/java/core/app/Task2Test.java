package com.a.afrosin.course.java.core.app;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Task2Test {

    private int[] testData;
    private boolean assertResult;

    public Task2Test(int[] testData, boolean assertResult) {
        this.testData = testData;
        this.assertResult = assertResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 1, 1, 4, 4, 1, 4, 4}, true},
                {new int[]{1, 1, 1, 1, 1, 1, 1}, false},
                {new int[]{4, 4, 4, 4}, false},
                {new int[]{1, 4, 4, 1, 1, 4, 3}, false}
        });
    }

    @Test
    public void task_2() {
        Assert.assertEquals(assertResult, Main.task_2(testData));
    }
}