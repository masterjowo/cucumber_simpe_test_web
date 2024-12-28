package com.simple_web_automation_saucedemo_com.singleton;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSingleton {
    private static WebDriver driver; // Variabel static untuk instance tunggal

    
    private DriverSingleton() {// Private constructor untuk mencegah instansiasi langsung
        
    }


    // Metode untuk mendapatkan instance WebDriver
    public static WebDriver getDriver() {
        if (driver == null) { // Jika driver belum dibuat, buat instance baru
            // driver = new ChromeDriver();// Buat instance ChromeDriver secara tidak dinamis 
            String browser = System.getProperty("browser", "chrome"); // Ambil nilai browser (default chrome)
            switch (browser.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    System.out.println("Browser Firefox belum didukung atau server belum diatur untuk browser ini");
                default:
                    throw new IllegalArgumentException("Browser yang diberikan tidak didukung: " + browser);
            }
            driver.manage().window().setSize(new Dimension(1440, 832)); // Atur browser untuk mode fullscreen
        }
        return driver;
    }

    // Metode untuk menutup driver (opsional)
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; // Set instance menjadi null setelah ditutup
        }
    }
}