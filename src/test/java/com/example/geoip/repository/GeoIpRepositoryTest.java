package com.example.geoip.repository;

import com.example.geoip.model.GeoIp;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GeoIpRepositoryTest {

    @Autowired
    private GeoIpRepository geoIpRepository;

    @Test
    void findGeoIp() {
        GeoIp expected = new GeoIp();
        expected.setId(81875L);
        expected.setStart(134744064L);
        expected.setEnd(134744319L);
        expected.setCountryCode("US");
        expected.setCountryName("United States of America");
        expected.setRegionName("California");
        expected.setCityName("Mountain View");
        expected.setLatitude("37.405992");
        expected.setLongitude("-122.078515");
        GeoIp actual = geoIpRepository.findGeoIp(134744072L);
        assertEquals(expected, actual);
    }
}