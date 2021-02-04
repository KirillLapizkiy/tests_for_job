package testProject.tests;

import org.testng.annotations.Test;
import testProject.model.SearchData;

public class AddInWishListTests extends TestBase {

    /**
     * "Автотест на добавление товара nameProduct в вишлист."
     */
    @Test
    public void addInWishListTest() throws Exception {
        app.getWishListHelper().insertItem(new SearchData("Faded Short Sleeve T-shirts"));
        app.getWishListHelper().logout();
    }

}
