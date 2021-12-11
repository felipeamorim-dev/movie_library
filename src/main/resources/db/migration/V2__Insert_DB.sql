 -- Arquivo para popular o banco de dados de filmes em modo de teste

insert into TB_MOVIE(TITLE, RELEASE_YEAR, QUALITY, DESCRIPTION, IMAGE_URL, URL) values('No Time to Die', 2021, 10, 'Filme mais recente do James Bond', 'https://newsunplug.com/wp-content/uploads/2020/09/No-Time-To-Die.jpg', 'https://www.imdb.com/title/tt2382320/');
insert into TB_MOVIE(TITLE, RELEASE_YEAR, QUALITY, DESCRIPTION, IMAGE_URL, URL) values('Shang-Chi e a Lenda dos Dez Anéis', 2020, 7, 'Shang-Chi o mestre das artes marciais baseadas no kung-fu é forçado a enfrentar o seu passado em virtude de novos acontecimentos em sua vida', 'https://www.disneyplusinformer.com/wp-content/uploads/2021/08/Shang-Chi-Movie-Poster.jpg' , 'https://www.imdb.com/title/tt9376612/?ref_=hm_tpks_tt_i_4_pd_tp1_cp');
insert into TB_MOVIE(TITLE, RELEASE_YEAR, QUALITY, DESCRIPTION, IMAGE_URL, URL) values('Venom: Tempo de Carnificina', 2021, 6, 'Novo filme do universo do homem aranha que apresentará um dos mais renomados inimigos do héroi', 'https://cinesuperk.com.br/wp-content/uploads/2020/12/9265fd46193a5137f881849ac7fba61b.jpg', 'https://www.imdb.com/title/tt7097896/?ref_=tt_sims_tt_i_8');
insert into TB_MOVIE(TITLE, RELEASE_YEAR, QUALITY, DESCRIPTION, IMAGE_URL, URL) values('Batman: O Cavaleiro das Trevas', 2008, 9, 'Quando a ameaça conhecida como O Coringa surge de seu passado, causa estragos e caos nas pessoas de Gotham. O Cavaleiro das Trevas deve aceitar um dos maiores testes para combater a injustiça.', 'https://2.bp.blogspot.com/-n_nkOsSAHUA/Tk1smLUG1VI/AAAAAAAAAbs/1PoZxrvDJAY/s1600/The%2BDark%2BKnight.jpg', 'https://www.imdb.com/title/tt0468569/?pf_rd_m=A2FGELUUNOQJNL&pf_rd_p=9703a62d-b88a-4e30-ae12-90fcafafa3fc&pf_rd_r=Q85SMJHT8BBET5A0Y061&pf_rd_s=center-1&pf_rd_t=15506&pf_rd_i=top&ref_=chttp_tt_4');
insert into TB_MOVIE(TITLE, RELEASE_YEAR, QUALITY, DESCRIPTION, IMAGE_URL, URL) values('O Senhor dos Anéis: A Sociedade do Anel', 2001, 8, 'Um manso hobbit do Condado e oito companheiros partem em uma jornada para destruir o poderoso Um Anel e salvar a Terra-média das Trevas.', 'https://img.elo7.com.br/product/zoom/2692762/poster-o-senhor-dos-aneis-a-sociedade-do-anel-lo06-90x60-cm-presente-geek.jpg', 'https://www.imdb.com/title/tt0120737/?pf_rd_m=A2FGELUUNOQJNL&pf_rd_p=9703a62d-b88a-4e30-ae12-90fcafafa3fc&pf_rd_r=Q85SMJHT8BBET5A0Y061&pf_rd_s=center-1&pf_rd_t=15506&pf_rd_i=top&ref_=chttp_tt_10');
insert into TB_MOVIE(TITLE, RELEASE_YEAR, QUALITY, DESCRIPTION, IMAGE_URL, URL) values('Star Wars: Episode V - The Empire Strikes Back', 1980, 9, 'Os rebeldes derrotaram o Império no planeta congelado Hoth. Luke Skywalker começa a treinar como um Jedi com Yoda, enquanto seus amigos são perseguidos por Darth Vader.', 'https://3.bp.blogspot.com/-lF5UnAfyYpw/Wh_G5vMF37I/AAAAAAAATm8/kEuz5B7O4ZcxiwWXM9xmmxPNL3L1VCk6QCLcBGAs/s1600/star%2Bwars%2Bempire%2Bstrikes%2Bback.jpg', 'https://www.imdb.com/title/tt0080684/?pf_rd_m=A2FGELUUNOQJNL&pf_rd_p=9703a62d-b88a-4e30-ae12-90fcafafa3fc&pf_rd_r=Q85SMJHT8BBET5A0Y061&pf_rd_s=center-1&pf_rd_t=15506&pf_rd_i=top&ref_=chttp_tt_15');
insert into TB_MOVIE(TITLE, RELEASE_YEAR, QUALITY, DESCRIPTION, IMAGE_URL, URL) values('The Lion King', 1994, 9, 'Um pequeno lion é obrigado por seu tío a fugir de casa e anos depois se da conta da sua identidade e suas responsabilidades.', 'https://www.rotoscopers.com/wp-content/uploads/2014/02/Lion-King-Poster.jpg', 'https://www.imdb.com/title/tt0110357/?pf_rd_m=A2FGELUUNOQJNL&pf_rd_p=9703a62d-b88a-4e30-ae12-90fcafafa3fc&pf_rd_r=Q85SMJHT8BBET5A0Y061&pf_rd_s=center-1&pf_rd_t=15506&pf_rd_i=top&ref_=chttp_tt_38');
insert into TB_MOVIE(TITLE, RELEASE_YEAR, QUALITY, DESCRIPTION, IMAGE_URL, URL) values('Avengers: Infinity War', 2018, 8, 'Os Vingadores e seus aliados deverão sacrificar tudo em uma tentativa de derrotar o poderoso Thanos antes que sua explosão de devastação ponha fim ao universo.', 'https://image.tmdb.org/t/p/original/dBzuOU9urMXAMHIVGIlMZHsV6yn.jpg', 'https://www.imdb.com/title/tt4154756/?pf_rd_m=A2FGELUUNOQJNL&pf_rd_p=9703a62d-b88a-4e30-ae12-90fcafafa3fc&pf_rd_r=Q85SMJHT8BBET5A0Y061&pf_rd_s=center-1&pf_rd_t=15506&pf_rd_i=top&ref_=chttp_tt_62');

 -- Adição dos gêneros dos filmes

