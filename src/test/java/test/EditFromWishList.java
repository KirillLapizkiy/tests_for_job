package test;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class EditFromWishList {
    private WebDriver wd;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.get("http://automationpractice.com/index.php");
        login("kir9lapizkiy@gmail.com", "GoodSecret");
        mainPage();
    }

    private void mainPage() {
        wd.findElement(By.xpath("//img[@alt='My Store']")).click();
    }

    private void login(String username, String password) {
        wd.findElement(By.linkText("Sign in")).click();
        wd.findElement(By.id("email")).click();
        wd.findElement(By.id("email")).clear();
        wd.findElement(By.id("email")).sendKeys(username);
        wd.findElement(By.xpath("//form[@id='login_form']/div/div")).click();
        wd.findElement(By.id("passwd")).click();
        wd.findElement(By.id("passwd")).clear();
        wd.findElement(By.id("passwd")).sendKeys(password);
        wd.findElement(By.xpath("//button[@id='SubmitLogin']/span")).click();
    }

    @Test
    public void testEditProductInWishList() throws Exception {
        wd.get("http://automationpractice.com/index.php?controller=my-account");
        wd.findElement(By.xpath("//div[@id='center_column']/div/div[2]/ul/li/a/span")).click();
        wd.findElement(By.linkText("My wishlist")).click();
        wd.findElement(By.id("quantity_1_1")).click();
        wd.findElement(By.id("quantity_1_1")).clear();
        wd.findElement(By.id("quantity_1_1")).sendKeys("150");
        wd.findElement(By.xpath("//li[@id='wlp_1_1']/div/div[2]/div/div[2]/a/span")).click();
        wd.findElement(By.xpath("//div[@id='mywishlist']/ul/li/a/span")).click();
        wd.findElement(By.linkText("Sign out")).click();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        wd.quit();

    }

    private boolean isElementPresent(By by) {
        try {
            wd.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}

