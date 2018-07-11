CREATE TABLE IF NOT EXISTS tasks (
    id BIGINT IDENTITY PRIMARY KEY,
    title VARCHAR NOT NULL,
    memo VARCHAR,
    status CHAR(3) NOT NULL,
    createAt TIMESTAMP NOT NULL DEFAULT now()
);
