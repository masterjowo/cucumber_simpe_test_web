package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

// E:\QA\QA1\simple_web_automation_saucedemo_com\src\test\resources\feature\End2End_Test.feature
@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/resources/features", // Lokasi file .feature
                strict = true, // Menjalankan strict mode
                glue = { "stepdefenitions" }, // Lokasi step definitions. Cucumber memahami bahwa ini merujuk ke package
                                              // Java stepdefenitions, bukan direktori file di sistem file.
                plugin = {
                        "pretty", // Output konsol yang rapi
                        "html:target/cucumber-report", // HTML report
                        "json:target/cucumber-report.json", // JSON report
                        "junit:target/cucumber-report.xml" // JUnit XML report
                }

)

public class TestRunner {

}