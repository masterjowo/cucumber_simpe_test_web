package com.simple_web_automation_saucedemo_com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepTwoPage {
        WebDriver driver;// Deklarasi variabel driver sebagai variabel global
    // Konstruktor dengan parameter

    public CheckoutStepTwoPage(WebDriver driver) {
        // super(driver);
        this.driver = driver;// Menggunakan 'this' untuk membedakan antara variabel instance dan parameter
        PageFactory.initElements(driver, this);// fitur bawaan Selenium yang secara otomatis menginisialisasi
                                               // elemen-elemen web yang diberi anotasi seperti @FindBy di dalam kelas
                                               // Metode ini memastikan semua elemen pada halaman web di-bind ke
                                               // variabel dalam kelas.
        }

    @FindBy(xpath = "//button[@id='finish']")
    public WebElement finish ;
    //h2[@class='complete-header']
}
