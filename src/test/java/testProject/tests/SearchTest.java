package testProject.tests;

import org.testng.annotations.Test;
import testProject.model.SearchData;

public class SearchTest extends TestBase {

    /**
     * "Автотест на проверку работоспособности поисковой строки на главной странице."
     */
    @Test
    public void testSearchLine() throws Exception {
        app.getSearchHelper().startSearch(new SearchData("top"));
        app.getWishListHelper().logout();
    }

}
