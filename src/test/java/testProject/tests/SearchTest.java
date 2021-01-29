package testProject.tests;

import org.testng.annotations.Test;
import testProject.model.SearchData;

public class SearchTest extends TestBase {

    @Test
    public void testSearchLine() throws Exception {
        app.startSearch(new SearchData("top"));
        app.logout();
    }

}
