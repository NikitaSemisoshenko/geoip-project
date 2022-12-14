package com.example.geoip.repository;

import com.example.geoip.model.GeoIp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeoIpRepository extends JpaRepository<GeoIp, Long> {
    GeoIp findGeoIpByStartIsLessThanEqualAndEndIsGreaterThanEqual(Long ipAsDecimal, Long ipRepeat);
}
