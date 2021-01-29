package testProject.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testProject.model.SearchData;

public class SearchHelper {
    private WebDriver wd;

    public SearchHelper(WebDriver wd) {
        this.wd = wd;
    }

    public void startSearch(SearchData searchData) {
        wd.findElement(By.id("search_query_top")).click();
        wd.findElement(By.id("search_query_top")).clear();
        wd.findElement(By.id("search_query_top")).sendKeys(searchData.getNameProduct());
        wd.findElement(By.name("submit_search")).click();
    }
}
