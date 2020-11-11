create table AMA_ogp_comments (
	id_ LONG not null primary key,
	nome VARCHAR(75) null,
	email VARCHAR(75) null,
	mensagem VARCHAR(75) null,
	status BOOLEAN,
	date_ DATE null
);