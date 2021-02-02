package testProject.tests;

import com.sun.org.glassfish.gmbal.Description;
import org.testng.annotations.Test;
import testProject.model.SearchData;

public class DeleteItemInWishList extends TestBase{

    @Description("Автотест на удаление первой позиии в вишлисте, если вишлист пустой, то автотест сам наполнит его.")
    @Test
    public void testDeleteItemInWishList() {
        app.getWishListHelper().EntenInWishList();
        if(! app.getWishListHelper().isThereADesiredItem()){
            app.getWishListHelper().insertItem(new SearchData("Faded Short Sleeve T-shirts"));
        }
        app.getWishListHelper().EntenInWishList();
        app.getWishListHelper().ChoiceFirstPositionInWishList();
        app.getWishListHelper().DeleteFirstPositionFromWishList();
        app.getWishListHelper().ExitFromWishList();
        app.getWishListHelper().logout();
    }

}
