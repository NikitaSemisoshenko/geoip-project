package com.example.geoip.controller;

import com.example.geoip.mapper.GeoIpMapper;
import com.example.geoip.mapper.IpToDecimalMapper;
import com.example.geoip.model.GeoIp;
import com.example.geoip.model.dto.GeoIpResponseDto;
import com.example.geoip.service.GeoIpService;
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
        System.out.println("Ip as number: " + ipAsDecimal);
        long start = System.nanoTime();
        GeoIp geoIp = geoIpService.findIp(ipAsDecimal);
        GeoIpResponseDto dto = geoIpMapper.toDto(geoIp, ip, ipAsDecimal);
        long end = System.nanoTime();
        System.out.println("Elapsed time to complete transaction: " + ((end - start) / 1_000_000) + "ms");
        return dto;
    }
}