PGDMP     0    )                z            filmdb    14.1    14.1 	    ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    17959    filmdb    DATABASE     b   CREATE DATABASE filmdb WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Italian_Italy.1252';
    DROP DATABASE filmdb;
                postgres    false            ?            1259    17961    film    TABLE     ?   CREATE TABLE public.film (
    id integer NOT NULL,
    anno integer,
    incasso character varying(255),
    regista character varying(255),
    tipo character varying(255),
    titolo character varying(255)
);
    DROP TABLE public.film;
       public         heap    postgres    false            ?            1259    17960    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            ?          0    17961    film 
   TABLE DATA           H   COPY public.film (id, anno, incasso, regista, tipo, titolo) FROM stdin;
    public          postgres    false    210   ~       ?           0    0    hibernate_sequence    SEQUENCE SET     @   SELECT pg_catalog.setval('public.hibernate_sequence', 6, true);
          public          postgres    false    209            ]           2606    17967    film film_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.film
    ADD CONSTRAINT film_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.film DROP CONSTRAINT film_pkey;
       public            postgres    false    210            ?   ?  x?U??v?0@?ux
?SY:?X??? ?n?D????a??뢭??????L?g??E[?Ѻڣ?X?j?L??ڍ7I??c??HW??Q???20?ÝѾ?}4fBp??$? ?+=\?????:?D???6v?ۺ(!Q?Ri?wi??&?CJ?Xo0Yp???
?<X??:.???(p]f??u???g?Ur<ZA9?;?gp=?ve{?5c?P]Hϭ?ɝVŖms)?2H? ?Ot.?)-???G??~?b???&?
lc|ɼCI?'??????<???&?TD-?,MY?)
????^O?Y?c?}aMӾu??}     