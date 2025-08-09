package pages;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;

import java.util.List;

public class AddItem {

    private Page page;

    private String searchButton = "//span[contains(text(),'Search')]";
    private String searchField = "//div[@data-controller='search-suggestions']//form[@action='/search']//input" ;

    private String firstItem = "//div[@class='page-container']/div[@id='products']/div[1]";
    private String firsItemCarousel = "//div[@id='search-suggestions-content']//div[contains(@id, 'swiper-wrapper')]//div[contains(@class, 'swiper-slide')][1]";

    private String itemNameLabel = "//div[@data-product-form-target='productDetails']//h1";
    private String itemPriceLabel = "//div[@data-product-form-target='productDetails']//span[contains(text(), 'Regular price')]/following-sibling::p";
    private String itemSalePriceLabel = "//div[@data-product-form-target='productDetails']//span[contains(text(), 'Regular price')]/following-sibling::p[@class='inline text-danger']";
    private String itemQuantityLabel = "//input[@id='quantity']";


    private String chooseSizeButton = "//button[@type='button']/legend[contains(text() ,  'Please choose Size')]";
    private String sizeDropdown = "//div[@id='product-variant-picker']//div[@data-dropdown-target='menu']//label";

    private String unavailableSize = "//div[@id='product-variant-picker']//div[@data-dropdown-target='menu']//label[contains(@class,'not-allowed')]";
    private String addToCartButton = "//div[@data-sticky-button-target='stickyButton']//button[contains(@class, 'add-to-cart-button')]";
    private String cartFrame = "//div[contains(@class,'cart-summary-container')]";




    public AddItem(Page page){
      this.page = page;
    }

    public void searchAnItem(String itemName){
        page.click(searchButton);
        page.waitForSelector(searchField).click();
        page.fill(searchField, itemName);
    }

    public void clickAnIItem(){
        page.waitForSelector(firsItemCarousel);
        page.click(firsItemCarousel);
    }

    public String getItemName(){
        page.waitForSelector(itemNameLabel);
        return page.locator(itemNameLabel).innerText();
    }

    public String getItemPrice(){
        if(page.locator(itemSalePriceLabel).isVisible()){
            return page.locator(itemSalePriceLabel).innerText();
        }else{
            page.waitForSelector(itemPriceLabel);
            return page.locator(itemPriceLabel).innerText();
        }
    }

    public String getItemQuantity(){
        page.waitForSelector(itemQuantityLabel);
        return page.locator(itemQuantityLabel).getAttribute("value");
    }

    public boolean isSizeButtonDisplayed(){
        return page.waitForSelector(chooseSizeButton).isVisible();

    }

    public boolean isCartDisplayed(){
        page.waitForSelector(cartFrame);
        return page.locator(cartFrame).isVisible();

    }

    private String listSizes = sizeDropdown;
    public void chooseSize() throws InterruptedException {

        if(isSizeButtonDisplayed()){
           Thread.sleep(2000);
            page.click(chooseSizeButton);
            page.waitForSelector(listSizes);
            List<ElementHandle> items = page.querySelectorAll(listSizes);
            System.out.println("Total count of sizes: " + items.size());
            for (ElementHandle item : items){
                String classAttr = item.getAttribute("class");
                System.out.println("elements "+ classAttr);
                if (!classAttr.contains("not-allowed")){

                    item.click();
                    System.out.println("Size chosen: "+ item);
                    page.click(addToCartButton);
                    break;
                }
            }
        }else {
            page.click(addToCartButton);
        }

    }
}
