package com.example.geoip.repository;

import com.example.geoip.model.GeoIp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GeoIpRepository extends JpaRepository<GeoIp, Long> {
    @Query(value = "from GeoIp g where ?1 between g.start and g.end")
    GeoIp findGeoIp(Long ipAsDecimal);
}
