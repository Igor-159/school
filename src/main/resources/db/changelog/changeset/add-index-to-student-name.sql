-- liquibase formatted sql


-- changeset igor_mokryshin:4
-- comment: add-index-to-student-name

CREATE INDEX IF NOT EXISTS idx_student_name ON student(name);