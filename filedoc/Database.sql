create database shopquanao;
use shopquanao;

create table roles (
    id varchar(10) not null primary key,
    roleName nvarchar(50) not null
);

create table users (
    id int auto_increment primary key,
    fullName nvarchar(50) not null,
    phone varchar(10) not null,
    email varchar(50) not null,
    password varchar(10) not null,
    status smallint not null check(status in (0,1,2)), -- 0 là bị vô hiệu hóa , 1 là đã xác thực, 2 là chưa xác thực
    role varchar(10) not null,
    foreign key (role)
        references roles (id)
);

create table categories (
    id varchar(10) not null primary key,
    categoryName nvarchar(50) not null check(categoryName in ('Áo', 'Quần', 'Áo khoác', 'Đầm', 'Váy'))
);

create table category_details (
    id varchar(10) not null primary key,
    category varchar(10) not null,
    type nvarchar(50) not null,
    foreign key (category)
        references categories (id)
);

create table sizes (
    id varchar(10) not null primary key,
    size varchar(5) not null check (size in ('S','M','L'))
);

create table colors (
    id varchar(10) not null primary key,
    color nvarchar(20) not null
);

create table suppliers (
    id varchar(10) not null primary key,
    name nvarchar(50) not null,
    address nvarchar(255) not null,
    phone varchar(10) not null
);


create table discount_codes(
	id varchar(10) not null primary key,
    code varchar(50) not null,
    percentageOff float not null,
    dateStart date not null,
    dateEnd date not null
);

create table products (
    id varchar(10) not null primary key,
    name nvarchar(50) not null,
    discountCode varchar(10),
    price int not null  check(price >0),
    category varchar(10) not null,
    details text not null,
    color varchar(10) not null,
    size varchar(10) not null,
    suppliers varchar(10) not null,
    quantity int not null check(quantity >=0),
	status smallint not null check(status = 0 or status =1), -- 0 là bị vô hiệu, 1 là sản phẩm đang được bán
    importDate date not null,
    foreign key (category)
        references category_details (id),
	foreign key (discountCode)
        references discount_codes (id),
	foreign key (color)
        references colors (id),
    foreign key (size)
        references sizes (id),
    foreign key (suppliers)
        references suppliers (id)
);
create table carts(
	id int not null primary key,
	user int not null,
	foreign key (user)
        references users (id)
);

create table cart_details(
	id varchar(10) not null primary key,
    	cart int not null,
	product varchar(20) not null,
    	quantity int not null check (quantity >0),
	foreign key (product)
        references products (id),
	foreign key (cart)
        references carts (id)
);

create table bills (
    id varchar(10) not null primary key,
    userName nvarchar(50) not null,
    userPhone varchar(10) not null,
    userAddress nvarchar(255) not null,
    dateCreated date not null,
    note text,
    user int not null,
    statusPayment nvarchar(50) not null check (statusPayment in ('Đã thanh toán','Chưa thanh toán')),
    statusOrder nvarchar(50) not null check (statusOrder in ('Đang chuẩn bị hàng','Đang giao hàng','Giao hàng thành công')),
    paymentMethod nvarchar(100) not null check (paymentMethod in ("Thanh toán khi nhận hàng","Thanh toán Momo","Thanh toán ZaloPay","Chuyển khoản")),
    foreign key (user)
        references users (id)
);

create table bill_details (
    id varchar(10) not null primary key,
    bill varchar(20) not null,
    product varchar(20) not null,
    quantity int not null check (quantity >0),
    foreign key (bill)
        references bills (id),
    foreign key (product)
        references products (id)
);

create table images(
id varchar(10) not null primary key,
product varchar(10) not null,
link nvarchar(255) not null,
foreign key (product)
references products (id)
);


create table product_reviews(
bill varchar(10) not null,
comment text not null,
stars float not null check (stars between 1 and 5),
foreign key (bill)
        references bills (id)
);
