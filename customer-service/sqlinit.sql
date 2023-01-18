CREATE DATABASE "customer" OWNER postgres;
\connect customer
ALTER DATABASE "customer" SET TIMEZONE TO 'Europe/Rome';
SET TIMEZONE TO 'Europe/Rome';

CREATE TABLE "customer"
(
    customerId BIGINT,
    customerName character varying,
    customerSurname character varying,
    customerAddress character varying
) TABLESPACE pg_default;

ALTER TABLE "customer"
    OWNER to postgres;