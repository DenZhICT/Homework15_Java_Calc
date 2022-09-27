create database car_track_store
    with owner postgres;

create table cars
(
    id                 serial
        primary key,
    name               varchar(200) not null,
    fuel_economy       real         not null,
    fuel_capacity      integer      not null
);

alter table cars
    owner to postgres;

create table tracks
(
    id           serial
        primary key,
    name         varchar(200) not null,
    laps         integer      not null,
    lap_distance integer      not null
);

alter table tracks
    owner to postgres;

