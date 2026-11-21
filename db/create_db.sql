DROP DATABASE IF EXISTS FLIGHTMANAGMENT_SYSTEM;
CREATE DATABASE FLIGHTMANAGMENT_SYSTEM;
USE FLIGHTMANAGMENT_SYSTEM;

CREATE TABLE USERS (
  user_id           INT                 PRIMARY KEY AUTO_INCREMENT,
  name              VARCHAR(100)        NOT NULL UNIQUE,
  password          VARCHAR(100)        NOT NULL,
  role              VARCHAR(100)        NOT NULL CHECK(role IN ('CUSTOMER', 'AGENT', 'ADMIN'))
);

CREATE TABLE FLIGHTS (
  flight_id         INT                 PRIMARY KEY AUTO_INCREMENT,
  destination       VARCHAR(100)        NOT NULL,
  origin            VARCHAR(100)        NOT NULL,
  date              VARCHAR(100)        NOT NULL,
  airline           VARCHAR(100)        NOT NULL,
  price             REAL                NOT NULL,
  time              VARCHAR(100)        NOT NULL
);

CREATE TABLE SEATS (
  seat_id           INT                 PRIMARY KEY AUTO_INCREMENT,
  flight_id         INT                 NOT NULL,
  seat_number       INT                 NOT NULL,
  is_available      INT                 NOT NULL DEFAULT 1,
  FOREIGN KEY (flight_id) REFERENCES FLIGHTS (flight_id)
);

CREATE TABLE RESERVATIONS (
  reservation_id    INT                 PRIMARY KEY AUTO_INCREMENT,
  customer_id       INT                 NOT NULL,
  flight_id         INT                 NOT NULL,
  status            VARCHAR(100)        NOT NULL DEFAULT 'PENDING',
  FOREIGN KEY (customer_id) REFERENCES USERS (user_id),
  FOREIGN KEY (flight_id)   REFERENCES FLIGHTS (flight_id)
);

CREATE TABLE RESERVATION_SEATS (
  reservation_id    INT                 NOT NULL,
  seat_id           INT                 NOT NULL,
  PRIMARY KEY (reservation_id, seat_id),
  FOREIGN KEY (reservation_id) REFERENCES RESERVATIONS (reservation_id),
  FOREIGN KEY (seat_id)        REFERENCES SEATS (seat_id)
);

CREATE TABLE PAYMENTS (
  payment_id        INT                 PRIMARY KEY AUTO_INCREMENT,
  reservation_id    INT                 NOT NULL,
  payment_type      VARCHAR(100)        NOT NULL CHECK(payment_type IN ('CREDIT', 'DEBIT', 'PAYPAL')),
  amount            REAL                NOT NULL,
  payment_date      VARCHAR(100)        NOT NULL,
  status            VARCHAR(100)        NOT NULL,
  FOREIGN KEY (reservation_id) REFERENCES RESERVATIONS (reservation_id)
);

CREATE TABLE MONTHLYPROMOTIONS (
  promotion_id      INT                 PRIMARY KEY AUTO_INCREMENT,
  title             VARCHAR(100)        NOT NULL,
  details           VARCHAR(255)        NOT NULL,
  month             VARCHAR(100)        NOT NULL
);