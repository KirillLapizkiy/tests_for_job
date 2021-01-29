package testProject.tests;

import org.testng.annotations.Test;

public class EditFromWishList extends TestBase {

    @Test
    public void testEditProductInWishList() throws Exception {
        app.EntenInWishList();
        app.ChoiceFirstPositionInWishList();
        app.AssignedNumbers("150");
        app.ExitFromWishList();
        app.logout();
    }

}

