package com.example.driver.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
    private static WebDriver driver;

    public static WebDriver startDriver() {
        WebDriverManager.chromedriver().setup(); // WebDriverManager ile driver'ı başlat
        driver = new ChromeDriver(); // ChromeDriver başlatılır
        driver.manage().window().maximize(); // Pencereyi maksimum yapar
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
           // driver.quit(); // Tarayıcıyı kapatır
        }
    }
}
