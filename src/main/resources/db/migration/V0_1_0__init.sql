CREATE TABLE BRAND (
    id bigint not null,
    description varchar(255) not null,
    PRIMARY KEY (id)
);

CREATE TABLE PRODUCT (
    id bigint not null,
    description varchar(255) not null,
    PRIMARY KEY (id)
);

CREATE TABLE PRICES (
    id bigint not null,
    brand_id bigint not null,
    start_date timestamp not null,
    end_date timestamp not null,
    price_list numeric not null,
    product_id bigint not null,
    priority numeric not null,
    price decimal(19, 2) not null,
    curr varchar(3) not null,
    PRIMARY KEY (id),
    FOREIGN KEY (brand_id) REFERENCES BRAND(id),
    FOREIGN KEY (product_id) REFERENCES PRODUCT(id)
);

CREATE SEQUENCE IF NOT EXISTS prices_seq MINVALUE 1;