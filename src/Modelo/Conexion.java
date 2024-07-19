package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    
    protected Connection miConexion;
    private Statement miStatement;
    private String jdbc;
    private String url;
    private String usuario;
    private String contrasena;
    
    public Conexion(){
        this.miConexion = null;
        this.miStatement = null;
        this.jdbc = "org.mariadb.jdbc.Driver";
        this.url = "jdbc:mariadb://localhost:3306/cpel";
        this.usuario = "admincpel";
        this.contrasena = "cpel2023";
    }
    
    public Connection abrirConexionSQL() {
        try {
            Class.forName(this.jdbc);
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver JDBC");
            e.printStackTrace();
            return null;
        }

        try {
            miConexion = DriverManager.getConnection(this.url, this.usuario, this.contrasena);
            this.miStatement = miConexion.createStatement();
            System.out.println("Se ha conectado exitosamente con la base de datos");
            return miConexion;
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos");
            e.printStackTrace();
            return null;
        }
    }
    
    public void cerrarConexionSQL(){
        if (miConexion != null) {
            try {
                if (!miConexion.isClosed()) {
                    miConexion.close();
                    System.out.println("Base de datos cerrada exitosamente.");
                }
            } 
            catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error al cerrar la conexión a la base de datos.");
            }
        } else {
            System.out.println("No hay conexión abierta para cerrar.");
        }
    }
}
