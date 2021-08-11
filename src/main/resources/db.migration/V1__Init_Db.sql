--
-- PostgreSQL database dump
--

-- Dumped from database version 10.9
-- Dumped by pg_dump version 10.9

-- Started on 2021-08-12 02:20:32

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 197 (class 1259 OID 25052)
-- Name: actors; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.actors (
    id bigint NOT NULL,
    actor_name character varying(255),
    date_of_birth timestamp without time zone,
    date_of_death timestamp without time zone,
    total_earnings numeric(10,2),
    country_id bigint,
    sex_id bigint
);


ALTER TABLE public.actors OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 25050)
-- Name: actors_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.actors_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.actors_id_seq OWNER TO postgres;

--
-- TOC entry 2952 (class 0 OID 0)
-- Dependencies: 196
-- Name: actors_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.actors_id_seq OWNED BY public.actors.id;


--
-- TOC entry 198 (class 1259 OID 25058)
-- Name: actors_movies; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.actors_movies (
    movie_id bigint NOT NULL,
    actor_id bigint NOT NULL
);


ALTER TABLE public.actors_movies OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 25251)
-- Name: countries; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.countries (
    id bigint NOT NULL,
    country_name character varying(255)
);


ALTER TABLE public.countries OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 25249)
-- Name: countries_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.countries_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.countries_id_seq OWNER TO postgres;

--
-- TOC entry 2953 (class 0 OID 0)
-- Dependencies: 219
-- Name: countries_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.countries_id_seq OWNED BY public.countries.id;


--
-- TOC entry 200 (class 1259 OID 25070)
-- Name: directors; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.directors (
    id bigint NOT NULL,
    date_of_birth timestamp without time zone,
    date_of_death timestamp without time zone,
    director_name character varying(255),
    total_earnings numeric(10,2),
    country_id bigint,
    sex_id bigint
);


ALTER TABLE public.directors OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 25068)
-- Name: directors_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.directors_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.directors_id_seq OWNER TO postgres;

--
-- TOC entry 2954 (class 0 OID 0)
-- Dependencies: 199
-- Name: directors_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.directors_id_seq OWNED BY public.directors.id;


--
-- TOC entry 202 (class 1259 OID 25078)
-- Name: film_studios; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.film_studios (
    id bigint NOT NULL,
    film_studio_name character varying(255)
);


ALTER TABLE public.film_studios OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 25076)
-- Name: film_studios_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.film_studios_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.film_studios_id_seq OWNER TO postgres;

--
-- TOC entry 2955 (class 0 OID 0)
-- Dependencies: 201
-- Name: film_studios_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.film_studios_id_seq OWNED BY public.film_studios.id;


--
-- TOC entry 204 (class 1259 OID 25086)
-- Name: genres; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.genres (
    id bigint NOT NULL,
    genre_name character varying(255)
);


ALTER TABLE public.genres OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 25084)
-- Name: genres_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.genres_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.genres_id_seq OWNER TO postgres;

--
-- TOC entry 2956 (class 0 OID 0)
-- Dependencies: 203
-- Name: genres_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.genres_id_seq OWNED BY public.genres.id;


--
-- TOC entry 206 (class 1259 OID 25094)
-- Name: movie_nominations; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.movie_nominations (
    id bigint NOT NULL,
    is_awarded boolean,
    movie_id bigint NOT NULL,
    nomination_id bigint NOT NULL
);


ALTER TABLE public.movie_nominations OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 25092)
-- Name: movie_nominations_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.movie_nominations_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.movie_nominations_id_seq OWNER TO postgres;

--
-- TOC entry 2957 (class 0 OID 0)
-- Dependencies: 205
-- Name: movie_nominations_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.movie_nominations_id_seq OWNED BY public.movie_nominations.id;


--
-- TOC entry 207 (class 1259 OID 25100)
-- Name: movies; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.movies (
    id bigint NOT NULL,
    movie_description character varying(255),
    movie_name character varying(255),
    release_date timestamp without time zone,
    total_earnings numeric(10,2),
    total_spendings numeric(10,2),
    country_id bigint,
    director_id bigint,
    studio_id bigint,
    genre_id bigint
);


ALTER TABLE public.movies OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 25110)
-- Name: nominations; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.nominations (
    id bigint NOT NULL,
    nomination_category_name character varying(255),
    prize_id bigint
);


ALTER TABLE public.nominations OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 25108)
-- Name: nominations_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.nominations_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.nominations_id_seq OWNER TO postgres;

--
-- TOC entry 2958 (class 0 OID 0)
-- Dependencies: 208
-- Name: nominations_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.nominations_id_seq OWNED BY public.nominations.id;


