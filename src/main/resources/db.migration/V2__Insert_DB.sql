--
-- PostgreSQL database dump
--

-- Dumped from database version 10.9
-- Dumped by pg_dump version 10.9

-- Started on 2021-08-12 02:22:02

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

--
-- TOC entry 2922 (class 0 OID 25052)
-- Dependencies: 197
-- Data for Name: actors; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2923 (class 0 OID 25058)
-- Dependencies: 198
-- Data for Name: actors_movies; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2945 (class 0 OID 25251)
-- Dependencies: 220
-- Data for Name: countries; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.countries (id, country_name) VALUES (1, 'United States of America');
INSERT INTO public.countries (id, country_name) VALUES (2, 'France');
INSERT INTO public.countries (id, country_name) VALUES (3, 'Germany');
INSERT INTO public.countries (id, country_name) VALUES (6, 'Canada');


--
-- TOC entry 2925 (class 0 OID 25070)
-- Dependencies: 200
-- Data for Name: directors; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.directors (id, date_of_birth, date_of_death, director_name, total_earnings, country_id, sex_id) VALUES (8, '1954-08-16 06:00:00', NULL, 'James Cameron', 23.45, 6, 3);


--
-- TOC entry 2927 (class 0 OID 25078)
-- Dependencies: 202
-- Data for Name: film_studios; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.film_studios (id, film_studio_name) VALUES (1, '20th Century Fox');
INSERT INTO public.film_studios (id, film_studio_name) VALUES (2, 'TF1 Films Production');


--
-- TOC entry 2929 (class 0 OID 25086)
-- Dependencies: 204
-- Data for Name: genres; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2931 (class 0 OID 25094)
-- Dependencies: 206
-- Data for Name: movie_nominations; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2932 (class 0 OID 25100)
-- Dependencies: 207
-- Data for Name: movies; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2934 (class 0 OID 25110)
-- Dependencies: 209
-- Data for Name: nominations; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.nominations (id, nomination_category_name, prize_id) VALUES (1, 'Best Art Direction', 1);
INSERT INTO public.nominations (id, nomination_category_name, prize_id) VALUES (2, 'Best Cinematography', 1);
INSERT INTO public.nominations (id, nomination_category_name, prize_id) VALUES (3, 'Best Visual Effects', 1);
INSERT INTO public.nominations (id, nomination_category_name, prize_id) VALUES (4, 'Best Picture', 1);
INSERT INTO public.nominations (id, nomination_category_name, prize_id) VALUES (5, 'Best Director', 1);
INSERT INTO public.nominations (id, nomination_category_name, prize_id) VALUES (6, 'Best Film', 2);
INSERT INTO public.nominations (id, nomination_category_name, prize_id) VALUES (7, 'Best Actor', 2);
INSERT INTO public.nominations (id, nomination_category_name, prize_id) VALUES (8, 'Best Screenwriter', 2);


--
-- TOC entry 2936 (class 0 OID 25118)
-- Dependencies: 211
-- Data for Name: person; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2938 (class 0 OID 25126)
-- Dependencies: 213
-- Data for Name: prizes; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.prizes (id, nomination_name) VALUES (1, 'Academy Award');
INSERT INTO public.prizes (id, nomination_name) VALUES (2, 'European Film Awards');


--
-- TOC entry 2940 (class 0 OID 25134)
-- Dependencies: 215
-- Data for Name: sexes; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.sexes (id, sex_name) VALUES (2, 'female');
INSERT INTO public.sexes (id, sex_name) VALUES (3, 'male');


--
-- TOC entry 2942 (class 0 OID 25142)
-- Dependencies: 217
-- Data for Name: writers; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2943 (class 0 OID 25148)
-- Dependencies: 218
-- Data for Name: writers_movies; Type: TABLE DATA; Schema: public; Owner: postgres
--



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


-- Completed on 2021-08-12 02:22:03

--
-- PostgreSQL database dump complete
--

