-- liquibase formatted sql


-- changeset igor_mokryshin:2
-- comment: crate-table-house

CREATE TABLE IF NOT EXISTS house (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    color VARCHAR(255)
    );