--
-- TOC entry 211 (class 1259 OID 25118)
-- Name: person; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.person (
    person_type integer NOT NULL,
    id bigint NOT NULL,
    date_of_birth timestamp without time zone,
    date_of_death timestamp without time zone,
    name character varying(255),
    total_earnings numeric(10,2),
    country_id bigint,
    sex_id bigint
);


ALTER TABLE public.person OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 25116)
-- Name: person_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.person_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.person_id_seq OWNER TO postgres;

--
-- TOC entry 2959 (class 0 OID 0)
-- Dependencies: 210
-- Name: person_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.person_id_seq OWNED BY public.person.id;


--
-- TOC entry 213 (class 1259 OID 25126)
-- Name: prizes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.prizes (
    id bigint NOT NULL,
    nomination_name character varying(255)
);


ALTER TABLE public.prizes OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 25124)
-- Name: prizes_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.prizes_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.prizes_id_seq OWNER TO postgres;

--
-- TOC entry 2960 (class 0 OID 0)
-- Dependencies: 212
-- Name: prizes_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.prizes_id_seq OWNED BY public.prizes.id;


--
-- TOC entry 215 (class 1259 OID 25134)
-- Name: sexes; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sexes (
    id bigint NOT NULL,
    sex_name character varying(255)
);


ALTER TABLE public.sexes OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 25132)
-- Name: sexes_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sexes_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sexes_id_seq OWNER TO postgres;

--
-- TOC entry 2961 (class 0 OID 0)
-- Dependencies: 214
-- Name: sexes_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.sexes_id_seq OWNED BY public.sexes.id;


--
-- TOC entry 217 (class 1259 OID 25142)
-- Name: writers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.writers (
    id bigint NOT NULL,
    date_of_birth timestamp without time zone,
    date_of_death timestamp without time zone,
    total_earnings numeric(10,2),
    writer_name character varying(255),
    country_id bigint,
    sex_id bigint
);


ALTER TABLE public.writers OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 25140)
-- Name: writers_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.writers_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.writers_id_seq OWNER TO postgres;

--
-- TOC entry 2962 (class 0 OID 0)
-- Dependencies: 216
-- Name: writers_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.writers_id_seq OWNED BY public.writers.id;


--
-- TOC entry 218 (class 1259 OID 25148)
-- Name: writers_movies; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.writers_movies (
    movie_id bigint NOT NULL,
    writer_id bigint NOT NULL
);


ALTER TABLE public.writers_movies OWNER TO postgres;

--
-- TOC entry 2743 (class 2604 OID 25055)
-- Name: actors id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.actors ALTER COLUMN id SET DEFAULT nextval('public.actors_id_seq'::regclass);


--
-- TOC entry 2753 (class 2604 OID 25254)
-- Name: countries id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.countries ALTER COLUMN id SET DEFAULT nextval('public.countries_id_seq'::regclass);


--
-- TOC entry 2744 (class 2604 OID 25073)
-- Name: directors id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.directors ALTER COLUMN id SET DEFAULT nextval('public.directors_id_seq'::regclass);


--
-- TOC entry 2745 (class 2604 OID 25081)
-- Name: film_studios id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.film_studios ALTER COLUMN id SET DEFAULT nextval('public.film_studios_id_seq'::regclass);


--
-- TOC entry 2746 (class 2604 OID 25089)
-- Name: genres id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.genres ALTER COLUMN id SET DEFAULT nextval('public.genres_id_seq'::regclass);


--
-- TOC entry 2747 (class 2604 OID 25097)
-- Name: movie_nominations id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movie_nominations ALTER COLUMN id SET DEFAULT nextval('public.movie_nominations_id_seq'::regclass);


--
-- TOC entry 2748 (class 2604 OID 25113)
-- Name: nominations id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nominations ALTER COLUMN id SET DEFAULT nextval('public.nominations_id_seq'::regclass);


--
-- TOC entry 2749 (class 2604 OID 25121)
-- Name: person id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.person ALTER COLUMN id SET DEFAULT nextval('public.person_id_seq'::regclass);


--
-- TOC entry 2750 (class 2604 OID 25129)
-- Name: prizes id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.prizes ALTER COLUMN id SET DEFAULT nextval('public.prizes_id_seq'::regclass);


--
-- TOC entry 2751 (class 2604 OID 25137)
-- Name: sexes id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sexes ALTER COLUMN id SET DEFAULT nextval('public.sexes_id_seq'::regclass);


--
-- TOC entry 2752 (class 2604 OID 25145)
-- Name: writers id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.writers ALTER COLUMN id SET DEFAULT nextval('public.writers_id_seq'::regclass);


