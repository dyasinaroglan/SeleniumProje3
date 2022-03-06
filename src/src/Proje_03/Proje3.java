package src.Proje_03;

import com.beust.ah.A;
import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;


import java.time.Duration;
import java.util.Set;

public class Proje3 extends BaseStaticDriver {
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
        email.sendKeys("yasinargln264@gmail.com");
        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("264264264");
        WebElement logIN1 = driver.findElement(By.cssSelector("input[class='button-1 login-button']"));
        logIN1.click();

        WebElement facebook = driver.findElement(By.xpath("(//a[@target='_blank'])[1]"));
        facebook.click();

        Set<String> windowId = driver.getWindowHandles();
        for (String s : windowId) {
            if(!windowId.equals(anaSayfaID)){
                driver.switchTo().window(s);
            }
        }
        System.out.println("url : " + driver.getCurrentUrl());

        driver.close();
        driver.switchTo().window(anaSayfaID);

        WebElement contacUs = driver.findElement(By.linkText("Contact us"));
        js.executeScript("arguments[0].scrollIntoView(true);",contacUs);
        contacUs.click();

        WebElement message = driver.findElement(By.id("Enquiry"));
        message.sendKeys("bu bir test girişimidir");
        Thread.sleep(1000);
        WebElement submit = driver.findElement(By.cssSelector("input[name='send-email']"));
        submit.click();

        String expected = "Your enquiry has been successfully sent to the store owner.";
        WebElement actual = driver.findElement(By.cssSelector("div[class='page-body']"));

        if(actual.getText().contains(expected)){
            System.out.println("yazı kontrolü başarılı bir şekilde yapıldı.");


        }





    }
}
