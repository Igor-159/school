-- liquibase formatted sql


-- changeset igor_mokryshin:3
-- comment: crate-table-student

CREATE TABLE IF NOT EXISTS student (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    age INT DEFAULT 20 CHECK (age >= 16),
    house_id BIGINT,
    avatar_id BIGINT,
    FOREIGN KEY (house_id) REFERENCES house(id),
    FOREIGN KEY (avatar_id) REFERENCES avatar(id)
);