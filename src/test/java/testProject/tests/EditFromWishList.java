package testProject.tests;

import org.testng.annotations.Test;

public class EditFromWishList extends TestBase {

    @Test
    public void testEditProductInWishList() throws Exception {
        app.getWishListHelper().EntenInWishList();
        app.getWishListHelper().ChoiceFirstPositionInWishList();
        app.getWishListHelper().AssignedNumbers("150");
        app.getWishListHelper().ExitFromWishList();
        app.getWishListHelper().logout();
    }

}

