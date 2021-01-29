package test;

import org.testng.annotations.Test;

public class SearchTest extends TestBase {

    @Test
    public void testSearchLine() throws Exception {
        startSearch(new SearchData("top"));
        logout();
    }

}
