insert into users (login, email, phone, active, first_name, last_name, middle_name) values ('admin', 'admin@fake.ru', '89999999999', true, 'Админ', 'Админ', 'Админ');
insert into users (login, email, phone, active, first_name, last_name, middle_name) values ('ivanov.i', 'ivanov@fake.ru', '89999999999', true, 'Иванов', 'Иван', 'Иванович');
insert into users (login, email, phone, active, first_name, last_name, middle_name) values ('petrov.p', 'petrov@fake.ru', '89999999999', true, 'Петров', 'Петр', 'Петрович');
insert into users (login, email, phone, active, first_name, last_name, middle_name) values ('denisov.d', 'denisov@fake.ru', '89999999999', true, 'Денисов', 'Денис', 'Денисович');
insert into users (login, email, phone, active, first_name, last_name, middle_name) values ('chepurko.c', 'chepurko@fake.ru', '89999999999', true, 'Чепурко', 'Чепур', 'Чепурович');
insert into users (login, email, phone, active, first_name, last_name, middle_name) values ('aleksandrov.d', 'aleksandrov@fake.ru', '89999999999', true, 'Александров', 'Александр', 'Александрович');
insert into users (login, email, phone, active, first_name, last_name, middle_name) values ('vladimirov.d', 'vladimirov@fake.ru', '89999999999', true, 'Владимиров', 'Владимир', 'Владимирович');

insert into organization (name, email, owner_login, created_by, created, updated_by, updated) values ('ООО Ромашка', 'romashka@mail.ru', 'ivanov.i', 'ivanov.i', now(), 'ivanov.i', now());
insert into organization (name, email, owner_login, created_by, created, updated_by, updated) values ('ООО Петрушка', 'petrushka@mail.ru', 'ivanov.i', 'ivanov.i', now(), 'ivanov.i', now());

insert into calendar (title, owner_login, created_by, created, updated_by, updated, organization_id) values ('Тесовый календарь', 'ivanov.i', 'ivanov.i', now(), 'ivanov.i', now(), 1);
