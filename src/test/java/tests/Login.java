package tests;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LogoutPage;
import utils.TestData;

public class Login extends BaseTest{

    @Test
    @Parameters("BaseURL")
    public void logoutUser(String baseUrl){
        LoginPage loginPage = new LoginPage(page);
        String generatedEmailAddress = TestData.generatedEmail;

        page.navigate(baseUrl);


        loginPage.clickUserIcon();
        loginPage.enterEmail(generatedEmailAddress);
        loginPage.enterPassword("qatester");
        loginPage.clickLogin();

        String actualLoginMessage = loginPage.getNotificationMessage();
        Assert.assertEquals(actualLoginMessage, "SIGNED IN SUCCESSFULLY.");
    }
}
