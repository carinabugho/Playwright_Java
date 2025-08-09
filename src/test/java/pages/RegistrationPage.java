package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;


public class RegistrationPage {
    private Page page;

    //Locators
    private String emailField = "//form[@id='new_user']//input[@type='email']";
    private String passwordField = "//form[@id='new_user']//input[@id='user_password']";
    private String confirmPassField = "//form[@id='new_user']//input[@id='user_password_confirmation']";
    private String signUpButton = "//form[@id='new_user']//input[@type='submit']";
    private String userIcon = "//div[@class='page-container']//button[contains(@data-action,'slideover-account')]";
    private String signUpLink = "//a[@href='/user/sign_up']";
    private String notificationMessage = "//div[@id='flashes']//p";


    public RegistrationPage(Page page) {
        this.page = page;
    }

    public void clickUserIcon(){
        page.click(userIcon);
    }

    public void clickSignUpLink(){
        page.click(signUpLink);
    }

    // Actions
    public void enterEmail(String email) {
        page.fill(emailField, email);
    }

    public void enterPassword(String password) {
        page.fill(passwordField, password);
    }

    public void enterConfirmPass(String password) {
        page.fill(confirmPassField, password);
    }

    public void clickSignUpButton() {
        page.click(signUpButton);
    }

    public String getNotificationMessage() {
        page.waitForSelector(notificationMessage);
        return page.locator(notificationMessage).innerText();
    }

}
