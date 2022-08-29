package com.example.geoip.mapper;

import com.example.geoip.model.GeoIp;
import com.example.geoip.model.dto.GeoIpResponseDto;
import org.springframework.stereotype.Component;

@Component
public class GeoIpMapper {
    public GeoIpResponseDto toDto(GeoIp geoIp, String ip, Long ipAsDecimal) {
        GeoIpResponseDto dto = new GeoIpResponseDto();
        dto.setLatitude(geoIp.getLatitude());
        dto.setCityName(geoIp.getCityName());
        dto.setLongitude(geoIp.getLongitude());
        dto.setCountryName(geoIp.getCountryName());
        dto.setCountryCode(geoIp.getCountryCode());
        dto.setRegionName(geoIp.getRegionName());
        dto.setIpv4(String.valueOf(ipAsDecimal));
        dto.setCanonicalIpRepresentation(ip);
        return dto;
    }
}
