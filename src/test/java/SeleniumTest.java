import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

public class Seleniumtest {
    public static ChromeOptions options;
    public static WebDriver driver;

    @BeforeTest

    public static void AmazonLaunching() {
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //System.setProperty("WebDriver.chrome.driver", "/home/Desktop/maven/mavenproject/src/test/resources/chromedriver");
        driver = new ChromeDriver(options);
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
    }

    @Test
    public static void Search() {
        WebElement searchbar = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
        searchbar.sendKeys("boat headphone");
        WebElement searchbutton = driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]"));
        searchbutton.click();
        Assert.assertTrue(driver.getTitle().contains("boat headphone"), "yes");
    }

    @Test
    public static void testcolorpatternsforfirstelement() {
        WebElement firstproduct = driver.findElement(By.cssSelector(""));
        WebElement colorpatternbutton = driver.findElement(By.linkText("+1 colour/pattern"));
        colorpatternbutton.click();
    }

    @Test
    public static void addtocart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement product = driver.findElement(By.cssSelector("div.puisg-col-inner\n"));
        product.click();
        Set<String> s = driver.getWindowHandles();
        ArrayList ar = new ArrayList(s);
        driver.switchTo().window((String) ar.get(1));
        WebElement addtocartbutton = driver.findElement(By.id("add-to-cart-button"));
        addtocartbutton.click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("nav-cart-count"), "1"));
        driver.get("https://www.amazon.in/gp/cart/view.html?ref_=nav_cart");
    }

    @Test
    public static void proceedtopay() {
        WebElement proceedtopaybutton = driver.findElement(By.xpath("//*[@id=\"sc-buy-box-ptc-button\"]/span/input"));
        proceedtopaybutton.click();
    }

    @AfterTest
     public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }
}








