CREATE TABLE tipo_inmueble (
  idtipo_inmueble SERIAL  NOT NULL ,
  nombre VARCHAR(50)      ,
PRIMARY KEY(idtipo_inmueble));

INSERT INTO tipo_inmueble (nombre) VALUES ('APARTAMENTO');
INSERT INTO tipo_inmueble (nombre) VALUES ('CASA');
INSERT INTO tipo_inmueble (nombre) VALUES ('LOCAL');


CREATE SEQUENCE idtipo_inmueble;
ALTER TABLE tipo_inmueble ALTER idtipo_inmueble SET DEFAULT NEXTVAL('tipo_inmueble_idtipo_inmueble_seq');

CREATE TABLE usuario (
  cedula VARCHAR(50)  NOT NULL ,
  nombre VARCHAR(100)    ,
  contrasena VARCHAR(50)      ,
PRIMARY KEY(cedula));




CREATE TABLE configuracion (
  idconfiguracion SERIAL  NOT NULL ,
  porcentaje_inmueble BIGINT    ,
  coutas INTEGER    ,
  comision BIGINT      ,
PRIMARY KEY(idconfiguracion));

CREATE SEQUENCE idconfiguracion;
ALTER TABLE configuracion ALTER idconfiguracion SET DEFAULT NEXTVAL('configuracion_idconfiguracion_seq');



CREATE TABLE inmueble (
  idinmueble SERIAL  NOT NULL ,
  usuario_cedula VARCHAR(20)   NOT NULL ,
  tipo_inmueble_idtipo_inmueble INTEGER   NOT NULL ,
  direccion VARCHAR(255)    ,
  valor BIGINT    ,
  estrato INTEGER    ,
  metraje BIGINT    ,
  valor_prima BIGINT    ,
  latitud VARCHAR(50)    ,
  longitud VARCHAR(50)    ,
  zoom INTEGER      ,
PRIMARY KEY(idinmueble)    ,
  FOREIGN KEY(tipo_inmueble_idtipo_inmueble)
    REFERENCES tipo_inmueble(idtipo_inmueble),
  FOREIGN KEY(usuario_cedula)
    REFERENCES usuario(cedula));

CREATE SEQUENCE idinmueble;
ALTER TABLE inmueble ALTER idinmueble SET DEFAULT NEXTVAL('inmueble_idinmueble_seq');


CREATE INDEX inmueble_FKIndex1 ON inmueble (tipo_inmueble_idtipo_inmueble);
CREATE INDEX inmueble_FKIndex2 ON inmueble (usuario_cedula);


CREATE INDEX IFK_Rel_01 ON inmueble (tipo_inmueble_idtipo_inmueble);
CREATE INDEX IFK_Rel_02 ON inmueble (usuario_cedula);


CREATE TABLE reclamacion (
  idreclamacion SERIAL  NOT NULL ,
  inmueble_idinmueble INTEGER   NOT NULL ,
  sentimiento1 VARCHAR(11)    ,
  sentimiento2 VARCHAR(11)    ,
  sentimiento3 VARCHAR(11)    ,
  pago BOOL      ,
PRIMARY KEY(idreclamacion)  ,
  FOREIGN KEY(inmueble_idinmueble)
    REFERENCES inmueble(idinmueble));

CREATE SEQUENCE idreclamacion;
ALTER TABLE reclamacion ALTER idreclamacion SET DEFAULT NEXTVAL('reclamacion_idreclamacion_seq');


CREATE INDEX reclamacion_FKIndex1 ON reclamacion (inmueble_idinmueble);


CREATE INDEX IFK_Rel_05 ON reclamacion (inmueble_idinmueble);



