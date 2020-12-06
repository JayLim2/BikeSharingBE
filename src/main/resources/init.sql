DROP TABLE public.messages;
DROP TABLE public.tickets;
DROP TABLE public.orders;
DROP TABLE public.bikes;
DROP TABLE public.ticket_statuses;
DROP TABLE public.tariffs;
DROP TABLE public.time_units;
DROP TABLE public.users;

DROP SEQUENCE public.bike_id_seq;
DROP SEQUENCE public.order_id_seq;
DROP SEQUENCE public.message_id_seq;
DROP SEQUENCE public.ticket_id_seq;

CREATE SEQUENCE public.bike_id_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1
    NO CYCLE;

CREATE SEQUENCE public.order_id_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1
    NO CYCLE;

CREATE SEQUENCE public.message_id_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1
    NO CYCLE;

CREATE SEQUENCE public.ticket_id_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    START 1
    CACHE 1
    NO CYCLE;

CREATE TABLE IF NOT EXISTS public.bikes
(
    id    int4         NOT NULL DEFAULT nextval('bike_id_seq'),
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
    "name"           varchar(255) NOT NULL,
    background_color varchar(255) NULL,
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

CREATE TABLE public.orders
(
    id          int4         NOT NULL DEFAULT nextval('order_id_seq'),
    end_time    timestamp    NULL,
    start_time  timestamp    NOT NULL,
    bike_id     int4         NOT NULL,
    tariff_name varchar(255) NOT NULL,
    user_id     varchar(255) NOT NULL,
    CONSTRAINT orders_pkey PRIMARY KEY (id),
    CONSTRAINT user_fk FOREIGN KEY (user_id) REFERENCES users (phone),
    CONSTRAINT tariff_fk FOREIGN KEY (tariff_name) REFERENCES tariffs (name),
    CONSTRAINT bike_fk FOREIGN KEY (bike_id) REFERENCES bikes (id)
);

CREATE TABLE public.tickets
(
    id            int4         NOT NULL DEFAULT nextval('ticket_id_seq'),
    order_id      int4         NOT NULL,
    ticket_status varchar(255) NOT NULL,
    assignee_id   varchar(255) NULL,
    CONSTRAINT tickets_pkey PRIMARY KEY (id),
    CONSTRAINT status_fk FOREIGN KEY (ticket_status) REFERENCES ticket_statuses (name),
    CONSTRAINT order_fk FOREIGN KEY (order_id) REFERENCES orders (id),
    CONSTRAINT user_fk FOREIGN KEY (assignee_id) REFERENCES users (phone)
);

CREATE TABLE public.messages
(
    id        int4         NOT NULL DEFAULT nextval('message_id_seq'),
    date_time timestamp    NULL,
    "text"    varchar(255) NOT NULL,
    ticket_id int4         NOT NULL,
    author_id varchar(255) NOT NULL,
    CONSTRAINT messages_pkey PRIMARY KEY (id),
    CONSTRAINT ticket_fk FOREIGN KEY (ticket_id) REFERENCES tickets (id),
    CONSTRAINT user_fk FOREIGN KEY (author_id) REFERENCES users (phone)
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

INSERT INTO public.ticket_statuses ("name", background_color)
VALUES ('Поиск оператора', NULL),
       ('В работе', '#ff5e00'),
       ('Вопрос решен', 'green'),
       ('Вопрос не решен', 'red')
;

INSERT INTO public.bikes (brand, model)
VALUES ('GT', 'Team Conway'),                    -- 1
       ('GT', 'Team Comp Conway'),               -- 2
       ('GT', 'Team BK'),                        -- 3
       ('Merida', 'eSPEEDER'),                   -- 4
       ('Merida', 'eSILEX+'),                    -- 5
       ('Merida', 'eONE-FORTY'),                 -- 6
       ('Merida', 'eBIG.TOUR'),                  -- 7
       ('Stels', 'Navigator-500 V 26" V020'),    -- 8
       ('Stels', 'Navigator-700 MD 27.5" F010'), -- 9
       ('Cube', 'Kathmandu Pro'),                -- 10
       ('Nordway', 'Cruise'),                    -- 11
       ('Nordway', 'Active 300 Disc'),           -- 12
       ('Nordway', 'Vortex') -- 13
;

INSERT INTO public.orders (start_time, end_time, bike_id, tariff_name, user_id)
VALUES (TIMESTAMP '2020-11-11 08:37:48', TIMESTAMP '2020-11-11 09:21:07', 2, 'Эконом', '79001002031'),
       (TIMESTAMP '2020-06-03 12:01:20', TIMESTAMP '2020-06-07 06:42:37', 11, 'Travel', '79001002034'),
       (TIMESTAMP '2020-07-16 21:15:39', NULL, 7, 'Travel', '79001002034'),
       (TIMESTAMP '2020-09-24 09:27:43', NULL, 8, 'Эконом', '79001002032'),
       (TIMESTAMP '2020-03-25 14:56:58', TIMESTAMP '2020-03-25 16:32:49', 4, 'Комфорт', '79001002033')
;
