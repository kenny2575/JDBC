create schema JDBC;

use JDBC;

create table Customers
(
    id           int primary key auto_increment,
    name         varchar(25),
    surname      varchar(25),
    age          int check ( age between 0 and 150),
    phone_number char(17)
);

create table Orders
(
    id           int primary key auto_increment,
    date         DATE,
    customer_id  int,
    foreign key (customer_id) references Customers (id),
    product_name varchar(40) NOT NULL,
    amount       int check ( amount > 0 )
);
