package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LogoutPage;

public class Logout extends BaseTest{

    @Test
    @Parameters("BaseURL")
    public void logoutUser(String baseUrl){
        LogoutPage logoutPage = new LogoutPage(page);

        page.navigate(baseUrl);

        logoutPage.clickUserIconHomepage();
        logoutPage.clickLogout();
        String actualLogoutMessage = logoutPage.getNotificationMessage();
        Assert.assertEquals(actualLogoutMessage, "SIGNED OUT SUCCESSFULLY.");
    }





}
