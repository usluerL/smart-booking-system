CREATE TABLE hotels (
    id BIGINT PRIMARY KEY,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,

    city VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    star INTEGER NOT NULL CHECK (star BETWEEN 1 AND 5),
    description VARCHAR(500)
);