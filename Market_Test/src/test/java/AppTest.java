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

public class AppTest {
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


/*    @Test //1 numaralı test
    public void kategoriler() throws InterruptedException {
        String[] z = {"milkProductsButton", "cleanerButton", "breadButton", "meatButton", "drinkButton", "chocolateButton"};
        String[] x = {"Süt ve Süt Ürünleri", "Temizlik ve Bakım", "Ekmek ve Pasta", "Et ve Et Ürünleri", "İçecekler", "Atıştırmalık"};
        for(int i = 0; i < 6; i++) {
            driver.findElement(By.id("com.example.myapplication:id/"+z[i])).click();
            TimeUnit.SECONDS.sleep(2);
            String txt = driver.findElement(By.id("categoryTextView")).getText();
            Assert.assertEquals(x[i], txt);
            driver.navigate().back();
        }
    }

*//*    @Test //2 numaralı test
    public void Urunler() throws InterruptedException {
        String[] z = {"milkProductsButton", "cleanerButton", "breadButton", "meatButton", "drinkButton", "chocolateButton"};
        for(int i = 0; i < 6; i++) {
            String s = "com.example.myapplication:id/" + z[i];
            driver.findElement(By.id(s)).click();
            TimeUnit.SECONDS.sleep(2);
            MobileElement f = driver.findElement(By.xpath("//android.widget.FrameLayout[2]"));
            List<MobileElement> Flames = f.findElements(By.id("com.example.myapplication:id/CardView"));
            boolean res;
            for (MobileElement flame : Flames) {
                String x = flame.findElement(By.id("com.example.myapplication:id/ProductName")).getText();
                flame.click();
                TimeUnit.SECONDS.sleep(1);
                String t = driver.findElement(By.xpath("//android.view.ViewGroup/android.widget.TextView[2]")).getText();
                TimeUnit.SECONDS.sleep(1);
                res = t.contains(x);
                Assert.assertTrue(res);
                driver.navigate().back();
                TimeUnit.SECONDS.sleep(1);
            }
            driver.navigate().back();
            TimeUnit.SECONDS.sleep(1);
        }
    }*//*

    @Test // 3 numaralı test
    public void artir() throws InterruptedException {
        //TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.id("com.example.myapplication:id/milkProductsButton")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.xpath("//android.widget.FrameLayout[2]//android.widget.FrameLayout[1]")).click();
        TimeUnit.SECONDS.sleep(1);
        String a = driver.findElement(By.id("com.example.myapplication:id/textView2")).getText();
        driver.findElement(By.id("com.example.myapplication:id/increaseButton")).click();
        TimeUnit.SECONDS.sleep(1);
        int b = Integer.parseInt(a);
        String c = driver.findElement(By.id("com.example.myapplication:id/textView2")).getText();
        int d = Integer.parseInt(c);
        Assert.assertEquals(d - b, 1);
    }

    @Test // 4 numara
    public void eksilme() throws InterruptedException {
        driver.findElement(By.id("com.example.myapplication:id/milkProductsButton")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.xpath("//android.widget.FrameLayout[2]//android.widget.FrameLayout[1]")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.id("com.example.myapplication:id/decreaseButton")).click();
        TimeUnit.SECONDS.sleep(2);
        MobileElement toast = driver.findElement(By.xpath("//android.widget.Toast"));
        Assert.assertEquals(toast.getText(), "henüz ürün eklemediniz");
    }

    @Test // 5 numara
    public void eksilme_v2() throws InterruptedException {
        //TimeUnit.SECONDS.sleep(3);
        driver.findElement(By.id("com.example.myapplication:id/milkProductsButton")).click();
        TimeUnit.SECONDS.sleep(3);
        driver.findElement(By.xpath("//android.widget.FrameLayout[2]//android.widget.FrameLayout[1]")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/increaseButton")).click();
        TimeUnit.SECONDS.sleep(1);
        String a = driver.findElement(By.id("com.example.myapplication:id/textView2")).getText();
        driver.findElement(By.id("com.example.myapplication:id/decreaseButton")).click();
        TimeUnit.SECONDS.sleep(1);
        int b = Integer.parseInt(a);
        String c = driver.findElement(By.id("com.example.myapplication:id/textView2")).getText();
        int d = Integer.parseInt(c);
        Assert.assertEquals(b - d, 1);
    }

    @Test //6 no
    public void ek_3_to_4() throws InterruptedException {
        driver.findElement(By.id("com.example.myapplication:id/milkProductsButton")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.xpath("//android.widget.FrameLayout[2]//android.widget.FrameLayout[1]")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/buyButton")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/PayButton")).isDisplayed();
    }

    @Test //8 no
    public void total_price() throws InterruptedException {
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
        c = c.replaceAll("\\D+","");
        int d = Integer.parseInt(c);
        driver.findElement(By.id("com.example.myapplication:id/buyButton")).click();
        TimeUnit.SECONDS.sleep(1);
        String e = driver.findElement(By.id("com.example.myapplication:id/total_price")).getText();
        e = e.replaceAll("\\D+","");
        int g = Integer.parseInt(e);
        Assert.assertEquals(b * d, g);
    }

    @Test //no 10
    public void odemede_back() throws InterruptedException {
        driver.findElement(By.id("com.example.myapplication:id/milkProductsButton")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.xpath("//android.widget.FrameLayout[2]//android.widget.FrameLayout[1]")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/increaseButton")).click();
        TimeUnit.MILLISECONDS.sleep(10);
        driver.findElement(By.id("com.example.myapplication:id/increaseButton")).click();
        TimeUnit.MILLISECONDS.sleep(10);
        driver.findElement(By.id("com.example.myapplication:id/increaseButton")).click();
        TimeUnit.MILLISECONDS.sleep(10);
        String a = driver.findElement(By.id("com.example.myapplication:id/textView2")).getText();
        int b = Integer.parseInt(a);
        driver.findElement(By.id("com.example.myapplication:id/buyButton")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.navigate().back();
        TimeUnit.MILLISECONDS.sleep(10);
        String c = driver.findElement(By.id("com.example.myapplication:id/textView2")).getText();
        int d = Integer.parseInt(c);
        Assert.assertEquals(d - b, 0);
    }

    @Test //no 11
    public void yonlendirme() throws InterruptedException {
        driver.findElement(By.id("com.example.myapplication:id/milkProductsButton")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.xpath("//android.widget.FrameLayout[2]//android.widget.FrameLayout[1]")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/buyButton")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/PayButton")).click();
        TimeUnit.SECONDS.sleep(5);
        MobileElement kategori = driver.findElement(By.id("com.example.myapplication:id/textView"));
        Assert.assertEquals(kategori.getText(), "Kategoriler");
    }

    @Test //7 no
    public void bigger_stok() throws InterruptedException {
        driver.findElement(By.id("com.example.myapplication:id/stokButton")).click();
        TimeUnit.SECONDS.sleep(2);
        MobileElement screen = driver.findElement(By.xpath("//android.widget.FrameLayout[2]"));
        List<MobileElement> Flames = screen.findElements(By.id("com.example.myapplication:id/CardView"));
        String s1 = "Ülker Albeni 40 gr";
        String s2 = "";
        int n = 0;
        for(MobileElement i : Flames) {
            if(s1.equals(i.findElement(By.id("com.example.myapplication:id/ProductName")).getText())) {
                s2 = i.findElement(By.id("com.example.myapplication:id/ProductCount")).getText();
                n = Integer.parseInt(s2);
                break;
            }
        }
        driver.findElement(By.id("com.example.myapplication:id/homeButton")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.id("com.example.myapplication:id/chocolateButton")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.xpath("//android.widget.FrameLayout[2]//android.widget.FrameLayout[1]")).click();
        TimeUnit.SECONDS.sleep(2);
        for(int i = 0; i < n + 1; ++i) {
            driver.findElement(By.id("com.example.myapplication:id/increaseButton")).click();
            TimeUnit.MILLISECONDS.sleep(10);
        }
        driver.findElement(By.id("com.example.myapplication:id/buyButton")).click();
        TimeUnit.SECONDS.sleep(2);
        MobileElement toast = driver.findElement(By.xpath("//android.widget.Toast"));
        Assert.assertEquals(toast.getText(), "Üzgünüz, istediğiniz üründen kalmadı..");
    }

    @Test //9 no
    public void stok_eksiltme() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.id("com.example.myapplication:id/stokButton")).click();
        TimeUnit.SECONDS.sleep(2);
        MobileElement screen = driver.findElement(By.xpath("//android.widget.FrameLayout[2]"));
        List<MobileElement> Flames = screen.findElements(By.id("com.example.myapplication:id/CardView"));
        String s1 = "Ülker Albeni 40 gr";
        String s2 = "";
        String s3 = "";
        int n1 = 0;
        int n2 = 0;
        for(MobileElement i : Flames) {
            if(s1.equals(i.findElement(By.id("com.example.myapplication:id/ProductName")).getText())) {
                s2 = i.findElement(By.id("com.example.myapplication:id/ProductCount")).getText();
                n1 = Integer.parseInt(s2);
                break;
            }
        }
        driver.findElement(By.id("com.example.myapplication:id/homeButton")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.id("com.example.myapplication:id/chocolateButton")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.xpath("//android.widget.FrameLayout[2]//android.widget.FrameLayout[1]")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.id("com.example.myapplication:id/increaseButton")).click();
        TimeUnit.MILLISECONDS.sleep(10);
        driver.findElement(By.id("com.example.myapplication:id/buyButton")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.id("com.example.myapplication:id/PayButton")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.id("com.example.myapplication:id/stokButton")).click();
        TimeUnit.SECONDS.sleep(2);
        MobileElement screen2 = driver.findElement(By.xpath("//android.widget.FrameLayout[2]"));
        List<MobileElement> Flames2 = screen2.findElements(By.id("com.example.myapplication:id/CardView"));
        for(MobileElement i : Flames2) {
            if(s1.equals(i.findElement(By.id("com.example.myapplication:id/ProductName")).getText())) {
                s3 = i.findElement(By.id("com.example.myapplication:id/ProductCount")).getText();
                n2 = Integer.parseInt(s3);
                break;
            }
        }
        Assert.assertEquals(n1 - n2, 1);
    }

    //@Test // 12 numaralı test için
    public void ek_1_to_stok() throws InterruptedException {
        driver.findElement(By.id("com.example.myapplication:id/stokButton")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/saveButton")).isDisplayed();
    }

    //@Test // 12 numaralı test için
    public void ek_2_to_stok() throws InterruptedException {
        driver.findElement(By.id("com.example.myapplication:id/milkProductsButton")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/stokButton")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/saveButton")).isDisplayed();
    }

    //@Test // 12 numaralı test için
    public void ek_3_to_stok() throws InterruptedException {
        driver.findElement(By.id("com.example.myapplication:id/milkProductsButton")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.xpath("//android.widget.FrameLayout[2]//android.widget.FrameLayout[1]")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/stokButton")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/saveButton")).isDisplayed();
    }

    //@Test // 12 numaralı test için
    public void ek_4_to_stok() throws InterruptedException {
        driver.findElement(By.id("com.example.myapplication:id/milkProductsButton")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.xpath("//android.widget.FrameLayout[2]//android.widget.FrameLayout[1]")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/buyButton")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/stokButton")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/saveButton")).isDisplayed();
    }

    @Test //12 numara
    public void tumu_to_stok() throws InterruptedException {
        ek_1_to_stok();
        driver.findElement(By.id("com.example.myapplication:id/homeButton")).click();
        TimeUnit.SECONDS.sleep(1);
        ek_2_to_stok();
        driver.findElement(By.id("com.example.myapplication:id/homeButton")).click();
        TimeUnit.SECONDS.sleep(1);
        ek_3_to_stok();
        driver.findElement(By.id("com.example.myapplication:id/homeButton")).click();
        TimeUnit.SECONDS.sleep(1);
        ek_4_to_stok();
        driver.findElement(By.id("com.example.myapplication:id/homeButton")).click();
        TimeUnit.SECONDS.sleep(1);
    }

    //@Test // 19 için
    public void ek_2_to_home() throws InterruptedException {
        driver.findElement(By.id("com.example.myapplication:id/milkProductsButton")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/homeButton")).click();
        TimeUnit.SECONDS.sleep(1);
        MobileElement kategori = driver.findElement(By.id("com.example.myapplication:id/textView"));
        Assert.assertEquals(kategori.getText(), "Kategoriler");
    }

    //@Test // 19 numaralı test için
    public void ek_3_to_home() throws InterruptedException {
        driver.findElement(By.id("com.example.myapplication:id/milkProductsButton")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.xpath("//android.widget.FrameLayout[2]//android.widget.FrameLayout[1]")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/homeButton")).click();
        TimeUnit.SECONDS.sleep(1);
        MobileElement kategori = driver.findElement(By.id("com.example.myapplication:id/textView"));
        Assert.assertEquals(kategori.getText(), "Kategoriler");
    }

    //@Test // 19 numaralı test için
    public void ek_4_to_home() throws InterruptedException {
        driver.findElement(By.id("com.example.myapplication:id/milkProductsButton")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.xpath("//android.widget.FrameLayout[2]//android.widget.FrameLayout[1]")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/buyButton")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/homeButton")).click();
        TimeUnit.SECONDS.sleep(1);
        MobileElement kategori = driver.findElement(By.id("com.example.myapplication:id/textView"));
        Assert.assertEquals(kategori.getText(), "Kategoriler");
    }

    // @Test //19 için
    public void ek_5_to_home() throws InterruptedException {
        driver.findElement(By.id("com.example.myapplication:id/stokButton")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/homeButton")).click();
        TimeUnit.SECONDS.sleep(1);
        MobileElement kategori = driver.findElement(By.id("com.example.myapplication:id/textView"));
        Assert.assertEquals(kategori.getText(), "Kategoriler");
    }

    @Test //19 numara
    public void tumu_to_home() throws InterruptedException {
        ek_2_to_home();
        TimeUnit.SECONDS.sleep(1);
        ek_3_to_home();
        TimeUnit.SECONDS.sleep(1);
        ek_4_to_home();
        TimeUnit.SECONDS.sleep(1);
        ek_5_to_home();
        TimeUnit.SECONDS.sleep(1);
    }

    //@Test // 20 için
    public void ek_2_back() throws InterruptedException {
        driver.findElement(By.id("com.example.myapplication:id/milkProductsButton")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(1);
        MobileElement kategori = driver.findElement(By.id("com.example.myapplication:id/textView"));
        Assert.assertEquals(kategori.getText(), "Kategoriler");
    }

    //@Test // 20 numaralı test için
    public void ek_3_back() throws InterruptedException {
        driver.findElement(By.id("com.example.myapplication:id/milkProductsButton")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.xpath("//android.widget.FrameLayout[2]//android.widget.FrameLayout[1]")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("categoryTextView")).isDisplayed();
    }

    //@Test // 20 numaralı test için
    public void ek_4_back() throws InterruptedException {
        driver.findElement(By.id("com.example.myapplication:id/milkProductsButton")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.xpath("//android.widget.FrameLayout[2]//android.widget.FrameLayout[1]")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/buyButton")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/buyButton")).isDisplayed();
    }

    //@Test //20 için
    public void ek_5_back() throws InterruptedException {
        driver.findElement(By.id("com.example.myapplication:id/stokButton")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(1);
        MobileElement kategori = driver.findElement(By.id("com.example.myapplication:id/textView"));
        Assert.assertEquals(kategori.getText(), "Kategoriler");

        driver.findElement(By.id("com.example.myapplication:id/milkProductsButton")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.id("com.example.myapplication:id/stokButton")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("categoryTextView")).isDisplayed();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/homeButton")).click();
        TimeUnit.SECONDS.sleep(1);

        driver.findElement(By.id("com.example.myapplication:id/milkProductsButton")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.xpath("//android.widget.FrameLayout[2]//android.widget.FrameLayout[1]")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/stokButton")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/buyButton")).isDisplayed();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/homeButton")).click();
        TimeUnit.SECONDS.sleep(1);

        driver.findElement(By.id("com.example.myapplication:id/milkProductsButton")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.xpath("//android.widget.FrameLayout[2]//android.widget.FrameLayout[1]")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/buyButton")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/stokButton")).click();
        TimeUnit.SECONDS.sleep(1);
        driver.navigate().back();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/PayButton")).isDisplayed();
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("com.example.myapplication:id/homeButton")).click();
    }

    @Test //20 numara
    public void tumu_back() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        ek_2_back();
        TimeUnit.SECONDS.sleep(3);
        ek_3_back();
        TimeUnit.SECONDS.sleep(3);
        driver.findElement(By.id("com.example.myapplication:id/homeButton")).click();
        TimeUnit.SECONDS.sleep(3);
        ek_4_back();
        TimeUnit.SECONDS.sleep(3);
        driver.findElement(By.id("com.example.myapplication:id/homeButton")).click();
        TimeUnit.SECONDS.sleep(3);
        ek_5_back();
        TimeUnit.SECONDS.sleep(3);
    }*/
}