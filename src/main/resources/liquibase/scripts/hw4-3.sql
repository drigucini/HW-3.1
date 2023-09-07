-- liquibase formatted sql

-- changeset drigas:create_student_name_index
-- comment: Creating index for student search by name
create index student_by_name_index on student(name);

-- changeset drigas:faculty_by_name_and_color_index
-- comment: Creating index for faculty search by name and color
create index faculty_by_name_and_color_index on faculty (name, color);