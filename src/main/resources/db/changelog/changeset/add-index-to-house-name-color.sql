-- liquibase formatted sql


-- changeset igor_mokryshin:5
-- comment: add-index-to-house-name-color

CREATE INDEX IF NOT EXISTS idx_house_name_color ON house(name, color);