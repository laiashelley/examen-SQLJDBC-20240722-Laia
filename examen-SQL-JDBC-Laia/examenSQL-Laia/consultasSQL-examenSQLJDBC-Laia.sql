/* Ver todos los libros */

SELECT * FROM examensqljdbc.libros;

/* Ver los id de la tabla libros */

SELECT id_libros FROM examensqljdbc.libros;

/* Ver todos los clientes */

SELECT * FROM examensqljdbc.clientes;

/* Obtener los libros publicados después de 2005: */

SELECT * FROM examensqljdbc.libros
WHERE anyo_libros > '2005';

/* Obtener los clientes cuyo nombre contiene la letra "e": */

SELECT * FROM examensqljdbc.clientes
WHERE nombre_clientes LIKE '%e%';

/* Contar el número total de libros: */

SELECT COUNT(*) AS total_libros FROM examensqljdbc.libros;

/* ¿Cuál es el título del libro con el ID 3?: */

SELECT titulo_libros FROM examensqljdbc.libros
WHERE id_libros = 3;

/* ¿Cuántos clientes tienen una dirección de correo electrónico que termina en "@ironhack.es": */

SELECT COUNT(*) AS clientes_con_ironhack FROM examensqljdbc.clientes
WHERE email_clientes LIKE '%ironhack.es';

/* ¿Cuál es el título del libro más antiguo?: */

SELECT titulo_libros FROM examensqljdbc.libros
ORDER BY anyo_libros ASC
LIMIT 1;

/* JOIN: Obtener los libros junto con los nombres de los clientes que los poseen: */

SELECT libros.titulo_libros, clientes.nombre_clientes FROM examensqljdbc.libros
JOIN clientes ON libros.id_libros = clientes.libros_id_libros;

/* Muestro tabla clientes para añadir un cliente sin libro */ 

SELECT * FROM examensqljdbc.clientes;

/* JOIN: Obtener los clientes que no tienen libros: */

SELECT clientes.nombre_clientes FROM examensqljdbc.clientes
LEFT JOIN libros ON clientes.libros_id_libros = libros.id_libros
WHERE libros.id_libros IS NULL;
