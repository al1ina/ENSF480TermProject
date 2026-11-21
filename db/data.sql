USE FLIGHTMANAGMENT_SYSTEM;

INSERT INTO FLIGHTS
(flight_number, destination, origin, airline, date, price, time) VALUES
('AC101', 'Calgary', 'Vancouver', 'Air Canada', '2026-12-05',  129.00, '11:00'),
('WS202', 'London', 'Ibiza', 'WestJet', '2026-12-05',  109.50, '14:00'),
('AC305', 'New York', 'Toronto', 'Air Canada', '2026-12-06',  389.00, '20:00'),

INSERT INTO USERS (name, password, role) VALUES
('Alex Admin', 'cool123', 'ADMIN'),
('Aisha Agent', 'yurr123', 'AGENT'),
('Liam Chen', 'sup123', 'CUSTOMER'),
('Sofia Martins', 'passwordunique', 'CUSTOMER'),
('Noah Patel', 'passuniword', 'CUSTOMER');

INSERT INTO RESERVATIONS (customer_id, flight_id, status) VALUES
(3, 1, 'CONFIRMED'),
(4, 3, 'CONFIRMED'),
(5, 2, 'CANCELLED');

INSERT INTO PAYMENTS (reservation_id, payment_type, amount, payment_date, status) VALUES
(1, 'CREDIT', 258.00, '2026-11-15', 'COMPLETED'),
(2, 'DEBIT',  389.00, '2026-11-17', 'COMPLETED');

INSERT INTO MONTHLYPROMOTIONS (promotion_id, title, details, month) VALUES
('Winter Escape',  '15% off all flights to Vancouver', '2026-12'),
('Holiday Travel', 'Free seat selection on bookings over $300', '2026-12'),
('New Year Deals', 'Business class upgrade from $99', '2027-01');