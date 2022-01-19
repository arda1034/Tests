import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Gas_Test {
    public AndroidDriver<MobileElement> driver;
    @BeforeMethod
    public void setup() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "emulator-5554");
        cap.setCapability("udid", "emulator-5554");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "11");
        cap.setCapability("appPackage", "com.example.imudogalgazhomework");
        cap.setCapability("appActivity", "com.example.imudogalgazhomework.MainActivity");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
    }

    public void giris() throws InterruptedException {
        driver.findElement(By.id("com.example.imudogalgazhomework:id/personnel_button")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/personnelnum_text")).setValue("45678912");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/personnelpass_text")).setValue("12345678");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/subnum_text")).setValue("12345678");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/usedm3_text")).setValue("120");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/m3price_text")).setValue("3");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/month_spinner")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.xpath("//android.widget.CheckedTextView[2]")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
        TimeUnit.SECONDS.sleep(1);
    }

    @Test
    public void personel_c1() throws InterruptedException {
        giris();
        List<MobileElement> buttons = driver.findElements(By.xpath("//android.widget.Button"));
        String[] texts = new String[buttons.size()];
        for(MobileElement text : buttons) texts = ArrayUtils.add(texts, text.getText());
        List<String> texts2 = Arrays.asList(texts);
        boolean res1 = texts2.contains("FOTOĞRAF YÜKLE");
        boolean res2 = texts2.contains("İŞLEMİ BİTİR");
        Assert.assertTrue(res1);
        Assert.assertTrue(res2);
    }

    @Test
    public void personel_c2() throws InterruptedException {
        giris();
        driver.findElement(By.id("com.example.imudogalgazhomework:id/upload_button")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.google.android.documentsui:id/icon_thumb")).click();
        TimeUnit.SECONDS.sleep(1);
    }

    @Test
    public void personel_c3() throws InterruptedException {
        driver.findElement(By.id("com.example.imudogalgazhomework:id/personnel_button")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/personnelnum_text")).setValue("45678912");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/personnelpass_text")).setValue("12345678");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/subnum_text")).setValue("12345678");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/usedm3_text")).setValue("150");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/m3price_text")).setValue("2.5");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/month_spinner")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.xpath("//android.widget.CheckedTextView[2]")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/upload_button")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.google.android.documentsui:id/icon_thumb")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(1);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(1);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/main_spinner")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.xpath("//android.widget.CheckedTextView[2]")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/subnum_text")).setValue("12345678");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
        TimeUnit.SECONDS.sleep(1);
        String text1 = driver.findElement(By.id("com.example.imudogalgazhomework:id/m3price_text")).getText();
        TimeUnit.SECONDS.sleep(1);
        String text2 = driver.findElement(By.id("com.example.imudogalgazhomework:id/usedm3_text")).getText();
        Assert.assertEquals(text1, "2.5");
        Assert.assertEquals(text2, "150");
    }

    @Test
    public void abone_d1() throws InterruptedException {
        driver.findElement(By.id("com.example.imudogalgazhomework:id/main_spinner")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.xpath("//android.widget.CheckedTextView[2]")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/subnum_text")).setValue("12345678");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/pay_button")).click();
        TimeUnit.SECONDS.sleep(1);
        List<MobileElement> textviews = driver.findElements(By.xpath("//android.widget.TextView"));
        String[] texts = new String[textviews.size()];
        for(MobileElement text : textviews) texts = ArrayUtils.add(texts, text.getText());
        List<String> texts2 = Arrays.asList(texts);
        boolean res1 = texts2.contains("Borç Ödeme");
        boolean res2 = texts2.contains("Ödenecek Tutar:");
        Assert.assertTrue(res1);
        Assert.assertTrue(res2);
    }

    @Test
    public void abone_d3() throws InterruptedException {
        driver.findElement(By.id("com.example.imudogalgazhomework:id/main_spinner")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.xpath("//android.widget.CheckedTextView[2]")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/subnum_text")).setValue("12345678");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/pay_button")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/month_spinner")).click();
        TimeUnit.SECONDS.sleep(1);
        MobileElement elem = driver.findElement(By.xpath("//android.widget.CheckedTextView[2]"));
        String txt = elem.getText();
        elem.click();
        TimeUnit.SECONDS.sleep(1);
        String txt_2 = driver.findElement(By.id("com.example.imudogalgazhomework:id/info_text_5")).getText();
        TimeUnit.SECONDS.sleep(1);
        boolean res1 = txt_2.contains(txt);
        Assert.assertTrue(res1);
    }

