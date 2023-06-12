package com.hillel.rosenko.lessons.lesson21;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestRunner {

  public static void start(Class<?> testClass) throws Exception {
    if (testClass == null) {
      throw new NullPointerException("testClass is null");
    }
    if (testClass.isAnnotationPresent(RunWith.class)) {

      Object testObject = testClass.getDeclaredConstructor().newInstance();
      Method[] methods = testClass.getDeclaredMethods();

      List<Method> beforeMethods = new ArrayList<>();
      List<Method> testMethods = new ArrayList<>();
      List<Method> afterMethods = new ArrayList<>();


      for (Method method : methods) {
        if (method.isAnnotationPresent(BeforeSuite.class)) {
          beforeMethods.add(method);
        } else if (method.isAnnotationPresent(Test.class)) {
          testMethods.add(method);
        } else if (method.isAnnotationPresent(AfterSuite.class)) {
          afterMethods.add(method);
        }
      }

      if (beforeMethods.size() > 1 || afterMethods.size() > 1) {
        throw new RuntimeException(
            "BeforeSuite та AfterSuite повинні бути присутні у єдиному екземплярі.");
      }

      if (!beforeMethods.isEmpty()) {
        beforeMethods.get(0).invoke(testObject);
      }
      testMethods.sort(Comparator.comparingInt(m -> m.getAnnotation(Test.class).priority()));
      for (Method testMethod : testMethods) {
        testMethod.invoke(testObject);
      }

      if (!afterMethods.isEmpty()) {
        afterMethods.get(0).invoke(testObject);
      }
    } else {
      throw new RuntimeException("У класі відсутня анотація");
    }
  }
}