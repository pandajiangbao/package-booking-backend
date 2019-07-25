CREATE TABLE package
(
    ID int not null auto_increment,
    receiver varchar(255) ,
    order_number varchar(255) ,
    phone_number varchar(255) ,
    PRIMARY key (ID)
);
CREATE TABLE package_order
(
    ID int not null auto_increment,
    receiver varchar(255) ,
    order_number varchar(255) ,
    phone_number varchar(255) ,
    status varchar(255) ,
    weight double,
    booking_time TIMESTAMP,
    PRIMARY key (ID)
);


