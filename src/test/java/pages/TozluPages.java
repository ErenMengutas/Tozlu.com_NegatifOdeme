package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TozluPages {
    public TozluPages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath ="//span[text()=' Giriş Yap']")
    public WebElement girisYapSekmesi;

    @FindBy(id = "eposta-login-tab")
    public WebElement epostaGiris;

    @FindBy(xpath = "//input[@type='email']")
    public WebElement emailSekmesi;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement sifreSekmesi;

    @FindBy(xpath = "//button[text()='Giriş Yap']")
    public WebElement acilirPencereGirisYapSekmesi;

    @FindBy(xpath = "(//a[text()='ERKEK'])[1]")
    public WebElement anaSayfaErkekTabi;

    @FindBy(xpath = "(//a[text()='Günlük Ayakkabı'])[2]")
    public WebElement gunlukAyakkabi;

    @FindBy(xpath = "(//div[@class='product-list-item col-6 col-sm-6 col-md-6 col-lg-4 col-xl-4'])[1]")
    public WebElement ayakkabiIlkUrun;

    @FindBy(xpath = "(//h2[@class='product-name'])[1]")
    public WebElement ilkUrunYaziElementi;

    @FindBy(xpath = "//h1[@class='product-name']")
    public WebElement acilirPencereUrunIsmi;

    @FindBy(xpath = "//button[@class='btn btn-secondary w-100 mr-3 large addCart']")
    public WebElement sepeteEkleButonu;

    @FindBy(xpath = "(//label[@class='btn link border px-3 py-2'])[3]")
    public WebElement ayakkabiNumarasi;

    @FindBy(xpath = "(//span[text()='Sepetim'])[1]")
    public WebElement sepet;

    @FindBy(xpath = "//div[@class='row card flex-row align-items-center m-0 p-3 cart-page-item-box ']")
    public WebElement sepettekiUrunElementi;

    @FindBy(xpath = "//*[text()='Sepeti onayla']")
    public WebElement sepetiOnayla;

    @FindBy(xpath = "(//*[text()='Kaydet ve Ödemeye Geç'])[1]")
    public WebElement kaydetVeOdemeyeGec;

    @FindBy(xpath = "(//select[@class='form-control cityList'])[2]")
    public WebElement sehirDropDownMenu;

    @FindBy(xpath = "//select[@class='form-control districtList']")
    public WebElement ilceDropDownMenu;

    @FindBy(xpath = "(//*[text()='Sepetim'])[3]")
    public WebElement sepetAcilirPencere;

    @FindBy(xpath = "//button[@class='btn btn-secondary']")
    public WebElement yeniAdressEkle;

    @FindBy(xpath = "//select[@class='form-control neighborhoodlist']")
    public WebElement mahDropDownMenu;

    @FindBy(id = "AddressDetail")
    public WebElement caddeSokakBilgileri;

    @FindBy(xpath = "(//button[text()='Adresi Kaydet ve Devam Et'])[2]")
    public WebElement addresiKaydet;

    @FindBy(id = "CardHolderName")
    public WebElement krediKartIsmi;

    @FindBy(id = "CardNumber")
    public WebElement kredikartNo;

    @FindBy(xpath = "//input[@placeholder='AA / YY']")
    public WebElement krediKartDt;

    @FindBy(id = "CvvCode")
    public WebElement krediKartCvvKod;

    @FindBy(xpath = "(//*[text()='Siparişi Tamamla'])[1]")
    public WebElement siparisiTamamlaButonu;

    @FindBy(id = "buttonOk")
    public WebElement silmeOnayButonu;

    @FindBy(xpath = "//button[@class='btn btn-link cart-page-item-close-btn']")
    public WebElement urunSilmeButonu;

    @FindBy(xpath = "//a[@class='d-flex  align-items-center dropdown-toggle']")
    public WebElement profilButonu;

    @FindBy(xpath = "(//*[text()='Hesabım'])[1]")
    public WebElement profilHesabimButonu;

    @FindBy(xpath = "(//*[@class='submenu-link'])[2]")
    public WebElement profilAdreslerimButonu;

    @FindBy(xpath = "//button[@class='btn btn-indent']")
    public WebElement adresSilmeButonu;

    @FindBy(xpath = "(//button)[1]")
    public WebElement anaSayfaKampanyaKapatmaButonu;











}
