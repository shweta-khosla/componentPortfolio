package Interface;

/**
 * Kernel interface for a TestResult component. Represents the result of a test
 * with basic pass/fail status, expected/actual values, and an optional message.
 */
public interface TestResultKernel {

    /**
     * Sets the status of this test result.
     *
     * @param status
     *            the status string, e.g., "pass", "fail"
     * @requires status is either "pass" or "fail"
     * @ensures this.status = status
     */
    void setStatus(String status);

    /**
     * Sets the expected value of this test result.
     *
     * @param expected
     *            the expected value of the test
     * @ensures this.expectedValue = expected
     */
    void setExpectedValue(Object expected);

    /**
     * Sets the actual value of this test result.
     *
     * @param actual
     *            the actual value returned by the system
     * @ensures this.actualValue = actual
     */
    void setActualValue(Object actual);

    /**
     * Adds a message to this test result.
     *
     * @param message
     *            the message to add
     * @ensures this.message = message
     */
    void addMessage(String message);
}
