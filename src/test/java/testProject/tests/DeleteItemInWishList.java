package testProject.tests;

import com.sun.org.glassfish.gmbal.Description;
import org.testng.annotations.Test;

public class DeleteItemInWishList extends TestBase{

    @Description("Автотест на удаление первой позиии в вишлисте.")
    @Test
    public void testDeleteItemInWishList() {
        app.getWishListHelper().EntenInWishList();
        app.getWishListHelper().ChoiceFirstPositionInWishList();
        app.getWishListHelper().DeleteFirstPositionFromWishList();
        app.getWishListHelper().ExitFromWishList();
        app.getWishListHelper().logout();
    }

}
