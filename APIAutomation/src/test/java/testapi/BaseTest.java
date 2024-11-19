package testapi;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utilities.ReportManager;

public class BaseTest {

    @BeforeClass
    public static void setup() {
        // Initialize Extent Report
        ReportManager.initReport("API Automation Report");
    }

    @AfterClass
    public static void tearDown() {
        // Flush (save) the report
        ReportManager.flushReport();
    }
}