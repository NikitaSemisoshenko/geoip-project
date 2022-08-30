package com.example.geoip.mapper;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class IpToDecimalMapper {

    private static final String IP_DELIMITER = "\\.";

    public Long toDecimal(String ip) {
        long start = System.nanoTime();
        List<Long> ipNumbers = Arrays.stream(ip.split(IP_DELIMITER)).map(Long::parseLong).toList();
        Long sum = 0L;
        int pow = 3;
        for (Long number : ipNumbers) {
            sum += (long)(number * Math.pow(256, pow));
            pow--;
        }
        long end = System.nanoTime();
        return sum;
    }
}