insert into TB_GENRE(NAME) values('Action');
insert into TB_GENRE(NAME) values('Adventure');
insert into TB_GENRE(NAME) values('Family');
insert into TB_GENRE(NAME) values('Comedy');
insert into TB_GENRE(NAME) values('Childrens');
insert into TB_GENRE(NAME) values('Heroes');
insert into TB_GENRE(NAME) values('Drama');
insert into TB_GENRE(NAME) values('Crime');
insert into TB_GENRE(NAME) values('Fantasy');
insert into TB_GENRE(NAME) values('Epic');
insert into TB_GENRE(NAME) values('Horror');
insert into TB_GENRE(NAME) values('Musical');
insert into TB_GENRE(NAME) values('Mystery');
insert into TB_GENRE(NAME) values('Romance');
insert into TB_GENRE(NAME) values('Science Fiction');
insert into TB_GENRE(NAME) values('Spy');
insert into TB_GENRE(NAME) values('War');
insert into TB_GENRE(NAME) values('Western');
insert into TB_GENRE(NAME) values('Adult');
insert into TB_GENRE(NAME) values('Experimental');

 -- ADICIONANDO OS GÊNEROS DOS FILMES
insert into TB_MOVIE_GENRE(MOVIE_ID, GENRE_ID) values(1, 1);
insert into TB_MOVIE_GENRE(MOVIE_ID, GENRE_ID) values(1, 2);
insert into TB_MOVIE_GENRE(MOVIE_ID, GENRE_ID) values(1, 16);
insert into TB_MOVIE_GENRE(MOVIE_ID, GENRE_ID) values(2, 1);
insert into TB_MOVIE_GENRE(MOVIE_ID, GENRE_ID) values(2, 2);
insert into TB_MOVIE_GENRE(MOVIE_ID, GENRE_ID) values(2, 6);
insert into TB_MOVIE_GENRE(MOVIE_ID, GENRE_ID) values(3, 1);
insert into TB_MOVIE_GENRE(MOVIE_ID, GENRE_ID) values(3, 2);
insert into TB_MOVIE_GENRE(MOVIE_ID, GENRE_ID) values(3, 6);
insert into TB_MOVIE_GENRE(MOVIE_ID, GENRE_ID) values(4, 1);
insert into TB_MOVIE_GENRE(MOVIE_ID, GENRE_ID) values(4, 2);
insert into TB_MOVIE_GENRE(MOVIE_ID, GENRE_ID) values(4, 6);
insert into TB_MOVIE_GENRE(MOVIE_ID, GENRE_ID) values(5, 2);
insert into TB_MOVIE_GENRE(MOVIE_ID, GENRE_ID) values(5, 9);
insert into TB_MOVIE_GENRE(MOVIE_ID, GENRE_ID) values(5, 10);
insert into TB_MOVIE_GENRE(MOVIE_ID, GENRE_ID) values(6, 2);
insert into TB_MOVIE_GENRE(MOVIE_ID, GENRE_ID) values(6, 9);
insert into TB_MOVIE_GENRE(MOVIE_ID, GENRE_ID) values(6, 15);
insert into TB_MOVIE_GENRE(MOVIE_ID, GENRE_ID) values(7, 3);
insert into TB_MOVIE_GENRE(MOVIE_ID, GENRE_ID) values(7, 5);
insert into TB_MOVIE_GENRE(MOVIE_ID, GENRE_ID) values(8, 1);
insert into TB_MOVIE_GENRE(MOVIE_ID, GENRE_ID) values(8, 2);
insert into TB_MOVIE_GENRE(MOVIE_ID, GENRE_ID) values(8, 9);


