package pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    private Page page;

    private String loginForm = "//form[@action='/user/sign_in']";
    private String emailField = "//form[@id='new_user']//input[@type='email']";
    private String passwordField = "//form[@id='new_user']//input[@id='user_password']";
    private String loginButton = "//input[@id='login-button']";
    private String userIcon = "//div[@class='page-container']//button[contains(@data-action,'slideover-account')]";
    private String notificationMessage = "//div[@id='flashes']//p";

    public LoginPage(Page page) {
        this.page = page;
    }

    public void clickUserIcon(){
        page.click(userIcon);
    }

    public void enterEmail(String email){
        page.waitForSelector(loginForm);
        page.locator(emailField).fill(email);
    }

    public void enterPassword(String password){
        page.locator(passwordField).fill(password);
    }

    public void clickLogin(){
        page.click(loginButton);
    }
    public String getNotificationMessage() {
        return page.locator(notificationMessage).innerText();
    }

}
