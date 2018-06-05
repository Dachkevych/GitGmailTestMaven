package com.epam.lab.listeners;

import org.apache.log4j.Logger;
import org.testng.*;
import org.testng.xml.XmlSuite;

import java.util.List;
import java.util.Map;

public class CustomListener implements ITestListener, IReporter {

    private Logger LOGGER = Logger.getLogger(CustomListener.class);

    @Override
    public void onTestStart(ITestResult iTestResult) {
        LOGGER.info("test starts " + iTestResult.getTestName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        LOGGER.info("test passed " + iTestResult.getTestName() + " during time " + (iTestResult.getEndMillis() - iTestResult.getStartMillis()));
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        LOGGER.info("test failed " + iTestResult.getTestName());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        LOGGER.info("test skipped " + iTestResult.getTestName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        LOGGER.info("test failed but within success percentage: " + iTestResult.getTestName());
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        LOGGER.info("test starts " + iTestContext.getName() + " on " + iTestContext.getStartDate());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        LOGGER.info("Passed tests: " + iTestContext.getPassedTests());
        LOGGER.info("Failed tests:" + iTestContext.getFailedTests());
    }

    @Override
    public void generateReport(List<XmlSuite> list, List<ISuite> list1, String s) {
        // Iterating over each suite included in the test
        for (ISuite suite : list1) {
            // Following code gets the suite name
            String suiteName = suite.getName();
            // Getting the results for the said suite
            Map<String, ISuiteResult> suiteResults = suite.getResults();
            for (ISuiteResult sr : suiteResults.values()) {
                ITestContext tc = sr.getTestContext();
                LOGGER.info(
                        "Passed tests for suite '" + suiteName + "' is - " + tc.getPassedTests().getAllResults().size());
                LOGGER.info(
                        "Failed tests for suite '" + suiteName + "' is:" + tc.getFailedTests().getAllResults().size());
                LOGGER.info("Skipped tests for suite '" + suiteName + "' is:"
                        + tc.getSkippedTests().getAllResults().size());
            }
        }
    }
}
