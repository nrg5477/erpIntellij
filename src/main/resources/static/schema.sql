create table product(
	product_no number(10) primary key,
	product_name varchar2(100),
	info varchar2(100),
	price number(10),
	image varchar2(100),
	stock number(10),
	insertTime DATE,
	category number(10)
);