--
-- TOC entry 2922 (class 0 OID 25052)
-- Dependencies: 197
-- Data for Name: actors; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.actors (id, actor_name, date_of_birth, date_of_death, total_earnings, country_id, sex_id) FROM stdin;
\.


--
-- TOC entry 2923 (class 0 OID 25058)
-- Dependencies: 198
-- Data for Name: actors_movies; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.actors_movies (movie_id, actor_id) FROM stdin;
\.


--
-- TOC entry 2945 (class 0 OID 25251)
-- Dependencies: 220
-- Data for Name: countries; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.countries (id, country_name) FROM stdin;
1	United States of America
2	France
3	Germany
6	Canada
\.


--
-- TOC entry 2925 (class 0 OID 25070)
-- Dependencies: 200
-- Data for Name: directors; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.directors (id, date_of_birth, date_of_death, director_name, total_earnings, country_id, sex_id) FROM stdin;
8	1954-08-16 06:00:00	\N	James Cameron	23.45	6	3
\.


--
-- TOC entry 2927 (class 0 OID 25078)
-- Dependencies: 202
-- Data for Name: film_studios; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.film_studios (id, film_studio_name) FROM stdin;
1	20th Century Fox
2	TF1 Films Production
\.


--
-- TOC entry 2929 (class 0 OID 25086)
-- Dependencies: 204
-- Data for Name: genres; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.genres (id, genre_name) FROM stdin;
\.


--
-- TOC entry 2931 (class 0 OID 25094)
-- Dependencies: 206
-- Data for Name: movie_nominations; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.movie_nominations (id, is_awarded, movie_id, nomination_id) FROM stdin;
\.


--
-- TOC entry 2932 (class 0 OID 25100)
-- Dependencies: 207
-- Data for Name: movies; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.movies (id, movie_description, movie_name, release_date, total_earnings, total_spendings, country_id, director_id, studio_id, genre_id) FROM stdin;
\.


--
-- TOC entry 2934 (class 0 OID 25110)
-- Dependencies: 209
-- Data for Name: nominations; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.nominations (id, nomination_category_name, prize_id) FROM stdin;
1	Best Art Direction	1
2	Best Cinematography	1
3	Best Visual Effects	1
4	Best Picture	1
5	Best Director	1
6	Best Film	2
7	Best Actor	2
8	Best Screenwriter	2
\.


--
-- TOC entry 2936 (class 0 OID 25118)
-- Dependencies: 211
-- Data for Name: person; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.person (person_type, id, date_of_birth, date_of_death, name, total_earnings, country_id, sex_id) FROM stdin;
\.


--
-- TOC entry 2938 (class 0 OID 25126)
-- Dependencies: 213
-- Data for Name: prizes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.prizes (id, nomination_name) FROM stdin;
1	Academy Award
2	European Film Awards
\.


--
-- TOC entry 2940 (class 0 OID 25134)
-- Dependencies: 215
-- Data for Name: sexes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.sexes (id, sex_name) FROM stdin;
2	female
3	male
\.


--
-- TOC entry 2942 (class 0 OID 25142)
-- Dependencies: 217
-- Data for Name: writers; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.writers (id, date_of_birth, date_of_death, total_earnings, writer_name, country_id, sex_id) FROM stdin;
\.


--
-- TOC entry 2943 (class 0 OID 25148)
-- Dependencies: 218
-- Data for Name: writers_movies; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.writers_movies (movie_id, writer_id) FROM stdin;
\.


--
-- TOC entry 2963 (class 0 OID 0)
-- Dependencies: 196
-- Name: actors_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.actors_id_seq', 1, false);


--
-- TOC entry 2964 (class 0 OID 0)
-- Dependencies: 219
-- Name: countries_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.countries_id_seq', 6, true);


--
-- TOC entry 2965 (class 0 OID 0)
-- Dependencies: 199
-- Name: directors_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.directors_id_seq', 8, true);


--
-- TOC entry 2966 (class 0 OID 0)
-- Dependencies: 201
-- Name: film_studios_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.film_studios_id_seq', 3, true);


--
-- TOC entry 2967 (class 0 OID 0)
-- Dependencies: 203
-- Name: genres_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.genres_id_seq', 1, false);


--
-- TOC entry 2968 (class 0 OID 0)
-- Dependencies: 205
-- Name: movie_nominations_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.movie_nominations_id_seq', 1, false);


--
-- TOC entry 2969 (class 0 OID 0)
-- Dependencies: 208
-- Name: nominations_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.nominations_id_seq', 8, true);


