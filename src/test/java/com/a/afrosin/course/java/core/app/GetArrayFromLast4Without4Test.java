package com.a.afrosin.course.java.core.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class GetArrayFromLast4Without4Test {

    private int[] testData;

    public GetArrayFromLast4Without4Test(int[] testData) {
        this.testData = testData;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 3, 3}},
                {new int[]{3}},
                {new int[]{1, 2, 3, 2}},
                {new int[0]}
        });
    }

    @Test(expected = RuntimeException.class)
    public void get_array_from_last_4() {
        System.out.println(Arrays.toString(Main.task_1(testData)));
    }
}