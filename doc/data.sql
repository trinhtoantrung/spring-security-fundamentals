create table users (
	username varchar(50) not null primary key,
    password varchar(50) not null,
    enabled boolean not null
);

create table authorities (
	username varchar(50) not null,
    authority varchar(50) not null,
    constraint fk_authorities_users
    foreign key(username) references users(username)
);

create unique index ix_auth_username on authorities(username, authority);

insert into users(username, password, enabled) values ("bryan", "secret", true);
insert into authorities(username, authority) values ("bryan", "ROLE_USER");

insert into users(username, password, enabled) values ("admin", "secret", true);
insert into authorities(username, authority) values ("admin", "ROLE_ADMIN");
insert into authorities(username, authority) values ("admin", "ROLE_USER");

select * from users;
select * from authorities;

update users set password = "5ebe2294ecd0e0f08eab7690d2a6ee69" where username = "bryan";