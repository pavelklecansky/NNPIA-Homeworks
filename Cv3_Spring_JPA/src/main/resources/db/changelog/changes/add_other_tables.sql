-- liquibase formatted sql
-- changeset pavel:add_other_tables

CREATE TABLE public.task
(
    id            serial PRIMARY KEY,
    title         VARCHAR(255),
    description   VARCHAR(255),
    creation_date date,
    update_date   date,
    author_id     INTEGER REFERENCES app_user (id)
);

CREATE TABLE public.role
(
    id   serial PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE public.app_user_role
(
    app_user_id INTEGER REFERENCES app_user (id),
    role_id     INTEGER REFERENCES role (id)
);

