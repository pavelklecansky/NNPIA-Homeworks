-- liquibase formatted sql
-- changeset pavel:add_app_user_table
create TABLE public.app_user
(
    id            serial primary key,
    username      varchar(255),
    password      varchar(255),
    active        bool,
    creation_date date,
    update_date   date
);