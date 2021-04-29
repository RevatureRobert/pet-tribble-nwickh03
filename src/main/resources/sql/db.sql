CREATE TABLE public.labs (
	id serial NOT NULL,
	"name" varchar NOT NULL,
	capacity int4 NULL,
	CONSTRAINT labs_pk PRIMARY KEY (id)
);
CREATE TABLE public.tribbles (
	id serial NOT NULL,
	color varchar NOT NULL DEFAULT 'red'::character varying,
	lab_id int4 NULL,
	CONSTRAINT tribble_pk PRIMARY KEY (id)
);