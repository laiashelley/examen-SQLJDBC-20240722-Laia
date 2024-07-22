package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class consultasJDBC {

    	public static void main(String[] args) {

			// JDBC: usa tu propia plantilla JDBC o la que te pase el profesor. Realiza una consulta para ver todos los titulos y los autores de todos los libros desde un statement normal directo. Del tipo:
			// System.out.printIn("titulo: " + resultado1.getString("titulo") + ", banda: " + resultado1.getString("banda")): 

            try {

				Class.forName("com.mysql.cj.jdbc.Driver");

				Connection conexion1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/examensqljdbc?serverTimezone=UTC", "root","");

				System.out.println("Conexión establecida correctamente.");

				Statement objeto1 = conexion1.createStatement();

				ResultSet resultado = objeto1.executeQuery("SELECT titulo_libros, autor_libros FROM libros");

				while(resultado.next()){
					System.out.println("Titulo del libro: " + resultado.getString("titulo_libros") + ", Autor del libro: " + resultado.getString("autor_libros"));
				}

				// JDBC. Sobre esa misma plantilla, realiza un insert con un PreparedStatement para registrar una nueva fila la en en la tabla Clientes. Verica que aparece el nuevo libro en la base de datos. Del tipo: String actualizar2 = “UPDATE discos SET lanzamiento = ? WHERE id = ?”; el ejemplo es un UPDATE, no un INSERT como se está pidiendo. Se pueden introducir los datos por scanner o mediante asignación de variables*

				String insertar = "INSERT INTO clientes (nombre_clientes, email_clientes, libros_id_libros) VALUES (?, ?, ?)";

				Scanner sc = new Scanner(System.in);

				System.out.println("Introduce el nombre del cliente nuevo: ");
				String nombreCliente = sc.nextLine();
				System.out.println("Introduce el email del cliente nuevo: ");
				String emailCliente = sc.nextLine();
				System.out.println("Introduce el id del libro que tiene asociado el cliente nuevo. Los libros son: 1-Harry Potter y la Piedra Filosofal 2-1984 3-It 4-Apocalipsis Z 5-The Martian"); 
				int idLibro = sc.nextInt();
				
				PreparedStatement prep = conexion1.prepareStatement(insertar);
				prep.setString(1, nombreCliente);
				prep.setString(2, emailCliente);
				prep.setInt(3, idLibro);

				prep.execute();
			
				System.out.println("Datos insertados.");

				prep.close();
				conexion1.close();
				sc.close();

			} catch (Exception e) {

				System.out.println("No funciona.");
				e.printStackTrace();
			}

	}

}
