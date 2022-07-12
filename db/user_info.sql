-- Table: public.user_info

-- DROP TABLE IF EXISTS public.user_info;

CREATE TABLE IF NOT EXISTS public.user_info
(
    name character varying COLLATE pg_catalog."default",
    age integer,
    password character varying COLLATE pg_catalog."default",
    id bigint
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.user_info
    OWNER to postgres;