package testProject.tests;

import com.sun.org.glassfish.gmbal.Description;
import org.testng.annotations.Test;
import testProject.model.SearchData;

public class AddInWishListTests extends TestBase {

    @Description("Автотест на добавление товара naeProduct в вишлист.")
    @Test
    public void addInWishListTest() throws Exception {
        app.getWishListHelper().insertItem(new SearchData("Faded Short Sleeve T-shirts"));
        app.getWishListHelper().logout();
    }

}
