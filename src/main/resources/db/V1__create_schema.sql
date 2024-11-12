CREATE TABLE serie_pelicula (
    id INT PRIMARY KEY,
    titulo VARCHAR(100),
    genero VARCHAR(50),
    fecha_estreno DATE
);


CREATE TABLE nave_espacial (
    id INT PRIMARY KEY,
    nombre VARCHAR(100),
    tipo VARCHAR(50),
    fecha_creacion TIMESTAMP,
    ultima_modificacion TIMESTAMP,
    serie_pelicula_id INT,
    FOREIGN KEY (serie_pelicula_id) REFERENCES serie_pelicula(id)
);