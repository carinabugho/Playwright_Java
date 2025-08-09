package pages;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.testng.Assert;

public class CheckoutPage {
    private Page page;

    private String itemNameLabel = "//div[@class='summary-content flex flex-col gap-5']//div[@class='flex-1 pr-3 text-sm']/p[1]";
    private String itemPriceLabel = "//div[@data-hook='order_summary']//span[@id='summary-order-total']";
    private String itemQtyLabel = "//div[@class='summary-content flex flex-col gap-5']//span[contains(@class, 'rounded-full')]";

    private String  checkoutButton = "//a[@data-cart-target='checkoutButton']";
    private String firstNameField = "//input[@id='order_ship_address_attributes_firstname']";
    private String lastNameField = "//input[@id='order_ship_address_attributes_lastname']";
    private String streetField = "//input[@id='order_ship_address_attributes_address1']";
    private String apartmentField = "//input[@id='order_ship_address_attributes_address2']";
    private String cityField = "//input[@id='order_ship_address_attributes_city']";
    private String postalField = "//input[@id='order_ship_address_attributes_zipcode']";
    private String numberField = "//input[@id='order_ship_address_attributes_phone']";
    private String saveAndContinueButton = "//div[@class='flex justify-end w-full']//button[@type='submit']";
    private String shipmentForm = "//div[@class='shipment']";
    private String cardNumField = "//div[@class='p-Input']//input[@name='number']";
    private String expiryDateField = "//div[@class='p-Input']//input[@name='expiry']";
    private String cardCVCField = "//div[@class='p-Input']//input[@name='cvc']";
    private String payNowButton = "//button[@id='checkout-payment-submit']";
    private String orderNumberLabel = "//div[@id='checkout']//p[@class='text-sm mb-1 mt-3']";
    private String thankYouUser = "//div[@id='checkout']//h4[@class='mb-4 text-green-600 font-semibold text-lg font-body']";
    private String orderCompleteLabel = "//div[@id='checkout']//h5[@class='mb-3 font-semibold pb-3 border-b font-body']";
    private String paidLabel = "//span[@class='badge-paid']";
    private String iframe = "//iframe[@title='Secure payment input frame']";




    public CheckoutPage(Page page){
        this.page = page;
    }

    public void tapCheckoutButton(){
        page.waitForSelector(checkoutButton);
        page.click(checkoutButton);
    }

    //Getting item details in Order page detail
    public String getItemNameDetail() {
        page.waitForSelector(itemNameLabel);
        return page.locator(itemNameLabel).innerText();
    }

    public String getItemQuantityDetail() {
        page.waitForSelector(itemQtyLabel);
        return page.locator(itemQtyLabel).innerText();
    }

    public String getItemPriceDetail() {
        page.waitForSelector(itemPriceLabel);
        return page.locator(itemPriceLabel).innerText();
    }


    public void enterShippingAddress(String firstName, String lastName, String street, String apt, String city, String postal) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterStreet(street);
        enterApartment(apt);
        enterCity(city);
        enterPostal(postal);
    }

    //Enter user details
    public void enterFirstName(String firstName){
        page.waitForSelector(firstNameField);
     //   page.locator(firstNameField).fill(firstName);
        page.fill(firstNameField, firstName);
    }

    public void enterLastName(String lastName){
        page.locator(lastNameField).fill(lastName);
    }

    public void enterStreet(String street){
        page.locator(streetField).fill(street);
    }

    public void enterApartment(String apartment){
        page.locator(apartmentField).fill(apartment);
    }

    public void enterCity(String city){
        page.locator(cityField).fill(city);
    }

    public void enterPostal(String postal){
        page.locator(postalField).fill(postal);
    }

    public void enterPhone(String phoneNum){
        page.locator(numberField).fill(phoneNum);
    }
    public void clickSaveAndContinue(){
        page.click(saveAndContinueButton);
    }

    public void FinalClickSaveAndContinue(){
        page.waitForSelector(shipmentForm);
        page.click(saveAndContinueButton);
    }

    // Enter Card details
    public void enterCardNun(){
         FrameLocator cardFrame = page.frameLocator(iframe);
            Locator cardField = cardFrame.locator(cardNumField);
         cardField.scrollIntoViewIfNeeded();
        cardField.fill("4242 4242 4242 4242");
    }

    public void enterExpiry(){
        FrameLocator cardFrame = page.frameLocator(iframe);
        Locator expField = cardFrame.locator(expiryDateField);
        expField.scrollIntoViewIfNeeded();
        expField.fill("11/27");


    }

    public void enterCardCVCField(){
        FrameLocator cardFrame = page.frameLocator(iframe);
        Locator ccvField = cardFrame.locator(cardCVCField);
        ccvField.scrollIntoViewIfNeeded();
        ccvField.fill("123");

    }

    public void tapPayNowButton(){
        Locator payNowBtn = page.locator(payNowButton);
        payNowBtn.scrollIntoViewIfNeeded();
        page.click(payNowButton);
    }

    // Verify order's complete
    public String getOrderNum(){
        page.waitForSelector(orderNumberLabel);
        return page.locator(orderNumberLabel).innerText();
    }

    public String getThankYouUserMessage(){
        return page.locator(thankYouUser).innerText();
    }

    public boolean isOrderCompleteMsgDisplayed(){
        return page.locator(orderCompleteLabel).isVisible();

    }

    public boolean isPaidMsgDisplayed(){
        return page.locator(paidLabel).isVisible();

    }








}
