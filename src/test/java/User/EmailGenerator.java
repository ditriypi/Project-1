package User;

import org.apache.commons.lang.RandomStringUtils;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;

public class EmailGenerator {
    int randomNumb1 = (int) (Math.random()*5);
    int randomNumb2 = (int) (Math.random()*10);
    public String getEmail() {
        ArrayList<String> domainEx = new ArrayList<>();
        Collections.addAll(domainEx,
                "@yandex.ru","mail.ru","gmail.com"
        );
        return generateEmail(domainEx.get(randomNumb1), randomNumb2);
    }


    private String generateEmail(String domain, int length) {
        return RandomStringUtils.random(length, "abcdefghijklmnopqrstuvwxyz") + "@" + domain;
    }
    }
     class PhoneGenerator{
        static int min = 1000000;
        static int max = 9999999;
       static double value = Math.random() * (max - min) + min;


        public static String rands(){
            String code = "66";
            String number =  Integer.toString((int) value);
            return  code + number;


    }

}