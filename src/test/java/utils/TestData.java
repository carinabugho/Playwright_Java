package utils;

import org.testng.annotations.DataProvider;

import java.util.UUID;

public class TestData {

    public static String generatedEmail;

    public  static String generateRandomEmail(){
        return UUID.randomUUID().toString().replace("-","").substring(0,5) + "@test.com";
    }

    @DataProvider(name = "orderData")
    public Object[][] orderData() {
        return new Object[][] {
                {"SHIRT", "John", "Doe", "1 Santa Claus Lane", "Apartment", "North Pole", "88888"}
        };
    }


}
