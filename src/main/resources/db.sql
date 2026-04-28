create table product_test2
(
    p_no    number(3) primary key,
    p_name  varchar2(30 char) not null,
    p_price number(5) not null
);
create sequence product_test2_seq;

insert into product_test2
values (product_test2_seq.nextval, 'test1', 1000);
insert into product_test2
values (product_test2_seq.nextval, 'test2', 2000);
insert into product_test2
values (product_test2_seq.nextval, 'test3', 3000);

select * from product_test2;

create table review_test2
(
    r_no    number(3) primary key,
    r_title  varchar2(30 char) not null,
    r_txt varchar2(100 char) not null,
    r_date date not null
);
create sequence review_test2_seq;

insert into review_test2
values (review_test2_seq.nextval, 'test1', 'test1', sysdate);

select * from review_test2;
