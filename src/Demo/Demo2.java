package Demo;

import KernelImplementation.TestResult1L;

public class Demo2 {
    public static void main(String[] args) {
        TestResult1L result = new TestResult1L();
        result.setExpectedValue("expected");
        result.setActualValue("actual");
        result.compareValues();
        System.out.println(result.generateReport());
    }
}
