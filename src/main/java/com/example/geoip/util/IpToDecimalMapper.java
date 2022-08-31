package com.example.geoip.util;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

@Component
public class IpToDecimalMapper {
    private static final String IP_DELIMITER = "\\.";

    private static final Long MAXIMUM_DECIMAL_IP = getDecimal("255.255.255.255");

    public Long toDecimal(String ip) {
        String pattern = "\\d+\\.\\d+\\.\\d+\\.\\d+";
        if (!Pattern.matches(pattern, ip) || ip == null) {
            throw new RuntimeException("Incorrect ip");
        }
        Long sum = getDecimal(ip);
        if (sum > MAXIMUM_DECIMAL_IP) {
            throw new RuntimeException("This ip is out of range");
        }
        return sum;
    }

    private static Long getDecimal(String ip) {
        List<Long> ipNumbers = Arrays.stream(ip.split(IP_DELIMITER)).map(Long::parseLong).toList();
        Long sum = 0L;
        int pow = 3;
        for (Long number : ipNumbers) {
            sum += (long)(number * Math.pow(256, pow));
            pow--;
        }
        return sum;
    }
}
