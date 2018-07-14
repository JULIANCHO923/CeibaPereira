CREATE DATABASE bdseguro
USE bdseguro
CREATE TABLE tipo_inmueble (
  idtipo_inmueble VARCHAR(11)   NOT NULL ,
  nombre VARCHAR(50)      ,
PRIMARY KEY(idtipo_inmueble));




CREATE TABLE usuario (
  cedula VARCHAR(20)   NOT NULL ,
  nombre VARCHAR(100)    ,
  contrasena VARCHAR(50)      ,
PRIMARY KEY(cedula));




CREATE TABLE configuracion (
  idconfiguracion VARCHAR(11)   NOT NULL ,
  porcentaje_inmueble DOUBLE    ,
  coutas INTEGER    ,
  comision DOUBLE      ,
PRIMARY KEY(idconfiguracion));




CREATE TABLE inmueble (
  idinmueble VARCHAR(11)   NOT NULL ,
  usuario_cedula VARCHAR(20)   NOT NULL ,
  tipo_inmueble_idtipo_inmueble VARCHAR(11)   NOT NULL ,
  direccion VARCHAR(255)    ,
  valor DOUBLE    ,
  estrato INTEGER    ,
  metraje DOUBLE    ,
  valor_prima DOUBLE      ,
PRIMARY KEY(idinmueble)    ,
  FOREIGN KEY(tipo_inmueble_idtipo_inmueble)
    REFERENCES tipo_inmueble(idtipo_inmueble),
  FOREIGN KEY(usuario_cedula)
    REFERENCES usuario(cedula));


CREATE INDEX inmueble_FKIndex1 ON inmueble (tipo_inmueble_idtipo_inmueble);
CREATE INDEX inmueble_FKIndex2 ON inmueble (usuario_cedula);


CREATE INDEX IFK_Rel_01 ON inmueble (tipo_inmueble_idtipo_inmueble);
CREATE INDEX IFK_Rel_02 ON inmueble (usuario_cedula);


CREATE TABLE reclamacion (
  idreclamacion VARCHAR(11)   NOT NULL ,
  inmueble_idinmueble VARCHAR(11)   NOT NULL ,
  sentimiento1 VARCHAR(11)    ,
  sentimiento2 VARCHAR(11)    ,
  sentimiento3 VARCHAR(11)    ,
  pago BOOL      ,
PRIMARY KEY(idreclamacion)  ,
  FOREIGN KEY(inmueble_idinmueble)
    REFERENCES inmueble(idinmueble));


CREATE INDEX reclamacion_FKIndex1 ON reclamacion (inmueble_idinmueble);


CREATE INDEX IFK_Rel_05 ON reclamacion (inmueble_idinmueble);



