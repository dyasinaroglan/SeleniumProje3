package src.Proje_04;

import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.BaseStaticDriver;

import java.time.Duration;

public class Proje4 extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().deleteAllCookies();

        String anaSayfaID = driver.getWindowHandle();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("http://demowebshop.tricentis.com/");
        WebElement logın = driver.findElement(By.cssSelector("a[class='ico-login']"));
        logın.click();
        WebElement email = driver.findElement(By.id("Email"));
        if(email.isDisplayed()) {
            email.sendKeys("yasinargln264@gmail.com");
        }
        WebElement password = driver.findElement(By.id("Password"));
        if(password.isDisplayed()) {
            password.sendKeys("264264264");
        }
        WebElement logIN1 = driver.findElement(By.cssSelector("input[class='button-1 login-button']"));
        logIN1.click();
        Thread.sleep(1000);
        WebElement computers = driver.findElement(By.xpath("(//a[@href='/computers'])[3]"));
        computers.click();
        WebElement desktops = driver.findElement(By.xpath("(//a[@href='/desktops'])[3]"));
        desktops.click();
        Thread.sleep(1000);
        WebElement expensiveComputer = driver.findElement(By.linkText("Build your own expensive computer"));
        js.executeScript("arguments[0].scrollIntoView(true);", expensiveComputer);
        Thread.sleep(1000);
        expensiveComputer.click();

        WebElement fast = driver.findElement(By.cssSelector("input[id='product_attribute_74_5_26_82']"));
        fast.click();
        WebElement ram = driver.findElement(By.cssSelector("input[id='product_attribute_74_6_27_85']"));
        ram.click();
        WebElement hdd = driver.findElement(By.cssSelector("input[id='product_attribute_74_3_28_86']"));
        hdd.click();
        WebElement software = driver.findElement(By.cssSelector("input[id='product_attribute_74_8_29_90']"));
        software.click();
        WebElement addToCard = driver.findElement(By.cssSelector("input[id='add-to-cart-button-74']"));
        addToCard.click();
        WebElement shoppingCard = driver.findElement(By.xpath("(//a[@href='/cart'])[1]"));
        shoppingCard.click();

        WebElement checkBox = driver.findElement(By.cssSelector("input[id='termsofservice']"));
        checkBox.click();
        WebElement checkOut = driver.findElement(By.cssSelector("button[id='checkout']"));
        checkOut.click();

        WebElement selectCountry = driver.findElement(By.cssSelector("select[class='valid']"));
        if (selectCountry.isDisplayed()) {
            Select select = new Select(selectCountry);
            select.selectByValue("12");
        }
        WebElement city = driver.findElement(By.id("BillingNewAddress_City"));
        if (city.isDisplayed()){
            city.sendKeys("İstanbul");
        }
        WebElement adress = driver.findElement(By.id("BillingNewAddress_Address1"));
        if(adress.isDisplayed()) {
            adress.sendKeys("zümrütevler mahallesi");
        }
        WebElement zipCode = driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
        if(zipCode.isDisplayed()) {
            zipCode.sendKeys("34000");
        }
        WebElement phoneNumber = driver.findElement(By.id("BillingNewAddress_PhoneNumber"));
        if(phoneNumber.isDisplayed()) {
            phoneNumber.sendKeys("5454384744");
        }


        WebElement continueBilling= driver.findElement(By.xpath("(//input[@class='button-1 new-address-next-step-button'])[1]"));
        continueBilling.click();
        WebElement continueShipping = driver.findElement(By.cssSelector("input[onclick='Billing.save()']"));
        continueShipping.click();
        WebElement ınStore = driver.findElement(By.id("PickUpInStore"));
        ınStore.click();
        WebElement continueShipping1 = driver.findElement(By.cssSelector("input[onclick='Shipping.save()']"));
        continueShipping1.click();
        WebElement cashOnDelivery = driver.findElement(By.id("paymentmethod_0"));
        cashOnDelivery.click();

        WebElement continueSon = driver.findElement(By.cssSelector("input[onclick='PaymentMethod.save()']"));
        js.executeScript("arguments[0].scrollIntoView(true);",continueSon);
        continueSon.click();
        WebElement continuePayment = driver.findElement(By.cssSelector("input[onclick='PaymentInfo.save()']"));
        continuePayment.click();
        WebElement comfirm = driver.findElement(By.cssSelector("input[onclick='ConfirmOrder.save()']"));
        comfirm.click();

        String expected = "Your order has been successfully processed!";
        String actual = driver.findElement(By.cssSelector("div[class='title']")).getText();

        if(!expected.equals(actual)){
            System.out.println("hatalı mesaj");
        }else {
            System.out.println("test başarılı bir şekilde tamamlanmıştır...");
        }





    }
}
