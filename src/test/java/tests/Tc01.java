package tests;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TozluPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.time.Duration;

public class Tc01 extends TestBaseRapor {
    @Test
    public void NegatifOdemeTesti(){

        SoftAssert softAssert=new SoftAssert();
        TozluPages tozluPages=new TozluPages();
        Actions actions=new Actions(Driver.getDriver());
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));


        extentTest=extentReports.createTest("Negatif Odeme testi",
                "Kullanici yanlis bilgilerle ödeme yapamamali");

        extentTest.info("Kullanici tozlu.com'a gider");
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        //Site belirli zamanlarda kampanya yapıyor ve bazı uyarı yazıları çıkıyor dinamik olması için if bloğu kullanıldı.
        if (tozluPages.anaSayfaKampanyaKapatmaButonu.isDisplayed())
        {
            tozluPages.anaSayfaKampanyaKapatmaButonu.click();
        }

        extentTest.info("Test datalarindan aldigi kullanici email ve sifresi ile giris yapar.");
        tozluPages.girisYapSekmesi.click();
        tozluPages.epostaGiris.click();
        wait.until(ExpectedConditions.visibilityOf(tozluPages.emailSekmesi));
        tozluPages.emailSekmesi.sendKeys(ConfigReader.getProperty("toEmail"));
        tozluPages.sifreSekmesi.sendKeys(ConfigReader.getProperty("toSifre"));
        tozluPages.acilirPencereGirisYapSekmesi.click();

        extentTest.info("Ana sayfada 'Erkek' tabinin gözüktüğünü doğrular ve " +
                "'Erkek' tabinin üzerine gelir ve günlük ayakkabı sekmesine tiklar");
        softAssert.assertTrue(tozluPages.anaSayfaErkekTabi.isDisplayed(),"Ana Sayfada Erkek tabi gözükmüyor");
        ReusableMethods.bekle(1);
        actions.moveToElement(tozluPages.anaSayfaErkekTabi).perform();
        tozluPages.gunlukAyakkabi.click();

        extentTest.info("Acilan sayfada ilk ürünün ismini kaydeder ve ilk ürüne tiklar");
        String ilkUrunYaziElementi=tozluPages.ilkUrunYaziElementi.getText();
        tozluPages.ayakkabiIlkUrun.click();

        extentTest.pass("Açılan sayfada ki ürün yazisinin kaydedilmiş ürün yazisini içerdiğini test eder.");
        softAssert.assertTrue(tozluPages.acilirPencereUrunIsmi.getText().contains(ilkUrunYaziElementi));

        extentTest.info("Numara seçer ve ürünü sepete ekler");
        ReusableMethods.click( tozluPages.ayakkabiNumarasi);
        ReusableMethods.click( tozluPages.sepeteEkleButonu);




        extentTest.pass("Sepete gider ve ürün eklendiğini test eder.");
        wait.until(ExpectedConditions.visibilityOf(tozluPages.sepetAcilirPencere));
        tozluPages.sepet.click();
        softAssert.assertTrue(tozluPages.sepettekiUrunElementi.isDisplayed(),"Sepette ürün bulunamadi");

        extentTest.info("Sepeti onayla butonuna basar ve açilan sayfada adres bilgilerini girer");
        tozluPages.sepetiOnayla.click();
        tozluPages.yeniAdressEkle.click();
        wait.until(ExpectedConditions.visibilityOf(tozluPages.sehirDropDownMenu));
        Select selectSehir=new Select(tozluPages.sehirDropDownMenu);
        selectSehir.selectByValue("İstanbul");

        Select selectIlce=new Select(tozluPages.ilceDropDownMenu);
        selectIlce.selectByValue("Avcılar");

        Select selectMah=new Select(tozluPages.mahDropDownMenu);
        selectMah.selectByValue("MERKEZ MAH");
        tozluPages.caddeSokakBilgileri.sendKeys(ConfigReader.getProperty("mahalle"));

        extentTest.info("Adresi kaydeder ve ödeme adımına geçer");
        tozluPages.addresiKaydet.click();
        tozluPages.kaydetVeOdemeyeGec.click();

        extentTest.info("Geçersiz kredi kartı bilgilerini girer ve siparisi tamamla butonuna basar ");
        tozluPages.krediKartIsmi.sendKeys(ConfigReader.getProperty("kartIsmi"));
        tozluPages.kredikartNo.sendKeys(ConfigReader.getProperty("kartNo"));
        tozluPages.krediKartDt.sendKeys(ConfigReader.getProperty("kartDt"));
        tozluPages.krediKartCvvKod.sendKeys(ConfigReader.getProperty("kartCv"));
        tozluPages.siparisiTamamlaButonu.click();

        extentTest.pass("Kart numarası hatalıdır mesajının çıktığını doğrular ve çıkan uyarıyı  onaylar");
        String expectedUyariMesaji="Kart numarası hatalı. Kart numarasını kontrol ederek tekrar deneyin (KOD HKN).";
        wait.until(ExpectedConditions.alertIsPresent());
        String actualUyariMesaji=Driver.getDriver().switchTo().alert().getText();
        softAssert.assertEquals(actualUyariMesaji,expectedUyariMesaji);
        Driver.getDriver().switchTo().alert().accept();


        extentTest.info("Sepete gider ve sepetteki ürünleri siler");
        tozluPages.sepet.click();
        tozluPages.urunSilmeButonu.click();
        wait.until(ExpectedConditions.visibilityOf(tozluPages.silmeOnayButonu));
        tozluPages.silmeOnayButonu.click();


        extentTest.info("Kullanici profiline girer ve adres bilgilerini siler ve sayfayı kapatir");
        tozluPages.profilButonu.click();
        tozluPages.profilHesabimButonu.click();
        tozluPages.profilAdreslerimButonu.click();
        tozluPages.adresSilmeButonu.click();
        wait.until(ExpectedConditions.visibilityOf(tozluPages.silmeOnayButonu));
        tozluPages.silmeOnayButonu.click();

        softAssert.assertAll();


    }
}
