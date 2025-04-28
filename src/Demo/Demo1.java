package Demo;

import KernelImplementation.TestResult1L;

public class Demo1 {
    public static void main(String[] args) {
        TestResult1L result = new TestResult1L();
        result.setExpectedValue(5);
        result.setActualValue(5);
        result.compareValues();
        System.out.println(result.generateReport());
    }
}
