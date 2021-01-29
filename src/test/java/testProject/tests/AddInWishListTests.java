package testProject.tests;

import org.testng.annotations.Test;
import testProject.model.SearchData;

public class AddInWishListTests extends TestBase {

    @Test
    public void addWishListTest() throws Exception {
        app.startSearch(new SearchData("Faded Short Sleeve T-shirts"));
        app.choiceProduct();
        app.addWhishList();
        app.closeWindowAfterChoiceProduct();
        app.logout();
    }

}
