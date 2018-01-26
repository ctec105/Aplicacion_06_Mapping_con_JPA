CREATE DATABASE IF NOT EXISTS mysqljpa;
USE mysqljpa;

DROP TABLE IF EXISTS tb_secuencia;
CREATE TABLE tb_secuencia(
  descripcion varchar(10) NOT NULL,
  valor int(10) NOT NULL,
  PRIMARY KEY (descripcion  )
) ;

insert into tb_secuencia values('empleado',0);
