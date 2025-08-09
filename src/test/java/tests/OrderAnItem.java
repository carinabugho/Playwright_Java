package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AddItem;
import pages.CheckoutPage;
import utils.TestData;

public class OrderAnItem extends BaseTest{


    private String baseUrl;

    @BeforeClass
    @Parameters("BaseURL")
    public void setBaseUrl(String baseUrl){
        this.baseUrl = baseUrl;
    }
    @Test(dataProvider = "orderData", dataProviderClass = TestData.class)
    public void OrderAnItemE2E(String product, String firstName, String lastName, String street, String apt, String city, String postal) throws InterruptedException {
        CheckoutPage checkoutPage = new CheckoutPage(page);
        AddItem addItem = new AddItem(page);
        page.navigate(baseUrl);

        addItem.searchAnItem(product);
        addItem.clickAnIItem();

        String itemName = addItem.getItemName();
        System.out.println("Item name: " + itemName);
        String itemPrice = addItem.getItemPrice();
        System.out.println("Item price: " + itemPrice);
        String itemQty = addItem.getItemQuantity();
        System.out.println("Item qty: " + itemQty);

        addItem.chooseSize();

        Assert.assertTrue(addItem.isCartDisplayed());


       // Checkout page
        checkoutPage.tapCheckoutButton();
        String finalItemName = checkoutPage.getItemNameDetail();
        String finalQtyCount = checkoutPage.getItemQuantityDetail();
        String finalItemPrice = checkoutPage.getItemPriceDetail();

        Assert.assertEquals(itemName.toUpperCase(), finalItemName.toUpperCase());
        System.out.println("Name+ " + itemName+ itemName);
        Assert.assertEquals(itemQty, finalQtyCount);
        System.out.println("QTY+ " +itemQty+ finalQtyCount);
        Assert.assertEquals(itemPrice, finalItemPrice);
        System.out.println("Price+ " +itemQty+ finalQtyCount);

        // Enter user details
        checkoutPage.enterShippingAddress(firstName, lastName, street, apt, city, postal);
        checkoutPage.clickSaveAndContinue();
        checkoutPage.FinalClickSaveAndContinue();

        //Card number details
        checkoutPage.enterCardNun();
        checkoutPage.enterExpiry();
        checkoutPage.enterCardCVCField();
        checkoutPage.tapPayNowButton();

        //Successful checkout order details
        String orderNumber = checkoutPage.getOrderNum();
        String thankYouMsg = checkoutPage.getThankYouUserMessage();

        //Report details
        System.out.println("Order number: "+ orderNumber);
        assertContains(thankYouMsg, firstName);
        checkoutPage.isOrderCompleteMsgDisplayed();
        checkoutPage.isPaidMsgDisplayed();
        assertContains(thankYouMsg, firstName);

    }


}
