package tests;

import com.example.driver.tests.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // WebDriver'ı başlat
        driver = Driver.startDriver();
    }

    @Test
    public void testLogin() {
        // Login sayfasına git
        driver.get("https://catchylabs-webclient.testinium.com/signIn");

        // Kullanıcı adı ve şifre alanlarına değer girilir
        WebElement usernameField = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='Password']"));

        usernameField.sendKeys("beyza.sahin");
        passwordField.sendKeys("KBsc*-32");

        // Login butonuna tıklanır
        WebElement loginButton = driver.findElement(By.xpath("//div[text()='Login']"));
        loginButton.click();

        // Test: Başarılı giriş sonrası beklenen sayfanın URL'i
        String expectedUrl = "https://catchylabs-webclient.testinium.com/signIn";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Login işlemi başarılı oldu!");
    }
}
