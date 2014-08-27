
CREATE SEQUENCE public.tarea_id_seq;

CREATE TABLE public.tarea (
                id INTEGER NOT NULL DEFAULT nextval('public.tarea_id_seq'),
                fecha TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                descripcion VARCHAR NOT NULL,
                realizado BOOLEAN NOT NULL DEFAULT false,
                CONSTRAINT tarea_pk PRIMARY KEY (id)
);

ALTER SEQUENCE public.tarea_id_seq OWNED BY public.tarea.id;
