CREATE TABLE arquivos_do(
		id_arquivo INT NOT NULL PRIMARY KEY IDENTITY(1,1),
		arquivo IMAGE
);

CREATE TABLE edital_do(
		num_edital BIGINT NOT NULL PRIMARY KEY,
		data_edital DATE NOT NULL,
		aprovado BIT NOT NULL,
		data_publicacao DATE ,
		id_arquivo INT,
		num_diario VARCHAR(MAX),
		assinado BIT,
		id_arquivo_pdf INT,
		tipo_edital INT,
		ativo BIT	
 );
  
CREATE TABLE portaria_do (
		num_portaria BIGINT NOT NULL PRIMARY KEY,
		data_portaria DATE NOT NULL,
		aprovado BIT NOT NULL,
		data_publicacao DATE ,
		id_arquivo INT,
		num_diario VARCHAR(MAX),
		assinado BIT,
		id_arquivo_pdf INT,
		tipo_portaria INT,
		ativo BIT	
);

CREATE TABLE proc_diario_oficial(
		id_processo BIGINT identity(1,1),
		cod_ciclo int,
		cnh varchar(255),
		codigo_processo int,
		condutor varchar(255),
		cpf varchar(255),
		data_hora_local TEXT,
		fundamento_legal varchar(255),
		num_auto TEXT,
		num_pontos varchar (255),
		numero_processo varchar(255),
		orgao_atuador TEXT ,
		placa varchar(255),
		prazo varchar (255),
		registro_pgu varchar(255),
		tipificacao TEXT ,
		tipo_procedimento int,
		tipo_processo TEXT,		
		portaria BIGINT,		
		id_edital BIGINT,		
		edital_gerado bit,
		ativo bit
)
  
