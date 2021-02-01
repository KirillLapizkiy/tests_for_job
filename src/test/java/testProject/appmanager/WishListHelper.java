package testProject.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishListHelper extends HelperBase {

    public WishListHelper(WebDriver wd) {
        super(wd);
    }

    public void logout() {
        click(By.linkText("Sign out"));
    }

    public void closeWindowAfterChoiceProduct() {
        click(By.xpath("//body[@id='product']/div[2]/div/div/a"));
    }

    public void addWhishList() {
        click(By.id("wishlist_button"));
    }

    public void choiceProduct() {
        click(By.xpath("//img[@alt='Faded Short Sleeve T-shirts']"));
    }

    public void ExitFromWishList() {
        click(By.xpath("//li[@id='wlp_1_1']/div/div[2]/div/div[2]/a/span"));
        click(By.xpath("//div[@id='mywishlist']/ul/li/a/span"));
    }

    public void AssignedNumbers(String value) {
        type(By.id("quantity_1_1"), value);
    }

    public void ChoiceFirstPositionInWishList() {
        click(By.id("quantity_1_1"));
        wd.findElement(By.id("quantity_1_1")).clear();
    }

    public void DeleteFirstPositionFromWishList() {
        click(By.xpath("//li[@id='wlp_1_1']/div/div[2]/div/a/i"));
    }

    public void EntenInWishList() {
        wd.get("http://automationpractice.com/index.php?controller=my-account");
        click(By.xpath("//div[@id='center_column']/div/div[2]/ul/li/a/span"));
        click(By.linkText("My wishlist"));
    }
}
