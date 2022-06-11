CREATE TABLE IF NOT EXISTS estudiante (
  id SERIAL,
  nombre VARCHAR (100) NOT NULL,
  cedula INT,
  edad INT,
  telefono INT,
  discapacidad VARCHAR (100) NOT NULL,
  curso VARCHAR (100) NOT NULL,
  PRIMARY KEY (id)
     );

CREATE TABLE IF NOT EXISTS notas (
  id SERIAL,
  calificacion INT,
  estudiante_id INT,
  FOREIGN KEY (estudiante_id) REFERENCES estudiante (id),
  PRIMARY KEY (id)
  );

CREATE TABLE IF NOT EXISTS docente (
  id SERIAL,
  nombre VARCHAR (100) NOT NULL,
  cedula INT,
  edad INT,
  telefono INT,
  ciudad VARCHAR (100) NOT NULL,
  estudiante_id INT,
  calificacion_id INT,
  PRIMARY KEY (id),
  FOREIGN KEY (estudiante_id) REFERENCES estudiante (id),
  FOREIGN KEY (calificacion_id) REFERENCES notas (id)
  );

CREATE TABLE IF NOT EXISTS deporte (
  id SERIAL,
  nombre VARCHAR (100) NOT NULL,
  hora INT,
  cancha VARCHAR (100) NOT NULL,
  PRIMARY KEY (id)

);
