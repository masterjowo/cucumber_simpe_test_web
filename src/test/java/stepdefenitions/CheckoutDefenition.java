package stepdefenitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.simple_web_automation_saucedemo_com.pageobjects.HomePage;
import com.simple_web_automation_saucedemo_com.pageobjects.CheckoutStepOnePage;
import com.simple_web_automation_saucedemo_com.pageobjects.CheckoutStepTwoPage;
import com.simple_web_automation_saucedemo_com.pageobjects.CheckoutCompletePage;
import com.simple_web_automation_saucedemo_com.pageobjects.keranjangPage;
import com.simple_web_automation_saucedemo_com.singleton.DriverSingleton;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutDefenition {
    WebDriver driver;
    HomePage obj2;
    CheckoutStepOnePage obj3;
    CheckoutStepTwoPage obj4;
    CheckoutCompletePage obj5;
    keranjangPage obj6;
    public CheckoutDefenition() {
        driver = DriverSingleton.getDriver();
        obj2 = new HomePage(driver); // Inisialisasi HomePage
        obj3 = new CheckoutStepOnePage(driver); // Inisialisasi CheckoutStepOnePage
        obj4 = new CheckoutStepTwoPage(driver); // Inisialisasi CheckoutStepTwoPage
        obj5 = new CheckoutCompletePage(driver); // Inisialisasi CheckoutCompletePage
        obj6 = new keranjangPage(driver); // Inisialisasi keranjangPage
    }

    @Then("Maka user dapat melihat pemberitahuan {string}")
    public void maka_user_dapat_melihat_pemberitahuan(String string) {
        Assert.assertEquals(obj5.Complete(), string);
    }

    @When("Dan user menekan tombol finish")
    public void dan_user_menekan_tombol_finish() {
        obj4.finish.click();
    }

    @When("Dan user memasukan nama depan {string} dan nama belakang {string} dan kode pos {string} dan menekan tombol continue")
    public void dan_user_memasukan_nama_depan_dan_nama_belakang_dan_kode_pos_dan_menekan_tombol_continue(String string, String string2, String string3) {
        obj3.YourInformation(string, string2, string3);
    }

    @When("Dan user menekan tombol keranjang")
    public void dan_user_menekan_tombol_keranjang() {
        obj2.keranjang.click();

    }

    @When("Dan user memilih barang sauce labs backpack dan barang sauce labs bike light")
    public void dan_user_memilih_barang_sauce_labs_backpack_dan_barang_sauce_labs_bike_light() {
        obj2.SauceLabsBackpack.click();
        obj2.SauceLabsBikeLight.click();

    }
    @When("Dan user menekan tombol checkout")
    public void dan_user_menekan_tombol_checkout() {
        obj6.checkout.click();

    }


}
