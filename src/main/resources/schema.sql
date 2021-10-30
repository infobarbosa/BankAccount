drop table if exists tbl_customers;

create table tbl_customers(
    id      int auto_increment primary key,
    name    varchar(100) not null
);

drop table if exists tbl_accounts;

create table tbl_accounts(
    id              int auto_increment primary key,
    customer_id     int,
    name            varchar(100),
    balance         float
)
