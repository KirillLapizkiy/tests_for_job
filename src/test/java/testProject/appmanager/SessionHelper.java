package testProject.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void login(String username, String password) {
        click(By.linkText("Sign in"));
        type(By.id("email"), username);
        click(By.xpath("//form[@id='login_form']/div/div"));
        type(By.id("passwd"), password);
        click(By.xpath("//button[@id='SubmitLogin']/span"));
    }
}
