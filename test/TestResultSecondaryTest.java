
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import KernelImplementation.TestResult1L;

public class TestResultSecondaryTest {

    private static class TestStub extends TestResult1L {
    }

    @Test
    public void testCompareValuesPass() {
        TestStub result = new TestStub();
        result.setExpectedValue(100);
        result.setActualValue(100);
        assertTrue(result.compareValues());
        assertEquals("pass", result.getStatus());
    }

    @Test
    public void testCompareValuesFail() {
        TestStub result = new TestStub();
        result.setExpectedValue(100);
        result.setActualValue(200);
        assertFalse(result.compareValues());
        assertEquals("fail", result.getStatus());
    }

    @Test
    public void testGenerateReport() {
        TestStub result = new TestStub();
        result.setStatus("pass");
        result.setExpectedValue(50);
        result.setActualValue(50);
        result.addMessage("Test executed successfully.");
        String report = result.generateReport();
        assertTrue(report.contains("pass"));
        assertTrue(report.contains("50"));
        assertTrue(report.contains("Test executed successfully."));
    }
}
