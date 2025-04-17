CREATE TABLE search_entries (
                                id BIGSERIAL PRIMARY KEY,
                                hotel_id BIGINT,
                                hotel_name VARCHAR(255),
                                city VARCHAR(255),
                                star INT,
                                room_id BIGINT,
                                room_type VARCHAR(100),
                                price_per_night DECIMAL(10,2),
                                reservation_id BIGINT,
                                reservation_status VARCHAR(50),
                                check_in DATE,
                                check_out DATE,
                                created_at TIMESTAMP DEFAULT now(),
                                updated_at TIMESTAMP DEFAULT now()
);