/*
    @Test
    public void abone_1a() throws InterruptedException {
        driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
        TimeUnit.SECONDS.sleep(1);
        MobileElement toast = driver.findElement(By.xpath("//android.widget.Toast"));
        Assert.assertEquals(toast.getText(), "Lütfen kullanıcı seçin!");
    }

    @Test
    public void abone_1b() throws InterruptedException {
        driver.findElement(By.id("com.example.imudogalgazhomework:id/main_spinner")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.xpath("//android.widget.CheckedTextView[2]")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
        TimeUnit.SECONDS.sleep(1);
        Assert.assertEquals(driver.findElement(By.id("com.example.imudogalgazhomework:id/system_text")).getText(), "ABONE NUMARANIZI GİRİN:");
    }

        @Test
        public void abone_2a() throws InterruptedException {
            driver.findElement(By.id("com.example.imudogalgazhomework:id/main_spinner")).click();
            TimeUnit.SECONDS.sleep(1);
            driver.findElement(By.xpath("//android.widget.CheckedTextView[2]")).click();
            TimeUnit.SECONDS.sleep(1);
            driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
            TimeUnit.SECONDS.sleep(1);
            driver.findElement(By.id("com.example.imudogalgazhomework:id/subnum_text")).setValue("12346678");
            TimeUnit.SECONDS.sleep(1);
            driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
            TimeUnit.SECONDS.sleep(1);
            MobileElement toast = driver.findElement(By.xpath("//android.widget.Toast"));
            Assert.assertEquals(toast.getText(), "İsim ve abone numarası uyuşmuyor!");
        }

        @Test
        public void abone_2b() throws InterruptedException {
            driver.findElement(By.id("com.example.imudogalgazhomework:id/main_spinner")).click();
            TimeUnit.SECONDS.sleep(1);
            driver.findElement(By.xpath("//android.widget.CheckedTextView[2]")).click();
            TimeUnit.SECONDS.sleep(1);
            driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
            TimeUnit.SECONDS.sleep(1);
            driver.findElement(By.id("com.example.imudogalgazhomework:id/subnum_text")).setValue("1234as78");
            TimeUnit.SECONDS.sleep(1);
            driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
            TimeUnit.SECONDS.sleep(1);
            MobileElement toast = driver.findElement(By.xpath("//android.widget.Toast"));
            Assert.assertEquals(toast.getText(), "Abone numarası doğru formatta değil!");
            TimeUnit.SECONDS.sleep(1);
            driver.navigate().back();
            TimeUnit.SECONDS.sleep(1);
            driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
            TimeUnit.SECONDS.sleep(1);
            driver.findElement(By.id("com.example.imudogalgazhomework:id/subnum_text")).setValue("123478");
            TimeUnit.SECONDS.sleep(1);
            driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
            TimeUnit.SECONDS.sleep(1);
            MobileElement toast2 = driver.findElement(By.xpath("//android.widget.Toast"));
            Assert.assertEquals(toast2.getText(), "Abone numarası doğru uzunlukta değil!");
            TimeUnit.SECONDS.sleep(1);
            driver.navigate().back();
            TimeUnit.SECONDS.sleep(1);
            driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
            TimeUnit.SECONDS.sleep(1);
            driver.findElement(By.id("com.example.imudogalgazhomework:id/subnum_text")).setValue("1234567890");
            TimeUnit.SECONDS.sleep(1);
            driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
            TimeUnit.SECONDS.sleep(1);
            MobileElement toast3 = driver.findElement(By.xpath("//android.widget.Toast"));
            Assert.assertEquals(toast3.getText(), "Abone numarası doğru uzunlukta değil!");
        }

    @Test
    public void abone_2c() throws InterruptedException {
        driver.findElement(By.id("com.example.imudogalgazhomework:id/main_spinner")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.xpath("//android.widget.CheckedTextView[2]")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/subnum_text")).setValue("12345678");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
        TimeUnit.SECONDS.sleep(1);
        Assert.assertEquals(driver.findElement(By.id("com.example.imudogalgazhomework:id/info_text_2")).getText(), "TOPLAM BORÇ:");
    }

    @Test
    public void abone_3a() throws InterruptedException {
        driver.findElement(By.id("com.example.imudogalgazhomework:id/main_spinner")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.xpath("//android.widget.CheckedTextView[2]")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/subnum_text")).setValue("12345678");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
        TimeUnit.SECONDS.sleep(1);
        Assert.assertEquals(driver.findElement(By.id("com.example.imudogalgazhomework:id/info_text_5")).getText(), "MEVCUT BORÇ:");
    }

    @Test
    public void abone_3b() throws InterruptedException {
        driver.findElement(By.id("com.example.imudogalgazhomework:id/main_spinner")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.xpath("//android.widget.CheckedTextView[2]")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/subnum_text")).setValue("12345678");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
        TimeUnit.SECONDS.sleep(1);
        List<MobileElement> textviews = driver.findElements(By.xpath("//android.widget.TextView"));
        String[] texts = new String[textviews.size()];
        for(MobileElement text : textviews) texts = ArrayUtils.add(texts, text.getText());
        List<String> texts2 = Arrays.asList(texts);
        boolean res1 = texts2.contains("Gaz m3 Fiyatı");
        boolean res2 = texts2.contains("Bu ay kullanılan");
        boolean res3 = texts2.contains("Bu ayın faturası");
        Assert.assertTrue(res1);
        Assert.assertTrue(res2);
        Assert.assertTrue(res3);
    }

        @Test
    public void abone_3c() throws InterruptedException {
        driver.findElement(By.id("com.example.imudogalgazhomework:id/main_spinner")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.xpath("//android.widget.CheckedTextView[2]")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/subnum_text")).setValue("12345678");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
        TimeUnit.SECONDS.sleep(1);
        List<MobileElement> textviews = driver.findElements(By.xpath("//android.widget.TextView"));
        String[] texts = new String[textviews.size()];
        for(MobileElement text : textviews) texts = ArrayUtils.add(texts, text.getText());
        List<String> texts2 = Arrays.asList(texts);
        boolean res1 = texts2.contains("Aralık");
        boolean res2 = texts2.contains("Kasım");
        boolean res3 = texts2.contains("Ekim");
        Assert.assertTrue(res1);
        Assert.assertTrue(res2);
        Assert.assertTrue(res3);
    }

    @Test
    public void abone_3d() throws InterruptedException {
        driver.findElement(By.id("com.example.imudogalgazhomework:id/main_spinner")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.xpath("//android.widget.CheckedTextView[2]")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/subnum_text")).setValue("12345678");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/pay_button")).click();
        TimeUnit.SECONDS.sleep(1);
        List<MobileElement> textviews = driver.findElements(By.xpath("//android.widget.TextView"));
        String[] texts = new String[textviews.size()];
        for(MobileElement text : textviews) texts = ArrayUtils.add(texts, text.getText());
        List<String> texts2 = Arrays.asList(texts);
        boolean res1 = texts2.contains("Borç Ödeme");
        Assert.assertTrue(res1);
    }

    @Test
    public void abone_3e() throws InterruptedException {
        driver.findElement(By.id("com.example.imudogalgazhomework:id/main_spinner")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.xpath("//android.widget.CheckedTextView[2]")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/subnum_text")).setValue("12345678");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/pay_button")).click();
        TimeUnit.SECONDS.sleep(1);
        List<MobileElement> textviews = driver.findElements(By.xpath("//android.widget.TextView"));
        String[] texts = new String[textviews.size()];
        for(MobileElement text : textviews) texts = ArrayUtils.add(texts, text.getText());
        List<String> texts2 = Arrays.asList(texts);
        boolean res1 = texts2.contains("İBAN:");
        boolean res2 = texts2.contains("Ödenecek Tutar");
        Assert.assertTrue(res1);
        Assert.assertTrue(res2);
        Assert.assertEquals(driver.findElement(By.className("android.widget.Button")).getText(), "BANKA SITESINE GIT");
    }

    @Test
    public void personel_a1() throws InterruptedException {
        driver.findElement(By.id("com.example.imudogalgazhomework:id/personnel_button")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/personnelnum_text")).setValue("4567as12");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/personnelpass_text")).setValue("12345678");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
        TimeUnit.SECONDS.sleep(1);
        MobileElement toast = driver.findElement(By.xpath("//android.widget.Toast"));
        Assert.assertEquals(toast.getText(), "Personel numarası doğru formatta değil!");
        TimeUnit.SECONDS.sleep(1);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/personnel_button")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/personnelnum_text")).setValue("456712");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/personnelpass_text")).setValue("12345678");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
        TimeUnit.SECONDS.sleep(1);
        MobileElement toast2 = driver.findElement(By.xpath("//android.widget.Toast"));
        Assert.assertEquals(toast2.getText(), "Personel numarası doğru uzunlukta değil!");
        TimeUnit.SECONDS.sleep(1);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/personnel_button")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/personnelnum_text")).setValue("4567891234");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/personnelpass_text")).setValue("12345678");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
        TimeUnit.SECONDS.sleep(1);
        MobileElement toast3 = driver.findElement(By.xpath("//android.widget.Toast"));
        Assert.assertEquals(toast3.getText(), "Personel numarası doğru uzunlukta değil!");
    }

    @Test
    public void personel_a2() throws InterruptedException {
        driver.findElement(By.id("com.example.imudogalgazhomework:id/personnel_button")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/personnelnum_text")).setValue("45678912");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/personnelpass_text")).setValue("123aaa56");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
        TimeUnit.SECONDS.sleep(1);
        MobileElement toast1 = driver.findElement(By.xpath("//android.widget.Toast"));
        Assert.assertEquals(toast1.getText(), "Personel şifresi doğru formatta değil!");
        TimeUnit.SECONDS.sleep(1);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/personnel_button")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/personnelnum_text")).setValue("45678912");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/personnelpass_text")).setValue("123456");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
        TimeUnit.SECONDS.sleep(1);
        MobileElement toast2 = driver.findElement(By.xpath("//android.widget.Toast"));
        Assert.assertEquals(toast2.getText(), "Personel şifresi doğru uzunlukta değil!");
        TimeUnit.SECONDS.sleep(1);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/personnel_button")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/personnelnum_text")).setValue("45678912");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/personnelpass_text")).setValue("1234567890");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
        TimeUnit.SECONDS.sleep(1);
        MobileElement toast3 = driver.findElement(By.xpath("//android.widget.Toast"));
        Assert.assertEquals(toast3.getText(), "Personel şifresi doğru uzunlukta değil!");
    }

    @Test
    public void personel_a3() throws InterruptedException {
        driver.findElement(By.id("com.example.imudogalgazhomework:id/personnel_button")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/personnelnum_text")).setValue("45678912");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/personnelpass_text")).setValue("12345666");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
        TimeUnit.SECONDS.sleep(1);
        MobileElement toast3 = driver.findElement(By.xpath("//android.widget.Toast"));
        Assert.assertEquals(toast3.getText(), "Personel numarası ve personel şifresi uyuşmuyor!");
    }

    @Test
    public void personel_a4() throws InterruptedException {
        driver.findElement(By.id("com.example.imudogalgazhomework:id/personnel_button")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/personnelnum_text")).setValue("45678912");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/personnelpass_text")).setValue("12345678");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
        TimeUnit.SECONDS.sleep(1);
        List<MobileElement> textviews = driver.findElements(By.xpath("//android.widget.TextView"));
        String[] texts = new String[textviews.size()];
        for(MobileElement text : textviews) texts = ArrayUtils.add(texts, text.getText());
        List<String> texts2 = Arrays.asList(texts);
        //System.out.println(texts2);
        boolean res1 = texts2.contains("ABONE NO:");
        boolean res2 = texts2.contains("KULLANILAN GAZ (M3):");
        boolean res3 = texts2.contains("M3 GAZ FİYATI (TL):");
        Assert.assertTrue(res1);
        Assert.assertTrue(res2);
        Assert.assertTrue(res3);
    }

    @Test
    public void personel_b1() throws InterruptedException {
        personel_a4();
        driver.findElement(By.id("com.example.imudogalgazhomework:id/subnum_text")).setValue("123aa678");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/usedm3_text")).setValue("100.00");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/m3price_text")).setValue("3.00");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/month_spinner")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.xpath("//android.widget.CheckedTextView[10]")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/month_spinner")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.xpath("//android.widget.CheckedTextView[10]")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
        TimeUnit.SECONDS.sleep(1);
        MobileElement toast3 = driver.findElement(By.xpath("//android.widget.Toast"));
        Assert.assertEquals(toast3.getText(), "Abone numarası istenilen formatta değil!");
    }

    @Test
    public void personel_b1_2() throws InterruptedException {
        personel_a4();
        driver.findElement(By.id("com.example.imudogalgazhomework:id/subnum_text")).setValue("12377678");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/usedm3_text")).setValue("100.00");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/m3price_text")).setValue("3.00");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/month_spinner")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.xpath("//android.widget.CheckedTextView[10]")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/month_spinner")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.xpath("//android.widget.CheckedTextView[10]")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
        TimeUnit.SECONDS.sleep(1);
        MobileElement toast3 = driver.findElement(By.xpath("//android.widget.Toast"));
        Assert.assertEquals(toast3.getText(), "Belirtilen abone numarasıyla kayıtlı bir abone bulunamadı!");
    }

    @Test
    public void personel_b2() throws InterruptedException {
        personel_a4();
        driver.findElement(By.id("com.example.imudogalgazhomework:id/subnum_text")).setValue("12345678");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/usedm3_text")).setValue("100,00");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/m3price_text")).setValue("3.00");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/month_spinner")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.xpath("//android.widget.CheckedTextView[10]")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/month_spinner")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.xpath("//android.widget.CheckedTextView[10]")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
        TimeUnit.SECONDS.sleep(1);
        MobileElement toast3 = driver.findElement(By.xpath("//android.widget.Toast"));
        Assert.assertEquals(toast3.getText(), "Kullanılan gaz istenilen formatta değil!");
    }

    @Test
    public void personel_b3() throws InterruptedException {
        personel_a4();
        driver.findElement(By.id("com.example.imudogalgazhomework:id/subnum_text")).setValue("12345678");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/usedm3_text")).setValue("100.00");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/m3price_text")).setValue("3,00");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/month_spinner")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.xpath("//android.widget.CheckedTextView[10]")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/month_spinner")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.xpath("//android.widget.CheckedTextView[10]")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
        TimeUnit.SECONDS.sleep(1);
        MobileElement toast3 = driver.findElement(By.xpath("//android.widget.Toast"));
        Assert.assertEquals(toast3.getText(), "Gaz fiyatı istenilen formatta değil!");
    }

    @Test
    public void personel_b4() throws InterruptedException {
        personel_a4();
        driver.findElement(By.id("com.example.imudogalgazhomework:id/subnum_text")).setValue("12345678");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/usedm3_text")).setValue("100.00");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/m3price_text")).setValue("3.00");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
        TimeUnit.SECONDS.sleep(1);
        MobileElement toast3 = driver.findElement(By.xpath("//android.widget.Toast"));
        Assert.assertEquals(toast3.getText(), "Lütfen ay seçin!");
    }

    @Test
    public void personel_b5() throws InterruptedException {
        personel_a4();
        driver.findElement(By.id("com.example.imudogalgazhomework:id/subnum_text")).setValue("12345678");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/usedm3_text")).setValue("100.00");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/m3price_text")).setValue("3.00");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/month_spinner")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.xpath("//android.widget.CheckedTextView[10]")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/month_spinner")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.xpath("//android.widget.CheckedTextView[10]")).click();
        driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
        TimeUnit.SECONDS.sleep(1);
        MobileElement toast3 = driver.findElement(By.xpath("//android.widget.Toast"));
        Assert.assertEquals(toast3.getText(), "Fatura bilgisi başarıyla güncellendi.");
    }*/
}
