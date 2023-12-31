PGDMP         7                {            Pesquiz    15.3    15.3                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    24615    Pesquiz    DATABASE     �   CREATE DATABASE "Pesquiz" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Portuguese_Brazil.1252';
    DROP DATABASE "Pesquiz";
                Pesquiz    false                       0    0    Pesquiz    DATABASE PROPERTIES     0   ALTER DATABASE "Pesquiz" CONNECTION LIMIT = 10;
                     Pesquiz    false                        2615    2200    public    SCHEMA     2   -- *not* creating schema, since initdb creates it
 2   -- *not* dropping schema, since initdb creates it
                Pesquiz    false            �            1255    32788    funcao_data_criacao_pesquisa()    FUNCTION     �   CREATE FUNCTION public.funcao_data_criacao_pesquisa() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
NEW.data_criacao := CURRENT_TIMESTAMP;
RETURN NEW;
END; $$;
 5   DROP FUNCTION public.funcao_data_criacao_pesquisa();
       public          postgres    false    5            �            1259    24622    info_pesquisas    TABLE     �   CREATE TABLE public.info_pesquisas (
    n_respostas_obtidas integer NOT NULL,
    data_criacao date,
    titulo character varying(200),
    id_pesquisa integer NOT NULL,
    id_pesquisador integer
);
 "   DROP TABLE public.info_pesquisas;
       public         heap    Pesquiz    false    5            �            1259    32814    info_pesquisas_id_pesquisa_seq    SEQUENCE     �   CREATE SEQUENCE public.info_pesquisas_id_pesquisa_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 5   DROP SEQUENCE public.info_pesquisas_id_pesquisa_seq;
       public          Pesquiz    false    216    5                       0    0    info_pesquisas_id_pesquisa_seq    SEQUENCE OWNED BY     a   ALTER SEQUENCE public.info_pesquisas_id_pesquisa_seq OWNED BY public.info_pesquisas.id_pesquisa;
          public          Pesquiz    false    220            �            1259    24616    login_pesquisadores    TABLE     �   CREATE TABLE public.login_pesquisadores (
    email character varying(30) NOT NULL,
    senha character varying(30) NOT NULL,
    nome character varying(35) NOT NULL,
    id_pesquisador integer NOT NULL
);
 '   DROP TABLE public.login_pesquisadores;
       public         heap    Pesquiz    false    5            �            1259    32799 &   login_pesquisadores_id_pesquisador_seq    SEQUENCE     �   CREATE SEQUENCE public.login_pesquisadores_id_pesquisador_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 =   DROP SEQUENCE public.login_pesquisadores_id_pesquisador_seq;
       public          Pesquiz    false    5    214                       0    0 &   login_pesquisadores_id_pesquisador_seq    SEQUENCE OWNED BY     q   ALTER SEQUENCE public.login_pesquisadores_id_pesquisador_seq OWNED BY public.login_pesquisadores.id_pesquisador;
          public          Pesquiz    false    218            �            1259    24619    login_voluntarios    TABLE     �   CREATE TABLE public.login_voluntarios (
    n_chatbot character(12) NOT NULL,
    senha character varying(20) NOT NULL,
    id_voluntario integer NOT NULL
);
 %   DROP TABLE public.login_voluntarios;
       public         heap    Pesquiz    false    5            �            1259    32794 #   login_voluntarios_id_voluntario_seq    SEQUENCE     �   CREATE SEQUENCE public.login_voluntarios_id_voluntario_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 :   DROP SEQUENCE public.login_voluntarios_id_voluntario_seq;
       public          Pesquiz    false    215    5                       0    0 #   login_voluntarios_id_voluntario_seq    SEQUENCE OWNED BY     k   ALTER SEQUENCE public.login_voluntarios_id_voluntario_seq OWNED BY public.login_voluntarios.id_voluntario;
          public          Pesquiz    false    217            �            1259    32804    questionarios    TABLE     �   CREATE TABLE public.questionarios (
    q1 character varying(100),
    q2 character varying(100),
    q3 character varying(100),
    q4 character varying(100),
    q5 character varying(100),
    id_pesquisa integer
);
 !   DROP TABLE public.questionarios;
       public         heap    Pesquiz    false    5            v           2604    32815    info_pesquisas id_pesquisa    DEFAULT     �   ALTER TABLE ONLY public.info_pesquisas ALTER COLUMN id_pesquisa SET DEFAULT nextval('public.info_pesquisas_id_pesquisa_seq'::regclass);
 I   ALTER TABLE public.info_pesquisas ALTER COLUMN id_pesquisa DROP DEFAULT;
       public          Pesquiz    false    220    216            t           2604    32800 "   login_pesquisadores id_pesquisador    DEFAULT     �   ALTER TABLE ONLY public.login_pesquisadores ALTER COLUMN id_pesquisador SET DEFAULT nextval('public.login_pesquisadores_id_pesquisador_seq'::regclass);
 Q   ALTER TABLE public.login_pesquisadores ALTER COLUMN id_pesquisador DROP DEFAULT;
       public          Pesquiz    false    218    214            u           2604    32795    login_voluntarios id_voluntario    DEFAULT     �   ALTER TABLE ONLY public.login_voluntarios ALTER COLUMN id_voluntario SET DEFAULT nextval('public.login_voluntarios_id_voluntario_seq'::regclass);
 N   ALTER TABLE public.login_voluntarios ALTER COLUMN id_voluntario DROP DEFAULT;
       public          Pesquiz    false    217    215                      0    24622    info_pesquisas 
   TABLE DATA           p   COPY public.info_pesquisas (n_respostas_obtidas, data_criacao, titulo, id_pesquisa, id_pesquisador) FROM stdin;
    public          Pesquiz    false    216   |                  0    24616    login_pesquisadores 
   TABLE DATA           Q   COPY public.login_pesquisadores (email, senha, nome, id_pesquisador) FROM stdin;
    public          Pesquiz    false    214   o!                 0    24619    login_voluntarios 
   TABLE DATA           L   COPY public.login_voluntarios (n_chatbot, senha, id_voluntario) FROM stdin;
    public          Pesquiz    false    215   )"                 0    32804    questionarios 
   TABLE DATA           H   COPY public.questionarios (q1, q2, q3, q4, q5, id_pesquisa) FROM stdin;
    public          Pesquiz    false    219   �"                  0    0    info_pesquisas_id_pesquisa_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.info_pesquisas_id_pesquisa_seq', 5, true);
          public          Pesquiz    false    220                       0    0 &   login_pesquisadores_id_pesquisador_seq    SEQUENCE SET     U   SELECT pg_catalog.setval('public.login_pesquisadores_id_pesquisador_seq', 18, true);
          public          Pesquiz    false    218                       0    0 #   login_voluntarios_id_voluntario_seq    SEQUENCE SET     R   SELECT pg_catalog.setval('public.login_voluntarios_id_voluntario_seq', 19, true);
          public          Pesquiz    false    217            w           2620    32790 $   info_pesquisas data_criacao_pesquisa    TRIGGER     �   CREATE TRIGGER data_criacao_pesquisa BEFORE INSERT ON public.info_pesquisas FOR EACH ROW EXECUTE FUNCTION public.funcao_data_criacao_pesquisa();
 =   DROP TRIGGER data_criacao_pesquisa ON public.info_pesquisas;
       public          Pesquiz    false    216    221               �   x�}�;NA@��S�A��@�����.�3cV�f�a���� 
�������A�d[������6�v�m��tD?T�HA�3�BBx�<a�(�6'�@i�Vb�H�'׹�cӵ���T�"+U������s2�B�����h�@y���+��|���LU 	L��1���^�P=������h�Ŏ�j�ji&�$����+���*�U�)�+e�u7����i�o6�t�         �   x�M�1�0E��Sx��ʱ0XX�,Cf�uH��2��������ꎊ79Ǟ��{0T[�U�n��4x�\��{�xZb(սR�
b�����9(�5$�3�%��)�\�����e�͑�m)�46�V��f�������L�Ӈ��0�`G������f"�G��_ΥT�         �   x�5���0E��� �v��7&`.�R��f:�,FZ��d�?={�Ƕ��#�@���X�P�6a��S`rSNy0�C��罔W�.�G#KL�ͷ�� %T���i��	H�랺��pT�(#�[�[Lc�+�!e7���:-�i����w<�!�/         O   x�,M�Q�W(N-U���M��	���y�E�0��D�̔ĔT$~Q���HR�RR�R/���
5����qqq 2�H     