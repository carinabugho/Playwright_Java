package tests;

import com.microsoft.playwright.*;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Browser;
import org.testng.Assert;
import org.testng.annotations.*;

public class BaseTest {

    public static Playwright playwright;
    public static Browser browser;
    public static Page page;


    @BeforeSuite
    public void setup(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setSlowMo(1000));
      //  page = browser.newPage();

       BrowserContext context = browser.newContext();
        page = context.newPage();
    //    page.navigate(baseUrl);
    }


    @AfterSuite
    public void teardown(){
        if (browser != null) browser.close();
        if (playwright !=null) playwright.close();
    }

    public void assertContains(String actual, String expectedSubstring) {
        Assert.assertTrue(
                actual.contains(expectedSubstring),
                "Expected '" + actual + "' to contain '" + expectedSubstring + "'"
        );
    }



}


