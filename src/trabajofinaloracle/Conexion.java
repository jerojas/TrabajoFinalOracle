/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajofinaloracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jeovany
 */
public class Conexion {

    Connection conn;
    Statement sentencia;
    ResultSet resultado;

    public Conexion() {

        System.out.println("Conexión a la base de datos...");

        try { // Se carga el driver JDBC-ODBC
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (Exception e) {
            System.out.println("No se pudo cargar el driver JDBC");
            return;
        }
        try { // Se establece la conexión con la base de datos
            conn = DriverManager.getConnection("jdbc:oracle:thin:@Jeovany-PC:1521:xe", "system", "gato");
            sentencia = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("No hay conexión con la base de datos.");
            return;
        }

    } //Fin del main

    public void cerrar() throws SQLException {
        conn.close();
    }

    public ResultSet ejecutarSelect(String sql) {

        try {
            return sentencia.executeQuery(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void ejecutarDML(String sql) {

        try {
            sentencia.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
