CREATE TABLE userData(
    id bigserial not null,
    login VARCHAR(100) not null,
    password VARCHAR(100) not null
);
ALTER TABLE userData ADD CONSTRAINT userData_pk PRIMARY KEY (id);