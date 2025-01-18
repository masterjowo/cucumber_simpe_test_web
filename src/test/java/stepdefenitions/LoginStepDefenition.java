package stepdefenitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import com.simple_web_automation_saucedemo_com.singleton.DriverSingleton;

import org.testng.Assert;


import com.simple_web_automation_saucedemo_com.pageobjects.LoginPage;

class Data_Sementaras {
    private String data_semtara_string;

    public void setTitik_url(String data_semtara_string) {
        this.data_semtara_string = data_semtara_string;
    }

    public String getTitik_url() {
        return this.data_semtara_string;
    }

}

public class LoginStepDefenition {
    // Deklarasi variabel driver sebagai variabel global
    private WebDriver driver;
    Data_Sementaras URL = new Data_Sementaras();
    LoginPage obj;
    
    @Before
    public void setUp() {
        driver = DriverSingleton.getDriver();
        obj = new LoginPage(driver);
    }

    @After
    public void After_setUp() throws InterruptedException {
        Thread.sleep(1000);
        DriverSingleton.quitDriver();
    }

    @Given("Diberikan  user akses halaman {string}")
    public void diberikan_user_akses_halaman_saucedemo_com(String string) throws InterruptedException {
        URL.setTitik_url(string);
        driver.get(string);
    }

    @When("Dan user memasukan UserName {string}")
    public void dan_user_memasukan_UserName(String string) {
        obj.InputUserName(string);
    }

    @When("Dan user memasukan password {string}")
    public void dan_user_memasukan_password(String string) {
        obj.InputUserpasswod(string);
    }

    @When("Dan user menekan tombol login")
    public void dan_user_mmenekan_tombol_login() {
        obj.clickbutton();
    }

    @Then("Maka user dapat melihat {string}")
    public void maka_user_dapat_melihat(String string) throws InterruptedException {
        boolean SameOrNot = URL.getTitik_url().equals(driver.getCurrentUrl());
        if (SameOrNot) {
            Assert.assertEquals(obj.ConditionSuccessOrFailure(URL.getTitik_url().equals(driver.getCurrentUrl())), string);
            System.out.println("berhasil "+obj.ConditionSuccessOrFailure(URL.getTitik_url().equals(driver.getCurrentUrl())) );
        } else {
            Thread.sleep(1000);
            Assert.assertTrue(obj.ConditionSuccessOrFailure(URL.getTitik_url().equals(driver.getCurrentUrl())) != null);// operator ternary
            System.out.println("gagal"+ obj.ConditionSuccessOrFailure(URL.getTitik_url().equals(driver.getCurrentUrl())));
        }
    }

    @When("Ketika user sudah berada pada halaman awal, user dapat melihat {string}")
    public void Ketika_user_sudah_berada_pada_halaman_awal_user_dapat_melihat(String string) {
        Assert.assertEquals(string, obj.pagetitle());
    }

}
