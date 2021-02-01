package testProject.tests;

import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import testProject.appmanager.ApplicationManager;

public class TestBase {
    @Description("Выбор браузера для запуска автотестов осуществляется подстановкой в BrowserType.XXX" +
            "Вебдрайверы IE и firefox лежат в репе, знаю, что это не канонично," +
            "сделал так, что бы их не искали в интернете при проверке тестового")
    protected final ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        app.init();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }

}
