package framework.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Log {

  private static Map<String, Integer> testLastStepNumberMap = new HashMap<>(); // map to store test names

  private static Logger getLog(String className) {
    return LogManager.getLogger(className);
  }

  private static String getCallingClassName() {
    final StackTraceElement[] stackTrace = new Throwable().getStackTrace();
    final String fullClassName = stackTrace[2].getClassName();
    return fullClassName.substring(fullClassName.lastIndexOf('.') + 1);
  }

  private static String getCallingMethodName() {
    final StackTraceElement[] stackTrace = new Throwable().getStackTrace();
    return stackTrace[2].getMethodName();
  }

  public static void step(String message) {
    String className = getCallingClassName();
    String methodName = getCallingMethodName();

    if (testLastStepNumberMap.containsKey(methodName)) {
      int stepNum = testLastStepNumberMap.get(methodName);
      testLastStepNumberMap.replace(methodName, stepNum + 1);
    } else
      testLastStepNumberMap.put(methodName, 1);

    String stepNumber = testLastStepNumberMap.get(methodName).toString();

    String fullMessage = String.format("[STEP %s] %s", stepNumber, message);
    getLog(className).info(fullMessage);
  }

  public static void info(String message) {
    info(getCallingClassName(), message);
  }

  public static void info(String name, String message) {
    System.out.println(name + " " + message);
    getLog(name).info(message);
  }

  public static void debug(String message) {
    debug(getCallingClassName(), message);
  }

  public static void debug(String name, String message) {
    getLog(name).debug(message);
  }
}
