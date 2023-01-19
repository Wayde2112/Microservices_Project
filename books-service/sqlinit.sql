CREATE DATABASE "book" OWNER postgres;
\connect book
ALTER DATABASE "book" SET TIMEZONE TO 'Europe/Rome';
SET TIMEZONE TO 'Europe/Rome';

CREATE TABLE "book"
(
    bookId BIGINT,
    bookName character varying,
    bookAuthor character varying,
) TABLESPACE pg_default;

ALTER TABLE "book"
    OWNER to postgres;