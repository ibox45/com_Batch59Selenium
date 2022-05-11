package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_Locators {
   /* Main method oluşturun ve aşağıdaki görevi tamamlayın.
            a. http://a.testaddressbook.com adresine gidiniz.
    b. Sign in butonuna basin
    c. email textbox,password textbox, and signin button elementlerini locate ediniz..
    d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
    i. Username : testtechproed@gmail.com
    ii. Password : Test1234!
    e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
    f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
            3. Sayfada kac tane link oldugunu bulun.*/

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("http://a.testaddressbook.com");
        WebElement signInLinki=driver.findElement(By.linkText("Sign in"));
        signInLinki.click();
        WebElement emailTextBox=driver.findElement(By.id("session_email"));
        WebElement passwordTextBox=driver.findElement(By.name("session[password]"));
        WebElement signInButonu=driver.findElement(By.name("commit"));
        emailTextBox.sendKeys("testtechproed@gmail.com");
        passwordTextBox.sendKeys("Test1234!");
        signInButonu.click();
        WebElement actualKullaniciAdiElementi=driver.findElement((By.className("navbar-text")));
        System.out.println(actualKullaniciAdiElementi.getText());
        String expectedUserMail="testtechproed@gmail.com";

        if(expectedUserMail.equals(actualKullaniciAdiElementi.getText())){
            System.out.println("Expected kullanici testi PASSED");
        }else{
            System.out.println("Expected kullanici testi FAILED");
        }

        WebElement adressesElementi=driver.findElement(By.linkText("Addresses"));
        WebElement signOutElementi=driver.findElement(By.linkText("Sign out"));
        if(adressesElementi.isDisplayed()){
            System.out.println("adresses testi PASSED");
        }else{
            System.out.println("adresses testi FAILED");
        }

        if(signOutElementi.isDisplayed()){
            System.out.println("sign out testi PASSED");
        }else{
            System.out.println("sign out testi FAILED");
        }

        List<WebElement> linklerListesi=driver.findElements(By.tagName("a"));
        System.out.println("sayfadaki link sayisi : "+linklerListesi.size());

        for (WebElement each:linklerListesi
             ) {
            System.out.println(each.getText());
        }

        driver.close();









    }
}
