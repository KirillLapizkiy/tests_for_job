package test;

import org.testng.annotations.Test;

public class AddInWishListTests extends TestBase {

    @Test
    public void addWishListTest() throws Exception {
        startSearch(new SearchData("Faded Short Sleeve T-shirts"));
        choiceProduct();
        addWhishList();
        closeWindowAfterChoiceProduct();
        logout();
    }

}
