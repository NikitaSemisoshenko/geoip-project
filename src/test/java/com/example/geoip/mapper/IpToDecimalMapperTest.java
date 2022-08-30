package com.example.geoip.mapper;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class IpToDecimalMapperTest {
    private final IpToDecimalMapper ipToDecimalMapper = new IpToDecimalMapper();

    @Test
    void toDecimal_normalValue_ok() {
        Long expected = 134744072L;
        Long actual = ipToDecimalMapper.toDecimal("8.8.8.8");
        assertEquals(expected, actual);
    }

    @Test
    void toDecimal_incorrectValue_notOk() {
        assertThrows(RuntimeException.class, () -> ipToDecimalMapper.toDecimal("fasdf"));
    }
}