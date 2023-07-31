-- liquibase formatted sql

-- changeset ZhdanovDM:1
CREATE TABLE users (
id serial,
email text
)
-- changeset ZhdanovDM:2
CREATE INDEX users_email ON users (email)

-- changeset ZhdanovDM:3
CREATE INDEX student_name ON student (name)

-- changeset ZhdanovDM:4
CREATE INDEX faculty_name_color ON faculty (name, color)