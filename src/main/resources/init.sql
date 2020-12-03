CREATE SEQUENCE public.bike_id_seq
    INCREMENT BY 50
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1
    NO CYCLE;

CREATE SEQUENCE public.order_id_seq
    INCREMENT BY 50
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1
    NO CYCLE;

CREATE SEQUENCE public.ticket_id_seq
    INCREMENT BY 50
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1
    NO CYCLE;

CREATE TABLE IF NOT EXISTS public.bikes
(
    id    int4         NOT NULL,
    brand varchar(255) NULL,
    model varchar(255) NULL,
    CONSTRAINT bikes_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.time_units
(
    "name" varchar(255) NOT NULL,
    CONSTRAINT time_units_pkey PRIMARY KEY (name)
);

CREATE TABLE IF NOT EXISTS public.ticket_statuses
(
    "name" varchar(255) NOT NULL,
    CONSTRAINT ticket_statuses_pkey PRIMARY KEY (name)
);

CREATE TABLE IF NOT EXISTS public.tariffs
(
    "name"              varchar(255) NOT NULL,
    price_per_time_unit float8       NOT NULL,
    time_unit           varchar(255) NOT NULL,
    CONSTRAINT tariffs_pkey PRIMARY KEY (name),
    CONSTRAINT time_unit_fk FOREIGN KEY (time_unit) REFERENCES time_units (name)
);

CREATE TABLE IF NOT EXISTS public.users
(
    phone           varchar(255) NOT NULL,
    first_name      varchar(255) NOT NULL,
    last_name       varchar(255) NOT NULL,
    middle_name     varchar(255) NULL,
    passport_number int4         NOT NULL,
    passport_series int4         NOT NULL,
    "password"      varchar(255) NOT NULL,
    "role"          varchar(255) NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (phone),
    CONSTRAINT users_uk UNIQUE (first_name, middle_name, last_name, passport_series, passport_number)
);

CREATE TABLE IF NOT EXISTS public.orders
(
    ticket_id   int4         NOT NULL,
    end_time    timestamp    NULL,
    start_time  timestamp    NOT NULL,
    bike_id     int4         NOT NULL,
    tariff_name varchar(255) NOT NULL,
    username    varchar(255) NOT NULL,
    CONSTRAINT orders_pkey PRIMARY KEY (ticket_id),
    CONSTRAINT user_fk FOREIGN KEY (username) REFERENCES users (phone),
    CONSTRAINT tariff_fk FOREIGN KEY (tariff_name) REFERENCES tariffs (name),
    CONSTRAINT bike_fk FOREIGN KEY (bike_id) REFERENCES bikes (id)
);


CREATE TABLE IF NOT EXISTS public.tickets
(
    id            int4         NOT NULL,
    order_id      int4         NOT NULL, --make great again
    ticket_status varchar(255) NOT NULL,
    CONSTRAINT tickets_pkey PRIMARY KEY (id),
    CONSTRAINT status_fk FOREIGN KEY (ticket_status) REFERENCES ticket_statuses (name),
    CONSTRAINT order_fk FOREIGN KEY (order_id) REFERENCES orders (ticket_id)
);

INSERT INTO public.users (phone, first_name, last_name, middle_name, passport_number, passport_series, "password",
                          "role")
VALUES ('79001002031', 'Никита', 'Цой', 'Александрович', 100001, 1001,
        '$2a$10$ffkOlOz7o1WTAdELqy7KdunfLS04WNdpSN28a7u3IpZ8r3HMDrVGa', 'CLIENT'),
       ('79001002034', 'Сергей', 'Скворцов', 'Егорович', 100004, 1004,
        '$2a$10$ixp6b6x41qrlR2heqTlD/.mrGmWDnCJhCwS64W7I37w4OrjwzXQAu', 'CLIENT'),
       ('79001002038', 'Сергей', 'Скворцов', 'Никитич', 100008, 1008,
        '$2a$10$F1l3WVx1QNV3ClhcixMCaOUL3dRJIhoVAEmVuMLjhKjLB.dOt7m0.', 'ADMIN'),
       ('79001002030', 'Сергей', 'Иванов', 'Егорович', 100000, 1000,
        '$2a$10$XdgADnpqjT8EuyUpSsL4S.eZwDj34v6GEpLpq.LJO3qcR9aF6Z6Re', 'CLIENT'),
       ('79001002037', 'Никита', 'Цой', 'Алексеевич', 100007, 1007,
        '$2a$10$PoiH76pTaAXOiTSxymxWM.QmMtwRyPrNaHYSfiIHF6vejCCqhqsZy', 'SUPPORT'),
       ('79001002035', 'Евпатий', 'Бубнов', 'Михайлович', 100005, 1005,
        '$2a$10$7ok/4qe5AVc4rhEMnAr6KONE.mZM.C3Arrd9AX8j3/T5zqycz8lZS', 'SUPPORT'),
       ('79001002032', 'Александр', 'Знаменский', 'Алексеевич', 100002, 1002,
        '$2a$10$Z7TD8bkWS2FmBwOToAwvxu/DKeXU.35zVhTgemuYX37oUd9s.Nqtm', 'CLIENT'),
       ('79001002036', 'Никита', 'Левченко', NULL, 100006, 1006,
        '$2a$10$aRBBIReRU3ThthUDPQBWueCDu2iCFq3kEaFsl.PPhXNorI3R3Ap4u', 'SUPPORT'),
       ('79001002033', 'Никита', 'Комаров', 'Евпатиевич', 100003, 1003,
        '$2a$10$5ifnZi2WX4PWw/ajbMxH7e2SLk4vSLJyCFnB8ROXRZB0drVOUJGky', 'CLIENT');

INSERT INTO public.time_units ("name")
VALUES ('день'),
       ('час'),
       ('мин')
;

INSERT INTO public.tariffs("name", price_per_time_unit, time_unit)
VALUES ('Эконом', 2, 'мин'),
       ('Комфорт', 199, 'час'),
       ('Travel', 2399, 'день')
;

INSERT INTO public.ticket_statuses ("name")
VALUES ('Поиск оператора'),
       ('В работе'),
       ('Вопрос решен'),
       ('Вопрос не решен')
;

INSERT INTO public.bikes (brand, model)
VALUES ('GT', 'Team Conway'),
       ('GT', 'Team Comp Conway'),
       ('GT', 'Team BK'),
       ('Merida', 'eSPEEDER'),
       ('Merida', 'eSILEX+'),
       ('Merida', 'eONE-FORTY'),
       ('Merida', 'eBIG.TOUR'),
       ('Stels', 'Navigator-500 V 26" V020'),
       ('Stels', 'Navigator-700 MD 27.5" F010'),
       ('Cube', 'Kathmandu Pro'),
       ('Nordway', 'Cruise'),
       ('Nordway', 'Active 300 Disc'),
       ('Nordway', 'Vortex')
;

