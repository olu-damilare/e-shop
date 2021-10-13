set foreign_key_checks = 0;
truncate table product;
truncate table feedback;


insert into product (`id`, `name`, `price`,`details`,`currency`)
values(110,'luxury chair', 4500, 'Soap for bath','FRC'),
      (111,'luxury sofa', 4000, 'Soap for bath','USD'),
      (112,'luxury bench', 6500, 'Soap for bath','NGN'),
      (113,'luxury table', 4500, 'Soap for bath','NGN');
set foreign_key_checks = 1;