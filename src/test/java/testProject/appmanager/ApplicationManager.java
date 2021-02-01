package testProject.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;

    private SessionHelper sessionHelper;
    private SearchHelper searchHelper;
    private WishListHelper wishListHelper;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.IE)) {
            wd = new InternetExplorerDriver();
        }
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.get("http://automationpractice.com/index.php");
        wishListHelper = new WishListHelper(wd);
        searchHelper = new SearchHelper(wd);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.login("kir9@sibmail.com", "GoodSecret");
        mainPage();
    }

    public void mainPage() {
        wd.findElement(By.xpath("//img[@alt='My Store']")).click();
    }

    public void stop() {
        wd.quit();
    }

    public WishListHelper getWishListHelper() {
        return wishListHelper;
    }

    public SearchHelper getSearchHelper() {
        return searchHelper;
    }
}
