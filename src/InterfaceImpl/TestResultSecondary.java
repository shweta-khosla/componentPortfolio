package InterfaceImpl;

import Interface.TestResult;

/**
 * Abstract class implementing the secondary methods of TestResult.
 */
public abstract class TestResultSecondary implements TestResult {

    @Override
    public boolean compareValues() {
        Object expected = this.getExpectedValue();
        Object actual = this.getActualValue();

        if (expected == null || actual == null) {
            this.addMessage(
                    "One of the values is null, comparison cannot be made.");
            this.setStatus("fail");
            return false;
        }

        if (expected.equals(actual)) {
            this.setStatus("pass");
            return true;
        } else {
            this.setStatus("fail");
            this.addMessage(
                    "Test failed due to mismatch between expected and actual values.");
            return false;
        }
    }

    @Override
    public String generateReport() {
        StringBuilder report = new StringBuilder();
        report.append("Test Result Report\n");
        report.append("------------------\n");
        report.append("Status: ").append(this.getStatus()).append("\n");
        report.append("Expected Value: ").append(this.getExpectedValue())
                .append("\n");
        report.append("Actual Value: ").append(this.getActualValue())
                .append("\n");
        report.append("Message: ").append(this.getMessage()).append("\n");
        return report.toString();
    }

    /**
     * Getter method for status. Kernel implementations must provide this.
     */
    protected abstract String getStatus();

    /**
     * Getter method for expected value. Kernel implementations must provide
     * this.
     */
    protected abstract Object getExpectedValue();

    /**
     * Getter method for actual value. Kernel implementations must provide this.
     */
    protected abstract Object getActualValue();

    /**
     * Getter method for message. Kernel implementations must provide this.
     */
    protected abstract String getMessage();

}