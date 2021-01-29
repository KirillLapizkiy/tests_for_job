package testProject.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishListHelper {
   private WebDriver wd;

    public WishListHelper(WebDriver wd) {
        this.wd=wd;
    }

    public void logout() {
        wd.findElement(By.linkText("Sign out")).click();
    }

    public void closeWindowAfterChoiceProduct() {
        wd.findElement(By.xpath("//body[@id='product']/div[2]/div/div/a")).click();
    }

    public void addWhishList() {
        wd.findElement(By.id("wishlist_button")).click();
    }

    public void choiceProduct() {
        wd.findElement(By.xpath("//img[@alt='Faded Short Sleeve T-shirts']")).click();
    }

    public void ExitFromWishList() {
        wd.findElement(By.xpath("//li[@id='wlp_1_1']/div/div[2]/div/div[2]/a/span")).click();
        wd.findElement(By.xpath("//div[@id='mywishlist']/ul/li/a/span")).click();
    }

    public void AssignedNumbers(String value) {
        wd.findElement(By.id("quantity_1_1")).sendKeys(value);
    }

    public void ChoiceFirstPositionInWishList() {
        wd.findElement(By.id("quantity_1_1")).click();
        wd.findElement(By.id("quantity_1_1")).clear();
    }

    public void EntenInWishList() {
        wd.get("http://automationpractice.com/index.php?controller=my-account");
        wd.findElement(By.xpath("//div[@id='center_column']/div/div[2]/ul/li/a/span")).click();
        wd.findElement(By.linkText("My wishlist")).click();
    }
}
