# Tozlu.com Negatif Ödeme Testi

Bu proje, [tozlu.com](https://www.tozlu.com) web sitesi üzerinde yapılan **negatif ödeme (başarısız ödeme)** testini otomasyon yoluyla gerçekleştirmek amacıyla hazırlanmıştır. Amaç, geçersiz kart bilgileri ile yapılan ödeme girişimlerinin sistem tarafından doğru şekilde reddedildiğini ve uygun hata mesajlarının gösterildiğini test etmektir.

## 🎯 Testin Amacı

- Hatalı kredi kartı bilgileri ile ödeme denemesi yapıldığında sistemin doğru tepki verip vermediğini kontrol etmek.
- Güvenlik ve kullanıcı deneyimi açısından ödeme adımlarının sağlamlığını test etmek.

## ⚙️ Kullanılan Teknolojiler

- **Java**
- **Selenium WebDriver**
- **TestNG**
- **Maven**
- **IntelliJ IDEA**

## 🧪 Test Senaryosu

1. Kullanıcı, sepete ürün ekler.
2. Ödeme sayfasına ilerler.
3. Geçersiz kredi kartı bilgilerini girer.
4. “Ödemeyi Tamamla” butonuna tıklar.
5. Sistemin ödeme işlemini reddettiği ve hata mesajı gösterdiği doğrulanır.
