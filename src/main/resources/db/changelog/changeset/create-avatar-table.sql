-- liquibase formatted sql


-- changeset igor_mokryshin:1
-- comment: crate-table-avatar

 CREATE TABLE IF NOT EXISTS avatar(
    id BIGSERIAL PRIMARY KEY,
    file_path VARCHAR(255) NOT NULL,
    file_size BIGINT NOT NULL,
    media_type VARCHAR(255)  NOT NULL,
    data BYTEA NOT NULL
 );