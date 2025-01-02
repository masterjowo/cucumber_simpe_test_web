package com.simple_web_automation_saucedemo_com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepOnePage {
    WebDriver driver;// Deklarasi variabel driver sebagai variabel global
    // Konstruktor dengan parameter

    public CheckoutStepOnePage(WebDriver driver) {
        // super(driver);
        this.driver = driver;// Menggunakan 'this' untuk membedakan antara variabel instance dan parameter
        PageFactory.initElements(driver, this);// fitur bawaan Selenium yang secara otomatis menginisialisasi
                                               // elemen-elemen web yang diberi anotasi seperti @FindBy di dalam kelas
                                               // Metode ini memastikan semua elemen pada halaman web di-bind ke
                                               // variabel dalam kelas.
        }
    @FindBy(xpath = "//*[@id='continue']")
    public WebElement Continue ;

    @FindBy(xpath = "//*[@id='first-name']")
    public WebElement FirstName ;

    @FindBy(xpath = "//*[@id='last-name']")
    public WebElement LastName ;

    @FindBy(xpath = "//*[@id='postal-code']")
    public WebElement PostalCode ;

    public void YourInformation(String NamaDepan, String NamaBelakang, String Zip) {

        FirstName.sendKeys(NamaDepan);
        LastName.sendKeys(NamaBelakang);
        PostalCode.sendKeys(Zip);
        Continue.click();
    }
}
