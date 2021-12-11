create sequence fc_tb_movie_id_seq
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  MAXVALUE 2147483647
  CACHE 1;

create table if not exists TB_MOVIE(
    ID int not null default nextval('fc_tb_movie_id_seq'),
    TITLE varchar(255) not null,
    RELEASE_YEAR int not null,
    QUALITY int,
    DESCRIPTION varchar(4000),
    IMAGE_URL varchar(4000),
    URL varchar(4000),
    primary key(ID));

create sequence fc_tb_genre_id_seq
  START WITH 1
  INCREMENT BY 1
  NO MINVALUE
  MAXVALUE 2147483647
  CACHE 1;

create table if not exists TB_GENRE(
    ID int not null default nextval('fc_tb_genre_id_seq'),
    NAME varchar(255),
    primary key(ID));

create table if not exists TB_MOVIE_GENRE(
    MOVIE_ID int,
    GENRE_ID int,
    primary key(MOVIE_ID, GENRE_ID));

alter table TB_MOVIE_GENRE add constraint FK_MOVIE_GENRE
	foreign key(MOVIE_ID)
    references TB_MOVIE(ID);

alter table TB_MOVIE_GENRE add constraint FK_GENRE_MOVIE
	foreign key(GENRE_ID)
    references TB_GENRE(ID);