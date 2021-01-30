package testProject.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testProject.model.SearchData;

public class SearchHelper extends HelperBase {

    public SearchHelper(WebDriver wd) {
        super(wd);
    }

    public void startSearch(SearchData searchData) {
        type(By.id("search_query_top"), searchData.getNameProduct());
        click(By.name("submit_search"));
    }

}
