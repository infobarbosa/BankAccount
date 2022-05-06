drop table if exists tbl_customers;

create table tbl_customers(
    id      int auto_increment primary key,
    name    varchar(100) not null
);

drop table if exists tbl_accounts;

create table tbl_accounts(
    id                      int auto_increment primary key,
    customer_id             int not null,
    account_description     varchar(100) not null,
    account_balance         float not null,
    account_status          varchar(100) not null
);

create table tbl_transactions(
    id                  int auto_increment primary key,
    debit_account_id    int,
    credit_account_id   int,
    amount              float not null,
    transaction_date    timestamp not null,
    transaction_type    varchar(100) not null
);

create table tbl_ledger(
    id              int auto_increment primary key,
    account_id      int,
    entry_amount    float,
    entry_date      timestamp,
    entry_type      varchar(100)
);
