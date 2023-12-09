insert into users (id, active, email, first_name, last_name, password)
values
    (1, 1, 'admin@example.com', 'Admin', 'Adminov', '95c1933b8ffe84f085f2839899d1673260be58dbd9c2c787ac35515805502c996417596dae9a92880aaa50a046fc7151'),
    (2, 1, 'user@example.com', 'Some', 'User', '95c1933b8ffe84f085f2839899d1673260be58dbd9c2c787ac35515805502c996417596dae9a92880aaa50a046fc7151'),
    (3, 1, 'tsvettanov18@icloiud.com', 'Tsvetan', 'Tsvetanov', '95c1933b8ffe84f085f2839899d1673260be58dbd9c2c787ac35515805502c996417596dae9a92880aaa50a046fc7151');

insert into roles (id, role)
values
    (1, 'ADMIN'),
    (2, 'USER');

insert into users_roles(user_id, role_id)
values
    (1, 1),
    (1, 2),
    (2, 2);

insert into authors (id, name)
values
    (1, 'Ivan Vazov'),
    (2, 'Aleko Konstantinov'),
    (3, 'Iordan Iovkov');

--insert into `models` (`id`, `category`, `brand_id`, `name`)
--VALUES
--    (1, 'CAR', 1, 'Camry'),
--    (2, 'CAR', 1, 'Corolla'),
--    (3, 'CAR', 2, 'Focus'),
--    (4, 'CAR', 2, 'Fiesta'),
--    (5, 'CAR', 3, '601');
--
--insert into `offers` (`id`, `description`, `engine`, `image_url`, `mileage`, `price`, `transmission`, `uuid`, `year`, `model_id`, `seller_id`)
--VALUES
--    (1, 'Top Trabi 1!', 'PETROL', 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/b8/AWZ_Trabant_601S%2C_Verkehrszentrum_des_Deutschen_Museums.JPG/1200px-AWZ_Trabant_601S%2C_Verkehrszentrum_des_Deutschen_Museums.JPG', 24000, 2223, 'MANUAL', 'b72e6550-e365-43bf-aab2-b57cafc2db7c', 1985, 5, 1),
--    (2, 'Top Trabi 1!', 'PETROL', 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/b8/AWZ_Trabant_601S%2C_Verkehrszentrum_des_Deutschen_Museums.JPG/1200px-AWZ_Trabant_601S%2C_Verkehrszentrum_des_Deutschen_Museums.JPG', 24000, 2225, 'MANUAL', 'b72e6550-e365-43bf-aab2-b57cafc2db71', 1986, 5, 1),
--    (3, 'Top Trabi 2!', 'PETROL', 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/b8/AWZ_Trabant_601S%2C_Verkehrszentrum_des_Deutschen_Museums.JPG/1200px-AWZ_Trabant_601S%2C_Verkehrszentrum_des_Deutschen_Museums.JPG', 24000, 2227, 'MANUAL', 'b72e6550-e365-43bf-aab2-b57cafc2db72', 1987, 5, 2),
--    (4, 'Top Trabi 2!', 'PETROL', 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/b8/AWZ_Trabant_601S%2C_Verkehrszentrum_des_Deutschen_Museums.JPG/1200px-AWZ_Trabant_601S%2C_Verkehrszentrum_des_Deutschen_Museums.JPG', 24000, 2221, 'MANUAL', 'b72e6550-e365-43bf-aab2-b57cafc2db73', 1988, 5, 2),
--    (5, 'Top Trabi 2!', 'PETROL', 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/b8/AWZ_Trabant_601S%2C_Verkehrszentrum_des_Deutschen_Museums.JPG/1200px-AWZ_Trabant_601S%2C_Verkehrszentrum_des_Deutschen_Museums.JPG', 24000, 2220, 'MANUAL', 'b72e6550-e365-43bf-aab2-b57cafc2db74', 1989, 5, 2);