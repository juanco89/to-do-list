
CREATE SEQUENCE public.tarea_id_seq;

CREATE TABLE public.tarea (
                id INTEGER NOT NULL DEFAULT nextval('public.tarea_id_seq'),
                fecha TIMESTAMP NOT NULL,
                descripcion VARCHAR NOT NULL,
                realizado BOOLEAN NOT NULL,
                CONSTRAINT tarea_pk PRIMARY KEY (id)
);

ALTER SEQUENCE public.tarea_id_seq OWNED BY public.tarea.id;
