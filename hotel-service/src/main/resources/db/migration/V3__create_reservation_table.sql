CREATE TABLE reservation (
                             id BIGINT PRIMARY KEY,
                             created_at TIMESTAMP,
                             updated_at TIMESTAMP,

                             hotel_id BIGINT NOT NULL,
                             room_id BIGINT NOT NULL,
                             check_in DATE NOT NULL,
                             check_out DATE NOT NULL,
                             total_price NUMERIC(10, 2) NOT NULL,
                             status VARCHAR(50) NOT NULL
);