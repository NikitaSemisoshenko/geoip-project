CREATE TABLE `geo_ip` (
                          `id` bigint NOT NULL AUTO_INCREMENT,
                          `start` bigint DEFAULT NULL,
                          `end` bigint DEFAULT NULL,
                          `country_code` varchar(255) DEFAULT NULL,
                          `country_name` varchar(255) DEFAULT NULL,
                          `region_name` varchar(255) DEFAULT NULL,
                          `city_name` varchar(255) DEFAULT NULL,
                          `latitude` varchar(255) DEFAULT NULL,
                          `longitude` varchar(255) DEFAULT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3080146 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOAD DATA LOCAL INFILE 'ABSOLUTE_PATH_TO_FILE_ip2location.csv'
INTO TABLE geo_ip
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
(@start, @end, @country_code, @country_name, @region_name, @city_name, @latitude, @longitude)
set start=@start, end=@end, country_code=@country_code, country_name=@country_name, region_name=@region_name, city_name=@city_name, latitude=@latitude, longitude=@longitude
