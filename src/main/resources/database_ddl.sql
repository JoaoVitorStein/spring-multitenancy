-- Drop table

-- DROP TABLE public.employee;

CREATE TABLE public.employee (
	id int8 NOT NULL,
	"name" varchar(255) NOT NULL,
	department varchar(255) NULL,
	CONSTRAINT employee_pkey PRIMARY KEY (id)
);

-- DROP SEQUENCE public.employee_sequence;

CREATE SEQUENCE public.employee_sequence
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	CACHE 1
	NO CYCLE;
