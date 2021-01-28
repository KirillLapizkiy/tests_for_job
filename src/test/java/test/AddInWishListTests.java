package test;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddInWishListTests {
    private WebDriver wd;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.get("http://automationpractice.com/index.php");
        login("kir9lapizkiy@gmail.com", "GoodSecret");
        mainPage();
    }

    private void startSearch(SearchData searchData) {
        wd.findElement(By.id("search_query_top")).click();
        wd.findElement(By.id("search_query_top")).clear();
        wd.findElement(By.id("search_query_top")).sendKeys(searchData.getNameProduct());
        wd.findElement(By.name("submit_search")).click();
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
    public void addWishListTest() throws Exception {
        startSearch(new SearchData("Faded Short Sleeve T-shirts"));
        choiceProduct();
        addWhishList();
        closeWindowAfterChoiceProduct();
        logout();
    }

    private void logout() {
        wd.findElement(By.linkText("Sign out")).click();
    }

    private void closeWindowAfterChoiceProduct() {
        wd.findElement(By.xpath("//body[@id='product']/div[2]/div/div/a")).click();
    }

    private void addWhishList() {
        wd.findElement(By.id("wishlist_button")).click();
    }

    private void choiceProduct() {
        wd.findElement(By.xpath("//img[@alt='Faded Short Sleeve T-shirts']")).click();
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

    private boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}