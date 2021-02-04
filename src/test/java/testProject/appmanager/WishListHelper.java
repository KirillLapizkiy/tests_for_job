package testProject.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import testProject.model.SearchData;

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

    /**
     * "Если есть выпадающий список, то метод его заполнит данными из priority,"
     * "creation определяет в автотесте ожедание наличия дропбокса на странице"
     */
    public void AssignedNumbers(String value, String priority, boolean creation) {
        type(By.id("quantity_1_1"), value);

        if (creation) {
            new Select(wd.findElement(By.id("priority_1_1"))).selectByVisibleText(priority);
        } else {
            Assert.assertFalse(IsElementPresent(By.id("priority_1_1")));
        }

    }

    public void ChoiceFirstPositionInWishList() {
        click(By.id("quantity_1_1"));
        wd.findElement(By.id("quantity_1_1")).clear();
    }

    public void DeleteFirstPositionFromWishList() {
        click(By.xpath("//li[@id='wlp_1_1']/div/div[2]/div/a/i"));
    }

    /**
     * "Вход в список желаний, если находимся на странице,  с сназванием страницы MY ACCOUNT" +
     * "и с кнопкой \"My wishlists\", то неоткрываем по новой эту страницу"
     */
    public void EnterInWishList() {
        if (isElementPresent(By.tagName("page-heading"))
                && wd.findElement(By.tagName("page-heading")).getText().equals("MY ACCOUNT")
                && isElementPresent(By.name("My wishlists"))) {
            return;
        }
        wd.get("http://automationpractice.com/index.php?controller=my-account");
        click(By.xpath("//div[@id='center_column']/div/div[2]/ul/li/a/span"));
        click(By.linkText("My wishlist"));
    }

    public void startSearch(SearchData searchData) {
        type(By.id("search_query_top"), searchData.getNameProduct());
        click(By.name("submit_search"));
    }

    public void insertItem(SearchData item) {
        startSearch(item);
        choiceProduct();
        addWhishList();
        closeWindowAfterChoiceProduct();
    }

    public boolean isThereADesiredItem() {
        return isElementPresent(By.id("quantity_1_1"));
    }
}
