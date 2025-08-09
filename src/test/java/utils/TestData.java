package utils;

import java.util.UUID;

public class TestData {

    public static String generatedEmail;

    public  static String generateRandomEmail(){
        return UUID.randomUUID().toString().replace("-","").substring(0,5) + "@test.com";
    }


}
