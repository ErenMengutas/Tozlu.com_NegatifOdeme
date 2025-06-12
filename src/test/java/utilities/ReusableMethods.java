package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class ReusableMethods {



    public static void bekle(int saniye){

        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            System.out.println("bekletme isleminde sorun olustu");
        }

    }



    public static void tumSayfaScreenshot(WebDriver driver,String screenshotIsmi){

        // 1.adim TakesScreenShot objesi olusturun
        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2.screenShoot'i kaydedecegimiz File olusturun

        // raporlara tarih etiketi ekleyelim

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyyMMdd");
        String tarihEtiketi = ldt.format(format1);

        screenshotIsmi = screenshotIsmi.replaceAll("\\s","");
        File tumSayfaScreenshot = new File("target/Screenshoots/"+screenshotIsmi+tarihEtiketi+".png");

        // 3.screenshot'i alip gecici bir dosyaya kaydedelim
        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        // 4. gecici dosyayi asil kaydetmek istedigimiz dosyaya kopyalayalim
        try {
            FileUtils.copyFile(geciciDosya,tumSayfaScreenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void webelementScreenshot(WebElement scrennshotAlinacakWebelement, String screenshotIsmi){
        // 1- screenshot almak istediginiz webelementi locate edin

        // 2- Screenshot'i kaydedecegimiz file'i olusturun

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyyMMdd");
        String tarihEtiketi = ldt.format(format1);

        screenshotIsmi = screenshotIsmi.replaceAll("\\s","");
        File webelementScreenshot = new File("target/Screenshoots/"+screenshotIsmi+tarihEtiketi+".png");

        // 3- webelementi kullanarak screenshot alip, gecici dosyaya kaydedin
        File geciciDosya = scrennshotAlinacakWebelement.getScreenshotAs(OutputType.FILE);

        // 4- gecici dosyayi, asil dosyaya kopyalayin
        try {
            FileUtils.copyFile(geciciDosya,webelementScreenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static String getScreenshot(String name) throws IOException {

        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);

        String target = System.getProperty("user.dir") + "/test-raporlari/" + name + date + ".png";
        File finalDestination = new File(target);
        FileUtils.copyFile(source, finalDestination);
        return target;
    }

    public static void click(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].click();", element);
        }
    }

}
