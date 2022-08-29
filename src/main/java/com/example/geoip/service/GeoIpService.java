package com.example.geoip.service;

import com.example.geoip.model.GeoIp;

public interface GeoIpService {
    GeoIp findIp(Long ipAsDecimal);
}
