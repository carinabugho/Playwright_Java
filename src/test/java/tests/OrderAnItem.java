package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AddItem;
import pages.CheckoutPage;
import pages.LoginPage;

public class OrderAnItem extends BaseTest{

    @Test
    @Parameters("BaseURL")
    public void addAnItem(String baseUrl) throws InterruptedException {
        CheckoutPage checkoutPage = new CheckoutPage(page);
        AddItem addItem = new AddItem(page);

        String firstName = "John";
        page.navigate(baseUrl);

        addItem.searchAnItem("SHIRT");
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
        checkoutPage.enterFirstName(firstName);
        checkoutPage.enterLastName("Doe");
        checkoutPage.enterStreet("1 Santa Claus Lane");
        checkoutPage.enterApartment("Apartment");
        checkoutPage.enterCity("Apartment");
        checkoutPage.enterCity("North Pole");
        checkoutPage.enterPostal("88888");

        checkoutPage.clickSaveAndContinue();
        checkoutPage.FinalClickSaveAndContinue();

        checkoutPage.enterCardNun();
        checkoutPage.enterExpiry();
        checkoutPage.enterCardCVCField();

        checkoutPage.tapPayNowButton();

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
