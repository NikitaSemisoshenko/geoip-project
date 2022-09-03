package com.example.geoip.controller;

import com.example.geoip.mapper.GeoIpMapper;
import com.example.geoip.model.GeoIp;
import com.example.geoip.model.dto.GeoIpResponseDto;
import com.example.geoip.service.GeoIpService;
import com.example.geoip.util.IpToDecimalMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/geoip")
public class GeoIpController {
    private final GeoIpService geoIpService;
    private final IpToDecimalMapper ipToDecimalMapper;
    private final GeoIpMapper geoIpMapper;

    @GetMapping("/{ip}")
    public GeoIpResponseDto findByIp(@PathVariable String ip) {
        Long ipAsDecimal = ipToDecimalMapper.toDecimal(ip);
        GeoIp geoIp = geoIpService.findIp(ipAsDecimal);
        return geoIpMapper.toDto(geoIp, ip, ipAsDecimal);
    }
}
