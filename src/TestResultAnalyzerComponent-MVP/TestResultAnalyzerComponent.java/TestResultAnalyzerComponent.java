public class TestResultAnalyzerComponent {
    // Fields
    private String status;         // Pass/Fail status of the test
    private Object expectedValue;  // Expected value for the test case
    private Object actualValue;    // Actual value returned by the system
    private String message;        // Message for logging the result

    // Constructor (changed the name to match the class name)
    public TestResultAnalyzerComponent() {
        this.status = "Not Run";    // Default status when a test is not run
        this.expectedValue = null;
        this.actualValue = null;
        this.message = "";
    }

    // Kernel Methods
    public void setStatus(String status) {
        this.status = status;
    }

    public void setExpectedValue(Object expected) {
        this.expectedValue = expected;
    }

    public void setActualValue(Object actual) {
        this.actualValue = actual;
    }

    public void addMessage(String message) {
        this.message = message;
    }

    // Secondary Methods
    public String generateReport() {
        StringBuilder report = new StringBuilder();
        report.append("Test Result Report\n");
        report.append("------------------\n");
        report.append("Status: " + this.status + "\n");
        report.append("Expected Value: " + this.expectedValue + "\n");
        report.append("Actual Value: " + this.actualValue + "\n");
        if (!this.message.isEmpty()) {
            report.append("Message: " + this.message + "\n");
        }
        return report.toString();
    }

    public boolean compareValues() {
        if (this.expectedValue == null || this.actualValue == null) {
            // Handle null values gracefully
            addMessage("One of the values is null, comparison cannot be made.");
            setStatus("fail");
            return false;
        }
        if (this.expectedValue.equals(this.actualValue)) {
            setStatus("pass");
            return true;
        } else {
            setStatus("fail");
            addMessage("Test failed due to mismatch between expected and actual values.");
            return false;
        }
    }

    // Main method to demonstrate usage of the TestResultAnalyzerComponent class
    public static void main(String[] args) {
        // Example Test Case 1: Passing Test
        TestResultAnalyzerComponent test1 = new TestResultAnalyzerComponent();
        test1.setExpectedValue(100);
        test1.setActualValue(100);
        test1.compareValues();
        System.out.println(test1.generateReport());

        // Example Test Case 2: Failing Test
        TestResultAnalyzerComponent test2 = new TestResultAnalyzerComponent();
        test2.setExpectedValue("Correct");
        test2.setActualValue("Wrong");
        test2.compareValues();
        System.out.println(test2.generateReport());

        // Example Test Case 3: Null Value Test
        TestResultAnalyzerComponent test3 = new TestResultAnalyzerComponent();
        test3.setExpectedValue(null);
        test3.setActualValue(100);
        test3.compareValues();
        System.out.println(test3.generateReport());
    }
}
