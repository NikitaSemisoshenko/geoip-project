create table geo_ip (
                        `id` bigint not null auto_increment,
                        `start` bigint,
                        `end` bigint,
                        `country_code` varchar(255),
                        `country_name` varchar(255),
                        `region_name` varchar(255),
                        `city_name` varchar(255),
                        `latitude` varchar(255),
                        `longitude` varchar(255),
                        primary key (`id`)
);
