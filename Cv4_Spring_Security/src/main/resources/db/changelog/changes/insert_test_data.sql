-- liquibase formatted sql
-- changeset pavel:add_app_user_table

insert into public.role (id, name) values (1, 'Admin');
insert into public.role (id, name) values (2, 'User');

insert into public.app_user (id, username, password, active, creation_date, update_date) values (1, 'Pavel', 'heslo', true, '2023-02-28', '2023-02-28');
insert into public.app_user (id, username, password, active, creation_date, update_date) values (2, 'Honza', 'heslo', true, '2023-02-28', '2023-02-28');
insert into public.app_user (id, username, password, active, creation_date, update_date) values (3, 'Franta', 'heslo', false, '2023-02-28', '2023-02-28');

insert into public.task (id, title, description, creation_date, update_date, author_id) values (1, 'Test', 'Description', '2023-02-28', '2023-02-28', 1);
insert into public.task (id, title, description, creation_date, update_date, author_id) values (2, 'Test', 'Description', '2023-02-28', '2023-02-28', 2);
insert into public.task (id, title, description, creation_date, update_date, author_id) values (3, 'Test', 'Description', '2023-02-28', '2023-02-28', 3);
insert into public.task (id, title, description, creation_date, update_date, author_id) values (4, 'Test', 'Description', '2023-02-28', '2023-02-28', 1);

insert into public.app_user_role (app_user_id, role_id) values (1, 1);
insert into public.app_user_role (app_user_id, role_id) values (2, 2);
insert into public.app_user_role (app_user_id, role_id) values (3, 2);
insert into public.app_user_role (app_user_id, role_id) values (1, 2);
