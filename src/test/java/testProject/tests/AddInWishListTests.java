package testProject.tests;

import org.testng.annotations.Test;
import testProject.model.SearchData;

public class AddInWishListTests extends TestBase {

    @Test
    public void addInWishListTest() throws Exception {
        app.getSearchHelper().startSearch(new SearchData("Faded Short Sleeve T-shirts"));
        app.getWishListHelper().choiceProduct();
        app.getWishListHelper().addWhishList();
        app.getWishListHelper().closeWindowAfterChoiceProduct();
        app.getWishListHelper().logout();
    }

}
