CREATE TABLE users(
    id bigserial not null,
    login VARCHAR(100) not null,
    password VARCHAR(100) not null
);
ALTER TABLE tarefa ADD CONSTRAINT tarefa_pk PRIMARY KEY (id);