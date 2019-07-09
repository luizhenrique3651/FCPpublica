select * from pendencia;

insert into colaborador(nomeColaborador, setorColab, nomeUsuarioColab, senhaUsuarioColab) values ("luiz", "T.I", "luiz", "luiz123");
insert into aministrador(nomeAdm, setorAdm, nomeUsuarioAdm, senhaUsuarioAdm) values  ("luiz", "T.I", "luiz", "luiz123");
insert into aministrador(nomeAdm, setorAdm, nomeUsuarioAdm, senhaUsuarioAdm) values ("Amauri", "SGI", "amauri.santos", "santos.amauri");
insert into colaborador(nomeColaborador, setorColab, nomeUsuarioColab, senhaUsuarioColab) values  ("Amauri", "SGI", "amauri.santos", "santos.amauri");
insert into colaborador(nomeColaborador, setorColab, nomeUsuarioColab, senhaUsuarioColab) values  ("manutencao.sondas", "operacao", "manutencao", "abc123");

truncate table pendencia;

ALTER TABLE pendencia.pendencia ADD ordemServico int(5);
ALTER TABLE pendencia.pendencia ADD acaoSugerida varchar(144);
ALTER TABLE pendencia.pendencia ADD solicitaCompra int(5);
ALTER TABLE pendencia.pendencia ADD criticidade varchar(15);
insert into pendencia(causaRaiz, setorOperacaoPendencia, tipo, origem, dataPendencia, criticidade,ordemServico. solicitaCompra) values("sss","sss", "sss", "sss", "sss", "sss", 2, 1);
ALTER TABLE pendencia.pendencia ADD statusPendencia varchar(15);
ALTER TABLE pendencia.pendencia ADD caminhoArquivo varchar(255);
ALTER TABLE pendencia CHANGE dataPendencia dataPendencia varchar(20); 
ALTER TABLE pendencia ADD COLUMN providencia1 varchar(100);
ALTER TABLE pendencia ADD COLUMN providencia2 varchar(100);
ALTER TABLE pendencia ADD COLUMN providencia3 varchar(100);




describe pendencia;



INSERT INTO pendencia
(acaoTomadaAdm)
SELECT'advertising'
FROM pendencia
WHERE not exists (select * from pendencia
where pendencia.causaRaiz = "ojnihbuy" );


UPDATE pendencia
SET acaoTomadaAdm = 'putz', dataPreviaTermino = 20190202 WHERE causaRaiz = 'ojnihbuy';



select * from pendencia where setorOperacaoPendencia = 'ALMOXARIFADO' and causaRaiz= 'ojnihbuy' and tipo= 'ACIDENTE';

