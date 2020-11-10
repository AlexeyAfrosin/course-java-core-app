package com.a.afrosin.course.java.core.app;
import java.lang.reflect.Method;
import java.util.*;


public class TestRunner {
    public static void start(Class testClass) throws Exception {

        Method[] methodList = testClass.getDeclaredMethods();

        TreeMap<Integer, List<Method>> testSet = new TreeMap<>();

        Method methodBeforeSuite = null;
        Method methodAfterSuite = null;

        for (Method method : methodList) {
            if (method.isAnnotationPresent(Test.class)) {
                int priority = method.getAnnotation(Test.class).priority();
                if (testSet.containsKey(priority)) {
                    List<Method> tmpList = testSet.get(priority);
                    tmpList.add(method);
                    testSet.put(priority, tmpList);
                } else {
                    testSet.put(priority, new ArrayList<>(Collections.singletonList(method)));
                }
            }
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                if (methodBeforeSuite != null) {
                    throw new RuntimeException("Методов с аннотацией BeforeSuite должно быть не более 1");
                }
                methodBeforeSuite = method;

            } else if (method.isAnnotationPresent(AfterSuite.class)) {
                if (methodAfterSuite != null) {
                    throw new RuntimeException("Методов с аннотацией AfterSuite должно быть не более 1");
                }
                methodAfterSuite = method;
            }
        }

        if (methodBeforeSuite != null) {
            methodBeforeSuite.invoke(null);
        }

        testSet.forEach((key, value) -> {
            for (Method method : value) {
                try {
                    System.out.println("=========================================================");
                    System.out.println("Приоритет "+ method.getAnnotation(Test.class).priority());
                    method.invoke(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        if (methodAfterSuite != null) {
            methodAfterSuite.invoke(null);
        }

    }

}
