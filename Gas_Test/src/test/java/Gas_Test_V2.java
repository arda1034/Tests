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


public class Gas_Test_V2 {
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

        public void perFatura() throws InterruptedException {
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

    public void aboneGiris() throws InterruptedException {
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
    }

    @Test
    public void personelRevC1() throws InterruptedException {
        perFatura();
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
    public void personelRevC2() throws InterruptedException {
        perFatura();
        driver.findElement(By.id("com.example.imudogalgazhomework:id/upload_button")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.google.android.documentsui:id/icon_thumb")).click();
        TimeUnit.SECONDS.sleep(1);
    }

    @Test
    public void personelRevC3() throws InterruptedException {
        perFatura();
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
        aboneGiris();
        driver.findElement(By.id("com.example.imudogalgazhomework:id/continue_button")).click();
        TimeUnit.SECONDS.sleep(1);
        String text1 = driver.findElement(By.id("com.example.imudogalgazhomework:id/m3price_text")).getText();
        TimeUnit.SECONDS.sleep(1);
        String text2 = driver.findElement(By.id("com.example.imudogalgazhomework:id/usedm3_text")).getText();
        Assert.assertEquals(text1, "3.00");
        Assert.assertEquals(text2, "120");
    }

    @Test
    public void aboneRevD1() throws InterruptedException {
        aboneGiris();
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
    public void aboneRevD3() throws InterruptedException {
        aboneGiris();
        driver.findElement(By.id("com.example.imudogalgazhomework:id/pay_button")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.imudogalgazhomework:id/month_spinner")).click();
        TimeUnit.SECONDS.sleep(1);
        MobileElement elem = driver.findElement(By.xpath("//android.widget.CheckedTextView[2]"));
        String txt = elem.getText();
        elem.click();
        TimeUnit.SECONDS.sleep(1);
        String txt2 = driver.findElement(By.id("com.example.imudogalgazhomework:id/info_text_5")).getText();
        TimeUnit.SECONDS.sleep(1);
        boolean res1 = txt2.contains(txt);
        Assert.assertTrue(res1);
    }
}
