package pages;

import com.microsoft.playwright.Page;

public class LogoutPage {

    private Page page;

    private String userIcon = "//div[@class='page-container']//a[@href='/account']";
    private String logoutButton = "//button[contains(text(),'Log out')]";
    private String notificationMessage = "//div[@id='flashes']//p";

    public LogoutPage(Page page) {
        this.page = page;
    }



    public void clickUserIconHomepage(){
        page.click(userIcon);

    }

    public void clickLogout(){
        page.click(logoutButton);
    }
    public String getNotificationMessage() {
        return page.locator(notificationMessage).innerText();
    }

}
