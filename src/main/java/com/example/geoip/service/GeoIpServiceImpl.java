package com.example.geoip.service;

import com.example.geoip.model.GeoIp;
import com.example.geoip.repository.GeoIpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GeoIpServiceImpl implements GeoIpService {
    private final GeoIpRepository geoIpRepository;

    @Override
    public GeoIp findIp(Long ipAsDecimal) {
        return geoIpRepository.findGeoIpByStartIsLessThanEqualAndEndIsGreaterThanEqual(
                ipAsDecimal,
                ipAsDecimal);
    }
}
