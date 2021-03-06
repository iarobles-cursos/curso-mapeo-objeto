/************** TABLAS PARA EJERCICIOS ONE-TO-ONE ***************/
CREATE SEQUENCE usuarios_id_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE datos_usuarios_id_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE datos_articulos_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE datos_usuarios(
   id INT GENERATED BY DEFAULT AS SEQUENCE datos_usuarios_id_seq,
   biografia CLOB,
   fecha_registro DATE,PRIMARY KEY(id)
);

CREATE TABLE datos_articulos(
   id INT GENERATED BY DEFAULT AS SEQUENCE datos_articulos_id_seq,
   observaciones CLOB,
   PRIMARY KEY(id)   
);

CREATE TABLE usuarios(
   id INT GENERATED BY DEFAULT AS SEQUENCE usuarios_id_seq,   
   datos_autor_id INT,
   nombre VARCHAR(600),
   email VARCHAR(500),
   password VARCHAR(500),
   rol VARCHAR(500),
   activo BOOLEAN,
   PRIMARY KEY(id),
   FOREIGN KEY(datos_autor_id) REFERENCES datos_usuarios
);


/************** TABLAS PARA EJERCICIO ONE-TO-MANY ***************/
CREATE SEQUENCE articulo_id_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE comentario_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE articulos(
   id INT GENERATED BY DEFAULT AS SEQUENCE articulo_id_seq,
   usuario_id INT, 
   datos_articulo_id INT,
   titulo VARCHAR(500), 
   contenido CLOB, 
   fecha_creacion DATE, 
   PRIMARY KEY(id), 
   FOREIGN KEY(usuario_id) REFERENCES usuarios,
   FOREIGN KEY(datos_articulo_id) REFERENCES datos_articulos
);

CREATE TABLE comentarios(
   id INT GENERATED BY DEFAULT AS SEQUENCE comentario_id_seq,
   articulo_id INT,
   comentario CLOB,
   comentarista VARCHAR(500),
   fecha_creacion DATE,
   PRIMARY KEY (id),
   FOREIGN KEY(articulo_id) REFERENCES articulos
);

/************** TABLAS PARA EJERCICIO MANY-TO-MANY ***************/
CREATE SEQUENCE categoria_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE categorias(
   id INT GENERATED BY DEFAULT AS SEQUENCE categoria_id_seq,
   nombre VARCHAR(200),
   PRIMARY KEY(id)
);

CREATE TABLE categorias_articulos(
   categoria_id INT ,
   articulo_id INT,
   PRIMARY KEY(categoria_id, articulo_id),
   FOREIGN KEY(categoria_id) REFERENCES categorias,
   FOREIGN KEY(articulo_id) REFERENCES articulos
);

CREATE SEQUENCE departamento_id_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE departamentos(
   id INT GENERATED BY DEFAULT AS SEQUENCE departamento_id_seq ,
   nombre VARCHAR(200),
   PRIMARY KEY(id)
);

CREATE TABLE departamentos_usuarios(
   departamento_id INT,
   usuario_id INT,
   PRIMARY KEY(departamento_id, usuario_id),
   FOREIGN KEY(departamento_id) REFERENCES departamentos,
   FOREIGN KEY(usuario_id) REFERENCES usuarios
);



/************ TABLAS PARA EJEMPLOS @Embedded y @ElementCollection *********/
CREATE SEQUENCE domicilios_id_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE domicilios(
   id INT GENERATED BY DEFAULT AS SEQUENCE domicilios_id_seq,
   usuario_id INT,
   calle VARCHAR(300),
   numero VARCHAR(100),
   colonia VARCHAR(300),
   ciudad VARCHAR(300),
   PRIMARY KEY(id),
   FOREIGN KEY(usuario_id) REFERENCES usuarios        
);

CREATE SEQUENCE ratings_id_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE ratings(
    id INT GENERATED BY DEFAULT AS SEQUENCE ratings_id_seq,
    rating INT,
    articulo_id INT,
    PRIMARY KEY(id),
    FOREIGN KEY(articulo_id)  REFERENCES articulos
); 

CREATE SEQUENCE telefonos_id_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE telefonos(
  id INT GENERATED BY DEFAULT AS SEQUENCE telefonos_id_seq,
  usuario_id INT,
  telefono VARCHAR(300),
  PRIMARY KEY(id),
  FOREIGN KEY(usuario_id) REFERENCES usuarios
);

CREATE SEQUENCE emails_adicionales_id_seq START WITH 1 INCREMENT BY 1; 
CREATE TABLE emails_adicionales(
  id INT GENERATED BY DEFAULT AS SEQUENCE emails_adicionales_id_seq,
  usuario_id INT,
  email VARCHAR(300),
  PRIMARY KEY(id),
  FOREIGN KEY(usuario_id) REFERENCES usuarios
);

/************* TABLAS DE EJEMPLO PARA LLAVES COMPUESTAS **********/

CREATE TABLE ventas(
  orden INT,
  codigo_barras VARCHAR(300),
  nombre_producto VARCHAR(300),
  cantidad INT,
  PRIMARY KEY(orden, codigo_barras)
);


CREATE TABLE inscripciones(
  matricula VARCHAR(300),
  curso VARCHAR(300),
  fecha_inscripcion DATE,
  PRIMARY KEY(matricula,curso)
);

/************** DATOS PARA EJERCICIOS ONE-TO-ONE ***************/