--
-- TOC entry 2970 (class 0 OID 0)
-- Dependencies: 210
-- Name: person_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.person_id_seq', 1, false);


--
-- TOC entry 2971 (class 0 OID 0)
-- Dependencies: 212
-- Name: prizes_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.prizes_id_seq', 2, true);


--
-- TOC entry 2972 (class 0 OID 0)
-- Dependencies: 214
-- Name: sexes_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sexes_id_seq', 6, true);


--
-- TOC entry 2973 (class 0 OID 0)
-- Dependencies: 216
-- Name: writers_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.writers_id_seq', 1, false);


--
-- TOC entry 2757 (class 2606 OID 25062)
-- Name: actors_movies actors_movies_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.actors_movies
    ADD CONSTRAINT actors_movies_pkey PRIMARY KEY (movie_id, actor_id);


--
-- TOC entry 2755 (class 2606 OID 25057)
-- Name: actors actors_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.actors
    ADD CONSTRAINT actors_pkey PRIMARY KEY (id);


--
-- TOC entry 2781 (class 2606 OID 25256)
-- Name: countries countries_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.countries
    ADD CONSTRAINT countries_pkey PRIMARY KEY (id);


--
-- TOC entry 2759 (class 2606 OID 25075)
-- Name: directors directors_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.directors
    ADD CONSTRAINT directors_pkey PRIMARY KEY (id);


--
-- TOC entry 2761 (class 2606 OID 25083)
-- Name: film_studios film_studios_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.film_studios
    ADD CONSTRAINT film_studios_pkey PRIMARY KEY (id);


--
-- TOC entry 2763 (class 2606 OID 25091)
-- Name: genres genres_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.genres
    ADD CONSTRAINT genres_pkey PRIMARY KEY (id);


--
-- TOC entry 2765 (class 2606 OID 25099)
-- Name: movie_nominations movie_nominations_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movie_nominations
    ADD CONSTRAINT movie_nominations_pkey PRIMARY KEY (id);


--
-- TOC entry 2767 (class 2606 OID 25107)
-- Name: movies movies_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movies
    ADD CONSTRAINT movies_pkey PRIMARY KEY (id);


--
-- TOC entry 2769 (class 2606 OID 25115)
-- Name: nominations nominations_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nominations
    ADD CONSTRAINT nominations_pkey PRIMARY KEY (id);


--
-- TOC entry 2771 (class 2606 OID 25123)
-- Name: person person_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.person
    ADD CONSTRAINT person_pkey PRIMARY KEY (id);


--
-- TOC entry 2773 (class 2606 OID 25131)
-- Name: prizes prizes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.prizes
    ADD CONSTRAINT prizes_pkey PRIMARY KEY (id);


--
-- TOC entry 2775 (class 2606 OID 25139)
-- Name: sexes sexes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.sexes
    ADD CONSTRAINT sexes_pkey PRIMARY KEY (id);


--
-- TOC entry 2779 (class 2606 OID 25152)
-- Name: writers_movies writers_movies_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.writers_movies
    ADD CONSTRAINT writers_movies_pkey PRIMARY KEY (movie_id, writer_id);


--
-- TOC entry 2777 (class 2606 OID 25147)
-- Name: writers writers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.writers
    ADD CONSTRAINT writers_pkey PRIMARY KEY (id);


--
-- TOC entry 2794 (class 2606 OID 25213)
-- Name: nominations fk2g049o0anb2labs0bjtisuymh; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.nominations
    ADD CONSTRAINT fk2g049o0anb2labs0bjtisuymh FOREIGN KEY (prize_id) REFERENCES public.prizes(id);


--
-- TOC entry 2783 (class 2606 OID 25257)
-- Name: actors fk2yo5yhg5xhkxjsdqcmlk8qali; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.actors
    ADD CONSTRAINT fk2yo5yhg5xhkxjsdqcmlk8qali FOREIGN KEY (country_id) REFERENCES public.countries(id);


--
-- TOC entry 2790 (class 2606 OID 25198)
-- Name: movies fk5ft3u8k962bmjd8rn2mr77j8d; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movies
    ADD CONSTRAINT fk5ft3u8k962bmjd8rn2mr77j8d FOREIGN KEY (director_id) REFERENCES public.directors(id);


--
-- TOC entry 2791 (class 2606 OID 25203)
-- Name: movies fk7l4klyd0vj214p60xd6hix2xg; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movies
    ADD CONSTRAINT fk7l4klyd0vj214p60xd6hix2xg FOREIGN KEY (studio_id) REFERENCES public.film_studios(id);


