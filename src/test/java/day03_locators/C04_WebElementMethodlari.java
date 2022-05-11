package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_WebElementMethodlari {

    /*
1- amazon.com'a gidip arama kutusunu locate edin
2- arama kutusunun tagName'inin input oldugunu test edin
3- arama kutusunun name attribute'nun degerinin ...... oldugunu test edin
 */

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("http://www.amazon.com");
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        String expectedTagName="input";
        String actualTagName=aramaKutusu.getTagName();
        if(expectedTagName.equals(actualTagName)){
            System.out.println("TagName testi PASSED");
        }else{
            System.out.println("TagName testi FAILED");
        }

        String expectedNameDegeri="field-keywords";
        String actualNameDegeri=aramaKutusu.getAttribute("name");

        if(expectedNameDegeri.equals(actualNameDegeri)){
            System.out.println("TagName testi PASSED");
        }else{
            System.out.println("TagName testi FAILED");
        }
        driver.close();

        /*
        <input type="text" id="twotabsearchtextbox" value="" name="field-keywords" autocomplete="off"
        placeholder="" class="nav-input nav-progressive-attribute" dir="auto" tabindex="0" aria-label="Search">

        webElementIsmi.getTagName()--> daha once locate ettigimiz bir webelementin tagname'ni döndürür
        webElementIsmi.getAttribute(attributeIsmi)--> daha once locate ettigimiz bir webelementin istedigim attribute'ünün degerini
        döndürür.

         */

    }
}
