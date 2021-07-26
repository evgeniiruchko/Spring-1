DROP TABLE IF EXISTS users CASCADE;
create table users (
                       id                    bigserial,
                       username              varchar(30) not null,
                       password              varchar(80) not null,
                       email                 varchar(50) unique,
                       score                 serial,
                       primary key (id)
);

DROP TABLE IF EXISTS roles CASCADE;
create table roles (
                       id                    serial,
                       name                  varchar(50) not null,
                       primary key (id)
);

DROP TABLE IF EXISTS users_roles CASCADE;
CREATE TABLE users_roles (
                             user_id               bigint not null,
                             role_id               int not null,
                             primary key (user_id, role_id),
                             foreign key (user_id) references users (id),
                             foreign key (role_id) references roles (id)
);

insert into roles (name)
values
('ROLE_USER'), ('ROLE_ADMIN');

insert into users (username, password, email, score)
values
('user', '{bcrypt}$2y$12$mFUdPh8.ESnhu.eyDjxrYuSigUIOboDP94mt7vuNhf604Yw0iuKQa', 'user@gmail.com', 0),
('admin', '{bcrypt}$2y$12$mFUdPh8.ESnhu.eyDjxrYuSigUIOboDP94mt7vuNhf604Yw0iuKQa', 'admin@gmail.com', 0);

insert into users_roles (user_id, role_id)
values
(1, 1),
(2, 1),
(2, 2);