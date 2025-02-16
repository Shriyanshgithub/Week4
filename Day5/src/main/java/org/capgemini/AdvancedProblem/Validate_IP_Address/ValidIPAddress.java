package org.capgemini.AdvancedProblem.Validate_IP_Address;

import java.util.Arrays;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidIPAddress {
    public static void main(String[] args) {
        //regex of IpV4
        String regex = "^(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9})"
                + "\\.(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9})"
                + "\\.(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9})"
                + "\\.(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9})$";
        //List of different ip address
        List<String> ip = Arrays.asList("192.3.5.23","192.168.1.1" ,"123.34.44" );

        //method call to validate ip address
        validateIPAddress(regex , ip);
    }
    public static void validateIPAddress(String regex , List<String> ip){
        // compile regex
        Pattern pattern = Pattern.compile(regex);
        for(String ips : ip){
            Matcher matcher = pattern.matcher(ips);
            if(matcher.matches()) {
                System.out.println("Matched : " + matcher.group());
            }
        }

    }
}
