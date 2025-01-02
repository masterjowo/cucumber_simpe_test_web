package com.simple_web_automation_saucedemo_com.pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import dev.failsafe.internal.util.Assert;

public class LoginPage {

    WebDriver driver;// Deklarasi variabel driver sebagai variabel global
    // Konstruktor dengan parameter

    public LoginPage(WebDriver driver) {
        // super(driver);
        this.driver = driver;// Menggunakan 'this' untuk membedakan antara variabel instance dan parameter
        PageFactory.initElements(driver, this);// fitur bawaan Selenium yang secara otomatis menginisialisasi
                                               // elemen-elemen web yang diberi anotasi seperti @FindBy di dalam kelas
                                               // Metode ini memastikan semua elemen pada halaman web di-bind ke
                                               // variabel dalam kelas.
    }
    @FindBy(xpath = "//div[contains(text(), 'Swag Labs')]")
    public WebElement titlePage ;
    @FindBy(xpath = "//*[@id='user-name']")
    public WebElement userName;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement userPassword;

    @FindBy(xpath = "//*[@id='login-button']")
    public WebElement login;

    @FindBy(xpath = "//h3[@data-test='error']")
    public WebElement errorMessageElement;

    @FindBy(xpath = "//*[@class='title']")
    public WebElement succeed;

    public void InputUserName(String UserName) {
        userName.sendKeys(UserName);

    }

    public void InputUserpasswod(String Password) {
        userPassword.sendKeys(Password);

    }

    public void clickbutton() {
        login.click();

    }
    public String pagetitle(){
        return titlePage.getText();
    }
    public String ConditionSuccessOrFailure(boolean hasil){
        String text= "";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        if (hasil) {
            wait.until(ExpectedConditions.visibilityOf(errorMessageElement));
            return text = errorMessageElement.getText();
        }
        else{
            return text = succeed.getText();
        }

    }
    public void IncludeLogin(String UserName, String Password){
        userName.sendKeys(UserName);
        userPassword.sendKeys(Password);
        login.click();
    }



}
