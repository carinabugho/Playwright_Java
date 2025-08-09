package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import utils.TestData;


public class RegisterNewUser extends BaseTest {

    @Test
    @Parameters("BaseURL")
    public void registerUser(String baseUrl) throws InterruptedException {
        RegistrationPage regPage = new RegistrationPage(page);

        String password = "qatester";

        TestData.generatedEmail = TestData.generateRandomEmail();
        String generatedEmailAddress = TestData.generatedEmail;
        System.out.println("[INFO] Generated Email: "+ generatedEmailAddress );


        System.out.println(page.title());
        page.navigate(baseUrl);
        regPage.clickUserIcon();
        regPage.clickSignUpLink();
        regPage.enterEmail(generatedEmailAddress);
        regPage.enterPassword(password);
        regPage.enterConfirmPass(password);
        regPage.clickSignUpButton();
        String actualMessage = regPage.getNotificationMessage();


        Assert.assertEquals(actualMessage, "WELCOME! YOU HAVE SIGNED UP SUCCESSFULLY.");
        System.out.println("Email generated: " + generatedEmailAddress );

    }




}
