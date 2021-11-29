create database website_sales;
use website_sales;

create table user
(
	id int primary key auto_increment,
    fullname nvarchar(255),
    username nvarchar(255),
    password nvarchar(255),
    phone_number nvarchar(15),
    email nvarchar(255),
    address nvarchar(255),
    role int default 0,
    status int default 0
);

create table product
(
	id int primary key auto_increment,
    product_name nvarchar(255),
    quantity int,
    price bigint,
    describe_product nvarchar(2000),
    image nvarchar(255),
    status int default 0
);

create table comment
(
	id int primary key auto_increment,
    write_date date,
    modify_date date,
    content nvarchar(2000),
    user_id int,
    product_id int,
    status int default 0,
    foreign key(user_id) references User(id),
    foreign key(product_id) references product(id)
);

create table Supplier 
(
	id int primary key auto_increment,
    name_supplier nvarchar(255),
    phone_number nvarchar(15),
    address nvarchar(255),
    status int default 0
);

create table Goods_received_note
(
	id int primary key auto_increment,
    date_goods_received date,
    note nvarchar(2000),
    supplier_id int,
    foreign key(supplier_id) references Supplier(id),
    status int default 0
);

create table Goods_received_detail
(
	note_id int,
    product_id int,
    quantity int,
    primary key(note_id,pro_id),
    foreign key(note_id) references Goods_received_note(id),
    foreign key(product_id) references product(id)
);

create table brand
(
	id int primary key auto_increment,
    brand_name nvarchar(255),
    image nvarchar(255),
	status int default 0
);
alter table product add foreign key(brand_id) references brand(id);

create table category
(
	id int primary key auto_increment,
    cate_name nvarchar(255),
    image nvarchar(255),
	status int default 0
);

create table detail_category
(
	id int primary key auto_increment,
    detail_cate_name nvarchar(255),
    image nvarchar(255),
	status int default 0,
    cate_id int,
    foreign key (cate_id) references category(id)
);

alter table product add detail_cate_id int references Detail_category(id);

create table cart
(
	id int primary key auto_increment,
	total_price bigint,
    customer_id int,
    shipper_id int,
    employee_id int,
	status int default 0,
    foreign key(customer_id) references user(id),
	foreign key(shipper_id) references user(id),
    foreign key(employee_id) references user(id)
);

create table cart_item
(
	pro_id int,
    cart_id int,
    unit_price bigint,
    quantity int,
    primary key(pro_id,cart_id),
    foreign key(pro_id) references product(id),
    foreign key(cart_id) references cart(id)
)


