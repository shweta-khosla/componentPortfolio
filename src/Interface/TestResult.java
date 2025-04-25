package Interface;

public interface TestResult extends TestResultKernel {

    /**
     * Generates a formatted report of the test result.
     *
     * @return a report string describing the test status, expected/actual
     *         values, and message
     * @ensures <pre>
     * {@code
     * return contains this.status, this.expectedValue, this.actualValue, and this.message
     * }
     * </pre>
     */
    String generateReport();

    /**
     * Compares expected and actual values of this test result.
     *
     * @return true if values match, false otherwise
     * @ensures <pre>
     * {@code
     * if this.expectedValue equals this.actualValue then
     *     this.status = "pass"
     * else
     *     this.status = "fail"
     * }
     * </pre>
     */
    boolean compareValues();
}
