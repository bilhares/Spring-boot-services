--
-- Fernando Boaglio
-- 2016-12
--
drop table propriedade IF EXISTS;

CREATE TABLE propriedade (
id MEDIUMINT NOT NULL AUTO_INCREMENT,
categoria VARCHAR(200),
subcategoria VARCHAR(200),
nome VARCHAR(200),
valor VARCHAR(512) default '',
descricao VARCHAR(1000),
PRIMARY KEY (id),
UNIQUE INDEX nome_unique (nome ASC));


-- ----------------------------------------
-- CORE PROPERTIES
-- ----------------------------------------

-- BANNER
insert into propriedade(categoria,subcategoria,nome,valor,descricao) values ('CORE PROPERTIES','BANNER','banner.charset','UTF-8','Banner file encoding'); 
insert into propriedade(categoria,subcategoria,nome,valor,descricao) values ('CORE PROPERTIES','BANNER','banner.location','classpath:banner.txt','Banner file location'); 
insert into propriedade(categoria,subcategoria,nome,valor,descricao) values ('CORE PROPERTIES','BANNER','banner.image.location','classpath:banner.gif','Banner image file location (jpg/png can also be used)'); 
insert into propriedade(categoria,subcategoria,nome,valor,descricao) values ('CORE PROPERTIES','BANNER','banner.image.width','','Width of the banner image in chars (default 76)'); 
insert into propriedade(categoria,subcategoria,nome,valor,descricao) values ('CORE PROPERTIES','BANNER','banner.image.height','','Height of the banner image in chars (default based on image height)'); 
insert into propriedade(categoria,subcategoria,nome,valor,descricao) values ('CORE PROPERTIES','BANNER','banner.image.margin','','Left hand image margin in chars (default 2)'); 
insert into propriedade(categoria,subcategoria,nome,valor,descricao) values ('CORE PROPERTIES','BANNER','banner.image.invert','','If images should be inverted for dark terminal themes (default false)'); 
