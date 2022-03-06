package src.Proje_02;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseStaticDriver;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BeniOku_02 extends BaseStaticDriver {
        /*
            https://www.etsy.com/  siteye gidiniz
            Wedding & Party  Action class kullanarak uzerine gelin
            Wedding Decorations  Action class ile geliniz ve aciniz
            Cake Toppers  seciniz
            SortBy  : Highest Price  olarak secilecek
            Listedeki urunlerden biri Random olarak secilecek
            "Top wedding searches to shop " bu yaziya kadar ekrani kaydirin alt kisimda olacak sekilde
            facebook iconuna basiniz
            Cikan ekranda Email textBox text gönderiniz

            Ana sayfaya gelip "Shop by interest" yazisinin varligini kontrol ediniz
            Title : Wedding Cake Toppers | Etsy oldugunu dogrulayiniz

            */
        public static void main(String[] args) throws InterruptedException {


            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.manage().deleteAllCookies();

            String anaSayfaID = driver.getWindowHandle();

            driver.get("https://www.etsy.com/");
            JavascriptExecutor js = (JavascriptExecutor) driver;
            Thread.sleep(1000);
            WebElement weddingParty = driver.findElement(By.id("catnav-primary-link-10983"));
            Actions builder = new Actions(driver);
            Thread.sleep(1000);
            Action action = builder.moveToElement(weddingParty).build();
            action.perform();

            WebElement weddingDecorations = driver.findElement(By.id("side-nav-category-link-10996"));
            Thread.sleep(1000);
            Action action1 = builder.moveToElement(weddingDecorations).build();
            action1.perform();

            WebElement cakeTappers = driver.findElement(By.id("catnav-l3-10998"));
            cakeTappers.click();

            WebElement sortBY = driver.findElement(By.cssSelector("span[class='wt-menu__trigger__label']"));

            js.executeScript("arguments[0].scrollIntoView(true);",sortBY);
            Thread.sleep(1000);
            sortBY.click();
            Thread.sleep(1000);

            WebElement highHestPrice = driver.findElement(By.xpath("(//a[@class='wt-menu__item '])[2]"));
            highHestPrice.click();

            List<WebElement> urunList = driver.findElements(By.cssSelector("div[class='height-placeholder']"));

            Thread.sleep(1000);
            int random = (int) (Math.random()* (urunList.size()));
            Thread.sleep(1000);
            js.executeScript("arguments[0].scrollIntoView(true);",urunList.get(random));
            Thread.sleep(1000);
            urunList.get(random).click();
            Thread.sleep(1000);

            Set<String> windowId =driver.getWindowHandles();
            for (String i : windowId) {
                if(!windowId.equals(anaSayfaID)){
                    driver.switchTo().window(i);

                    WebElement email = driver.findElement(By.id("email-list-signup-email-input"));
                    js.executeScript("arguments[0].scrollIntoView(false);",email);
                    Thread.sleep(1000);
                    js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
                }
            }
            WebElement facebook = driver.findElement(By.cssSelector("path[d='M18.3,8.559V9.007a9.666,9.666,0,0,1-9.729,9.737,9.614,9.614,0,0,1-5.256-1.394,5.367,5.367,0,0,0,.814.057,6.906,6.906,0,0,0,4.245-1.621,3.412,3.412,0,0,1-3.186-2.379,3.339,3.339,0,0,0,1.548-.058A3.419,3.419,0,0,1,3.988,9.993V9.952a3.427,3.427,0,0,0,1.548.424A3.407,3.407,0,0,1,4,7.54a3.261,3.261,0,0,1,.465-1.662A9.729,9.729,0,0,0,11.517,9.39a3.588,3.588,0,0,1-.073-0.79,3.408,3.408,0,0,1,3.414-3.414,3.542,3.542,0,0,1,2.518,1.075,6.837,6.837,0,0,0,2.159-.831,3.391,3.391,0,0,1-1.507,1.9A6.657,6.657,0,0,0,20,6.782,6.927,6.927,0,0,1,18.3,8.559Z']"));
            Thread.sleep(1000);
            facebook.click();
            Thread.sleep(1000);
            driver.close();


            driver.switchTo().window(anaSayfaID); // ana sayfa ıd sine geçtik

            WebDriverWait shopByInterest = new WebDriverWait(driver,Duration.ofSeconds(20));
            boolean dogruMu = shopByInterest.until(ExpectedConditions.textToBe(By.cssSelector("h3[class='wt-text-title-03 wt-mb-md-1']"),"Shop by interest"));
            System.out.println(dogruMu);

            System.out.println("sayfa başlığı : " + driver.getTitle());
            Thread.sleep(1000);
            driver.quit();





        }
}
