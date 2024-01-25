package com.veeva.utility;

import com.veeva.generic.GenericKeywords;
import io.qameta.allure.Step;
import org.apache.logging.log4j.Logger;
import io.qameta.allure.model.Status;

import static io.qameta.allure.Allure.step;

public class ReporterUtilities {

    private static final Logger logger = LoggerUtility.getLogger(ReporterUtilities.class);

    @Step("{0}")
    public static void log(String comment){

    }

    /**
     * Updates the test status in the Allure report and takes a screenshot.
     * Logs the test status using Log4j. If the test status is not 'PASSED',
     * it logs as info, otherwise, it logs as an error.
     *
     * @param status The status of the test (e.g., PASSED, FAILED, SKIPPED, etc.) from Allure's Status enum.
     */
    public static void updateTestStatus(Status status){
        new GenericKeywords().takeScreenshot();
        if(status != Status.PASSED) logger.info("Testcase Passed");
        else logger.error(status);
        step("Test Case "+status.value(), status);
    }

}
