import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.ArrayUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Market_Test {
    public AndroidDriver<MobileElement> driver;

    @BeforeMethod
    public void setup() throws MalformedURLException, InterruptedException {
        //TimeUnit.SECONDS.sleep(1);
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "emulator-5554");
        cap.setCapability("udid", "emulator-5554");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "11");
        cap.setCapability("appPackage", "com.example.myapplication");
        cap.setCapability("appActivity", "com.example.myapplication.MainActivity");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
        TimeUnit.SECONDS.sleep(6);
    }

    @Test
    public void sepete_ekle() throws InterruptedException {
        driver.findElement(By.id("com.example.myapplication:id/milkProductsButton")).click();
        TimeUnit.SECONDS.sleep(2);
        String txt = driver.findElement(By.xpath("//android.widget.FrameLayout[2]//android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.TextView[1]")).getText();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.xpath("//android.widget.FrameLayout[2]//android.widget.FrameLayout[1]")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/increaseButton")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/buyButton")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/sepetButton")).click();
        TimeUnit.SECONDS.sleep(1);
        List<MobileElement> textviews = driver.findElements(By.xpath("//android.widget.TextView"));
        String[] texts = new String[textviews.size()];
        for(MobileElement text : textviews) texts = ArrayUtils.add(texts, text.getText());
        List<String> texts2 = Arrays.asList(texts);
        boolean res1 = texts2.contains(txt);
        Assert.assertTrue(res1);
    }

    @Test
    public void toplam_tutar() throws InterruptedException {
        driver.findElement(By.id("com.example.myapplication:id/milkProductsButton")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.xpath("//android.widget.FrameLayout[2]//android.widget.FrameLayout[1]")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/increaseButton")).click();
        TimeUnit.MILLISECONDS.sleep(10);
        driver.findElement(By.id("com.example.myapplication:id/increaseButton")).click();
        TimeUnit.MILLISECONDS.sleep(10);
        driver.findElement(By.id("com.example.myapplication:id/increaseButton")).click();
        TimeUnit.SECONDS.sleep(1);
        String a = driver.findElement(By.id("com.example.myapplication:id/textView2")).getText();
        int b = Integer.parseInt(a);
        String c = driver.findElement(By.id("com.example.myapplication:id/textView5")).getText();
        c = c.replaceAll("[^0-9.]", "");
        float d = Float.parseFloat(c);
        driver.findElement(By.id("com.example.myapplication:id/buyButton")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.id("com.example.myapplication:id/milkProductsButton")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.xpath("//android.widget.FrameLayout[2]//android.widget.FrameLayout[2]")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/increaseButton")).click();
        TimeUnit.MILLISECONDS.sleep(10);
        driver.findElement(By.id("com.example.myapplication:id/increaseButton")).click();
        TimeUnit.MILLISECONDS.sleep(10);
        driver.findElement(By.id("com.example.myapplication:id/increaseButton")).click();
        TimeUnit.SECONDS.sleep(1);
        String a_2 = driver.findElement(By.id("com.example.myapplication:id/textView2")).getText();
        int b_2 = Integer.parseInt(a_2);
        String c_2 = driver.findElement(By.id("com.example.myapplication:id/textView5")).getText();
        c_2 = c_2.replaceAll("[^0-9.]", "");
        float d_2 = Float.parseFloat(c_2);
        driver.findElement(By.id("com.example.myapplication:id/buyButton")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/sepetButton")).click();
        TimeUnit.SECONDS.sleep(1);
        String e = driver.findElement(By.id("com.example.myapplication:id/total_price")).getText();
        e = e.replaceAll("[^0-9.]", "");
        float g = Float.parseFloat(e);
        Assert.assertEquals(b * d + b_2 * d_2, g);
    }

    //@Test
    public void ek_1_to_sepet() throws InterruptedException {
        driver.findElement(By.id("com.example.myapplication:id/sepetButton")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/SepetTitle")).isDisplayed();
    }

    //@Test
    public void ek_2_to_sepet() throws InterruptedException {
        driver.findElement(By.id("com.example.myapplication:id/milkProductsButton")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/sepetButton")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/SepetTitle")).isDisplayed();
    }

    //@Test
    public void ek_3_to_sepet() throws InterruptedException {
        driver.findElement(By.id("com.example.myapplication:id/milkProductsButton")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.xpath("//android.widget.FrameLayout[2]//android.widget.FrameLayout[1]")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/sepetButton")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/SepetTitle")).isDisplayed();
    }

    //@Test
    public void ek_4_to_sepet() throws InterruptedException {
        driver.findElement(By.id("com.example.myapplication:id/stokButton")).click();
        TimeUnit.SECONDS.sleep(3);
        driver.findElement(By.id("com.example.myapplication:id/editTextEmail")).setValue("fagosem481@vinopub.com");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/editTextPassword")).setValue("12345678");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/SigninButton")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.id("com.example.myapplication:id/sepetButton")).isDisplayed();
    }

    @Test
    public void tumu_to_sepet() throws InterruptedException {
        ek_1_to_sepet();
        driver.findElement(By.id("com.example.myapplication:id/homeButton")).click();
        TimeUnit.SECONDS.sleep(1);
        ek_2_to_sepet();
        driver.findElement(By.id("com.example.myapplication:id/homeButton")).click();
        TimeUnit.SECONDS.sleep(1);
        ek_3_to_sepet();
        driver.findElement(By.id("com.example.myapplication:id/homeButton")).click();
        TimeUnit.SECONDS.sleep(1);
        ek_4_to_sepet();
        driver.findElement(By.id("com.example.myapplication:id/homeButton")).click();
        TimeUnit.SECONDS.sleep(1);
    }

    @Test
    public void mevcut_uye() throws InterruptedException {
        driver.findElement(By.id("com.example.myapplication:id/stokButton")).click();
        TimeUnit.SECONDS.sleep(3);
        driver.findElement(By.id("com.example.myapplication:id/SignupButton")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.id("com.example.myapplication:id/editTextName")).setValue("abone_1");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/checkBox")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/editTextEmail")).setValue("fagosem481@vinopub.com");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/editTextPassword")).setValue("12345678");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/SignupButton")).click();
        TimeUnit.SECONDS.sleep(2);
        MobileElement toast = driver.findElement(By.xpath("//android.widget.Toast"));
        Assert.assertEquals(toast.getText(), "Zaten üyesiniz giriş yapınız");
    }

    @Test
    public void uye_girisi() throws InterruptedException {
        driver.findElement(By.id("com.example.myapplication:id/stokButton")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/editTextEmail")).setValue("fagosem481@vinopub.com");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/editTextPassword")).setValue("12345678");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/SigninButton")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.id("com.example.myapplication:id/sepetButton")).isDisplayed();
    }

    @Test
    public void personel_girisi() throws InterruptedException {
        driver.findElement(By.id("com.example.myapplication:id/stokButton")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/editTextEmail")).setValue("hagepa7562@rezunz.com");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/editTextPassword")).setValue("12345678");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/SigninButton")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.id("com.example.myapplication:id/saveButton")).isDisplayed();
    }
}
