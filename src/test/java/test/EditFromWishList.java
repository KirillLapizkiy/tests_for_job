package test;

import org.testng.annotations.Test;

public class EditFromWishList extends TestBase {

    @Test
    public void testEditProductInWishList() throws Exception {
        EntenInWishList();
        ChoiceFirstPositionInWishList();
        AssignedNumbers("150");
        ExitFromWishList();
        logout();
    }

}

