package User;

import org.apache.commons.lang.RandomStringUtils;

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