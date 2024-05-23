-- public.users definition

-- Drop table

-- DROP TABLE public.users;

CREATE TABLE public.users (
                              id bigserial NOT NULL,
                              email varchar(255) NULL,
                              "name" varchar(255) NULL,
                              "password" varchar(255) NULL,
                              user_role varchar(255) NULL,
                              username varchar(255) NULL,
                              CONSTRAINT uk_r43af9ap4edm43mmtq01oddj6 UNIQUE (username),
                              CONSTRAINT users_pkey PRIMARY KEY (id)
);