INSERT INTO datos_usuarios(id,biografia,fecha_registro) VALUES(DEFAULT,'Usuario ficticio 1 creado para el curso', '2013-10-20');
INSERT INTO usuarios(id, datos_autor_id, nombre, email, password, rol, activo) VALUES(DEFAULT,1,'Juan Perez', 'juan@email.com','1234','ROLE_EDITOR',true);

INSERT INTO datos_usuarios(id,biografia,fecha_registro) VALUES(DEFAULT,'Usuario ficticio 2 creado para el curso', '2013-10-20');
INSERT INTO usuarios(id, datos_autor_id, nombre, email, password,rol,activo) VALUES(DEFAULT,2,'Pepe', 'pepe@email.com','1234','ROLE_ADMIN',true);

INSERT INTO datos_articulos(id,observaciones) VALUES(DEFAULT,'Observaciones adicionales para articulo 1');
INSERT INTO datos_articulos(id,observaciones) VALUES(DEFAULT,'Observaciones adicionales para articulo 2');
INSERT INTO datos_articulos(id,observaciones) VALUES(DEFAULT,'Observaciones adicionales para articulo 3');

/************** DATOS PARA EJERCICIO ONE-TO-MANY ***************/

INSERT INTO articulos VALUES(DEFAULT,1,1,'titulo articulo 1','contenido articulo 1','2013-10-24');
INSERT INTO articulos VALUES(DEFAULT,1,2,'titulo articulo 2','contenido articulo 2','2013-10-24');
INSERT INTO articulos VALUES(DEFAULT,1,3,'titulo articulo 3','contenido articulo 3','2013-10-24');

INSERT INTO comentarios VALUES(DEFAULT, 1, 'mi comentario 1','anonimo','2013-9-24');
INSERT INTO comentarios VALUES(DEFAULT, 1, 'mi comentario 2','anonimo','2013-11-24');

INSERT INTO comentarios VALUES(DEFAULT, 3, 'mi comentario en articulo 3','anonimo','2013-9-24');
INSERT INTO comentarios VALUES(DEFAULT, 3, 'otro comentario en articulo 3','anonimo','2013-11-24');

/************** DATOS PARA EJERCICIO MANY-TO-MANY ***************/

INSERT INTO categorias VALUES(DEFAULT, 'java');
INSERT INTO categorias VALUES(DEFAULT, 'linux');
INSERT INTO categorias VALUES(DEFAULT, 'jpa');

INSERT INTO categorias_articulos VALUES(1,1);
INSERT INTO categorias_articulos VALUES(2,1);
INSERT INTO categorias_articulos VALUES(3,1);

INSERT INTO categorias_articulos VALUES(1,2);
INSERT INTO categorias_articulos VALUES(2,2);


INSERT INTO departamentos VALUES(DEFAULT,'deportes');
INSERT INTO departamentos VALUES(DEFAULT,'tecnologia');
INSERT INTO departamentos VALUES(DEFAULT,'espectaculos');
INSERT INTO departamentos VALUES(DEFAULT,'ciencia');

INSERT INTO departamentos_usuarios(usuario_id,departamento_id) VALUES(1,1);
INSERT INTO departamentos_usuarios(usuario_id,departamento_id) VALUES(1,2);
INSERT INTO departamentos_usuarios(usuario_id,departamento_id) VALUES(1,3);

INSERT INTO departamentos_usuarios(usuario_id,departamento_id) VALUES(2,3);
INSERT INTO departamentos_usuarios(usuario_id,departamento_id) VALUES(2,4);


/************ DATOS PARA EJEMPLOS @Embedded y @ElementCollection *********/
INSERT INTO telefonos(id,usuario_id,telefono) VALUES(DEFAULT,1,'55 94182567');
INSERT INTO telefonos(id,usuario_id,telefono) VALUES(DEFAULT,1,'55 94182783');
INSERT INTO telefonos(id,usuario_id,telefono) VALUES(DEFAULT,2,'55 16186745');
  
INSERT INTO emails_adicionales(id,usuario_id,email) VALUES(DEFAULT,1,'juan2@hotmail.com');
INSERT INTO emails_adicionales(id,usuario_id,email) VALUES(DEFAULT,1,'juan3@yahoo.com');

/*********** DATOS PARA EJEMPLOS CON LLAVES COMPUESTAS *****************/

INSERT INTO ventas(orden,codigo_barras,nombre_producto,cantidad) VALUES(1,'001 2348', 'Papas',2);
INSERT INTO ventas(orden,codigo_barras,nombre_producto,cantidad) VALUES(1,'221 6734', 'Refresco 2Lt',1);
INSERT INTO ventas(orden,codigo_barras,nombre_producto,cantidad) VALUES(2,'981 6752', 'Pizza microondas',1);
INSERT INTO ventas(orden,codigo_barras,nombre_producto,cantidad) VALUES(2,'871 4167', 'Cerveza lata',3);

INSERT INTO inscripciones(matricula,curso,fecha_inscripcion) VALUES('24540IA762','Historia','2019-10-3');
INSERT INTO inscripciones(matricula,curso,fecha_inscripcion) VALUES('24540IA762','Antropologia','2019-10-4');
INSERT INTO inscripciones(matricula,curso,fecha_inscripcion) VALUES('51200BF187','JPA 2','2019-10-2');
INSERT INTO inscripciones(matricula,curso,fecha_inscripcion) VALUES('51200BF187','Sistemas Operativos','2019-10-3');
