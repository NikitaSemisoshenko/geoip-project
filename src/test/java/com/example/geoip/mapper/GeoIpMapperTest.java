package com.example.geoip.mapper;

import com.example.geoip.model.GeoIp;
import com.example.geoip.model.dto.GeoIpResponseDto;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class GeoIpMapperTest {

    private final GeoIpMapper geoIpMapper = new GeoIpMapper();

    @Test
    void toDto_normalValue_ok() {
        GeoIp geoIp = new GeoIp();
        geoIp.setId(81875L);
        geoIp.setStart(134744064L);
        geoIp.setEnd(134744319L);
        geoIp.setCountryCode("US");
        geoIp.setCountryName("United States of America");
        geoIp.setRegionName("California");
        geoIp.setCityName("Mountain View");
        geoIp.setLatitude("37.405992");
        geoIp.setLongitude("-122.078515");
        String ip = "8.8.8.8";
        Long ipAsDecimal = 134744072L;

        GeoIpResponseDto expected = new GeoIpResponseDto();
        expected.setIpv4(String.valueOf(ipAsDecimal));
        expected.setCanonicalIpRepresentation(ip);
        expected.setLatitude(geoIp.getLatitude());
        expected.setLongitude(geoIp.getLongitude());
        expected.setCountryCode(geoIp.getCountryCode());
        expected.setRegionName(geoIp.getRegionName());
        expected.setCountryName(geoIp.getCountryName());
        expected.setCityName(geoIp.getCityName());

        assertEquals(expected, geoIpMapper.toDto(geoIp, ip, ipAsDecimal));
    }
}