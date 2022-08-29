package com.example.geoip.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class GeoIpResponseDto {
    private String canonicalIpRepresentation;
    private String cityName;
    private String countryCode;
    private String countryName;
    private String ipv4;
    private String latitude;
    private String longitude;
    private String regionName;
}
