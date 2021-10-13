create databases shopdb;

create user 'shop_user'@'localhost' identified by 'Shop123';
grant all privileges shopdb.* to 'shop_user'@'localhost';
flush privileges