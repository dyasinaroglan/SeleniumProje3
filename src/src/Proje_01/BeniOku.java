package src.Proje_01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.time.Duration;

public class BeniOku extends BaseStaticDriver {
    /*
        Manuel bir şekilde web sitesine kayıt olun. (Kendi hesabınızı oluşturun)

        Bu siteye gidin ->  https://app.hubspot.com/login
          !!!--> aclmiyorsa bu siteden baslayiniz:  https://app.hubspot.com/signup-hubspot/crm?loginRedirectUrl=undefined&step=landing_page

        Email address ve Password girdikten sonra Log in buttonuna tıklayınız.
        mail  =
        pass =
        login =

        Sales'a tıklayınız.
        Deals'a tıklayınız.

        Create Deal'a tıklayınız. (Note: Otomasyon sırasında Deal'a tıkladığınızda tablo gözükmeyebilir. Browser'ı yenileyin. (refresh) )



        Deal name giriniz.

        Sales Pipeline'a tıklayınız.  i
         (İkinci websitesinin URL'inin bu URL olduğunu doğrulayınız.
         -->https://app.hubspot.com/pricing/7766931/sales?upgradeSource=deals-create-deal-general-create-deal-multiple-pipelines-pql-feature-lock&term=annual&edition=starter


        Deal Stage dropdown'undan rastgele bir şey seçiniz.
        Deal Type dropdown'undan rastgele bir şey seçiniz.
        Create button'a tıklayınız.

        Sol üstte, Verdiğiniz isimin yanındaki küçük kalem simgesine tklayınız.
        Deal name'i değiştiriniz.
        Save'e tıklayınız.
        Deal Name'in değiştiğini doğrulayınız.

        "Actions" button'una tıklayınız.
        Delete'e tıklayınız.
        Delete deal'a tıklayınız.

        Deal'ın artık görünmediğini doğrulayınız.
     */
    public static void main(String[] args) throws InterruptedException {

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().deleteAllCookies();


        driver.get("https://app.hubspot.com/login");
/*
        WebElement email = driver.findElement(By.id("username"));
        email.sendKeys("yasinargln264@gmail.com");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Yasin.264264264");

        WebElement logın = driver.findElement(By.id("loginBtn"));
        logın.click();

 */







    }

}
