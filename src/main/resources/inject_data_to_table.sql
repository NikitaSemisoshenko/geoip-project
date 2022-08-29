LOAD DATA LOCAL INFILE '/ip2location.CSV'
INTO TABLE geo_ip
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\r\n'
(@start, @end, @country_code, @country_name, @region_name, @city_name, @latitude, @longitude)
set start=@start, end=@end, country_code=@country_code, country_name=@country_name, region_name=@region_name,
    city_name=@city_name, latitude=@latitude, longitude=@longitude;