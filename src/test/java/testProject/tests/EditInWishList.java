package testProject.tests;

import com.sun.org.glassfish.gmbal.Description;
import org.testng.annotations.Test;
import testProject.model.SearchData;

public class EditInWishList extends TestBase {

    @Description("Автотест на редактирование количества товара и приоритета покупки у позиции " +
            "в вишлисте, если вишлист пустой, то автотест сам наполнит его.")
    @Test
    public void testEditProductInWishList() throws Exception {
        app.getWishListHelper().EntenInWishList();
        if(! app.getWishListHelper().isThereADesiredItem()){
app.getWishListHelper().insertItem(new SearchData("Faded Short Sleeve T-shirts"));
        }
        app.getWishListHelper().EntenInWishList();
        app.getWishListHelper().ChoiceFirstPositionInWishList();
        app.getWishListHelper().AssignedNumbers("150", "High", true);
        app.getWishListHelper().ExitFromWishList();
        app.getWishListHelper().logout();
    }

}