--
-- TOC entry 2782 (class 2606 OID 25158)
-- Name: actors fk8t5l0t74poiwwcn2kcrwpm4co; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.actors
    ADD CONSTRAINT fk8t5l0t74poiwwcn2kcrwpm4co FOREIGN KEY (sex_id) REFERENCES public.sexes(id);


--
-- TOC entry 2785 (class 2606 OID 25168)
-- Name: actors_movies fk9f8e2rdcg8cikwb0e0sivjl0d; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.actors_movies
    ADD CONSTRAINT fk9f8e2rdcg8cikwb0e0sivjl0d FOREIGN KEY (movie_id) REFERENCES public.movies(id);


--
-- TOC entry 2798 (class 2606 OID 25238)
-- Name: writers_movies fkb30tpht80si0y0pma8sje18gi; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.writers_movies
    ADD CONSTRAINT fkb30tpht80si0y0pma8sje18gi FOREIGN KEY (writer_id) REFERENCES public.writers(id);


--
-- TOC entry 2793 (class 2606 OID 25267)
-- Name: movies fkbih7y2b2lwdg87s5gosghnu99; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movies
    ADD CONSTRAINT fkbih7y2b2lwdg87s5gosghnu99 FOREIGN KEY (country_id) REFERENCES public.countries(id);


--
-- TOC entry 2789 (class 2606 OID 25188)
-- Name: movie_nominations fkbypbv2qfokieog3c0pmjsjxrb; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movie_nominations
    ADD CONSTRAINT fkbypbv2qfokieog3c0pmjsjxrb FOREIGN KEY (nomination_id) REFERENCES public.nominations(id);


--
-- TOC entry 2784 (class 2606 OID 25163)
-- Name: actors_movies fkcmqv0td45o34umwldjq4lx0tb; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.actors_movies
    ADD CONSTRAINT fkcmqv0td45o34umwldjq4lx0tb FOREIGN KEY (actor_id) REFERENCES public.actors(id);


--
-- TOC entry 2799 (class 2606 OID 25243)
-- Name: writers_movies fkd2m7hqe5mkbhmqkaupajw2ij7; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.writers_movies
    ADD CONSTRAINT fkd2m7hqe5mkbhmqkaupajw2ij7 FOREIGN KEY (movie_id) REFERENCES public.movies(id);


--
-- TOC entry 2795 (class 2606 OID 25223)
-- Name: person fkf9fyp263xwaik8cvjc33syuai; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.person
    ADD CONSTRAINT fkf9fyp263xwaik8cvjc33syuai FOREIGN KEY (sex_id) REFERENCES public.sexes(id);


--
-- TOC entry 2788 (class 2606 OID 25183)
-- Name: movie_nominations fkfauc2trwxydgj8468ypdtpsnb; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movie_nominations
    ADD CONSTRAINT fkfauc2trwxydgj8468ypdtpsnb FOREIGN KEY (movie_id) REFERENCES public.movies(id);


--
-- TOC entry 2797 (class 2606 OID 25272)
-- Name: writers fkhw8fk9yhy9fn9044x7p7txc24; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.writers
    ADD CONSTRAINT fkhw8fk9yhy9fn9044x7p7txc24 FOREIGN KEY (country_id) REFERENCES public.countries(id);


--
-- TOC entry 2792 (class 2606 OID 25208)
-- Name: movies fkjp8fsy8a0kkmdi04i81v05c6a; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.movies
    ADD CONSTRAINT fkjp8fsy8a0kkmdi04i81v05c6a FOREIGN KEY (genre_id) REFERENCES public.genres(id);


--
-- TOC entry 2787 (class 2606 OID 25262)
-- Name: directors fkpkjs8pw1wdau0bxohuo9v5cvm; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.directors
    ADD CONSTRAINT fkpkjs8pw1wdau0bxohuo9v5cvm FOREIGN KEY (country_id) REFERENCES public.countries(id);


--
-- TOC entry 2796 (class 2606 OID 25233)
-- Name: writers fks2wwboiqpbxf7daxe0s46k91k; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.writers
    ADD CONSTRAINT fks2wwboiqpbxf7daxe0s46k91k FOREIGN KEY (sex_id) REFERENCES public.sexes(id);


--
-- TOC entry 2786 (class 2606 OID 25178)
-- Name: directors fksh28x0aqa1b7ydwn1dj5da4l8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.directors
    ADD CONSTRAINT fksh28x0aqa1b7ydwn1dj5da4l8 FOREIGN KEY (sex_id) REFERENCES public.sexes(id);


-- Completed on 2021-08-12 02:20:32

--
-- PostgreSQL database dump complete
--

