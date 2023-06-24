-- password: 123
insert into users (login, email, phone, active, first_name, last_name, middle_name, password) values ('admin', 'admin@fake.ru', '89999999999', true, 'Админ', 'Админ', 'Админ', '$2a$12$BWtarudkX6m1nNjDgRUmz.WZS3XoEcyIMDuYys0BCS3pMrgfke/8K');
insert into users (login, email, phone, active, first_name, last_name, middle_name, password) values ('ivanov.i', 'ivanov@fake.ru', '89999999999', true, 'Иванов', 'Иван', 'Иванович', '$2a$12$BWtarudkX6m1nNjDgRUmz.WZS3XoEcyIMDuYys0BCS3pMrgfke/8K');
-- insert into users (login, password, email, phone, active, first_name, last_name, middle_name, password) values ('ivanov.i', '', 'ivanov@fake.ru', '89999999999', true, 'Иванов', 'Иван', 'Иванович', '$2a$12$BWtarudkX6m1nNjDgRUmz.WZS3XoEcyIMDuYys0BCS3pMrgfke/8K');
insert into users (login, email, phone, active, first_name, last_name, middle_name, password) values ('petrov.p', 'petrov@fake.ru', '89999999999', true, 'Петров', 'Петр', 'Петрович', '$2a$12$BWtarudkX6m1nNjDgRUmz.WZS3XoEcyIMDuYys0BCS3pMrgfke/8K');
insert into users (login, email, phone, active, first_name, last_name, middle_name, password) values ('denisov.d', 'denisov@fake.ru', '89999999999', true, 'Денисов', 'Денис', 'Денисович', '$2a$12$BWtarudkX6m1nNjDgRUmz.WZS3XoEcyIMDuYys0BCS3pMrgfke/8K');
insert into users (login, email, phone, active, first_name, last_name, middle_name, password) values ('chepurko.c', 'chepurko@fake.ru', '89999999999', true, 'Чепурко', 'Чепур', 'Чепурович', '$2a$12$BWtarudkX6m1nNjDgRUmz.WZS3XoEcyIMDuYys0BCS3pMrgfke/8K');
insert into users (login, email, phone, active, first_name, last_name, middle_name, password) values ('aleksandrov.d', 'aleksandrov@fake.ru', '89999999999', true, 'Александров', 'Александр', 'Александрович', '$2a$12$BWtarudkX6m1nNjDgRUmz.WZS3XoEcyIMDuYys0BCS3pMrgfke/8K');
insert into users (login, email, phone, active, first_name, last_name, middle_name, password) values ('vladimirov.d', 'vladimirov@fake.ru', '89999999999', true, 'Владимиров', 'Владимир', 'Владимирович', '$2a$12$BWtarudkX6m1nNjDgRUmz.WZS3XoEcyIMDuYys0BCS3pMrgfke/8K');
SELECT setval('user_id_seq', 10, true);

insert into organization (name, email, owner_login, created_by, created, updated_by, updated) values ('ООО Ромашка', 'romashka@mail.ru', 'ivanov.i', 'ivanov.i', now(), 'ivanov.i', now());
insert into organization (name, email, owner_login, created_by, created, updated_by, updated) values ('ООО Петрушка', 'petrushka@mail.ru', 'ivanov.i', 'ivanov.i', now(), 'ivanov.i', now());
SELECT setval('organization_id_seq', 10, true);

insert into calendar (title, owner_login, created_by, created, updated_by, updated, organization_id) values ('Тесовый календарь', 'ivanov.i', 'ivanov.i', now(), 'ivanov.i', now(), 1);
SELECT setval('calendar_id_seq', 10, true);