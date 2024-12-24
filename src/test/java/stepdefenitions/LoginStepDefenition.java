package stepdefenitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


class Data_Sementaras {
    private  String  data_semtara_string;
    
    public void setTitik_url(String data_semtara_string){
        this.data_semtara_string = data_semtara_string;
    }
    public String getTitik_url(){
        return this.data_semtara_string;
    }

}

public class LoginStepDefenition {
    // Deklarasi variabel driver sebagai variabel global
    private WebDriver driver;
    Data_Sementaras URL = new Data_Sementaras();
    @Before
    public void setUp() {
        driver = new ChromeDriver();  // Setup WebDriver
        driver.manage().window().setSize(new Dimension(1440, 832));  // Maksimalkan jendela browser
    }
    @After
    public void After_setUp() throws InterruptedException{
        //throws InterruptedException digunakan ketika metode Anda melibatkan operasi yang dapat diinterupsi (seperti Thread.sleep()), dan Anda tidak ingin menangani exception tersebut secara langsung.
        Thread.sleep(1000);
        if (driver != null) {
            driver.quit();  // Menutup browser dengan benar
        }
        
    }

    @Given("Diberikan  user akses halaman saucedemo.com")
    public void diberikan_user_akses_halaman_saucedemo_com() throws InterruptedException {
        URL.setTitik_url("https://www.saucedemo.com/");
        driver.get(URL.getTitik_url()); 
    }

    @When("Ketika user di dalaman user dapat melihat {string}")
    public void ketika_user_di_dalaman_user_dapat_melihat(String string) {
        WebElement newWindowElement = driver.findElement(By.xpath("//div[contains(text(), '"+string+"')]"));
        System.out.println(newWindowElement.getText());  // Isi halaman di jendela baru
        Assert.assertEquals(string, newWindowElement.getText());
    }
    @When("Dan user memasukan UserName {string}")
    public void dan_user_memasukan_UserName(String string) {
        driver.findElement(By.xpath("//*[@id='user-name']")).sendKeys(string);
    }
    @When("Dan user memasukan password {string}")
    public void dan_user_memasukan_password(String string)  {
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys(string);
    }
    @When("Dan user mmenekan tombol login")
    public void dan_user_mmenekan_tombol_login() {
        driver.findElement(By.xpath("//*[@id='login-button']")).click();
    }
    @Then("Maka user dapat melihat {string}")
    public void maka_user_dapat_melihat(String string) throws InterruptedException {
        if (URL.getTitik_url().equals(driver.getCurrentUrl())){
            System.out.println("seter"+URL.getTitik_url()+"    url saat ini"+driver.getCurrentUrl());
             WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            // Menunggu hingga elemen pesan error ditemukan
            WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@data-test='error']")));
            System.out.println(errorMessageElement.getText());  // Isi halaman di jendela baru
            Assert.assertEquals(errorMessageElement.getText(), string);
        }
        else{
            Thread.sleep(1000);
            WebElement newWindowElement = driver.findElement(By.xpath("//*[@class='title']"));
            System.out.println("asdsadsadsad"+newWindowElement.getText());  // Isi halaman di jendela baru
            Assert.assertTrue(newWindowElement.getText() != null);//operator ternary
        }
    }

}
