package com.a.afrosin.course.java.core.app;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class GetArrayFromLast4Test {
    private static Main main;
    private int[] testData;
    private int[] resultData;

    @BeforeClass
    public static void beforeStart() {
        main = new Main();
    }

    public GetArrayFromLast4Test(int[] testData, int[] resultData) {
        this.testData = testData;
        this.resultData = resultData;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 3, 4, 3}, new int[]{3}},
                {new int[]{4, 2, 3, 1, 3}, new int[]{2, 3, 1, 3}},
                {new int[]{1, 2, 3, 2, 4}, new int[0]},
                {new int[]{1, 4, 3}, new int[]{3}},
        });
    }

    @Test
    public void get_array_from_last_4() {
        Assert.assertArrayEquals(resultData, main.task_1(testData));
    }
}