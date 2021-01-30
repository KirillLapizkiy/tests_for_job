package testProject.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;

    private SessionHelper sessionHelper;
    private SearchHelper searchHelper;
    private WishListHelper wishListHelper;

    public void init() {
        wd = new FirefoxDriver();
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
