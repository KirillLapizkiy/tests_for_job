package testProject.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import testProject.model.SearchData;

public class AddInWishListTests extends TestBase {

    /**
     * "Автотест на добавление товара nameProduct в вишлист."
     */
    @Test
    public void addInWishListTest() throws Exception {
        app.getWishListHelper().insertItem(new SearchData("Faded Short Sleeve T-shirts"));
        app.getWishListHelper().CheckTextPopup("Added to your wishlist.");
        app.getWishListHelper().closeWindow();
        app.getWishListHelper().logout();
    }

}
