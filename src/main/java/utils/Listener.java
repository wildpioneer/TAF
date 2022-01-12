package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
    public void onTestFailure(ITestResult result) {
        System.out.println("=========================================");
        System.out.println("Make screenshot.");
        System.out.println("Status is: " + result.getStatus());
        System.out.println("=========================================");
    }
}
