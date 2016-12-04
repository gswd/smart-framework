package org.smart4j.framework.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lihao on 2016-11-29.
 */
public class TestRegex {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("(?<=\\d){3}\\d", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("123456789");
        boolean didMatch = matcher.matches();
//        System.out.println("matcher.find() = " + matcher.find());

        System.out.println("didMatch = " + didMatch);
//        System.out.println("matcher.lookingAt() = " + matcher.lookingAt());
        int count = 0;
        while (matcher.find()){
            System.out.println("count = " + ++count);
            System.out.println("matcher.start() = " + matcher.start());
            System.out.println("matcher.end() = " + matcher.end());

        }



    }
}
