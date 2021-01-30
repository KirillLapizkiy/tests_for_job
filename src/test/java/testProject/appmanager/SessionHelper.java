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

//        wd.findElement(By.linkText("Sign in")).click();

//        wd.findElement(By.id("email")).click();
//        wd.findElement(By.id("email")).clear();
//        wd.findElement(By.id("email")).sendKeys(username);

//        wd.findElement(By.xpath("//form[@id='login_form']/div/div")).click();

//        wd.findElement(By.id("passwd")).click();
//        wd.findElement(By.id("passwd")).clear();
//        wd.findElement(By.id("passwd")).sendKeys(password);

//        wd.findElement(By.xpath("//button[@id='SubmitLogin']/span")).click();
    }
}
