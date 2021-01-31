package testProject.tests;

import org.testng.annotations.Test;

public class DeleteItemInWishList extends TestBase{

    @Test
    public void testDeleteItemInWishList() {
        app.getWishListHelper().EntenInWishList();
        app.getWishListHelper().ChoiceFirstPositionInWishList();
        app.getWishListHelper().DeleteFirstPositionFromWishList();
        app.getWishListHelper().ExitFromWishList();
        app.getWishListHelper().logout();
    }

}
