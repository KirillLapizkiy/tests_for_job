package test;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.get("http://automationpractice.com/index.php");
        login("kir9@sibmail.com", "GoodSecret");
        mainPage();
    }

    protected void startSearch(SearchData searchData) {
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

    protected void logout() {
        wd.findElement(By.linkText("Sign out")).click();
    }

    protected void closeWindowAfterChoiceProduct() {
        wd.findElement(By.xpath("//body[@id='product']/div[2]/div/div/a")).click();
    }

    protected void addWhishList() {
        wd.findElement(By.id("wishlist_button")).click();
    }

    protected void choiceProduct() {
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

    protected void ExitFromWishList() {
        wd.findElement(By.xpath("//li[@id='wlp_1_1']/div/div[2]/div/div[2]/a/span")).click();
        wd.findElement(By.xpath("//div[@id='mywishlist']/ul/li/a/span")).click();
    }

    protected void AssignedNumbers(String value) {
        wd.findElement(By.id("quantity_1_1")).sendKeys(value);
    }

    protected void ChoiceFirstPositionInWishList() {
        wd.findElement(By.id("quantity_1_1")).click();
        wd.findElement(By.id("quantity_1_1")).clear();
    }

    protected void EntenInWishList() {
        wd.get("http://automationpractice.com/index.php?controller=my-account");
        wd.findElement(By.xpath("//div[@id='center_column']/div/div[2]/ul/li/a/span")).click();
        wd.findElement(By.linkText("My wishlist")).click();
    }
}
