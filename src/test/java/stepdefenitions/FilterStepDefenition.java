package stepdefenitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.simple_web_automation_saucedemo_com.singleton.DriverSingleton;
import com.simple_web_automation_saucedemo_com.pageobjects.HomePage;



public class FilterStepDefenition {
    WebDriver driver;
    HomePage obj2;

    public FilterStepDefenition() {
        driver = DriverSingleton.getDriver();
        obj2 = new HomePage(driver); // Inisialisasi HomePage
    }

    @When("Dan user melakukan pengurutan Z ke A mengunakan fitur filter")
    public void dan_user_melakukan_pengurutan_Z_ke_A_mengunakan_fitur_filter() {
        obj2.clickFilter(1);
    }
    @Then("Maka user dapat melihat pengurutan {string}")
    public void maka_user_dapat_melihat_pengurutan(String string) {
        Assert.assertEquals(obj2.checkContain(), string);

    }
    

}
