CREATE USER "pg-investe" WITH PASSWORD 'pgsql-investe-password';

CREATE DATABASE "investe-bd";
ALTER DATABASE "investe-bd" OWNER TO "pg-investe";