package test;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SearchTest {
    private WebDriver wd;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.get("http://automationpractice.com/index.php");
        login();
        mainPage();
    }

    private void mainPage() {
        wd.findElement(By.xpath("//img[@alt='My Store']")).click();
    }

    private void login() {
        wd.findElement(By.linkText("Sign in")).click();
        wd.findElement(By.id("email")).click();
        wd.findElement(By.id("email")).clear();
        wd.findElement(By.id("email")).sendKeys("kir9lapizkiy@gmail.com");
        wd.findElement(By.xpath("//form[@id='login_form']/div/div")).click();
        wd.findElement(By.id("passwd")).click();
        wd.findElement(By.id("passwd")).clear();
        wd.findElement(By.id("passwd")).sendKeys("GoodSecret");
        wd.findElement(By.xpath("//button[@id='SubmitLogin']/span")).click();
    }

    @Test
    public void testSearchLine() throws Exception {
        startSearch( "top");
        logout();
    }

    private void logout() {
        wd.findElement(By.linkText("Sign out")).click();
    }

    private void startSearch(String product) {
        wd.findElement(By.id("search_query_top")).click();
        wd.findElement(By.id("search_query_top")).clear();
        wd.findElement(By.id("search_query_top")).sendKeys(product);
        wd.findElement(By.name("submit_search")).click();
    }

    @AfterClass(alwaysRun = true)
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

    private boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

}
