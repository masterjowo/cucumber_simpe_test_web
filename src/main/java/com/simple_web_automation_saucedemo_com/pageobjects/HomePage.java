package com.simple_web_automation_saucedemo_com.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class HomePage {
        
    WebDriver driver;// Deklarasi variabel driver sebagai variabel global
    // Konstruktor dengan parameter

    public HomePage(WebDriver driver) {
        // super(driver);
        this.driver = driver;// Menggunakan 'this' untuk membedakan antara variabel instance dan parameter
        PageFactory.initElements(driver, this);// fitur bawaan Selenium yang secara otomatis menginisialisasi
                                               // elemen-elemen web yang diberi anotasi seperti @FindBy di dalam kelas
                                               // Metode ini memastikan semua elemen pada halaman web di-bind ke
                                               // variabel dalam kelas.

            System.out.println("url saat ini   "+driver.getCurrentUrl());
        }
    @FindBy(xpath = "//*[@class='select_container']")
    public WebElement tombolFilter ;
    @FindBy(xpath = "//*[@class='product_sort_container']")
    public WebElement select ;
    @FindBy(xpath = "//*[@class='active_option']") public WebElement textcontainer;
    @FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-backpack']") public WebElement SauceLabsBackpack;
    @FindBy(xpath = "//button[@name='add-to-cart-sauce-labs-bike-light']") public WebElement SauceLabsBikeLight;
    @FindBy(xpath = "//*[@class='shopping_cart_link']") public WebElement keranjang;

    public void clickFilter(int i) {
        tombolFilter.click();
        Select dropdown = new Select(select);
        dropdown.selectByIndex(i);
        // 

    }

    public String checkContain() {
        
        // WebElement TexteElement=driver.findElement(By.xpath("//*[@class='active_option']"));
        return textcontainer.getText();
    }
    // public void clickSauceLabsBackpack() {
    //     SauceLabsBackpack.click();
    // }
    // public void clickSauceLabsBikeLight() {
    //     SauceLabsBikeLight.click();
    // }


    //*[@class='inventory_item']//div[2]//div[1]//a[@id='item_0_title_link']
        // WebElement TexteElement=driver.findElement(By.xpath("//*[@class='product_sort_container']"));
        // Assert.assertEquals(TexteElement.getText(), string);
    


}
