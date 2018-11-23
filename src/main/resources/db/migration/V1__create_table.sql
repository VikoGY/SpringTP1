CREATE TABLE seller(
id identity,
name varchar(255),
address varchar(255),
zipcode varchar(255),
city varchar(255)
);


CREATE TABLE product(
id identity,
name varchar(255),
description varchar(255),
image_url varchar(255),
price double(2),
created_on date,
seller_id bigint
);
