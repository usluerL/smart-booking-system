CREATE TABLE rooms (
                       id BIGINT PRIMARY KEY,
                       created_at TIMESTAMP,
                       updated_at TIMESTAMP,

                       room_number VARCHAR(50) NOT NULL,
                       type VARCHAR(50) NOT NULL,
                       price_per_night DOUBLE PRECISION NOT NULL,
                       is_available BOOLEAN DEFAULT TRUE,

                       hotel_id BIGINT NOT NULL,
                       CONSTRAINT fk_room_hotel FOREIGN KEY (hotel_id) REFERENCES hotels(id)
);