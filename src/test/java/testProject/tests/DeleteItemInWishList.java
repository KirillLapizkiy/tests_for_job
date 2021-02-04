package testProject.tests;

import org.testng.annotations.Test;
import testProject.model.SearchData;

public class DeleteItemInWishList extends TestBase {

    /**
     * "Автотест на удаление первой позиии в вишлисте,
     * если вишлист пустой, то автотест сам наполнит его."
     */
    @Test
    public void testDeleteItemInWishList() {
        app.getWishListHelper().EnterInWishList();
        if (!app.getWishListHelper().isThereADesiredItem()) {
            app.getWishListHelper().insertItem(new SearchData("Faded Short Sleeve T-shirts"));
        }
        app.getWishListHelper().EnterInWishList();
        app.getWishListHelper().ChoiceFirstPositionInWishList();
        app.getWishListHelper().DeleteFirstPositionFromWishList();
        app.getWishListHelper().ExitFromWishList();
        app.getWishListHelper().logout();
    }

}
