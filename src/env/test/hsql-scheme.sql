--
-- Generated by Maven: mvn -P test hibernate3:hbm2ddl
--

    create table countries (
        id integer generated by default as identity (start with 1),
        created_at timestamp not null,
        name varchar(50) not null,
        primary key (id),
        unique (name)
    );

    create table suspicious_activities (
        id integer generated by default as identity (start with 1),
        ip varchar(15) not null,
        occured_at timestamp not null,
        page varchar(100) not null,
        referer_page varchar(255) not null,
        user_agent varchar(255) not null,
        type_id integer not null,
        user_id integer,
        primary key (id)
    );

    create table suspicious_activities_types (
        id integer generated by default as identity (start with 1),
        name varchar(100) not null,
        primary key (id),
        unique (name)
    );

    create table users (
        id integer generated by default as identity (start with 1),
        activated_at timestamp not null,
        email varchar(255) not null,
        hash varchar(40) not null,
        login varchar(15) not null,
        name varchar(100) not null,
        registered_at timestamp not null,
        salt varchar(10) not null,
        primary key (id),
        unique (login)
    );

    create table users_activation (
        act_key varchar(10) not null,
        created_at timestamp not null,
        email varchar(255) not null,
        primary key (act_key)
    );

    alter table suspicious_activities 
        add constraint FK35F0CA0F8D3FBEA4 
        foreign key (user_id) 
        references users;

    alter table suspicious_activities 
        add constraint FK35F0CA0FC005E970 
        foreign key (type_id) 
        references suspicious_activities_types;
