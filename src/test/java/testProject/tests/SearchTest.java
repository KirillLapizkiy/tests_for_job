package testProject.tests;

import com.sun.org.glassfish.gmbal.Description;
import org.testng.annotations.Test;
import testProject.model.SearchData;

public class SearchTest extends TestBase {

    @Description("Автотест на проверку работоспособности поисковой строки на главной странице.")
    @Test
    public void testSearchLine() throws Exception {
        app.getSearchHelper().startSearch(new SearchData("top"));
        app.getWishListHelper().logout();
    }

}
