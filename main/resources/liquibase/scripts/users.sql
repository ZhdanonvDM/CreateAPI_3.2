-- liquibase formatted sql

-- changeset ZhdanovDM:1
CREATE TABLE users (
    id serial,
    email text
)
